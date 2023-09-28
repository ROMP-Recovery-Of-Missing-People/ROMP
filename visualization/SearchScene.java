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

public class SearchScene {
	private TextField name;
	private Button search;
	private Button cancel2;

	public SearchScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(170, 170, 170, 170));
		pane.setHgap(15);
		pane.setVgap(15);
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

		Label filel = new Label(("Search"));
		filel.setFont(Font.font(20));
		filel.setStyle("-fx-font-family: Monospace;-fx-font-weight: bold;");
		filel.setTextFill(Color.BLACK);
		pane.add(filel, 0, 0);

		Label samplel = new Label(("Enter a name: "));
		samplel.setFont(Font.font(20));
		samplel.setStyle("-fx-font-family: Monospace;");
		samplel.setTextFill(Color.BLACK);
		pane.add(samplel, 0, 1);

		name = new TextField();
		name.setPrefSize(150, 30);
		GridPane.setHalignment(name, HPos.CENTER);
		pane.add(name, 1, 1);

		search = new Button("Search");
		search.setPrefSize(100, 30);
		search.setFont(Font.font(14));
		search.setTextFill(Color.WHITE);
		search.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
		GridPane.setHalignment(search, HPos.CENTER);
		pane.add(search, 0, 2);

		cancel2 = new Button("Cancel");
		cancel2.setPrefSize(100, 30);
		cancel2.setFont(Font.font(14));
		cancel2.setTextFill(Color.WHITE);
		cancel2.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
		GridPane.setHalignment(cancel2, HPos.CENTER);
		pane.add(cancel2, 1, 2);

		Scene scene2 = new Scene(pane);
		stage.setScene(scene2);
		stage.setTitle("Search DNA");
		stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
		stage.show();
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField sample) {
		this.name = sample;
	}

	public Button getSearch() {
		return search;
	}

	public void setSearch(Button search) {
		this.search = search;
	}

	public Button getCancel2() {
		return cancel2;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}
}