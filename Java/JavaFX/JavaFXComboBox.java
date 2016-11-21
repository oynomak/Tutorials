import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXComboBox extends Application {

	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> comboBox;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Window");
		button = new Button("Submit");

		comboBox = new ComboBox<>();
		comboBox.getItems().addAll(
			"Good Will Hunting",
			"St. Vincent",
			"BlackHat"
		);

		comboBox.setPromptText("What is your favorite movie?");

		comboBox.setEditable(true);

		button.setOnAction(e -> printMovie());

		comboBox.setOnAction(e -> System.out.println("\n\t>>> User selected this <<" + comboBox.getValue() + ">> movie."));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(comboBox, button);

		scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();

	}

	private void printMovie(){
		System.out.println("\n\tSelected movie is : " + comboBox.getValue());
	}

}