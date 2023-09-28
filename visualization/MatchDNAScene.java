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

public class MatchDNAScene {
	private Button match;
	private Button cancel2;
	private Button browse;

	public MatchDNAScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
	    BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c);
	    
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(170,170,170,170));
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
	    logo01.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
	    pane.add(logo01, 1, 0);
     
		Label filel = new Label(("Chose samples files"));
		filel.setFont(Font.font(17));
		filel.setTextFill(Color.BLACK);
		filel.setStyle("-fx-font-family: Monospace;-fx-font-weight: bold;");
		pane.add(filel, 0, 0);
        
	    Label sample1 = new Label(("DNA sample: "));
	    sample1.setFont(Font.font(16));
	    sample1.setTextFill(Color.BLACK);
	    sample1.setStyle("-fx-font-family: Monospace;");
	    pane.add(sample1, 0, 1);
	    
        browse = new Button("Browse Sample");
        browse.setPrefSize(160,30);
        browse.setFont(Font.font(16));
        browse.setTextFill(Color.WHITE);
        browse.setStyle("-fx-background-color: #000000;-fx-font-family: Monospace;");
        GridPane.setHalignment(browse, HPos.CENTER);
        pane.add(browse, 1, 1);
     
    	match = new Button("Find a match");
    	match.setPrefSize(150,30);
    	match.setFont(Font.font(14));
    	match.setTextFill(Color.WHITE);
    	match.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
    	pane.add(match, 0, 3);
     
    	cancel2 = new Button("Cancel");
        cancel2.setPrefSize(100,30);
        cancel2.setFont(Font.font(14));
        cancel2.setTextFill(Color.WHITE);
        cancel2.setStyle("-fx-font-family: Monospace;-fx-background-color: #517664;");
        GridPane.setHalignment(cancel2, HPos.CENTER);
        pane.add(cancel2, 1, 3);
        
        Scene scene2 = new Scene(pane);
        stage.setScene(scene2);
        stage.setTitle("Match DNA samples");
        stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
        stage.show();		
	}

	public Button getMatch() {
		return match;
	}

	public void setMatch(Button match) {
		this.match = match;
	}

	public Button getCancel2() {
		return cancel2;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}	
}