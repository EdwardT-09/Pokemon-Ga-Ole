import java.util.concurrent.TimeUnit;

public class FreePokemonController {
    public static void main(String[] args) throws InterruptedException {
        // Displays the options of free pokemon for user to choose
        FreePokemonModel freePokemonModel = new FreePokemonModel();
        freePokemonModel.updateDisplay();
        while (freePokemonModel.getStayFreePokemon()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        BattleController.main(null);
    }
}