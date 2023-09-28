package control;

import java.io.File;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import visualization.MatchDNAScene;

public class MatchDNAControl {
	private MatchDNAScene scene;
	private File selectedFile;

	private Button match;
	private Button browse;
	private Button cancel2;

	public MatchDNAControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setScene(new MatchDNAScene(stage));
		setMatch(getScene().getMatch());
		setCancel2(getScene().getCancel2());
		setBrowse(getScene().getBrowse());

		handle_broswe(getBrowse());
		handle_match(getMatch());
		handle_cancel(getCancel2(), stage);
	}

	private void handle_broswe(Button browse2) {
		browse2.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
			Stage stage = new Stage();
			stage.centerOnScreen();
			selectedFile = fileChooser.showOpenDialog(stage);

			if (selectedFile == null) {
				AlertBoxCtrl alert = new AlertBoxCtrl("You haven't chose a file", "Havn't chose a file");
				alert.show();
			}
		});
	}

	private void handle_cancel(Button cancel22, Stage stage) {
		cancel22.setOnAction(o -> {
			new RunControl(stage);
		});
	}

	private void handle_match(Button match2) {
		match2.setOnAction(o -> {
			new MatchDNAAnswerControl();
		});
	}

	public MatchDNAScene getScene() {
		return scene;
	}

	public void setScene(MatchDNAScene scene) {
		this.scene = scene;
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

	/**
	 * @param cancel2
	 */
	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}
}