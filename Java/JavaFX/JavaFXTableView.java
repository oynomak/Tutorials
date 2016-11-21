import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class JavaFXTableView extends Application {

	Stage window;
	TableView<Product> table;
	TextField nameInput, priceInput, qtyInput;
	Scene scene;
	ObservableList<Product> products;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("My Window");

		// Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("P.U");
		priceColumn.setMinWidth(50);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		// Quantity column
		TableColumn<Product, Integer> qtyColumn = new TableColumn<>("Qty");
		qtyColumn.setMinWidth(50);
		qtyColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		// Name input
		nameInput = new TextField();
		nameInput.setPromptText("Product Name");
		nameInput.setMinWidth(100);

		// Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");

		// Quntity input
		qtyInput = new TextField();
		qtyInput.setPromptText("Quantity");

		// Buttons: Add + Delete
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());

		Button deleteBtn = new Button("Delete");
		deleteBtn.setOnAction(e -> deleteBtnClicked());

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, qtyInput, addButton, deleteBtn);


		table = new TableView<>();
		table.setItems(getProducts());
		table.getColumns().addAll(nameColumn, priceColumn, qtyColumn);

		VBox layout = new VBox();
		layout.getChildren().addAll(table, hBox);

		scene = new Scene(layout);
		window.setScene(scene);
		window.show();

	}

	// Add button click
	private void addButtonClicked(){
		Product product = new Product(
				nameInput.getText(),
				Double.parseDouble(priceInput.getText()),
				Integer.parseInt(qtyInput.getText())
			);

		//Adding to the DB (our list)
		products.add(product);
		// Adding directly to the Table
		//table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		qtyInput.clear();
	}

	// Delete button click
	private void deleteBtnClicked(){
		ObservableList<Product> productsSelected, allProducts;
		allProducts = table.getItems();
		productsSelected = table.getSelectionModel().getSelectedItems();

		productsSelected.forEach(allProducts::remove);
	}

	/** Gets all the products */
	private ObservableList<Product> getProducts(){
		products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Bouncy Ball", 29.00, 2));
		products.add(new Product("DVD Notebook", 9.30, 234));
		products.add(new Product("Corn", 1.90, 23));
		products.add(new Product("Shirt", 3.00, 9));

		return products;
	}

}