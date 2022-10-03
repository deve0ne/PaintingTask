package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

public class Boat implements Drawable {
    double currentRotation = 0;
    double goalRotation = 5;
    boolean leftRotation = false;
    Point2D coords;

    public Boat(Point2D coords) {
        this.coords = coords;
    }

    @Override
    public void draw(GraphicsContext gc) {
        Dimension2D boatSize = new Dimension2D(300, 100);
        double parusHeight = 250;

        gc.save();
        gc.rect(coords.getX() - boatSize.getWidth() / 2, coords.getY() - parusHeight, boatSize.getWidth() * 2, boatSize.getHeight() - 15 + parusHeight);
        gc.clip();

        gc.setFill(Color.rgb(64, 0, 34));

        gc.translate(coords.getX() + boatSize.getWidth() / 2, coords.getY() + boatSize.getHeight() / 2);
        if ((leftRotation && currentRotation <= goalRotation) || (!leftRotation && currentRotation >= goalRotation)) {
            leftRotation = !leftRotation;
            goalRotation *= -1;
        }
        double delta = Math.sqrt(Math.abs(currentRotation - goalRotation)) / 6;
        currentRotation += leftRotation ? -delta : delta;
        gc.rotate(currentRotation);
        gc.translate(-coords.getX() - boatSize.getWidth() / 2, -coords.getY() - boatSize.getHeight() / 2);

        gc.fillArc(coords.getX(), coords.getY(), boatSize.getWidth(), boatSize.getHeight(), 180, 180, ArcType.ROUND);

        double x = coords.getX() + boatSize.getWidth() / 2;
        double y = coords.getY() + boatSize.getHeight() / 2 - 5;
        gc.fillPolygon(new double[]{x, x, x + parusHeight/2},
                new double[]{y - parusHeight, y, y},
                3);

        x = coords.getX() + boatSize.getWidth() / 2 - 5;
        y = coords.getY() + boatSize.getHeight() / 2 - 5;
        gc.fillPolygon(new double[]{x, x, x - parusHeight/3},
                new double[]{y - parusHeight / 1.5, y, y},
                3);

        gc.setFill(Color.rgb(135, 104, 124));
        Text boatName = new Text("Ласточка");
        gc.fillText(boatName.getText(),
                coords.getX() + boatSize.getWidth() / 2 - boatName.getBoundsInLocal().getWidth() / 2,
                coords.getY() + boatSize.getHeight() / 2 +25);

        gc.restore();
    }
}
