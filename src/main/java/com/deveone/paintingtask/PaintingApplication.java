package com.deveone.paintingtask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaintingApplication.class.getResource("paint-view.fxml"));
        fxmlLoader.setController(new PaintingController());
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Painting");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}