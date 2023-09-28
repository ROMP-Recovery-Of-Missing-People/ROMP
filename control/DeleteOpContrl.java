package control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import visualization.DeleteOpcene;

public class DeleteOpContrl {
	// Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	private Button yes;
	private GridPane pane;
	private DeleteOpcene scene;

	public DeleteOpContrl(int id) {
		initialize(id);
	}

	private void initialize(int id) {
		setScene(new DeleteOpcene(id));
		setWindow(getScene().getWindow());
		setMessage(getScene().getMessage());
		setCancel(getScene().getCancel());
		setYes(getScene().getYes());
		setPane(getScene().getPane());
	
		handle_yes(getYes(), id);
		hanle_cancel(getCancel(), getWindow());
	}

	private void hanle_cancel(Button cancel2, Stage window2) {
		cancel2.setOnAction(e->{
			window2.close();
		});
	}

	private void handle_yes(Button yes2, int id) {
		yes2.setOnAction(e->{
			new DeleteAnswerControl(id);
		});
	}

	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Button getYes() {
		return yes;
	}

	public void setYes(Button yes) {
		this.yes = yes;
	}

	public DeleteOpcene getScene() {
		return scene;
	}

	public void setScene(DeleteOpcene scene) {
		this.scene = scene;
	}

}
