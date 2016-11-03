import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/* 	import javafx.application.Platform;
	import javafx.embed.swing.SwingFXUtils;
	import javafx.fxml.FXML;
	import javafx.scene.SnapshotParameters;
	import javafx.scene.image.WritableImage;
	import javax.imageio.ImageIO;
	import java.io.File;
	import java.io.IOException;
	import java.util.Timer;
	import java.util.TimerTask;
*/

public class JavaFXWindow extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		window = primaryStage;
		window.setTitle("Title of the Window");

		Button button1 = new Button();
		button1.setText("Alert Box!");

		Button button2 = new Button();
		button2.setText("Confirm Box!");

		Button closeButton = new Button();
		closeButton.setText("Close Program");

		button1.setOnAction(e -> AlertBox.display("Title of Window", "Wow, this alert box is awesome!"));

		Label resultLabel = new Label();
		button2.setOnAction(e -> {
			boolean result = ConfirmBox.display("Title of Window", "Are you sure you want to send the naked pics?");
			resultLabel.setText("\tThe answer is : " + result);
		});

		// In order to avoid close using normal button and skip action: "File is saved!"
		window.setOnCloseRequest(x -> 
			{
				x.consume(); // to let the program know that we are not closing yet.
				closeProgram();
			});

		closeButton.setOnAction(e -> closeProgram());

		/*
		// This for a single page with StackPane:
		StackPane layout = new StackPane();
		layout.getChildren().addAll(button1, button2);
		*/
		VBox layout = new VBox(20);
		layout.getChildren().addAll(button1, button2, resultLabel, closeButton);

		Scene scene = new Scene(layout, 300, 250);

		window.setScene(scene);
		window.show();
	}

	private void closeProgram(){

		Boolean answer = ConfirmBox.display("Title of Window", "Are you sure you want to send the naked pics?");

		if(answer)window.close();
	}
}











