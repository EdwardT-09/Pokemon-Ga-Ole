import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

// Generates 3 unique pokemon for user to choose for free before battle
public class FreePokemonModel {
    private FreePokemonView freePokemonView = new FreePokemonView();

    // Creates 3 variables of to store the pokemon
    public static PokedexModel poke1;
    public static PokedexModel poke2;
    public static PokedexModel poke3;
    // Creates a list of the possible free pokemon that user may choose from
    public static PokedexModel[] poke = {PokedexModel.allPokemon.get(2), PokedexModel.allPokemon.get(17), PokedexModel.allPokemon.get(18), PokedexModel.allPokemon.get(22), PokedexModel.allPokemon.get(12),
            PokedexModel.allPokemon.get(13), PokedexModel.allPokemon.get(9)};
    // Generates a random number to choose from the list
    private static Random rand = new Random();
    // Calls this class to create an object and passing 3 random pokemon chosen through random number generator
    public static FreePokemonModel free = new FreePokemonModel(poke[rand.nextInt(7)], poke[rand.nextInt(7)],
            poke[rand.nextInt(7)]);

    // Constructors
    public FreePokemonModel() {
    }
    public FreePokemonModel(PokedexModel poke1, PokedexModel poke2, PokedexModel poke3) {
        // Ensures that no duplicate pokemon are chosen from the list for user
        FreePokemonModel.poke1 = poke1;
        while (Objects.equals(poke1.getName(), poke2.getName())) {
            poke2 = poke[rand.nextInt(7)];
        }
        FreePokemonModel.poke2 = poke2;
        while ((Objects.equals(poke1.getName(), poke3.getName())) || (Objects.equals(poke2.getName(), poke3.getName()))) {
            poke3 = poke[rand.nextInt(7)];
        }
        FreePokemonModel.poke3 = poke3;
    }

    // Getter
    public static PokedexModel getPoke1() {
        return poke1;
    }
    public static PokedexModel getPoke2() {
        return poke2;
    }
    public static PokedexModel getPoke3() {
        return poke3;
    }
    public static PokedexModel[] getPoke() {
        return poke;
    }
    public static FreePokemonModel getFree() {
        return free;
    }

    // Setter
    public static void setPoke1(PokedexModel poke1) {
        FreePokemonModel.poke1 = poke1;
    }
    public static void setPoke2(PokedexModel poke2) {
        FreePokemonModel.poke2 = poke2;
    }
    public static void setPoke3(PokedexModel poke3) {
        FreePokemonModel.poke3 = poke3;
    }
    public static void setPoke(PokedexModel[] poke) {
        FreePokemonModel.poke = poke;
    }
    public static void setFree(FreePokemonModel free) {
        FreePokemonModel.free = free;
    }

    //Methods
    public ArrayList<String> getPokeNames() { // Returns a list of the 3 generated pokemon names
        ArrayList<String> pokeNames = new ArrayList<String>();
        pokeNames.add(poke1.getName());
        pokeNames.add(poke2.getName());
        pokeNames.add(poke3.getName());
        return pokeNames;
    }

    // View Methods
    public void updateDisplay() {
        freePokemonView.display();
    }
    public boolean getStayFreePokemon() {
        return freePokemonView.stayFreePokemon;
    }

}
