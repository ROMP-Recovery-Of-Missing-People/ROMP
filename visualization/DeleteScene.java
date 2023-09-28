package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class DeleteScene {
	private Button cancel2;
	private Button delete;
	private TextField id;

	public DeleteScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(50, 50, 50, 50));
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
		logo01.setStyle(
				"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane.add(logo01, 1, 0);

		Label hello2 = new Label(("Only delete by ID: "));
		hello2.setFont(Font.font(16));
		// GridPane.setHalignment(namel, HPos.CENTER);
		hello2.setTextFill(Color.BLACK);
		pane.add(hello2, 0, 0);
		hello2.setStyle("-fx-font-family: Monospace;");

		Label sample = new Label(("DNA relative id: "));
		sample.setFont(Font.font(16));
		// GridPane.setHalignment(namel, HPos.CENTER);
		sample.setTextFill(Color.BLACK);
		pane.add(sample, 0, 1);
		sample.setStyle("-fx-font-family: Monospace;");

		id = new TextField();
		id.setPrefSize(150, 30);
		GridPane.setHalignment(id, HPos.CENTER);
		pane.add(id, 1, 1);

		delete = new Button("Delete");
		delete.setPrefSize(100, 30);
		delete.setFont(Font.font(14));
		delete.setTextFill(Color.WHITE);
		delete.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
		GridPane.setHalignment(delete, HPos.CENTER);
		pane.add(delete, 0, 4);

		cancel2 = new Button("Cancel");
		cancel2.setPrefSize(100, 30);
		cancel2.setFont(Font.font(14));
		cancel2.setTextFill(Color.WHITE);
		cancel2.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
		GridPane.setHalignment(cancel2, HPos.CENTER);
		pane.add(cancel2, 1, 4);

		Scene scene2 = new Scene(pane);
		stage.setScene(scene2);
		stage.setTitle("Delete a record");
		stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
		stage.show();
	}

	public Button getCancel2() {
		return cancel2;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}

	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
	}

	public TextField getId() {
		return id;
	}

	public void setId(TextField id) {
		this.id = id;
	}
}