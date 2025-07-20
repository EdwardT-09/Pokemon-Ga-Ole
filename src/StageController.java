import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class StageController {
    public static StageModel stageModel = new StageModel();
    // Calls this class to make 3 different stages with different more likely pokemon
    public static StageModel lake = new StageModel("Lakeside", PokedexModel.allPokemon.get(4), PokedexModel.allPokemon.get(3), PokedexModel.allPokemon.get(0),
            PokedexModel.allPokemon.get(19), PokedexModel.allPokemon.get(1));
    public static StageModel volcano = new StageModel("Volcano", PokedexModel.allPokemon.get(8), PokedexModel.allPokemon.get(5), PokedexModel.allPokemon.get(16),
            PokedexModel.allPokemon.get(7), PokedexModel.allPokemon.get(6));
    public static StageModel desert = new StageModel("Desert", PokedexModel.allPokemon.get(24), PokedexModel.allPokemon.get(23), PokedexModel.allPokemon.get(11),
            PokedexModel.allPokemon.get(20), PokedexModel.allPokemon.get(21));

    // List of other spawnable pokemon
    public static PokedexModel[] otherSpawnablePokemon = {PokedexModel.allPokemon.get(10), PokedexModel.allPokemon.get(11),
            PokedexModel.allPokemon.get(14), PokedexModel.allPokemon.get(15),
            PokedexModel.allPokemon.get(2), PokedexModel.allPokemon.get(12),
            PokedexModel.allPokemon.get(22), PokedexModel.allPokemon.get(18),
            PokedexModel.allPokemon.get(10), PokedexModel.allPokemon.get(11),
            PokedexModel.allPokemon.get(9), PokedexModel.allPokemon.get(12),
            PokedexModel.allPokemon.get(22), PokedexModel.allPokemon.get(18),
            PokedexModel.allPokemon.get(6), PokedexModel.allPokemon.get(20)};

    // String list of the names of the more likely pokemon to spawn
    public static PokedexModel[] lakePokemon = {StageController.lake.getPoke1(), StageController.lake.getPoke2(), StageController.lake.getPoke3(), StageController.lake.getPoke4(), StageController.lake.getPoke5(), StageController.lake.getPoke2(), StageController.lake.getPoke3(), StageController.lake.getPoke4(), StageController.lake.getPoke5()};
    public static PokedexModel[] volcanoPokemon = {StageController.volcano.getPoke1(), StageController.volcano.getPoke2(), StageController.volcano.getPoke3(), StageController.volcano.getPoke4(), StageController.volcano.getPoke5(), StageController.volcano.getPoke2(), StageController.volcano.getPoke3(), StageController.volcano.getPoke4(), StageController.volcano.getPoke5()};
    public static PokedexModel[] desertPokemon = {StageController.desert.getPoke1(), StageController.desert.getPoke2(), StageController.desert.getPoke3(), StageController.desert.getPoke4(), StageController.desert.getPoke5(), StageController.desert.getPoke2(), StageController.desert.getPoke3(), StageController.desert.getPoke4(), StageController.desert.getPoke5()};

    public static void main(String[] args) throws InterruptedException {
        // Displays the options of stages to choose from
        stageModel.updateView();
        // Proceeds when user chooses a stage
        while (Objects.equals(stageModel.getStageOption(), "")) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // Calls the free pokemon driver for user to choose a free pokemon
        FreePokemonController.main(null);
    }
}