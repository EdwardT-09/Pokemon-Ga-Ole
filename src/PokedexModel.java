import java.util.ArrayList;
import java.util.List;

//Creates a list of all the pokemon in the game
public class PokedexModel {
    private PokedexView pokedexView = new PokedexView();

    // Variables for the pokemon's stats
    private String name;
    private String defType1, defType2;
    private String atkType;
    private int hp, atkPower, defPower, grade; // Temp values are to be used in battle
    // The list of all pokemon in the game
    public static List<PokedexModel> allPokemon = new ArrayList<>();
    static {
        allPokemon.add(new PokedexModel("Milotic", 3, 400, "Water", "", "Water", 60, 15));
        allPokemon.add(new PokedexModel("Squirtle", 2, 300, "Water", "", "Water", 40, 10));
        allPokemon.add(new PokedexModel("Seel", 1, 200, "Water", "", "Water", 20, 5));
        allPokemon.add(new PokedexModel("Gyarados", 4, 500, "Water", "Flying", "Flying", 80, 20));
        allPokemon.add(new PokedexModel("Suicune", 5, 600, "Water", "", "Water", 100, 25));
        allPokemon.add(new PokedexModel("Charizard", 4, 500, "Fire", "Flying", "Fire", 80, 20));
        allPokemon.add(new PokedexModel("Fennekin", 2, 300, "Fire", "", "Fire", 40, 10));
        allPokemon.add(new PokedexModel("Coalossal", 3, 400, "Fire", "Rock", "Rock", 60, 15));
        allPokemon.add(new PokedexModel("Volcanion", 5, 600, "Fire", "Water", "Water", 100, 25));
        allPokemon.add(new PokedexModel("Flareon", 3, 400, "Fire", "", "Fire", 60, 15));
        allPokemon.add(new PokedexModel("Meganium", 4, 500, "Grass", "", "Grass", 80, 20));
        allPokemon.add(new PokedexModel("Sceptile", 4, 500, "Grass", "", "Grass", 80, 20));
        allPokemon.add(new PokedexModel("Cherubi", 1, 200, "Grass", "", "Grass", 20, 5));
        allPokemon.add(new PokedexModel("Snivy", 2, 300, "Grass", "", "Grass", 40, 10));
        allPokemon.add(new PokedexModel("Shaymin", 5, 600, "Grass", "", "Grass", 100, 25));
        allPokemon.add(new PokedexModel("Ho-Oh", 5, 600, "Fire", "Flying", "Fire", 100, 25));
        allPokemon.add(new PokedexModel("Talonflame", 4, 500, "Fire", "Flying", "Flying", 80, 20));
        allPokemon.add(new PokedexModel("Rowlet", 2, 300, "Grass", "Flying", "Flying", 40, 10));
        allPokemon.add(new PokedexModel("Skiploom", 1, 200, "Grass", "Flying", "Flying", 20, 5));
        allPokemon.add(new PokedexModel("Pelipper", 3, 400, "Water", "Flying", "Water", 60, 15));
        allPokemon.add(new PokedexModel("Sudowoodo", 3, 400, "Rock", "", "Rock", 60, 15));
        allPokemon.add(new PokedexModel("Lileep", 3, 400, "Rock", "Grass", "Rock", 60, 15));
        allPokemon.add(new PokedexModel("Bonsly", 1, 200, "Rock", "", "Rock", 20, 5));
        allPokemon.add(new PokedexModel("Archeops", 4, 500, "Rock", "Flying", "Flying", 80, 20));
        allPokemon.add(new PokedexModel("Regirock", 5, 600, "Rock", "", "Rock", 100, 25));
    }
    //Constructors
    public PokedexModel() {
    }
    public PokedexModel(String name, int grade, int hp, String defType1, String defType2, String atkType, int atkPower,
                        int defPower) {
        this.name = name;
        this.grade = grade;
        this.hp = hp;
        this.atkType = atkType;
        this.defType1 = defType1;
        this.defType2 = defType2;
        this.atkPower = atkPower;
        this.defPower = defPower;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getDefType1() {
        return defType1;
    }
    public String getDefType2() {
        return defType2;
    }
    public String getAtkType() {
        return atkType;
    }
    public int getGrade() {
        return grade;
    }
    public int getHp() {
        return hp;
    }
    public int getAtkPower() {
        return atkPower;
    }
    public int getDefPower() {
        return defPower;
    }
    public static List<PokedexModel> getAllPokemon() {
        return allPokemon;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setDefType1(String defType1) {
        this.defType1 = defType1;
    }
    public void setDefType2(String defType2) {
        this.defType2 = defType2;
    }
    public void setAtkType(String atkType) {
        this.atkType = atkType;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAtkPower(int atkPower) {
        this.atkPower = atkPower;
    }
    public void setDefPower(int defPower) {
        this.defPower = defPower;
    }

    // Methods
    public String printGrade() { // Returns the grade of the pokemon as stars
        return switch (grade) {
            case 1 -> "(✮)";
            case 2 -> "(✮✮)";
            case 3 -> "(✮✮✮)";
            case 4 -> "(✮✮✮✮)";
            default -> "(✮✮✮✮✮)";
        };
    }

    // View Methods
    public void updateView() {
        pokedexView.display();
    }
    public boolean getStayPokedex() {
        return pokedexView.stayPokedex;
    }

    // toString
    @Override
    public String toString() {
        return  name + " | " +
                "Grade: " + printGrade() + " | " +
                "DefType: " + defType1 + " | " + defType2 + " | " +
                "AtkType: " + atkType + " | " +
                "HP: " + hp + " | " +
                "Attack: " + atkPower + " | " +
                "Defense: " + defPower;
    }
}
