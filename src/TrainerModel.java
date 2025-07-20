import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

// Creates the trainers profile associated with their username (Info of owned pokemon stored in text file)
public class TrainerModel {
    private String username;
    private int goldenChip;
    private int gaOleMedal;
    private List<Integer> highscores = new ArrayList<>(6);
    private Scanner keyboard = new Scanner(System.in);
    private TrainerView trainerView = new TrainerView();

    static TrainerModel trainerModel = new TrainerModel();

    // Constructors
    public TrainerModel() {
    }

    // Getters
    public String getUsername() {
        return username;
    }
    public int getGoldenChip() {
       return goldenChip;
    }
    public int getGaOleMedal() {
        return gaOleMedal;
    }
    public List<Integer> getHighscores() {
        return highscores;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setGoldenChip(int goldenChip) {
        this.goldenChip = goldenChip;
        if (this.goldenChip > 9) {
            this.goldenChip = getGoldenChip() - 10;
            gaOleMedal = gaOleMedal + 1;
        }
    }
    public void setGaOleMedal(int gaOleMedal) {
        this.gaOleMedal = gaOleMedal;
    }
    public void setHighscores(List<Integer> highscores) {
        this.highscores = highscores;
    }

    // Methods
    public void determineScorePlacement() {
        Collections.sort(highscores);
    }
    public void addScore(int score) {
        for (int i = 0; i < highscores.size(); i++) {
            if (score == highscores.get(i)) {
                return;
            }
        }
        highscores.set(0, score);
    }

    public void createProfile() { // Creates the text file linked to the username entered by the user
        try {
            File myObj = new File(username + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("New Account Created!");
                String initialiseScores = "0\n";
                for (int i = 0; i < 7; i++) {
                    try {
                        Files.write(Paths.get(username + ".txt"), initialiseScores.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                }
            } else {
                System.out.println("Successfully Logged In!");
            }
        } catch (IOException e) {
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(username + ".txt"));
            goldenChip = Integer.parseInt(lines.get(0));
            gaOleMedal = Integer.parseInt(lines.get(1));
            for (int i = 0; i < 5; i++) {
                highscores.add(Integer.parseInt(lines.get(i+2)));
            }
            highscores.add(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Appends pokemon to the users text file
    public void addToParty(PokedexModel addPokemon) {
        if (checkOwned(addPokemon.getName())) {
            System.out.println("-------------------------------------------------------------------\nPokemon Already Owned!");
        }
        else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println(addPokemon.getName() + " Has Been Added to Your Party!");
            String pokemon = addPokemon.getName() + "\n";
            try {
                Files.write(Paths.get(username + ".txt"), pokemon.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    public void updateProfile() {
        Path path = Paths.get(username + ".txt");
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            // Modify the first 7 lines
            if (lines.size() >= 7) {
                lines.set(0, String.valueOf(goldenChip));
                lines.set(1, String.valueOf(gaOleMedal));
                lines.set(2, String.valueOf(highscores.get(1)));
                lines.set(3, String.valueOf(highscores.get(2)));
                lines.set(4, String.valueOf(highscores.get(3)));
                lines.set(5, String.valueOf(highscores.get(4)));
                lines.set(6, String.valueOf(highscores.get(5)));
            } else {
                System.out.println("The file has less than 7 lines.");
            }
            // Write the modified lines back to the file
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PokedexModel[] chooseParty() {
        List<PokedexModel> ownedpokemon = new ArrayList<>();
        PokedexModel[] pokemonChoice = new PokedexModel[2];
        int choice = 0;
        for (int a = 0; a < 2; a++) {
            while (true) {
                int index = 0;
                ownedpokemon.clear();
                System.out.println("-------------------------------------------------------------------\nPokemon Available: ");
                for (int i = 0; i < PokedexModel.allPokemon.size(); i++) {
                    if (checkOwned(PokedexModel.allPokemon.get(i).getName())) {
                        if (a == 1) {
                            if (!Objects.equals(PokedexModel.allPokemon.get(i).getName(), pokemonChoice[0].getName())) {
                                index++;
                                System.out.println(index + ") " + PokedexModel.allPokemon.get(i).getName() + PokedexModel.allPokemon.get(i).printGrade() + " | DefType: " + PokedexModel.allPokemon.get(i).getDefType1() + " | " + PokedexModel.allPokemon.get(i).getDefType2() + " | AtkType: " + PokedexModel.allPokemon.get(i).getAtkType());
                                ownedpokemon.add(PokedexModel.allPokemon.get(i));
                            }
                        }
                        else {
                            index++;
                            System.out.println(index + ") " + PokedexModel.allPokemon.get(i).getName() + PokedexModel.allPokemon.get(i).printGrade() + " | DefType: " + PokedexModel.allPokemon.get(i).getDefType1() + " | " + PokedexModel.allPokemon.get(i).getDefType2() + " | AtkType: " + PokedexModel.allPokemon.get(i).getAtkType());
                            ownedpokemon.add(PokedexModel.allPokemon.get(i));
                        }
                    }
                }
                try {
                    if (index == 0) {
                        System.out.println("No More Available Pokemon!");
                    }
                    else {
                        System.out.println("Enter the Number of the Pokemon You Wish to Send Out to Battle: ");
                        choice = keyboard.nextInt();
                        if ((choice > ownedpokemon.size()) || (choice < 1)) {
                            System.out.println("Please Enter a Number Within the List!");
                            continue;
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println("Please Enter a Valid Integer!");
                    keyboard.next();
                    continue;
                }
                break;
            }
            if (choice == 0) {
                pokemonChoice[a] = BattleController.pokemonBattleModel.rentalPokemon(pokemonChoice[0]);
                System.out.println(pokemonChoice[a].getName() + " Came to help!");
            }
            else {
                pokemonChoice[a] = ownedpokemon.get(choice - 1);
                choice = 0;
            }
        }
        return pokemonChoice;
    }

    // Checks if a pokemon is owned by the user
    public boolean checkOwned(String name) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(username + ".txt");
        } catch (IOException e) {
            System.out.println("Error!");
        }
        Scanner scanFile = new Scanner(file);
        while (scanFile.hasNextLine()) {
            if (Objects.equals(scanFile.nextLine(), name)) {
                return true;
            }
        }
        return false;
    }

    // View Methods
    public void updateView() {
        trainerView.display();
    }
    public boolean getStayMainMenu() {
        return trainerView.stayMainMenu;
    }
    public boolean getSwitchPokedex() {
        return trainerView.switchPokedex;
    }

}
