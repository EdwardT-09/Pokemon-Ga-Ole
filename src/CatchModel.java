import java.util.Random;

public class CatchModel {
    private Random rand = new Random();
    public CatchView catchView = new CatchView();
    private final int POKEBALL = 60;
    private final int GREATBALL = 75;
    private final int ULTRABALL = 90;
    private final int MASTERBALL = 170;
    private final String[] BALLPOOL = {"Ultra Ball", "Master Ball", "Poke Ball","Poke Ball","Poke Ball","Poke Ball", "Great Ball", "Great Ball", "Great Ball", "Ultra Ball"};

    // Constructor
    public CatchModel() {
    }
    
    // Getter
    public String getPokeballName() {
        return BALLPOOL[rand.nextInt(10)];
    }
    public int getPokeball() {
        return POKEBALL;
    }
    public int getGreatBall() {
        return GREATBALL;
    }
    public int getUltraBall() {
        return ULTRABALL;
    }
    public int getMasterBall() {
        return MASTERBALL;
    }
    public String[] getBallPool() {
        return BALLPOOL;
    }

    // Methods
    public boolean pokemonCaught(String ball, double catchGauge, int grade) {
        int chance = 0;
        switch (ball) {
            case "Poke Ball":
                chance += POKEBALL;
                chance = chance - (int)((100 - catchGauge)/2);
                chance = chance - grade*4;
                break;
            case "Great Ball":
                chance += GREATBALL;
                chance = chance - (int)((100 - catchGauge)/2);
                chance = chance - grade*4;
                break;
            case "Ultra Ball":
                chance += ULTRABALL;
                chance = chance - (int)((100 - catchGauge)/2);
                chance = chance - grade*4;
                break;
            default:
                chance += MASTERBALL;
                chance = chance - (int)((100 - catchGauge)/2);
                chance = chance - grade*4;
        }
        int random = rand.nextInt(99) + 1;
        return chance >= random;
    }

    // View Methods
    public void updateView() {
        catchView.display();
    }
    public boolean getCatchNext() {
        return catchView.catchNext;
    }
    public int getPokemonCaught() {
        return catchView.pokemonCaught;
    }
    public void resetPokemonCaught() {
        catchView.pokemonCaught = 0;
    }
    public int getPokemonGradeCaught() {
        return catchView.pokemonGradeCaught;
    }
    public void resetPokemonGradeCaught() {
        catchView.pokemonGradeCaught = 0;
    }
}
