import java.util.concurrent.TimeUnit;

public class CatchController {
    public static CatchModel catchModelPokemon = new CatchModel();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            catchModelPokemon.updateView();
            while (!catchModelPokemon.getCatchNext()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        EndGameController.main(null);
    }
}
