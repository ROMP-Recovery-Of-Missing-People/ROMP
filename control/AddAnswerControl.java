package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.AddAnswerScene;

public class AddAnswerControl {
	private AddAnswerScene scene;
	private Button cancel2;

	public AddAnswerControl(boolean ans) {
		initialize(ans);
	}
	
	private void initialize(boolean ans) {
		String  text="";
		
		try {
			if(ans==true)
				text="Record Inserted Successfully!\n";
			else if(ans==false)
				text="Error in insertion to database!\n";
		} catch (Exception l) {
			text="Please Make sure you are inputting the right input\n";
		}
		setScene(new AddAnswerScene(text));
		setCancel2(getScene().getCancel2());
		handle_hancel(getCancel2(),getScene().getStage3());
	}

	private void handle_hancel(Button cancel22, Stage stage3) {
		cancel22.setOnAction(e->{
			stage3.close();
		});		
	}

	public AddAnswerScene getScene() {
		return scene;
	}

	public void setScene(AddAnswerScene scene) {
		this.scene = scene;
	}

	public Button getCancel2() {
		return cancel2;
	}

	public void setCancel2(Button cancel2) {
		this.cancel2 = cancel2;
	}
}