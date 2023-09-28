package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.AddOptionScene;

public class AddOptionControl {
	private AddOptionScene scene;
	private Button relative;
	private Button missing;
	
	public AddOptionControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setScene(new AddOptionScene(stage));
		setMissing(getScene().getMissing());
		setRelative(getScene().getRelative());
		
		handle_missing(getMissing(),stage);
		handle_relative(getRelative(), stage);
	}

	private void handle_relative(Button button,Stage stage) {
		button.setOnAction(e->
			new AddRelControl(stage)
		);
	}

	private void handle_missing(Button button, Stage stage) {
		button.setOnAction(e->
			new AddMisControl(stage)
		);
	}

	public AddOptionScene getScene() {
		return scene;
	}

	public void setScene(AddOptionScene scene) {
		this.scene = scene;
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