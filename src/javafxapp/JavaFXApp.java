package javafxapp;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.chart.PieChart;
import javafx.util.Duration;

public class JavaFXApp extends Application {
    ObservableList<PieChart.Data> pieData;
        @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(createPane(), 550, 550);
        stage.setTitle("Concurrency in JavaFX");
        stage.setScene(scene);
        stage.show();
        }

    private Pane createPane(){
        GridPane root = new GridPane();
        pieData = FXCollections.observableArrayList(
                new PieChart.Data("понедельник", 10),
                new PieChart.Data("вторник", 30),
                new PieChart.Data("среда", 15),
                new PieChart.Data("четверг", 25),
                new PieChart.Data("пятница", 20));

        PieChart chart = new PieChart(pieData);
        root.add(chart, 0,1,2,3);
        Button btn1 = new Button("Done");
        root.add(btn1, 0,0);
        btn1.setOnAction(ev->pieData.add( new PieChart.Data("суббота", 20)));

        RotateTransition rt = new RotateTransition(Duration.seconds(3), chart);
        rt.setByAngle(360);

        rt.play();
        return root;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
