import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Ball {

    private Circle ball=new Circle();

    public Ball(String colour)
    {
        display();
        ball.setFill(Paint.valueOf(colour));
    }


    private void display()
    {
        ball.setLayoutX(250);
        ball.setLayoutY(605);
        ball.setRadius(12);
        ball.setStroke(Paint.valueOf("BLACK"));
        ball.setStrokeType(StrokeType.INSIDE);
    }

    Node node()
    {
        return ball;
    }


}
