package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddRelScene {
	private TextField namet;
	private TextField numt;
	private GridPane pane;
	private Button browse;
	
	private TextArea detT;
	private Button add;
	private Button cancel2;

	public AddRelScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
	    BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c);
	    
		pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(100,100,100,100));
        pane.setHgap(10.5);
        pane.setVgap(10.5);
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
        
        Label namee = new Label(("Name: "));
        namee.setFont(Font.font(16));
        //GridPane.setHalignment(namel, HPos.CENTER);
        namee.setTextFill(Color.BLACK);
        pane.add(namee, 0, 1);
        namee.setStyle("-fx-font-family: Monospace;");
        
        namet = new TextField();
        namet.setPrefSize(150, 30);
        GridPane.setHalignment(namet, HPos.CENTER);
        pane.add(namet, 1, 1);

        Label num = new Label(("Number: "));
        num.setFont(Font.font(16));
        //GridPane.setHalignment(namel, HPos.CENTER);
        num.setTextFill(Color.BLACK);
        pane.add(num, 0, 2);
        num.setStyle("-fx-font-family: Monospace;");
        
        numt = new TextField();
        numt.setPrefSize(150, 30);
        GridPane.setHalignment(numt, HPos.CENTER);
        pane.add(numt, 1, 2);
        
        Label sample1 = new Label(("DNA sample: "));
        sample1.setFont(Font.font(18));
        sample1.setTextFill(Color.BLACK);
        pane.add(sample1, 0, 3);
        sample1.setStyle("-fx-font-family: Monospace;");
        
        browse = new Button("Browse Sample");
        browse.setPrefSize(160,30);
        browse.setFont(Font.font(16));
        browse.setTextFill(Color.WHITE);
        browse.setStyle("-fx-background-color: #517664;-fx-font-family: Monospace;");
        GridPane.setHalignment(browse, HPos.CENTER);
        pane.add(browse, 1, 3);
        
        Label det = new Label(("Details: "));
        det.setFont(Font.font(18));
        det.setTextFill(Color.BLACK);
        pane.add(det, 0, 4);
        det.setStyle("-fx-font-family: Monospace;");
        
        detT = new TextArea();
        detT.setPrefSize(200, 100);
        GridPane.setHalignment(detT, HPos.CENTER);
        pane.add(detT, 1, 4);
        
        add = new Button("Add");
        add.setPrefSize(100,30);
        add.setFont(Font.font(16));
        add.setTextFill(Color.WHITE);
        add.setStyle("-fx-background-color: #517664;-fx-font-family: Monospace;");
        GridPane.setHalignment(add, HPos.CENTER);
        pane.add(add, 0, 5);
        
        cancel2 = new Button("Cancel");
        cancel2.setPrefSize(100,30);
        cancel2.setFont(Font.font(16));
        cancel2.setTextFill(Color.WHITE);
        cancel2.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
        GridPane.setHalignment(cancel2, HPos.CENTER);
        pane.add(cancel2, 1, 5);
        
        Scene scene2 = new Scene(pane);
        stage.setScene(scene2);
        stage.setTitle("Add a new record");
        stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
        stage.show();
	}

	public TextField getNamet() {
		return namet;
	}

	public void setNamet(TextField namet) {
		this.namet = namet;
	}

	public TextField getNumt() {
		return numt;
	}

	public void setNumt(TextField numt) {
		this.numt = numt;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public Button getCancel2() {
		return cancel2;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}

	public TextArea getDetT() {
		return detT;
	}

	public void setDetT(TextArea detT) {
		this.detT = detT;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}
}
