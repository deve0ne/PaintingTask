package com.deveone.paintingtask;

import com.deveone.paintingtask.shapes.*;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Canvas canvas;

    private final ArrayList<Drawable> objects = new ArrayList<>();


    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();


//        canvas.getGraphicsContext2D().fillOval(100, 100, 100, 100);

        objects.add(new Background(new Point2D(0, 0), new Dimension2D(canvas.getWidth(), canvas.getHeight())));
        objects.add(new Stars(new Dimension2D(canvas.getWidth(), canvas.getHeight())));
        objects.add(new Sun(new Point2D(canvas.getWidth() / 2, canvas.getHeight() / 2), 250, 250));

        objects.add(new Sea(new Dimension2D(canvas.getWidth(), canvas.getHeight())));
        objects.add(new Mountians(new Dimension2D(canvas.getWidth(), canvas.getHeight())));

        objects.forEach(o -> o.draw(canvas.getGraphicsContext2D()));

//        for (PaintObject o : objects) {
//            System.out.println("1231231");
//            o.draw(canvas.getGraphicsContext2D());
//        }
    }
}