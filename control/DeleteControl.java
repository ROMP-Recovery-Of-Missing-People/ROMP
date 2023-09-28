package control;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import visualization.DeleteScene;

public class DeleteControl {
	private DeleteScene scene;

	private Button cancel;
	private Button delete;
	private TextField id;

	public DeleteControl(Stage stgae) {
		initialize(stgae);
	}

	private void initialize(Stage stage) {
		setScene(new DeleteScene(stage));

		setCancel(getScene().getCancel2());
		setDelete(getScene().getDelete());
		setId(getScene().getId());

		handle_cancel(cancel, stage);
		handle_delete(delete);
	}

	private void handle_cancel(Button cancel, Stage stage) {
		cancel.setOnAction(o -> {
			new RunControl(stage);
		});
	}

	private void handle_delete(Button delete) {
		delete.setOnAction(o -> {
			try {
				new DeleteOpContrl(Integer.parseInt(getId().getText().trim()));
			}catch (Exception e) {
				AlertBoxCtrl a = new AlertBoxCtrl(e.getMessage(), e.getMessage());
				a.show();
			}
		});
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
	}

	public TextField getId() {
		return id;
	}

	public void setId(TextField id) {
		this.id = id;
	}

	public DeleteScene getScene() {
		return scene;
	}

	public void setScene(DeleteScene scene) {
		this.scene = scene;
	}
}