package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Sea implements Drawable {
    private final double bottomLine;
    private final Dimension2D dimensions;

    public Sea(Dimension2D dimensions) {
        this.dimensions = dimensions;
        bottomLine = dimensions.getHeight() - 200;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.rgb(248, 121, 142));
        gc.fillRect(0, bottomLine, dimensions.getWidth(), dimensions.getHeight() - bottomLine);
        gc.setStroke(Color.WHITE);

        for (int i = 0; i < 10; i++)
            drawLine(gc, 0, dimensions.getWidth() / 2);
        for (int i = 0; i < 10; i++)
            drawLine(gc, dimensions.getWidth() / 2, dimensions.getWidth());

        gc.setFill(Color.rgb(255, 255, 255, 1));
        drawSunGlare(gc);
    }

    public void drawLine(GraphicsContext gc, double startX, double endX) {
        Random rnd = new Random();
        gc.setFill(Color.rgb(255, 255, 255, rnd.nextDouble(0.3, 0.9)));
        double length = 50;
        Point2D p1 = new Point2D(Math.abs(rnd.nextDouble(startX, endX)),
                Math.random() * (dimensions.getHeight() - bottomLine) + bottomLine);
        Point2D p2 = new Point2D(p1.getX() + length, p1.getY());

        gc.beginPath();
        gc.bezierCurveTo(p1.getX(), p1.getY(), p1.getX() + length / 2, p1.getY() - 2, p2.getX(), p2.getY());
        gc.stroke();
        gc.closePath();
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
