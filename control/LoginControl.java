package control;


import dataAccess.DatabaseConnection;
import dataAccess.UserLogin;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import visualization.LoginScene;

public class LoginControl {
	private LoginScene scene;

	private TextField name;
	private PasswordField pass;

	private Button run;
	private Button cancel;

	public LoginControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setScene(new LoginScene(stage));

		setName(getScene().getName());
		setPass(getScene().getPass());

		setRun(getScene().getRun());
		setCancel(getScene().getCancel());

		handle_cancel(getCancel());
		System.out.println(getName().getText());
		handle_run(getRun(), stage);
	}

	private void handle_run(Button run2, Stage stage) {
		run2.setOnAction(e -> {
			String usename=getName().getText().trim();
			String pass=getPass().getText().trim();
			DatabaseConnection dbConnection = new DatabaseConnection("jdbc:mysql://127.0.0.1:3306/romp" + "", "root",
				"");
			try {
				dbConnection.connect();

				UserLogin userLogin = new UserLogin(dbConnection);

				boolean loginResult = userLogin.login(usename, pass);

				if (loginResult==true) {
					new RunControl(stage);
				} else {
					AlertBoxCtrl a = new AlertBoxCtrl("Wrong Authentication, enter a right one!",
							"Wrong Authentication");
					a.show();
				}
			} catch (Exception e1) {
				AlertBoxCtrl a = new AlertBoxCtrl(e1.getLocalizedMessage(), e1.getMessage());
				a.show();
			}
		});
	}

	private void handle_cancel(Button cancel2) {
		cancel2.setOnAction(e -> Platform.exit());
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public PasswordField getPass() {
		return pass;
	}

	public void setPass(PasswordField pass) {
		this.pass = pass;
	}

	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public LoginScene getScene() {
		return scene;
	}

	public void setScene(LoginScene scene) {
		this.scene = scene;
	}
}