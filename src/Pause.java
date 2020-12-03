import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Pause implements Initializable {
    @FXML
    private Button play;
    @FXML
    private Button home;
    @FXML
    private Button save;

    private boolean less1 = false;
    private boolean less2 = false;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            animateplay();animatesave();
        }
    };
    public void animateplay(){
        double X=play.getScaleX();
        if(X>=0.7)
            less1=true;
        if(X<=0.6)
            less1=false;
        if(less1)
        {
            play.setScaleX(X-0.002);
            play.setScaleY(X-0.002);
        }
        else
        {
            play.setScaleX(X+0.002);
            play.setScaleY(X+0.002);
        }
    }

    public void animatesave(){
        double X=save.getScaleX();
        if(X>=0.7)
            less2=true;
        if(X<=0.6)
            less2=false;
        if(less2)
        {
            save.setScaleX(X-0.002);
            save.setScaleY(X-0.002);
        }
        else
        {
            save.setScaleX(X+0.002);
            save.setScaleY(X+0.002);
        }
    }


    public void saveanddisplscore(ActionEvent e){
        Frame.navigation.load("Score_Menu.fxml");
    }

    public void gotohome(ActionEvent e) throws IOException {
//        Stage s = (Stage) home.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("Player_Menu.fxml"));
//        s.setScene(new Scene(root,480,700));
//        s.show();
//        Frame.navigation.GoBack();
//        Frame.navigation.GoBack();
        Frame.navigation.load("Player_menu.fxml");
    }

    public void back(ActionEvent e) throws IOException{
//        Stage s = (Stage) play.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("Game_Screen.fxml"));
//        s.setScene(new Scene(root,480,700));
//        s.show();
        Frame.navigation.GoBack();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }
}
