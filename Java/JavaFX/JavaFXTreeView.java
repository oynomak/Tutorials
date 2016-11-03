import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXTreeView extends Application {

	Stage window;
	TreeView<String> tree;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Window");

		TreeItem<String> root, kamonyo, mugabo;

		// Root first
		root = new TreeItem<>();
		root.setExpanded(true);

		// Kamonyo second
		// kamonyo = new TreeItems<>();
		/** or even easier with a method ... Name and parent*/
		kamonyo = makeBranch("Kamonyo", root);
		makeBranch("Facebook", kamonyo);
		makeBranch("Pinterest", kamonyo);
		makeBranch("Snapchat", kamonyo);

		// Mugabo third
		mugabo = makeBranch("Mugabo", root);
		makeBranch("Youtube", mugabo);
		makeBranch("Google", mugabo);
		makeBranch("Twitter", mugabo);

		// Create tree
		tree = new TreeView<>(root);
		tree.setShowRoot(false);

		tree.getSelectionModel().selectedItemProperty().addListener(
				(v, oldValue, newValue) -> {
					if(newValue != null)
						System.out.println("\n\t>>> " + newValue.getValue());
				}
			);

		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();

	}

	/** Create branches with this method */
	private TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);

		return item;
	}

}