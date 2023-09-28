package control;

import java.io.File;
import dataAccess.InsertMissingQuery;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.DNArecord;
import visualization.AddMissScene;

public class AddMisControl {
	// Feilds
	private AddMissScene scene;
	private Button browse;
	private File selectedFile;
	private TextArea detT;

	private Button add;
	private Button cancel2;

	/**
	 * @param stage
	 */
	public AddMisControl(Stage stage) {
		initizlie(stage);
	}

	/**
	 * @param stage
	 */
	private void initizlie(Stage stage) {
		setScene(new AddMissScene(stage));
		setBrowse(getScene().getBrowse());
		setDetT(getScene().getDetT());
		
		setAdd(getScene().getAdd());
		setCancel2(getScene().getCancel2());

		handle_add(getAdd());
		handle_browse(getBrowse());
		handle_cancel(getCancel2(), stage);
	}

	/**
	 * @param browse2
	 */
	private void handle_browse(Button browse2) {
		browse2.setOnAction(e->{
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

	/**
	 * @param add
	 * @param num 
	 * @param name 
	 * @param filepath 
	 */
	private void handle_add(Button add) {
		add.setOnAction(o -> {
			DNArecord newRecord = new DNArecord(selectedFile.getName(), detT.getText());
			int id =InsertMissingQuery.insertMissingData(newRecord, selectedFile);
			if(id==-1) {
				new AddAnswerControl(false);
			}else{
				new AddAnswerControl(true);
				getDetT().setText("");
				selectedFile=null;
			}
		});
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @param cance
	 * @param stage
	 */
	private void handle_cancel(Button cance, Stage stage) {
		cance.setOnAction(o -> {
			new RunControl(stage);
		});
	}

	/**
	 * @return
	 */
	public Button getAdd() {
		return add;
	}

	/**
	 * @param add
	 */
	public void setAdd(Button add) {
		this.add = add;
	}

	/**
	 * @return
	 */
	public Button getCancel2() {
		return cancel2;
	}

	public TextArea getDetT() {
		return detT;
	}

	public void setDetT(TextArea detT) {
		this.detT = detT;
	}

	/**
	 * @param cancel2
	 */
	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}

	/**
	 * @return
	 */
	public AddMissScene getScene() {
		return scene;
	}

	/**
	 * @param scene
	 */
	public void setScene(AddMissScene scene) {
		this.scene = scene;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}
}