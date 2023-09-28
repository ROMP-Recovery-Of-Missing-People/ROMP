package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class ViewScene {
	// Feilds
	private GridPane pane;
	private Button cancel;
	private TableView<DNArecord> myDataTable;
	/**
	 * @param stage
	 */
	public ViewScene(Stage stage) {
		initialize(stage);
	}

	/**
	 * @param stage
	 */
	@SuppressWarnings("unchecked")
	private void initialize(Stage stage) {
		BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150, 70, 150));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setBackground(background);

		Image img01 = new Image("images/logo.png");
		ImageView v01 = new ImageView(img01);
		v01.setFitWidth(100);
		v01.setFitHeight(100);

		Button logo01 = new Button();
		GridPane.setHalignment(logo01, HPos.CENTER);
		logo01.setPrefSize(100, 100);
		logo01.setGraphic(v01);
		logo01.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane.add(logo01, 1, 0);
         
    	myDataTable = new TableView<DNArecord>();
    	TableColumn<DNArecord, Integer> idColumn = new TableColumn<>("ID");
    	idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

    	TableColumn<DNArecord, String> nameColumn = new TableColumn<>("Name");
    	nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    	TableColumn<DNArecord, Integer> numberColumn = new TableColumn<>("Number");
    	numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

    	TableColumn<DNArecord, String> filePathColumn = new TableColumn<>("File Path");
    	filePathColumn.setCellValueFactory(new PropertyValueFactory<>("dNA"));
    	
      	TableColumn<DNArecord, String> detailsColumn = new TableColumn<>("Details");
      	detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));

    	myDataTable.getColumns().addAll(idColumn, nameColumn, numberColumn, filePathColumn, detailsColumn); 
    	
    	myDataTable.setStyle("-fx-font-family: Monospace;-fx-font-size: 16px;");
    	myDataTable.setPadding(new Insets(10));
    	myDataTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		
    	myDataTable.setCenterShape(true);
    	myDataTable.setPrefWidth(1000);
		pane.add(myDataTable, 1, 1);
		
        cancel = new Button("Close");
        cancel.setPrefSize(100,30);
        cancel.setFont(Font.font(14));
        cancel.setTextFill(Color.BLACK);
        cancel.setStyle("-fx-font-family: Monospace;-fx-background-color: #9FD8CB;");
        GridPane.setHalignment(cancel, HPos.CENTER);
        pane.add(cancel,1,2);
        
        Scene scene = new Scene(pane);
        stage.setTitle("DNA Table");
        stage.setScene(scene);
		stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
		stage.show();
	}
	
	/*
	 * Getter and Setters
	 */
	/**
	 * @return
	 */
	public GridPane getPane() {
		return pane;
	}

	/**
	 * @param pane
	 */
	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	/**
	 * @return
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @param cancel
	 */
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public TableView<DNArecord> getMyDataTable() {
		return myDataTable;
	}

	public void setMyDataTable(TableView<DNArecord> myDataTable) {
		this.myDataTable = myDataTable;
	}
	
	
}