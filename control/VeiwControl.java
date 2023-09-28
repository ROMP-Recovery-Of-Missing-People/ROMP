package control;

import dataAccess.GetRelativeQuery;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DNArecord;
import visualization.ViewScene;

public class VeiwControl {
	private ViewScene scene;
	private Button cancel;
	private TableView<DNArecord> myDataTable;

	public VeiwControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {

		setScene(new ViewScene(stage));
		setCancel(getScene().getCancel());
		setMyDataTable(getScene().getMyDataTable());

		getMyDataTable().setItems(FXCollections.observableArrayList(GetRelativeQuery.retrieveData()));

		handle_cancel(getCancel(), stage);

	}

	private void handle_cancel(Button cancel, Stage stage) {
		cancel.setOnAction(k -> {
			new RunControl(stage);
		});
	}

	public ViewScene getScene() {
		return scene;
	}

	public void setScene(ViewScene scene) {
		this.scene = scene;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public TableView<DNArecord> getMyDataTable() {
		return myDataTable;
	}

	public void setMyDataTable(TableView<DNArecord> myDataTable) {
		this.myDataTable = myDataTable;
	}
}