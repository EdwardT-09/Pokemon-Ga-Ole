import java.util.concurrent.TimeUnit;

public class PokedexController {
    public static void main(String[] args) throws InterruptedException {
        // Displays all the pokemon in the game
        PokedexModel pokedexModel = new PokedexModel();
        pokedexModel.updateView();
        // Proceeds when user chooses to back out of pokedex
        while (pokedexModel.getStayPokedex()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // Calls trainer driver to display the 2 options again(Profile/Battle)
        TrainerController.main(null);
    }
}
