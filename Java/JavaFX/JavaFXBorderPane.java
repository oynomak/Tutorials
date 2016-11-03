import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXBorderPane extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Border Pane");

		/** BorderPane example */
		HBox topMenu = new HBox();
		Button fileButton = new Button("File");
		Button editButton = new Button("Edit");
		Button viewButton = new Button("View");
		topMenu.getChildren().addAll(fileButton, editButton, viewButton);

		VBox leftMenu = new VBox();
		Button buttonA = new Button("A");
		Button buttonB = new Button("B");
		Button buttonC = new Button("C");
		leftMenu.getChildren().addAll(buttonA, buttonB, buttonC);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);

		StackPane layout = new StackPane();
		Scene scene = new Scene(borderPane, 600, 550);
		/** END of BorderPane example */

		/** GridPane example */
		Label label1 = new Label("Username:");
		Label label2 = new Label("Password");
		Label label3 = new Label("Line 3");	

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		GridPane.setConstraints(label1, 0, 0);
		GridPane.setConstraints(label2, 0, 1);

		TextField usernameInput = new TextField("User name");
		GridPane.setConstraints(usernameInput, 1, 0);

		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);

		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 1, 2);

		grid.getChildren().addAll(label1, usernameInput, label2, passInput, loginButton);
		/** END of GridPane example */

		Scene scene1 = new Scene(grid, 600, 550);
		window.setScene(scene1);
		window.show();

	}
}