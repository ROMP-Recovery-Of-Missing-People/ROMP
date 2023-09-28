package control;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.RunScene;

public class RunControl {
	private RunScene scene;

	private Button matchDNA;
	private Button exit;
	private Button add;
	private Button view;
	private Button search;
	private Button delete;

	public RunControl(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		setScene(new RunScene(stage));

		setAdd(getScene().getAdd());
		setView(getScene().getView());
		setDelete(getScene().getDelete());
		setSearch(getScene().getSearch());
		setMatchDNA(getScene().getMatchDNA());
		setExit(getScene().getExit());
		
		handle_add(getAdd(), stage);
		handle_delete(getDelete(), stage);
		hanlde_view(getView(), stage);
		handle_search(getSearch(), stage);
		handle_exit(getExit());
		handle_matchDNA(getMatchDNA(), stage);
	}

	private void handle_exit(Button exit2) {
		exit2.setOnAction(e->{
			Platform.exit();
		});
	}

	private void handle_matchDNA(Button matchDNA2, Stage stage) {
		matchDNA2.setOnAction(e->{
			@SuppressWarnings("unused")
			MatchDNAControl scene = new MatchDNAControl(stage);
		});
	}

	private void handle_search(Button search2, Stage stage) {
		search2.setOnAction(e->{
			@SuppressWarnings("unused")
			SearchContrtol scene = new SearchContrtol(stage);
		});
	}

	private void hanlde_view(Button view2, Stage stage) {
		view2.setOnAction(e->{
			@SuppressWarnings("unused")
			VeiwControl scene = new VeiwControl(stage);
		});
	}

	private void handle_delete(Button delete2, Stage stage) {
		delete2.setOnAction(e->{
			@SuppressWarnings("unused")
			DeleteControl scene = new DeleteControl(stage);
		});
	}

	private void handle_add(Button add2, Stage stage) {
		add2.setOnAction(e->{
			@SuppressWarnings("unused")
			AddOptionControl scene = new AddOptionControl(stage);
		});
	}

	public RunScene getScene() {
		return scene;
	}

	public void setScene(RunScene scene) {
		this.scene = scene;
	}

	public Button getMatchDNA() {
		return matchDNA;
	}

	public void setMatchDNA(Button matchDNA) {
		this.matchDNA = matchDNA;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public Button getView() {
		return view;
	}

	public void setView(Button view) {
		this.view = view;
	}

	public Button getSearch() {
		return search;
	}

	public void setSearch(Button search) {
		this.search = search;
	}

	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
	}
}
