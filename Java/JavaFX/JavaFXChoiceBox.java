import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXChoiceBox extends Application {

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
		button = new Button("Click me");

		ChoiceBox<String> choiceBox = new ChoiceBox<>();

		// getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Apples");
		choiceBox.getItems().add("Pinapples");
		choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs", "Strawberries");

		// Set a default value
		choiceBox.setValue("Pinapples");

		// Listen for selection changes
		choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			System.out.println("\n\tThe new selected Value is : " + newValue);
			System.out.println("\n\tThe old selected Value was : " + oldValue);
		} );

		button.setOnAction(e -> System.out.println("\n\t>>> The current selected value is : " + getChoice(choiceBox)));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);

		scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();

	}

	private String getChoice(ChoiceBox<String> choice){
		String food = choice.getValue();
		return food;
	}

}