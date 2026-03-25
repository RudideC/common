package org.saturnclient.ui;

import org.saturnclient.common.ref.asset.IdentifierRef;
import org.saturnclient.common.ref.asset.SpriteRef;
import org.saturnclient.common.ref.game.ItemStackRef;
import org.saturnclient.common.ref.render.MatrixStackRef;

public interface RenderScope {

    // ----------------------------
    // Matrix & Transform
    // ----------------------------
    MatrixStackRef getMatrixStack();

    // ----------------------------
    // Color & Opacity
    // ----------------------------
    void setOpacity(float alpha);

    int getColor(int color);

    // ----------------------------
    // Shapes
    // ----------------------------
    void drawRectangle(int x, int y, int width, int height, int color);

    void drawRoundedRectangle(int x, int y, int width, int height, int radius, int color);

    void drawBorder(int x, int y, int width, int height, int color);

    void fill(int x1, int y1, int x2, int y2, int color);

    // ----------------------------
    // Text
    // ----------------------------
    void drawText(String text, int x, int y, int font, int color);

    void drawText(float scale, String text, int x, int y, int font, int color);

    // ----------------------------
    // Textures & Sprites
    // ----------------------------
    void drawTexture(IdentifierRef sprite, int x, int y, float u, float v, int width, int height);

    void drawTexture(IdentifierRef sprite, int x, int y, float u, float v, int width, int height, int color);

    void drawTexture(IdentifierRef sprite, int x, int y, float u, float v, int width, int height,
            int regionWidth, int regionHeight, int textureWidth, int textureHeight);

    void drawTexture(IdentifierRef sprite, int x, int y, float u, float v, int width, int height,
            int regionWidth, int regionHeight, int textureWidth, int textureHeight, int color);

    void drawSpriteStretched(SpriteRef sprite, int x, int y, int width, int height);

    void drawSpriteStretched(SpriteRef sprite, int x, int y, int width, int height, int color);

    // ----------------------------
    // Items
    // ----------------------------
    void drawItem(ItemStackRef item, int x, int y);

    // ----------------------------
    // Scissor / Clipping
    // ----------------------------
    void enableScissor(int x1, int y1, int x2, int y2);

    void disableScissor();

    boolean scissorContains(int x, int y);

    // ----------------------------
    // Window Info / Draw
    // ----------------------------
    int getScaledWindowWidth();

    int getScaledWindowHeight();

    void draw();
}