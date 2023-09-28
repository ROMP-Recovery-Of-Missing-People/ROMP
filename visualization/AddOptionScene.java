package visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddOptionScene {
	private Button relative;
	private Button missing;

	public AddOptionScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c);
	    
	    GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(70));
        pane.setHgap(35);
        pane.setVgap(20);
        pane.setBackground(background);
        
        Image img1 = new Image("images/family-picture.png");
        ImageView v1 = new ImageView(img1);
        v1.setFitWidth(200);
        v1.setFitHeight(200);
                
	    relative =new Button();
	    relative.setPrefSize(200, 200);
	    relative.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color:#000000;");
	    relative.setGraphic(v1);
	    pane.add(relative, 0, 0);
                
	    Image img6 = new Image("images/mistery.png");
        ImageView v6 = new ImageView(img6);
        v6.setFitWidth(200);
        v6.setFitHeight(200);
        
        missing = new Button();
        missing.setPrefSize(200, 200);
        missing.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color:#000000;");
        missing.setGraphic(v6);
        pane.add(missing, 1, 0);
        
        Scene scene1 = new Scene(pane);
        stage.setScene(scene1);
        stage.setTitle("What do you want to add?");
        stage.getIcons().add(new Image("images/logo.png"));
        stage.centerOnScreen();
        stage.show();   
	}

	public Button getRelative() {
		return relative;
	}

	public void setRelative(Button relative) {
		this.relative = relative;
	}

	public Button getMissing() {
		return missing;
	}

	public void setMissing(Button missing) {
		this.missing = missing;
	}
}