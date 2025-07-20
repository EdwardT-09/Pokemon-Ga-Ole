import java.util.Objects;
import java.util.Random;

// Creates the stages with the likely pokemon to spawn that user can choose
public class StageModel {
    private StageView stageView = new StageView();

    private Random rand = new Random();
    private String name;
    private PokedexModel poke1, poke2, poke3, poke4, poke5;

    //Constructor
    public StageModel() {
    }
    public StageModel(String name, PokedexModel poke1, PokedexModel poke2, PokedexModel poke3, PokedexModel pok4, PokedexModel pok5) {
        this.name = name;
        this.poke1 = poke1;
        this.poke2 = poke2;
        this.poke3 = poke3;
        this.poke4 = pok4;
        this.poke5 = pok5;
    }

    // Getter
    public String getName() {
        return name;
    }
    public PokedexModel getPoke1() {
        return poke1;
    }
    public PokedexModel getPoke2() {
        return poke2;
    }
    public PokedexModel getPoke3() {
        return poke3;
    }
    public PokedexModel getPoke4() {
        return poke4;
    }
    public PokedexModel getPoke5() {
        return poke5;
    }
    public StageModel getLake() {
        return StageController.lake;
    }
    public StageModel getVolcano() {
        return StageController.volcano;
    }
    public StageModel getDesert() {
        return StageController.desert;
    }

    // Setter
    public void setStageView(StageView stageView) {
        this.stageView = stageView;
    }
    public void setPoke1(PokedexModel poke1) {
        this.poke1 = poke1;
    }
    public void setPoke3(PokedexModel poke3) {
        this.poke3 = poke3;
    }
    public void setPoke4(PokedexModel poke4) {
        this.poke4 = poke4;
    }
    public void setPoke5(PokedexModel poke5) {
        this.poke5 = poke5;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPoke2(PokedexModel poke2) {
        this.poke2 = poke2;
    }

    // Methods
    public PokedexModel[] spawnEncounters(String stageArea) {
        PokedexModel[] enemies = new PokedexModel[2];
        switch (stageArea) {
            case "Lakeside":
                PokedexModel[] lakePossibleSpawns = {StageController.lakePokemon[rand.nextInt(9)], StageController.lakePokemon[rand.nextInt(9)], StageController.otherSpawnablePokemon[rand.nextInt(16)]};
                enemies[0] = lakePossibleSpawns[rand.nextInt(3)];
                do {
                    enemies[1] = lakePossibleSpawns[rand.nextInt(3)];
                } while (Objects.equals(enemies[1], enemies[0]));
                break;
            case "Volcano":
                PokedexModel[] volcanoPossibleSpawns = {StageController.volcanoPokemon[rand.nextInt(9)], StageController.volcanoPokemon[rand.nextInt(9)], StageController.otherSpawnablePokemon[rand.nextInt(16)]};
                enemies[0] = volcanoPossibleSpawns[rand.nextInt(3)];
                do {
                    enemies[1] = volcanoPossibleSpawns[rand.nextInt(3)];
                } while (Objects.equals(enemies[1], enemies[0]));
                break;
            default:
                PokedexModel[] desertPossibleSpawns = {StageController.desertPokemon[rand.nextInt(9)], StageController.desertPokemon[rand.nextInt(9)], StageController.otherSpawnablePokemon[rand.nextInt(16)]};
                enemies[0] = desertPossibleSpawns[rand.nextInt(3)];
                do {
                    enemies[1] = desertPossibleSpawns[rand.nextInt(3)];
                } while (Objects.equals(enemies[1], enemies[0]));
        }
        return enemies;
    }

    // View Methods
    public void updateView() {
        stageView.display();
    }
    public String getStageOption() {
        return stageView.stage;
    }

    //toString
    @Override
    public String toString() {
        return  "            Location   :       " + name +
                "        |        " +
                "Possible Encounters:    " +
                poke1.getName() + poke1.printGrade() + "    |    " +
                poke2.getName() + poke2.printGrade() + "    |    " +
                poke3.getName() + poke3.printGrade() + "    |    " +
                poke4.getName() + poke4.printGrade() + "    |    " +
                poke5.getName() + poke5.printGrade() + "          ";
    }
}
