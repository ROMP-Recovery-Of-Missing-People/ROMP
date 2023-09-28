package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DNArecord;
import visualization.MatchDNAAnswerScene;

public class MatchDNAAnswerControl {
	private MatchDNAAnswerScene scene;
	private Button cancel;
	private Stage stage;
	private TableView<DNArecord> myDataTable;
	private Label details;

	public MatchDNAAnswerControl() {
		initialize();
	}

	private void initialize() {
		setScene(new MatchDNAAnswerScene());
		setStage(getScene().getStage());
		setDetails(getScene().getDetails());
		
		setCancel(getScene().getCancel());
		setMyDataTable(getScene().getMyDataTable());
		
		ObservableList<DNArecord> matchResults = FXCollections.observableArrayList();   ;
		
        DNArecord record1 = new DNArecord(32, "A 48-year-old male, lost contact during a rescue mission in a war zone, aiding civilians trapped in the crossfire.", 1.56);
        DNArecord record2 = new DNArecord(45, "A 47-year-old male, last seen jugging went hiking", 1.34);
        DNArecord record3 = new DNArecord(83, "A 45-year-old man, on June 10, 2022, and his colleagues are actively assisting in the search for answers.", 46.54);
        DNArecord record4 = new DNArecord(4, "A 40-year-old male, last known to be near the park", 0.0243);

        matchResults.add(record1);
        matchResults.add(record3);
        matchResults.add(record4);
        matchResults.add(record2);
        
        myDataTable.setItems(matchResults);
        handle_canel(getCancel(), getStage());
	}

	private void handle_canel(Button cancel2, Stage stage2) {
		cancel2.setOnAction(e -> {
			stage2.close();
		});
	}

	public MatchDNAAnswerScene getScene() {
		return scene;
	}

	public void setScene(MatchDNAAnswerScene scene) {
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