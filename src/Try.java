import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Try {
    public void trying() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Try.fxml"));
    }
}
