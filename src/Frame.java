import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.module.FindException.*;


public class Frame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Menu.fxml"));
        stage.setScene(new Scene(root,480,700));
        stage.show();

//        System.out.println(MainClass.dis);
//        if(MainClass.dis.equals("login menu"))
//            display_loginmenu(stage);
//        if(MainClass.dis.equals("chck"))
//            display_Playermenu(stage);
    }

//    @FXML
//    private Group obs1;
//    private Group obs2;
//    Rotate rotate1 = new Rotate();
//
//    AnimationTimer timer = new AnimationTimer() {
//        @Override
//        public void handle(long l) {
//
//        }
//    }
    public void display_Playermenu(Stage stage) throws IOException {
//        stage.setTitle("Login Menu");
//        Parent root = FXMLLoader.load(getClass().getResource("Login_Menu.fxml"));

    }
}
