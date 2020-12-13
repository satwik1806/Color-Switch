import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Obstacle_1Windmill extends Obstacle{

    private Shape_rect rect1;
    private Shape_rect rect2;
    private Shape_rect rect3;
    private Shape_rect rect4;

    private ArrayList<Shapes> allshapes = new ArrayList<>();
    public Star s  = new Star(0,0);
    public Obstacle_1Windmill(Game_Screen g){
        super(g);
        display();
    }
    @Override
    public void display() {
        rect1 = new Shape_rect(50,150,"ff0181",144,140,164,38);
        rect2 = new Shape_rect(150,50,"#32dbf0",0,121,38,164);
        rect3 = new Shape_rect(50,150,"#900dff",145,-24,164,38);
        rect4 = new Shape_rect(150,50,"#fae100",162,121,38,164);

        allshapes.add(rect1);
        allshapes.add(rect2);
        allshapes.add(rect3);
        allshapes.add(rect4);
        allshapes.add(s);
        group.getChildren().addAll(rect1.getRect(),rect2.getRect(),rect3.getRect(),rect4.getRect());
        
        //gourp properties
        group.setLayoutX(5);
        group.setLayoutY(322);
        group.setScaleX(0.6);
        group.setScaleY(0.6);
        
        //star properties
        s.getStar().setLayoutX(group.getBoundsInParent().getMaxX());
        s.getStar().setLayoutY(group.getBoundsInParent().getMinY() + 80);

    }

    public Star getStar(){
        return this.s;
    }

    private Rotate rotateobj = new Rotate();

    @Override
    public boolean collide(Ball c){
        for(Shapes temp:allshapes)
        {
            if(temp.collide(c))
            {
                if(temp instanceof Star)
                {
                    gameScreen.increaseScore();
                    group.getChildren().remove(s.node());
                    return false;
                }
                else if (!c.getBallColor().equals(temp.getcolor()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void rotate() {
        rotateobj.setPivotX(163);
        rotateobj.setPivotY(140);
        rotateobj.setAngle(1);
        group.getTransforms().add(rotateobj);
        s.starsize();
    }
}
