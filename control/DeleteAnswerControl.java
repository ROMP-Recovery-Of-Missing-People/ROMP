package control;

import dataAccess.DeleteRelQuery;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.DeleteAnswerScene;

public class DeleteAnswerControl {
	private DeleteAnswerScene scene;
	private Button cancel2;

	public DeleteAnswerControl(int id) {
		initialzie(id);
	}

	private void initialzie(int id) {

		boolean isDeleted = DeleteRelQuery.deleteRelativeRecord(id);
		String text = "";
		if (isDeleted) {
			text="Record deleted successfully.";

		} else {
			text="Record not found or deletion failed.";
		}
		setScene(new DeleteAnswerScene(text));
		setCancel2(getScene().getCancel2());
		handle_cancel(getCancel2(), getScene().getStage3());
	}

	private void handle_cancel(Button cancel22, Stage stage32) {
		cancel22.setOnAction(e -> {
			stage32.close();
		});
	}

	public DeleteAnswerScene getScene() {
		return scene;
	}

	public void setScene(DeleteAnswerScene scene) {
		this.scene = scene;
	}

	public Button getCancel2() {
		return cancel2;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}
}