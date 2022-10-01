package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Mountians implements Drawable {
    Dimension2D dimensions;

    private double bottomLine;
    private double maxHeight = 200;
    private double minHeight = 100;
    private final int pointsCount = 20;

    public Mountians(Dimension2D dimensions) {
        this.dimensions = dimensions;
        bottomLine = dimensions.getHeight() - 200;

        maxHeight = bottomLine - maxHeight;
        minHeight = bottomLine - minHeight;
    }

    @Override
    public void draw(GraphicsContext gc) {
        double remainingXDistance = dimensions.getWidth();
        double[][] xyPoints = fillPoints();

//        gc.setFill(Color.rgb(128,46,84, 0.5));
        gc.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
//                new Stop(0, Color.rgb(189, 55, 108)),
        new Stop(1, Color.rgb(100, 34, 69))));
        gc.fillPolygon(xyPoints[0], xyPoints[1], pointsCount);


//        for (int i = 0; i < 5; i++) {
//            modifyPoints(xyPoints, 10);
//            gc.setFill(Color.rgb(128,46,84, 0.5));
//            gc.fillPolygon(xyPoints[0], xyPoints[1], pointsCount);
//        }
    }

    private double[][] fillPoints() {
        double[][] xyPoints = new double[2][pointsCount];

        for (int i = 0; i < xyPoints[0].length; i++) {
            if (i == 0 || i == pointsCount - 1) xyPoints[0][i] = dimensions.getWidth();
            else if (i == 1 || i == 2) xyPoints[0][i] = 0;
            else {
                xyPoints[0][i] = xyPoints[0][i - 1] + dimensions.getWidth() / (pointsCount - 4);
            }
        }

        for (int i = 0; i < xyPoints[1].length; i++) {
            if (i == 0 || i == 1) xyPoints[1][i] = bottomLine;
            else xyPoints[1][i] = getRandomY();
        }

        return xyPoints;
    }

    private double[][] modifyPoints(double[][] xyPoints, double delta) {
        for (int i = 1; i < xyPoints.length; i++) {
            for (int j = 0; j < xyPoints[i].length; j++) {
//                if (i == 0 && (j == 0 || j == 1)) continue;
                if (i == 1 && (j == 0 || j == 1 || j == pointsCount - 1)) continue;
                xyPoints[i][j] += delta;
            }
        }

        return xyPoints;
    }

    private double getRandomY() {
        return Math.random() * (maxHeight - minHeight) + minHeight;
    }
}
