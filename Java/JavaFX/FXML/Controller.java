import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

public class Controller implements Initializable {

	public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("\n\t<< View is now loaded! >>");
    }

    public void handleButtonClick(){
    	System.out.println("\n\tRun some code the user doesn't see...");
    	button.setText("Stop touching me!");
    }

}