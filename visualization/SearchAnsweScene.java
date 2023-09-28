package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.DNArecord;

public class SearchAnsweScene {
	private Button cancel;
	private Stage stage;
	private TableView<DNArecord> myDataTable;
	private GridPane pane3;
	private Label details;

	public SearchAnsweScene() {
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() {
	    BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c);
		stage = new Stage();
		pane3 = new GridPane();
		pane3.setAlignment(Pos.CENTER);
		pane3.setPadding(new Insets(70, 150, 70, 150));
		pane3.setHgap(10);
		pane3.setVgap(10);
        pane3.setBackground(background);


		Image img013 = new Image("images/logo.png");
		ImageView v013 = new ImageView(img013);
		v013.setFitWidth(100);
		v013.setFitHeight(100);

		Button logo013 = new Button();
		GridPane.setHalignment(logo013, HPos.CENTER);
		logo013.setPrefSize(100, 100);
		logo013.setGraphic(v013);
		logo013.setStyle(
				"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane3.add(logo013, 1, 0);
		
        myDataTable = new TableView<DNArecord>();

        TableColumn<DNArecord, String> customerID = new TableColumn<DNArecord, String>("Name");
        customerID.setCellValueFactory(new PropertyValueFactory<DNArecord, String>("name"));

        TableColumn<DNArecord, Integer> accountType = new TableColumn<DNArecord, Integer>("Number");
        accountType.setCellValueFactory(new PropertyValueFactory<DNArecord, Integer>("number"));

        TableColumn<DNArecord, String> customerID2 = new TableColumn<DNArecord, String>("DNA");
        customerID2.setCellValueFactory(new PropertyValueFactory<DNArecord, String>("DNA"));
        
        TableColumn<DNArecord, Integer> id = new TableColumn<DNArecord, Integer> ("ID");
        id.setCellValueFactory(new PropertyValueFactory<DNArecord, Integer> ("id"));
        
      	TableColumn<DNArecord, String> detailsColumn = new TableColumn<>("Details");
      	detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
      
        myDataTable.getColumns().addAll( id, customerID ,accountType,customerID2,detailsColumn);
      
    	myDataTable.setStyle("-fx-font-family: Monospace;-fx-font-size: 16px;");
    	myDataTable.setPadding(new Insets(10));
    	myDataTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		
    	myDataTable.setCenterShape(true);
    	myDataTable.setPrefWidth(700);
    	myDataTable.setPrefHeight(200);
    	
    	pane3.add(myDataTable,1,2);
    	
    	details = new Label();
    	details.setStyle("-fx-font-family: Monospace;-fx-font-size: 16px;-fx-text-fill: red;-fx-font-weight: bold;");
		GridPane.setHalignment(details, HPos.CENTER);
		pane3.add(details, 1, 1);

		cancel = new Button("Cancel");
		cancel.setPrefSize(100, 30);
		cancel.setFont(Font.font(14));
		cancel.setTextFill(Color.WHITE);
		cancel.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
		GridPane.setHalignment(cancel, HPos.CENTER);
		pane3.add(cancel, 1, 3);

		Scene scene3 = new Scene(pane3);
		stage.setScene(scene3);
		stage.setTitle("Search DNA");
		stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
		stage.show();		
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public TableView<DNArecord> getMyDataTable() {
		return myDataTable;
	}

	public void setMyDataTable(TableView<DNArecord> myDataTable) {
		this.myDataTable = myDataTable;
	}
	
	public GridPane getPane3() {
		return pane3;
	}

	public void setPane3(GridPane pane3) {
		this.pane3 = pane3;
	}

	public Label getDetails() {
		return details;
	}

	public void setDetails(Label details) {
		this.details = details;
	}
}