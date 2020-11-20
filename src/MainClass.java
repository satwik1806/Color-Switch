import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.module.FindException.*;

public class MainClass  {
    static String dis = "";
    public static void main(String[] args) {
        System.out.println("hello");
        dis = "login menu";
        Application.launch(Frame.class, args);
    }

//    Button bun;
//    @Override
//    public void start(Stage stage) throws Exception {
//        stage.setTitle("HELLO");
//        Button b = new Button("CAN YOU CLICK ME");
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(b);
//
//        BackgroundFill background_fill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
//
//        // create Background
//        Background background = new Background(background_fill);
//
//        layout.setBackground(background);
//
//
//        Scene sc = new Scene(layout,400,800);
//
//
//        stage.setScene(sc);
//        stage.show();
//    }

}
