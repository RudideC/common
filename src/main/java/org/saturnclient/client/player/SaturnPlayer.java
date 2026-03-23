package org.saturnclient.client.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.saturnclient.client.ServiceClient;
import org.saturnclient.common.provider.Providers;

public class SaturnPlayer {
    private static final Map<UUID, SaturnPlayer> PLAYERS = new HashMap<>();

    private static final Queue<UUID> QUEUE = new ConcurrentLinkedQueue<>();

    private static volatile boolean RUNNING = false;
    private static Thread WORKER;

    public String cloak = "";
    public String hat = "";
    public final UUID uuid;
    public final String name;

    public SaturnPlayer(UUID uuid, String name, String cloak, String hat) {
        this.cloak = cloak;
        this.hat = hat;
        this.uuid = uuid;
        this.name = name;
    }

    public static SaturnPlayer get() {
        if (ServiceClient.uuid == null) {
            return null;
        }
        return PLAYERS.get(ServiceClient.uuid);
    }

    public static SaturnPlayer get(String name, UUID uuid) {
        if (uuid == null)
            return null;

        SaturnPlayer player = PLAYERS.get(uuid);

        if (player == null) {
            PLAYERS.put(uuid, null);
            QUEUE.add(uuid);
            startPlayerThread();
        }

        return player;
    }

    public static SaturnPlayer get(UUID uuid) {
        return get(Providers.saturn.getClient().getPlayerListEntry(uuid), uuid);
    }

    public static SaturnPlayer get(String name) {
        return get(name, Providers.saturn.getClient().getPlayerListEntryUUID(name));
    }

    public static void set(SaturnPlayer player) {
        PLAYERS.put(player.uuid, player);
    }

    public static String[] getExternalUUIDAsString() {
        return PLAYERS.keySet().stream().filter(id -> ServiceClient.uuid == null || !id.equals(ServiceClient.uuid))
                .map(UUID::toString)
                .toArray(String[]::new);
    }

    public static synchronized void startPlayerThread() {
        if (RUNNING)
            return;

        RUNNING = true;

        WORKER = new Thread(() -> {
            long lastWorkTime = System.currentTimeMillis();

            while (true) {
                UUID uuid = QUEUE.poll();

                if (uuid != null) {
                    try {
                        String name = Providers.saturn.getClient().getPlayerListEntry(uuid);

                        SaturnPlayer player = ServiceClient.getPlayer(uuid, name);

                        // Apply on main thread
                        Providers.saturn.getClient().executeOnThread(() -> {
                            PLAYERS.put(uuid, player);
                        });

                    } catch (Exception e) {
                        Providers.saturn.logError("Failed to fetch player " + uuid, e);
                    }

                    lastWorkTime = System.currentTimeMillis();
                } else {
                    if (System.currentTimeMillis() - lastWorkTime > 5000) {
                        break;
                    }

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            RUNNING = false;
        }, "SaturnPlayer-Worker");

        WORKER.setDaemon(true);
        WORKER.start();
    }
}
