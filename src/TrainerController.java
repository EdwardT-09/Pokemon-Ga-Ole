import java.util.concurrent.TimeUnit;

public class TrainerController {
    public static void main(String[] args) throws InterruptedException {
        // Displays trainer welcome message with 2 options
        TrainerModel trainerModel = new TrainerModel();
        trainerModel.updateView();
        // Proceeds when user chooses one of the two options(Profile/Battle)
        while (trainerModel.getStayMainMenu()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // Calls pokedex driver if user chooses pokedex in profile
        if (trainerModel.getSwitchPokedex()) {
            PokedexController.main(null);
        }
        // Calls stage driver if user chooses battle
        else {
            StageController.main(null);
        }

    }
}
