import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXListView extends Application {

	Stage window;
	Scene scene;
	Button button;
	ListView<String> listView;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Window");
		button = new Button("Submit");

		listView = new ListView<>();
		listView.getItems().addAll(
				"Iron Man",
				"Titanic",
				"Contact",
				"Surrogates"
			);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		//listView.setOnAction();

		button.setOnAction(e -> buttonClicked());

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(listView, button);

		scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();

	}

	private void buttonClicked(){
		String message = "";
		ObservableList<String> movies;
		movies = listView.getSelectionModel().getSelectedItems();

		for(String m: movies){
			message += m + "\n\t";
		}
		System.out.println("\n\t" + message);
	}

}