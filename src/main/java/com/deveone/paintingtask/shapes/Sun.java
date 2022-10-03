package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Sun implements Drawable {
    Point2D coordinates;
    private final double width;
    private final double height;

    public Sun(Point2D coordinates, Dimension2D dims) {
        this.coordinates = coordinates;
        this.width = dims.getWidth();
        this.height = dims.getHeight();
    }

    @Override
    public void draw(GraphicsContext gc) {
        double delta = width/2;
        for (int i = 0; i < 2; i++) {
            gc.setFill(Color.rgb(255,255,255,0.1));
            gc.fillOval(coordinates.getX()-((width + delta)/2.0), coordinates.getY()-((width + delta)/2.0), width + delta, height + delta);
            delta*= 2;
        }

        gc.setFill(Color.rgb(254,254,254,1));
        gc.fillOval(coordinates.getX() - width/2, coordinates.getY()- height/2, width, height);
    }
}
