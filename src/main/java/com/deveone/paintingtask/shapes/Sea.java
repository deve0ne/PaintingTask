package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Sea implements Drawable {
    private double bottomLine;
    private Dimension2D dimensions;

    public Sea(Dimension2D dimensions) {
        this.dimensions = dimensions;
        bottomLine = dimensions.getHeight() - 200;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.rgb(248,121,142));
        gc.fillRect(0, bottomLine, dimensions.getWidth(), dimensions.getHeight() - bottomLine);
        gc.setStroke(Color.WHITE);
        for (int i = 0; i < 20; i++) {
            drawLine(gc);
        }

        gc.setFill(Color.rgb(255,255,255,1));
        drawSunGlare(gc);
    }

    public void drawLine(GraphicsContext gc) {
        double x = Math.abs(new Random().nextGaussian() * dimensions.getWidth());
        System.out.println(x);
        double y = Math.random() * (dimensions.getHeight() - bottomLine) + bottomLine;

        gc.strokeLine(x, y, x + 50, y);
    }

    public void drawSunGlare(GraphicsContext gc) {
        Random rnd = new Random();
        double y = dimensions.getHeight();
        while (y > bottomLine - 10) {
            double delta = y - bottomLine + 60;
            double width = rnd.nextDouble(delta, delta * 2);
            double height = rnd.nextDouble(10, 15);
            gc.fillOval((dimensions.getWidth() - width) / 2, y, width, height);
            y -= height / 8;
        }
    }
}
