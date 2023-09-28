package control;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import visualization.SearchScene;

public class SearchContrtol {
	private SearchScene scene;

	private TextField sample;
	private Button search;
	private Button cancel2;

	public SearchContrtol(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setScene(new SearchScene(stage));
		
		setSample(getScene().getName());
		setSearch(getScene().getSearch());
		setCancel2(getScene().getCancel2());
		
		handle_search(getSearch());
		handle_cancel(getCancel2(), stage);
	}

	private void handle_cancel(Button cancel22, Stage stage) {
		cancel22.setOnAction(
				o -> {	
				@SuppressWarnings("unused")
				RunControl scene = new RunControl(stage);
		});	}

	private void handle_search(Button search2) {
		search.setOnAction(o -> {
			

			@SuppressWarnings("unused")
			SearchAnswerControl scene = new SearchAnswerControl(sample.getText().trim());
		});
		
	}

	public SearchScene getScene() {
		return scene;
	}

	public void setScene(SearchScene scene) {
		this.scene = scene;
	}

	public TextField getSample() {
		return sample;
	}

	public void setSample(TextField sample) {
		this.sample = sample;
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