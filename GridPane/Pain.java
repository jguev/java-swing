// Author: Johanna Guevara
// Project Description:
// This program uses JavaFX GUI to create a GridPane of Labels with eight
// rows and nine columns. The text of each Label will include the *sum* of
// the row number and the column number.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Pain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grid(Pain)");

        GridPane gridPane = new GridPane();

        Label[][] lb = new Label[8][9];

        // Creating labels and populating them into Pane
        for(int i=1; i<lb.length; i++){
            for(int j=1; j<lb.length;j++){
                // Sum adds the row and column together
                int sum = i+j;
                lb[i][j] = new Label(""+sum+"");
                lb[i][j].setPrefSize(70, 70);
                gridPane.add(lb[i][j], i, j);
            }
        }

       //Add Pane to scene
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}