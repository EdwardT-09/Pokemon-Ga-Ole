public class EndGameModel {
    private EndGameView endGameView = new EndGameView();

    // Constructor
    public EndGameModel() {
    }

    // View Methods
    public void updateView() {
        endGameView.display();
    }
    public boolean getSummaryPage() {
        return endGameView.summaryPage;
    }
    public boolean getContinueGame() {
        return endGameView.continueGame;
    }
}
