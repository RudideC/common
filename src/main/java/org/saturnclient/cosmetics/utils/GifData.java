package org.saturnclient.cosmetics.utils;

import java.util.List;

public class GifData {
    public final List<GifFrame> frames;
    public final int totalDuration;

    public GifData(List<GifFrame> frames) {
        this.frames = frames;

        int sum = 0;
        for (GifFrame f : frames) {
            sum += f.getDelayMs();
        }
        this.totalDuration = sum;
    }
}
