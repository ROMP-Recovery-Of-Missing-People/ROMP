package control;

import dataAccess.SearchByNameQuery;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DNArecord;
import visualization.SearchAnsweScene;

public class SearchAnswerControl {
	private SearchAnsweScene scene;
	private Button cancel;
	private Stage stage;
	private TableView<DNArecord> myDataTable;
	private Label details;

	public SearchAnswerControl(String name) {
		initialize(name);
	}

	private void initialize(String name) {
		setScene(new SearchAnsweScene());
		setStage(getScene().getStage());
		setDetails(getScene().getDetails());
		
		setCancel(getScene().getCancel());
		setMyDataTable(getScene().getMyDataTable());
		
		ObservableList<DNArecord> searchResults = SearchByNameQuery.searchByName(name);
        myDataTable.setItems(searchResults);
        if(searchResults.size()!= 0)	
        	getDetails().setText(searchResults.get(0).getDetails());
		handle_canel(getCancel(), getStage());
	}

	private void handle_canel(Button cancel2, Stage stage2) {
		cancel2.setOnAction(e -> {
			stage2.close();
		});
	}

	public SearchAnsweScene getScene() {
		return scene;
	}

	public void setScene(SearchAnsweScene scene) {
		this.scene = scene;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}


	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public TableView<DNArecord> getMyDataTable() {
		return myDataTable;
	}

	public void setMyDataTable(TableView<DNArecord> myDataTable) {
		this.myDataTable = myDataTable;
	}

	public Label getDetails() {
		return details;
	}

	public void setDetails(Label details) {
		this.details = details;
	}
}