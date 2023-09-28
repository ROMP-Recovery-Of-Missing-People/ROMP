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
import javafx.stage.Stage;

public class AddAnswerScene {
	private Label answer;
	private Button cancel2;
	private Stage stage3;

	public AddAnswerScene(String text) {
		initialize(text);
	}

	private void initialize(String text) {
	    BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c);
	    
		stage3 = new Stage();
		GridPane pane3 = new GridPane();
		pane3.setAlignment(Pos.CENTER);
		pane3.setPadding(new Insets(100, 100, 100, 100));
		pane3.setHgap(15);
		pane3.setVgap(15);
		pane3.setBackground(background);

		answer = new Label();
		answer.setFont(Font.font(18));
		answer.setText(text);
        answer.setStyle("-fx-font-family: Monospace;");

		pane3.add(answer, 1, 1);

		Image img01 = new Image("images/logo.png");
		ImageView v01 = new ImageView(img01);
		v01.setFitWidth(100);
		v01.setFitHeight(100);

		Button logo01 = new Button();
		GridPane.setHalignment(logo01, HPos.CENTER);
		logo01.setPrefSize(100, 100);
		logo01.setGraphic(v01);
		logo01.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane3.add(logo01, 1, 0);

		cancel2 = new Button("Okay");
		cancel2.setPrefSize(100, 30);
		cancel2.setFont(Font.font(14));
		cancel2.setTextFill(Color.WHITE);
		cancel2.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
		GridPane.setHalignment(cancel2, HPos.CENTER);
		pane3.add(cancel2, 1, 2);
		
		Scene scene3 = new Scene(pane3);
		stage3.setScene(scene3);
		stage3.setTitle("Add a new Record");
		stage3.getIcons().add(new Image("images/logo.png"));
        stage3.centerOnScreen();
		stage3.show();		
	}
	
	public Label getAnswer() {
		return answer;
	}

	public Stage getStage3() {
		return stage3;
	}

	public void setStage3(Stage stage3) {
		this.stage3 = stage3;
	}

	public void setAnswer(Label answer) {
		this.answer = answer;
	}

	public Button getCancel2() {
		return cancel2;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}
}