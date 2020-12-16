import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Game_Screen implements Initializable {
    @FXML
    private Button pause;
    @FXML
    private AnchorPane pane;

    public AnchorPane getPane() {
        return pane;
    }

    @FXML
    private Label score;

    private Scene s;
    private Parent root;

    private int curscore=0;

    private ArrayList<Obstacle> onscreenobstacles = new ArrayList<>();
    private ArrayList<Collider> onscreencolliders=new ArrayList<>();
    private Ball ball;


    private double toadd = 0.05;
    private double add = 5;
    private boolean flag = true;
    private boolean jumphappened=false;
    private int jumpcount=0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onscreenobstacles.add(new Obstacle_circle(this));
        onscreenobstacles.add(new Obstacle_2Windmill(this));
        Obstacle tt=new Obstacle_2square(this);
        tt.node().setLayoutY(-350);
        onscreenobstacles.add(tt);


        for (Obstacle o:onscreenobstacles)
            onscreencolliders.add(o);

        onscreencolliders.add(new ColorSwitch());

        for (Collider c:onscreencolliders)
            pane.getChildren().add(c.node());

        timer.start();
        ball=new Ball((colors[new Random().nextInt(4)]));

        pane.getChildren().add(ball.node());
        score.setText("0");
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if(checkpause())
            {
                if(checkcollide(ball))
                {
                    System.out.println("Collided");
                    timer.stop();
                    System.out.println("DONE ========================" +
                            "\n \n \n \n \n \n \n \n \n \n \n \n \n" +
                            "DONE ===================" );
                }
                rotate();
                fall();
                updatescreen();
                if (jumphappened)
                {
                    jump();
                    jumphappened = !(jumpcount > 10);
                    if (!jumphappened)
                        jumpcount = 0;
                }
            }
        }
    };

    public void increaseScore()
    {
        curscore++;
        score.setText(Integer.toString(curscore));
    }


    public Obstacle add(){
        Random rand = new Random();
        int x = rand.nextInt(6);
        switch (x){
            case 0:
                return new Obstacle_1square(this);
            case 1:
                return new Obstacle_1Windmill(this);
            case 2:
                return new Obstacle_2square(this);
            case 3:
                return new Obstacle_2Windmill(this);
            case 4:
                return new Obstacle_circle(this);
            case 5:
                return new Obstacle_ConcentricCircle(this);
            default:
                return new Obstacle_circle(this);
        }
    }


    private void updatescreen()
    {
        for (int i=0;i<onscreenobstacles.size();i++)
        {
            Obstacle c=onscreenobstacles.get(i);
            if(c.node().getBoundsInParent().getMinY()>700)
            {
                Obstacle o=add();
                ColorSwitch newcolorswitch=addColorSwitch();

                onscreencolliders.add(o);
                onscreencolliders.add(newcolorswitch);
                onscreenobstacles.add(o);

                pane.getChildren().add(o.group);
                pane.getChildren().add(newcolorswitch.node());

                onscreencolliders.remove(c);
                onscreenobstacles.remove(c);
                pane.getChildren().removeAll(c.node());

                double lower = o.group.getBoundsInParent().getCenterY();
                o.group.setLayoutY(o.group.getLayoutY() -250 - lower);
                newcolorswitch.node().setLayoutY(o.group.getBoundsInParent().getMinY()-80);

            }
        }
    }


    private Star addStar()
    {
        return new Star(0,0);
    }



    private ColorSwitch addColorSwitch()
    {
        return new ColorSwitch();
    }


    private boolean checkcollide(Ball b)
    {
        Collider temp = null;
        for(Collider c:onscreencolliders)
        {
            if(c.collide(b))
            {
                if (c instanceof Obstacle)
                    return false;
                if(c instanceof ColorSwitch)
                    temp =c;
                if(c instanceof Star)
                    temp=c;
            }
        }
        if(temp!=null)
        {
            onscreencolliders.remove(temp);
            pane.getChildren().remove(temp.node());
        }
        return false;
    }


    boolean checkpause()
    {
        return pane.getScene()!=null;
    }



    void movedown()
    {
        if(ball.node().getBoundsInParent().getMinY()<400)
        {
            for (Collider c:onscreencolliders)
                c.node().setLayoutY(c.node().getLayoutY()+2.5);
        }
    }

    void rotate()
    {
        for(Obstacle o: onscreenobstacles)
            o.rotate();
    }

    public void pauseclick(ActionEvent e) throws IOException {Frame.navigation.load("Pause.fxml"); }

    public void jumpwanted(MouseEvent e){
        jumphappened=true;
    }

    private void jump()
    {
        flag = false;
        add = 1;
        ball.node().setTranslateY(ball.node().getTranslateY()-5);
        jumpcount+=1;
        movedown();
    }

    public void fall(){
        if(!flag) {ball.node().setTranslateY(ball.node().getTranslateY()+add+toadd);add+=toadd;}
    }




    private String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
}
