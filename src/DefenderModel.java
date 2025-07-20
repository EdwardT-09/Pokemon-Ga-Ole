import java.util.Random;

public class DefenderModel extends PokedexModel {
    private Random rand = new Random();
    private double effectiveness;
    private int defPower;
    private final int[] STATBUFF = {15, 20, 25, 30, 5, 10, 35};

    private DefenderView defenderView = new DefenderView();

    // Constructor
    public DefenderModel() {
    }
    public DefenderModel(int defPower) {
        this.defPower = defPower;
    }

    // Getter
    public int getRandomSTATBUFF() {
        return STATBUFF[rand.nextInt(7)];
    }
    @Override
    public int getDefPower() {
        return defPower;
    }
    public double getMoveEffectiveness(String atkType, String defType1, String defType2) {
        effectiveness = 1;
        switch (atkType) {
            case "Fire":
                switch (defType1) {
                    case "Water":
                        effectiveness = effectiveness/2;
                        break;
                    case "Rock":
                        effectiveness = effectiveness/2;
                        break;
                    case "Grass":
                        effectiveness = effectiveness*2;
                        break;
                    case "Fire":
                        effectiveness = effectiveness/2;
                        break;
                    default:
                }
                switch (defType2) {
                    case "Water":
                        effectiveness = effectiveness/2;
                        break;
                    case "Rock":
                        effectiveness = effectiveness/2;
                        break;
                    case "Grass":
                        effectiveness = effectiveness*2;
                        break;
                    case "Fire":
                        effectiveness = effectiveness/2;
                        break;
                    default:
                }
                break;
            case "Water":
                switch (defType1) {
                    case "Rock":
                        effectiveness = effectiveness*2;
                        break;
                    case "Fire":
                        effectiveness = effectiveness*2;
                        break;
                    case "Grass":
                        effectiveness = effectiveness/2;
                        break;
                    case "Water":
                        effectiveness = effectiveness/2;
                    default:
                }
                switch (defType2) {
                    case "Rock":
                        effectiveness = effectiveness*2;
                        break;
                    case "Fire":
                        effectiveness = effectiveness*2;
                        break;
                    case "Grass":
                        effectiveness = effectiveness/2;
                        break;
                    case "Water":
                        effectiveness = effectiveness/2;
                    default:
                }
                break;
            case "Rock":
                switch (defType1) {
                    case "Fire":
                        effectiveness = effectiveness*2;
                        break;
                    case "Flying":
                        effectiveness = effectiveness*2;
                        break;
                    default:
                }
                switch (defType2) {
                    case "Fire":
                        effectiveness = effectiveness*2;
                        break;
                    case "Flying":
                        effectiveness = effectiveness*2;
                        break;
                    default:
                }
                break;
            case "Flying":
                switch (defType1) {
                    case "Grass":
                        effectiveness = effectiveness*2;
                        break;
                    case "Rock":
                        effectiveness = effectiveness/2;
                        break;
                    default:
                }
                switch (defType2) {
                    case "Grass":
                        effectiveness = effectiveness*2;
                        break;
                    case "Rock":
                        effectiveness = effectiveness/2;
                        break;
                    default:
                }
                break;
            default:
                switch (defType1) {
                    case "Grass":
                        effectiveness = effectiveness/2;
                        break;
                    case "Fire":
                        effectiveness = effectiveness/2;
                        break;
                    case "Water":
                        effectiveness = effectiveness*2;
                        break;
                    case "Flying":
                        effectiveness = effectiveness/2;
                        break;
                    case "Rock":
                        effectiveness = effectiveness*2;
                    default:
                }
                switch (defType2) {
                    case "Grass":
                        effectiveness = effectiveness/2;
                        break;
                    case "Fire":
                        effectiveness = effectiveness/2;
                        break;
                    case "Water":
                        effectiveness = effectiveness*2;
                        break;
                    case "Flying":
                        effectiveness = effectiveness/2;
                        break;
                    case "Rock":
                        effectiveness = effectiveness*2;
                    default:
                }
        }
        return effectiveness;
    }

    // Setter
    @Override
    public void setDefPower(int defPower) {
        this.defPower = defPower;
    }

    // View Methods
    public void updateView(int defPower, String attackedName) {
        defenderView.display(defPower, attackedName);
    }
    public int getTempDefPower() {
        return defenderView.tempDefPower;
    }

}