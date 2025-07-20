import java.util.Objects;
import java.util.Random;

public class BattleModel {
    private PokedexModel[] ally = new PokedexModel[2];
    private PokedexModel[] enemy = new PokedexModel[2];
    private int battleScore;
    private int atkgaugeAlly1, atkgaugeAlly2, atkgaugeEnemy1, atkgaugeEnemy2;
    private double catchgauge1, catchgauge2;
    private int allyHp1, allyHp2;
    private int spirit = 50;
    private boolean spiritCharging = true;
    private PokedexModel pokemonAttacked;
    private Random rand = new Random();
    private int damage;
    private boolean battleEnd;
    private boolean round1 = true;

    private BattleView battleView = new BattleView();

    // Constructor
    public BattleModel() {
    }
    public BattleModel(PokedexModel[] ally, PokedexModel[] enemy) {
        this.ally = ally;
        this.enemy = enemy;
    }

    // Getter
    public int getSpirit() {
        return spirit;
    }
    public PokedexModel getAlly1() {
        return ally[0];
    }
    public PokedexModel getAlly2() {
        return ally[1];
    }
    public PokedexModel getEnemy1() {
        return enemy[0];
    }
    public PokedexModel getEnemy2() {
        return enemy[1];
    }
    public int getAtkgaugeAlly1() {
        return atkgaugeAlly1;
    }
    public int getAtkgaugeAlly2() {
        return atkgaugeAlly2;
    }
    public int getAtkgaugeEnemy1() {
        return atkgaugeEnemy1;
    }
    public int getAtkgaugeEnemy2() {
        return atkgaugeEnemy2;
    }
    public double getCatchgauge1() {
        return catchgauge1;
    }
    public double getCatchgauge2() {
        return catchgauge2;
    }
    public int getAllyHp1() {
        return allyHp1;
    }
    public int getAllyHp2() {
        return allyHp2;
    }
    public int getBattleScore() {
        return battleScore;
    }
    public PokedexModel getPokemonAttacked() {
        return pokemonAttacked;
    }
    public int getDamage() {
        return damage;
    }
    public boolean getBattleEnd() {
        return battleEnd;
    }
    public boolean getRound1() {
        return round1;
    }

