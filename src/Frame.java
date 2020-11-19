import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.module.FindException.*;


public class Frame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Login Menu");

        //label
        Label heading = new Label("LOGIN MENU");

        // buttons
        Button Existing_PLayer = new Button("Existing Player");
        Button New_Player = new Button("New_Player");
        Button Delete_Player = new Button("Delete Player");
        Button Exit_Game = new Button("Exit Game");

        //layout
        StackPane layout = new StackPane();
        BackgroundFill background_fill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        layout.setBackground(background);

        //adding to layout
        layout.getChildren().add(heading);
        layout.getChildren().add(Existing_PLayer);
        layout.getChildren().add(New_Player);
        layout.getChildren().add(Delete_Player);
        layout.getChildren().add(Exit_Game);

        // scene
        Scene sc = new Scene(layout,400,800);
        stage.setScene(sc);
        stage.show();
    }
}
