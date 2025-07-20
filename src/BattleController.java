import java.util.concurrent.TimeUnit;

public class BattleController {
    public static BattleModel pokemonBattleModel = new BattleModel();

    public static void main(String[] args) throws InterruptedException {
        pokemonBattleModel.setAlly(TrainerModel.trainerModel.chooseParty());
        pokemonBattleModel.setEnemy(StageController.stageModel.spawnEncounters(StageController.stageModel.getStageOption()));
        pokemonBattleModel.setBattleEnd(false);
        pokemonBattleModel.setRound1(true);
        while (!pokemonBattleModel.getBattleEnd()) {
            pokemonBattleModel.updateView(StageController.stageModel.getStageOption());
            //
            while (!pokemonBattleModel.getMoveOccurred()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            switch (pokemonBattleModel.getAttackerOrDefender()) {
                case 1:
                    pokemonBattleModel.setPokemonAttacked(pokemonBattleModel.getAllyAttacked());
                    pokemonBattleModel.setRound1(false);
                    DefenderController.main(null);
                    break;
                case 2:
                    pokemonBattleModel.setPokemonAttacked(pokemonBattleModel.getAllyAttacked());
                    pokemonBattleModel.setRound1(false);
                    DefenderController.main(null);
                    break;
                case 3:
                    pokemonBattleModel.setPokemonAttacked(pokemonBattleModel.getEnemyAttacked());
                    pokemonBattleModel.setRound1(false);
                    AttackerController.main(null);
                    break;
                default:
                    pokemonBattleModel.setPokemonAttacked(pokemonBattleModel.getEnemyAttacked());
                    pokemonBattleModel.setRound1(false);
                    AttackerController.main(null);
            }
        }
        pokemonBattleModel.updateView(StageController.stageModel.getStageOption());
        //
        CatchController.main(null);
    }
}
