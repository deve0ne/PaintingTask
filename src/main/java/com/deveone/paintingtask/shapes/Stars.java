package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Stars implements Drawable {
    private final Dimension2D dimensions;

    public Stars(Dimension2D dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        for (int i = 0; i < 600; i++) {
            gc.fillRect(Math.random() * dimensions.getWidth(), Math.random() * dimensions.getHeight(), 2, 2);
        }
    }
}
