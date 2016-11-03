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

public class JavaFXMain extends Application {

	Stage window;
	Scene scene1, scene2;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		window = primaryStage;
		window.setTitle("Title of the Window");

		Label displayLabel1 = new Label("welcome to the first scene!");
		
		Button button1 = new Button();
		button1.setText("Go to Scene 2");
		button1.setOnAction(e -> window.setScene(scene2));

		/*
		// This for a single page with StackPane:
		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 300, 250);
		*/

		// Layout 1 - Children are laid out in Vertical column

		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(displayLabel1, button1);
		scene1 = new Scene(layout1, 500, 200);

		Label displayLabel2 = new Label("This scene sucks, go back to Scene 1!");

		Button button2 = new Button("<<< Scene 1");
		button2.setOnAction(e -> window.setScene(scene1));

		// Layout 2 - Second display on Button1 click

		HBox layout2 = new HBox(20);
		layout2.getChildren().addAll(displayLabel2, button2);
		scene2 = new Scene(layout2, 500, 200);

		window.setScene(scene1);
		window.show();
	}
}











