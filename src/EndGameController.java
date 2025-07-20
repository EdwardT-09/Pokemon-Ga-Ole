import java.util.concurrent.TimeUnit;

public class EndGameController {
    public static void main(String[] args) {
        EndGameModel endGameModel = new EndGameModel();
        endGameModel.updateView();
        while (endGameModel.getSummaryPage()) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        TrainerModel.trainerModel.setGoldenChip(TrainerModel.trainerModel.getGoldenChip() + CatchController.catchModelPokemon.getPokemonCaught());
        TrainerModel.trainerModel.addScore(BattleController.pokemonBattleModel.getBattleScore());
        TrainerModel.trainerModel.determineScorePlacement();
        TrainerModel.trainerModel.updateProfile();

        CatchController.catchModelPokemon.resetPokemonCaught();
        CatchController.catchModelPokemon.resetPokemonGradeCaught();
        BattleController.pokemonBattleModel.setCatchgauge1(0);
        BattleController.pokemonBattleModel.setCatchgauge2(0);
        BattleController.pokemonBattleModel.setAtkgaugeEnemy1(0);
        BattleController.pokemonBattleModel.setAtkgaugeEnemy2(0);
        BattleController.pokemonBattleModel.setAtkgaugeAlly1(0);
        BattleController.pokemonBattleModel.setAtkgaugeAlly2(0);
        BattleController.pokemonBattleModel.setBattleScore(0);
        if (endGameModel.getContinueGame()) {
            try {
                TrainerController.main(null);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            TrainerModel.trainerModel.updateProfile();
            System.out.println("Logging Out...");
            System.exit(0);
        }
    }
}
