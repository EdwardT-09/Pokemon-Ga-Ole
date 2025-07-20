import java.util.concurrent.TimeUnit;

public class LoginController {
    public static void main(String[] args) throws InterruptedException {
        // Starts the game by displaying start screen
        LoginModel loginModel = new LoginModel();
        loginModel.updateView();
        // Proceeds when user clicks start
        while (loginModel.getStayTitleScreen()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // Calls the trainer driver class
        TrainerController.main(null);
    }
}
