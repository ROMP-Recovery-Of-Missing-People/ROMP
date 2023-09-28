package control;

import java.io.File;
import dataAccess.InsertRelativeQuery;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.DNArecord;
import visualization.AddRelScene;

public class AddRelControl {
	// Feilds
	private AddRelScene scene;

	private TextField namet;
	private TextField numt;
	private TextArea detT;
	
	private File selectedFile;
	
	private Button browse;
	private Button add;
	private Button cancel2;

	/**
	 * @param stage
	 */
	public AddRelControl(Stage stage) {
		initizlie(stage);
	}

	/**
	 * @param stage
	 */
	private void initizlie(Stage stage) {
		setScene(new AddRelScene(stage));

		setNamet(getScene().getNamet());
		setNumt(getScene().getNumt());
		setBrowse(getScene().getBrowse());

		setDetT(getScene().getDetT());

		setAdd(getScene().getAdd());
		setCancel2(getScene().getCancel2());

		handle_browse(getBrowse());
		handle_add(getAdd());
		handle_cancel(getCancel2(), stage);
	}

	/**
	 * @param browse2
	 */
	private void handle_browse(Button browse2) {
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

	/**
	 * @param add
	 * @param num
	 * @param name
	 * @param filepath
	 */
	private void handle_add(Button add) {
		add.setOnAction(o -> {
			DNArecord newRecord = new DNArecord(namet.getText(), Integer.parseInt(numt.getText()),
					selectedFile.getName(), detT.getText());
			int id =InsertRelativeQuery.insertRelativesData(newRecord, selectedFile);
			if(id==-1) {
				new AddAnswerControl(false);
			}else{
				new AddAnswerControl(true);
				getDetT().setText("");
				getNumt().setText("");
				getNamet().setText("");
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
	public TextField getNamet() {
		return namet;
	}

	/**
	 * @param namet
	 */
	public void setNamet(TextField namet) {
		this.namet = namet;
	}

	/**
	 * @return
	 */
	public TextField getNumt() {
		return numt;
	}

	/**
	 * @param numt
	 */
	public void setNumt(TextField numt) {
		this.numt = numt;
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

	/**
	 * @param cancel2
	 */
	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}

	/**
	 * @return
	 */
	public AddRelScene getScene() {
		return scene;
	}

	/**
	 * @param scene
	 */
	public void setScene(AddRelScene scene) {
		this.scene = scene;
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