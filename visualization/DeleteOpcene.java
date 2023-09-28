package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DeleteOpcene {
	//Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	private Button yes;
	private GridPane pane;
	
	public DeleteOpcene(int id) {
		initialize(id);
	}
	
	private void initialize(int id) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		window=new Stage();

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setHgap(15);
		pane1.setVgap(15);
		pane1.setBackground(background);
		pane.add(pane1, 0, 2);

		Image img = new Image("images/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(70);
		v.setFitHeight(70);

		Button logo = new Button();
		logo.setPrefSize(70, 70);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		message=new Label("Are you sure you want to delete record with id: "+id);
		message.setFont(Font.font("Monospace", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.DARKRED);
		pane.add(message, 0, 1);
		
		//User button to delete
		yes = new Button("Yes");
		yes.setFont(Font.font("Monospace", FontWeight.BOLD, FontPosture.REGULAR, 16));
		yes.setPrefSize(80, 20);
		yes.setTextFill(Color.WHITE);
		GridPane.setHalignment(yes,HPos.CENTER);
		yes.setStyle("-fx-font-family: Monospace;-fx-background-radius: 18, 7;-fx-background-color: #517664;");
		pane1.add(yes,0,0); 
		
		//User button to exit
		cancel = new Button("No");
		cancel.setFont(Font.font("Monospace", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel,HPos.CENTER);
		cancel.setStyle("-fx-font-family: Monospace;-fx-background-radius: 18, 7;-fx-background-color: #517664;");
		pane1.add(cancel,1,0); 

		Scene scene = new Scene(pane);
		window.setScene(scene);
        window.centerOnScreen();
		window.getIcons().add(new Image("images/logo.png"));
		window.show();
	}

	public Stage getWindow() {
		return window;
	}
	public void setWindow(Stage window) {
		this.window = window;
	}
	public Label getMessage() {
		return message;
	}
	public void setMessage(Label message) {
		this.message = message;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
	public GridPane getPane() {
		return pane;
	}
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	public Button getYes() {
		return yes;
	}
	public void setYes(Button yes) {
		this.yes = yes;
	}
}
