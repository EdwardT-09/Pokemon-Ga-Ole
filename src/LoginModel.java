public class LoginModel {
    private LoginView loginView = new LoginView();

    // Constructor
    public LoginModel() {
    }

    // View Methods
    public void updateView() {
        loginView.display();
    }
    public boolean getStayTitleScreen() {
        return loginView.stayTitleScreen;
    }
}
