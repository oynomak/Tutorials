import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class AlertBox{

	public static void display(String title, String message){
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		Label label = new Label(message);

		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);

		window.setScene(scene);
		//to disable the main window. It needs to be closed before we proceed (together with line 12 of code)
		window.showAndWait();

	}

}














