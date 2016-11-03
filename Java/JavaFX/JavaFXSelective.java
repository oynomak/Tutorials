import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXSelective extends Application {

	Stage window;
	Scene scene;
	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Restaurant");

		/** Form */
		CheckBox box1 = new CheckBox("Bacon");
		CheckBox box2 = new CheckBox("Tuna");
		box2.setSelected(true);//Checked by default...


		TextField nameInput = new TextField("Some thing here...");
		button = new Button("Order now!");

		button.setOnAction(e -> handleOptions(box1, box2));
		/** END of Form */

		/** Layout */
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(box1, box2, button);
		/** END of Layout */

		scene = new Scene(layout, 600, 550);
		window.setScene(scene);
		window.show();

	}

	private void handleOptions(CheckBox box1, CheckBox box2){
		String message = "Client orders: \n";

		if(box1.isSelected()){
			message += "Bacon\n";
		}
		if(box2.isSelected()){
			message += "Tuna\n";
		}
		System.out.println(message);
	}
}