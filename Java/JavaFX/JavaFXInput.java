import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXInput extends Application {

	Stage window;
	Scene scene;
	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Window");

		/** Form */
		TextField nameInput = new TextField("Some thing here...");
		button = new Button("Save me");

		button.setOnAction(e -> isInt(nameInput, nameInput.getText()));
		/** END of Form */

		/** Layout */
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(nameInput, button);
		/** END of Layout */

		scene = new Scene(layout, 600, 550);
		window.setScene(scene);
		window.show();

	}

	private boolean isInt(TextField input, String message){
		try{
			int age = Integer.parseInt(input.getText());
			AlertBox.display("Printout of message", input.getText());
			return true;
		}catch(NumberFormatException ex){
			System.out.println("Error: " + message + "is not a number");
			return false;
		}
	}
}