import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;

public class Star {
    private final SVGPath star=new SVGPath();

    public SVGPath getStar() {
        return star;
    }

    public Star(int layoutx, int layouty) {
        star.setContent("M 192.000 212.000L 212.000 226.641L" +
                " 209.321 202.000L 232.000 192.000L" +
                " 209.321 182.000L 212.000 157.359L" +
                " 192.000 172.000L 172.000 157.359L" +
                " 174.679 182.000L 152.000 192.000L " +
                "174.679 202.000L 172.000 226.641z");
        star.setLayoutY(layouty);
        star.setLayoutX(layoutx);
        star.setFill(Paint.valueOf("WHITE"));
        star.setScaleX(0.7);
        star.setScaleY(0.7);
    }

    public boolean Collide(Ball b)
    {
        return false;
    }

    private boolean less=false;

    void starsize()
    {

        double X=star.getScaleX();
        if(X>=0.7)
            less=true;
        if(X<=0.6)
            less=false;
        if(less)
        {
            star.setScaleX(X-0.005);
            star.setScaleY(X-0.005);
        }
        else
        {
            star.setScaleX(X+0.005);
            star.setScaleY(X+0.005);
        }
    }

}
