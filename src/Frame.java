import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.module.FindException.*;


public class Frame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(MainClass.dis);
        if(MainClass.dis.equals("login menu"))
            display_loginmenu(stage);
        if(MainClass.dis.equals("chck"))
            display_Playermenu(stage);
    }

    public void display_Playermenu(Stage stage){
        stage.setTitle("Player Menu");

        //label
        Label heading = new Label("Player Menu");
        heading.setStyle("-fx-text-fill: white; -fx-font: normal bold 50px 'serif' ");
        heading.setPrefHeight(300);

        // buttons
        Button New_Game = new Button("New Game");
        New_Game.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");
        Button Existing_Game = new Button("Existing Game");
        Existing_Game.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");
        Button Back_to_loginmenu = new Button("Back to Login Menu");
        Back_to_loginmenu.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");

        //BOX
        VBox box = new VBox(30,New_Game,Existing_Game,Back_to_loginmenu);
        box.setSpacing(50);
        box.setAlignment(Pos.CENTER);

        //layout
        StackPane layout = new StackPane();
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(41,41,41), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        layout.setBackground(background);

        //adding to layout
        layout.getChildren().add(heading);
        layout.getChildren().add(box);
        layout.setAlignment(Pos.TOP_CENTER);

        // scene
        Scene sc = new Scene(layout,400,800);
        stage.setScene(sc);
        stage.show();
    }

    public void display_loginmenu(Stage stage){
        stage.setTitle("Login Menu");

        //label
        Label heading = new Label("LOGIN MENU");
        heading.setStyle("-fx-text-fill: white; -fx-font: normal bold 50px 'serif' ");
//        heading.fontProperty();
        heading.setPrefHeight(300);

        // buttons
        Button Existing_PLayer = new Button("Existing Player");
        Existing_PLayer.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");
        Button New_Player = new Button("New_Player");
        New_Player.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");
        Button Delete_Player = new Button("Delete Player");
        Delete_Player.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");
        Button Exit_Game = new Button("Exit Game");
        Exit_Game.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font: 20px 'serif'");

        //BOX
        VBox box = new VBox(30,Existing_PLayer,New_Player,Delete_Player,Exit_Game);
        box.setSpacing(50);
        box.setAlignment(Pos.CENTER);

        //layout
        StackPane layout = new StackPane();
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(41,41,41), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        layout.setBackground(background);

        //adding to layout
        layout.getChildren().add(heading);
//        layout.getChildren().add(Existing_PLayer);
//        layout.getChildren().add(New_Player);
//        layout.getChildren().add(Delete_Player);
//        layout.getChildren().add(Exit_Game);
        layout.getChildren().add(box);
        layout.setAlignment(Pos.TOP_CENTER);

        // scene
        Scene sc = new Scene(layout,400,800);
        stage.setScene(sc);
        stage.show();
    }
}
