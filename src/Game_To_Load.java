import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.transform.Rotate;

public class Game_To_Load {
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;

    @FXML
    private TextArea ID;
    @FXML
    private Button button;

    private Player myplayer;

    public Player getMyplayer() {
        return myplayer;
    }

    public void setMyplayer(Player myplayer) {
        this.myplayer = myplayer;
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

    public Game_To_Load(){
        timer.start();
    }

    public void click(ActionEvent e){
        int itsid = Integer.parseInt(ID.getText());
//        Frame.navigation.setroot(Player_Menu.gamescreen.get(itsid-1).getPane().getScene().getRoot());
        Game_State gstate ;
        gstate = myplayer.getGamestates().get(itsid-1);
        Frame.navigation.load("Game_Screen.fxml");
        Game_Screen gsscreen =(Game_Screen)Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        gsscreen.setMyPlayer(myplayer);
        gsscreen.recreate_screen(gstate);
    }
}