    // Setter
    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }
    public void setSpiritCharging(boolean spiritCharging) {
        this.spiritCharging = spiritCharging;
    }
    public void setAtkgaugeAlly1(int atkgaugeAlly1) {
        this.atkgaugeAlly1 = atkgaugeAlly1;
    }
    public void setAtkgaugeAlly2(int atkgaugeAlly2) {
        this.atkgaugeAlly2 = atkgaugeAlly2;
    }
    public void setAtkgaugeEnemy1(int atkgaugeEnemy1) {
        this.atkgaugeEnemy1 = atkgaugeEnemy1;
    }
    public void setAtkgaugeEnemy2(int atkgaugeEnemy2) {
        this.atkgaugeEnemy2 = atkgaugeEnemy2;
    }
    public void setAllyHp1(int allyHp1) {
        this.allyHp1 = allyHp1;
    }
    public void setAllyHp2(int allyHp2) {
        this.allyHp2 = allyHp2;
    }
    public void setCatchgauge1(double catchgauge1) {
        this.catchgauge1 = catchgauge1;
    }
    public void setCatchgauge2(double catchgauge2) {
        this.catchgauge2 = catchgauge2;
    }
    public boolean getSpiritCharging() {
        return spiritCharging;
    }
    public void setEnemy(PokedexModel[] enemy) {
        this.enemy = enemy;
    }
    public void setAlly(PokedexModel[] ally) {
        this.ally = ally;
        System.out.println(ally[0]);
        System.out.println(ally[1]);
        allyHp1 = ally[0].getHp();
        allyHp2 = ally[1].getHp();
    }
    public PokedexModel getAllyAttacked() {
        if (rand.nextInt(2) == 1) {
            if (allyHp1 > 0) {
                return ally[0];
            }
            else {
                return ally[1];
            }
        }
        else {
            if (getAllyHp2() > 0) {
                return ally[1];
            }
            else {
                return ally[0];
            }
        }

    }
    public PokedexModel getEnemyAttacked() {
        if (rand.nextInt(2) == 1) {
            if (catchgauge1 < 100) {
                return enemy[0];
            }
            else {
                return enemy[1];
            }
        }
        else {
            if (catchgauge2 < 100) {
                return enemy[1];
            }
            else {
                return enemy[0];
            }
        }
    }

    // Setter
    public void setRound1(boolean round1) {
        this.round1 = round1;
    }
    public void setBattleEnd(boolean battleEnd) {
        this.battleEnd = battleEnd;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setPokemonAttacked(PokedexModel pokemonAttacked) {
        this.pokemonAttacked = pokemonAttacked;
    }
    public void setBattleScore(int battleScore) {
        this.battleScore = battleScore;
    }

    // Methods
    public void increaseSpirit() {
        spirit += 1;
    }
    public void increaseAtkgaugeAlly1() {
        if (allyHp1 > 0) {
            atkgaugeAlly1 += 4;
        }
    }

    public void increaseAtkgaugeAlly2() {
        if (allyHp2 > 0) {
            atkgaugeAlly2 += 4;
        }
    }

    public void increaseAtkgaugeEnemy() {
        if (rand.nextInt(4) > 0 && catchgauge1 < 100) {
            atkgaugeEnemy1 += rand.nextInt(6);
        }
        if (rand.nextInt(4) > 0 && catchgauge2 < 100) {
            atkgaugeEnemy2 += rand.nextInt(6);
        }
    }

    public PokedexModel rentalPokemon(PokedexModel ally1) {
        PokedexModel rental = FreePokemonModel.poke[rand.nextInt(7)];
        while (Objects.equals(rental, ally1)) {
            rental = FreePokemonModel.poke[rand.nextInt(7)];
        }
        return rental;
    }

    public int calculateBattleScore() {
        if (CatchController.catchModelPokemon.getPokemonCaught() == 1) {
            battleScore += 1000;
        } else if (CatchController.catchModelPokemon.getPokemonCaught() == 2) {
            battleScore += 2500;
        }
        battleScore += (CatchController.catchModelPokemon.getPokemonGradeCaught() * 200);
        if (catchgauge1 == 100 && catchgauge2 == 100) {
            battleScore += 1500;
        } else if (catchgauge2 == 100 || catchgauge1 == 100) {
            battleScore += 500;
        }
        if (allyHp1 > 0 && allyHp2 > 0) {
            battleScore += 1000;
        }
        return battleScore;
    }

    public int calculateCaughtScore() {
        int score = 0;
        if (CatchController.catchModelPokemon.getPokemonCaught() == 1) {
            score += 1000;
        } else if (CatchController.catchModelPokemon.getPokemonCaught() == 2) {
            score += 2500;
        }
        return score;
    }

    public int calculateGradeScore() {
        int score = 0;

        score += (CatchController.catchModelPokemon.getPokemonGradeCaught() * 200);
        return score;
    }

    public int calculateGaugeScore() {
        int score = 0;
        if (getCatchgauge1() == 100 && getCatchgauge2() == 100) {
            score += 1500;
        } else if (getCatchgauge2() == 100 || getCatchgauge1() == 100) {
            score += 500;
        }
        return score;
    }

    public int calculateHpScore() {
        int score = 0;
        if (getAllyHp1() > 0 && getAllyHp2() > 0) {
            score += 1000;
        }
        return score;
    }

    // View Methods
    public void updateView(String stageOption) {
        battleView.display(stageOption);
    }
    public boolean getMoveOccurred() {
        return battleView.moveOccurred;
    }
    public int getAttackerOrDefender() {
        return battleView.attackerOrDefender;
    }
}
