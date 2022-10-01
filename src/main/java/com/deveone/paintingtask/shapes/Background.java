package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Background implements Drawable {
    private final Point2D coordinates;
    private final Dimension2D dimensions;

    public Background(Point2D coordinates, Dimension2D dimensions) {
        this.coordinates = coordinates;
        this.dimensions = dimensions;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(125,74,117)),
                new Stop(10, Color.rgb(195,101,132))));


        gc.fillRect(coordinates.getX(),coordinates.getY(), dimensions.getWidth(), dimensions.getHeight());
    }
}
