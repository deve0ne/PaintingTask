package com.deveone.paintingtask.shapes;

import com.deveone.paintingtask.Drawable;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Mountains implements Drawable {
    Dimension2D dimensions;

    private final double bottomLine;
    private double minHeight = 100;
    private final int pointsCount = 30;
    private final Point2D sunCoords;

    public Mountains(Dimension2D dimensions, Point2D sunCoords) {
        this.dimensions = dimensions;
        bottomLine = dimensions.getHeight() - 200;

        minHeight = bottomLine - minHeight;

        this.sunCoords = sunCoords;
    }

    @Override
    public void draw(GraphicsContext gc) {
        double[][] xyPoints = fillPoints();

        Color[] colors = {Color.rgb(179, 66, 114), Color.rgb(128, 46, 84), Color.rgb(100, 34, 69)};

        for (int i = 0; i < 3; i++) {
            gc.setFill(colors[i]);
            gc.fillPolygon(xyPoints[0], xyPoints[1], pointsCount);
            modifyPoints(xyPoints, 15);
        }
    }

    private double[][] fillPoints() {
        double[][] xyPoints = new double[2][pointsCount];
        Random rnd = new Random();
        for (int i = 0; i < xyPoints[0].length; i++) {
            if (i == 0 || i == pointsCount - 1) xyPoints[0][i] = dimensions.getWidth();
            else if (i == 1 || i == 2) xyPoints[0][i] = 0;
            else xyPoints[0][i] = xyPoints[0][i - 1] + dimensions.getWidth() / (pointsCount - 4);
        }

        for (int i = 0; i < xyPoints[1].length; i++) {
            if (i == 0 || i == 1) {
                xyPoints[1][i] = bottomLine;
            } else {
                double x = (xyPoints[0][i] - sunCoords.getX());

                if (x < 0) minHeight = 0.35 * x + bottomLine;
                else minHeight = 0.35 * -x + bottomLine;

                xyPoints[1][i] = rnd.nextDouble(minHeight - 50, minHeight) - 30;
            }
        }

        return xyPoints;
    }

    private void modifyPoints(double[][] xyPoints, double delta) {
        Random rnd = new Random();
        for (int j = 0; j < xyPoints[1].length; j++) {
            if (j == 0 || j == 1 || j == pointsCount - 1) continue;

            double random = rnd.nextDouble(delta / 2, delta * 4);
            if (xyPoints[1][j] + random > bottomLine) xyPoints[1][j] = bottomLine;
            else xyPoints[1][j] += random;
        }
    }
}
