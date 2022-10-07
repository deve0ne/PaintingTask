package com.deveone.paintingtask;

import com.deveone.paintingtask.shapes.*;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.text.FontSmoothingType;

import java.util.*;

public class PaintingController {
    @FXML
    private Canvas canvas;

    private final ArrayList<Drawable> objects = new ArrayList<>();


    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setImageSmoothing(true);
        gc.setFontSmoothingType(FontSmoothingType.LCD);
        Dimension2D canvasDims = new Dimension2D(canvas.getWidth(), canvas.getHeight());


        objects.add(new Background(new Point2D(0, 0), canvasDims));
        objects.add(new Stars(canvasDims));

        Point2D sunCoords = new Point2D(canvasDims.getWidth() / 2, canvasDims.getHeight() / 2 - 50);
        Dimension2D sunDims = new Dimension2D(250, 250);
        objects.add(new Sun(sunCoords, sunDims));

        objects.add(new Sea(canvasDims));
        objects.add(new Mountains(canvasDims, sunCoords));

        objects.forEach(o -> o.draw(canvas.getGraphicsContext2D()));
        WritableImage snapshot = canvas.snapshot(null, null);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            final Boat boat = new Boat(sunCoords.subtract(0, -300));
            @Override
            public void run() {
                gc.drawImage(snapshot, 0, 0);
                gc.save();

                boat.draw(gc);

                gc.restore();
            }
        },0, 100);
    }


}