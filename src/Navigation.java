import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    private final Stage stage;
    private final Scene scene;

    private List<Parent> controllers = new ArrayList<>();

    public Navigation(Stage stage)
    {
        this.stage = stage;
        scene = new Scene(new Pane(),480,700);
        stage.setScene(scene);
    }

    public void load(String sUrl)
    {
        try {

            //loads the fxml file
            Parent root = (Parent)(FXMLLoader.load(getClass().getResource(sUrl)));
            controllers.add(root);
            scene.setRoot(root);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void GoBack()
    {
        if (controllers.size() > 1)
        {
            controllers.remove((controllers.size() - 1));
            scene.setRoot(controllers.get(controllers.size() - 1));
        }
    }

    public void cleanPrevious()
    {
        while(controllers.size()>1)
            controllers.remove(0);
    }
}
