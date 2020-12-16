import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.transform.Rotate;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Existing_Player_Details implements Initializable, Serializable {
    @FXML
    private TextArea namee;
    @FXML
    private Button button;

    @FXML
    private Group obs11;
    @FXML
    private Group obs22;

    private ArrayList<Player> plist=new ArrayList<>();

    public ArrayList<Player> getPlist() {
        return plist;
    }

    public void setPlist(ArrayList<Player> plist) {
        this.plist = plist;
    }

    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            //11
            rotate11.setPivotX(0);
            rotate11.setPivotY(0);
            rotate11.setAxis(new Point3D(0,0,1));
            obs11.getTransforms().addAll(rotate11);
            rotate11.setAngle(1.5);

            //22
            rotate22.setPivotX(0);
            rotate22.setPivotY(0);
            rotate22.setAxis(new Point3D(0,0,1));
            obs22.getTransforms().addAll(rotate22);
            rotate22.setAngle(1.5);
        }
    };
//
//    pub
//    public Existing_Player_Details(){timer.start();}

    public void click(ActionEvent e){
        String name = namee.getText();
        System.out.println(name);
        boolean f = true;
        for(Player p:plist){
            if(p.getName().equals(name)){
                f = false;
                p.start();
            }
        }
        if(f){
            Frame.navigation.GoBack();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }
}
