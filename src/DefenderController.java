import java.util.concurrent.TimeUnit;

public class DefenderController {
    public static void main(String[] args) {
        DefenderModel defenderModel = new DefenderModel();
        if (BattleController.pokemonBattleModel.getAttackerOrDefender() == 1) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println(BattleController.pokemonBattleModel.getPokemonAttacked().getName() + " is Preparing to Defend Against the Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + "!");
            defenderModel.setDefPower(BattleController.pokemonBattleModel.getPokemonAttacked().getDefPower());
            defenderModel.updateView(BattleController.pokemonBattleModel.getPokemonAttacked().getDefPower(), BattleController.pokemonBattleModel.getPokemonAttacked().getName());
            while (defenderModel.getTempDefPower() == defenderModel.getDefPower()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            double multiplier = defenderModel.getMoveEffectiveness(BattleController.pokemonBattleModel.getEnemy1().getAtkType(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType1(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType2());
            int enemyAtkBuff = (int)((double) defenderModel.getRandomSTATBUFF() * 1.5);
            int enemyFinalAtk = (int)((BattleController.pokemonBattleModel.getEnemy1().getAtkPower() + enemyAtkBuff) * multiplier);
            BattleController.pokemonBattleModel.setDamage(enemyFinalAtk - defenderModel.getTempDefPower());
            if (BattleController.pokemonBattleModel.getDamage() < 0) {
                BattleController.pokemonBattleModel.setDamage(0);
            }
            if (BattleController.pokemonBattleModel.getAlly1() == BattleController.pokemonBattleModel.getPokemonAttacked()) {
                BattleController.pokemonBattleModel.setAllyHp1(BattleController.pokemonBattleModel.getAllyHp1() - BattleController.pokemonBattleModel.getDamage());
            } else {
                BattleController.pokemonBattleModel.setAllyHp2(BattleController.pokemonBattleModel.getAllyHp2() - BattleController.pokemonBattleModel.getDamage());
            }
            System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + "'s Attack Increased to " + (enemyAtkBuff + BattleController.pokemonBattleModel.getEnemy1().getAtkPower()) + "!");
            if (multiplier > 1) {
                System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() +"'s Move Was Super Effective!");
            }
            else if (multiplier < 1) {
                System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() +"'s Move Was Not Very Effective!");
            }
        }
        else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println(BattleController.pokemonBattleModel.getPokemonAttacked().getName() + " is Preparing to Defend!");
            defenderModel.setDefPower(BattleController.pokemonBattleModel.getPokemonAttacked().getDefPower());
            defenderModel.updateView(BattleController.pokemonBattleModel.getPokemonAttacked().getDefPower(), BattleController.pokemonBattleModel.getPokemonAttacked().getName());
            while (defenderModel.getTempDefPower() == defenderModel.getDefPower()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            double multiplier = defenderModel.getMoveEffectiveness(BattleController.pokemonBattleModel.getEnemy2().getAtkType(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType1(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType2());
            int enemyAtkBuff = (int)((double) defenderModel.getRandomSTATBUFF() * 1.5);
            int enemyFinalAtk = (int)((BattleController.pokemonBattleModel.getEnemy2().getAtkPower() + enemyAtkBuff) * multiplier);
            BattleController.pokemonBattleModel.setDamage(enemyFinalAtk - defenderModel.getTempDefPower());
            if (BattleController.pokemonBattleModel.getDamage() < 0) {
                BattleController.pokemonBattleModel.setDamage(0);
            }
            if (BattleController.pokemonBattleModel.getAlly1() == BattleController.pokemonBattleModel.getPokemonAttacked()) {
                BattleController.pokemonBattleModel.setAllyHp1(BattleController.pokemonBattleModel.getAllyHp1() - BattleController.pokemonBattleModel.getDamage());
            } else {
                BattleController.pokemonBattleModel.setAllyHp2(BattleController.pokemonBattleModel.getAllyHp2() - BattleController.pokemonBattleModel.getDamage());
            }
            System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + "'s Attack Increased to " + (enemyAtkBuff + BattleController.pokemonBattleModel.getEnemy2().getAtkPower()) + "!");
            if (multiplier > 1) {
                System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() +"'s Move Was Super Effective!");
            }
            else if (multiplier < 1) {
                System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() +"'s Move Was Not Very Effective!");
            }
        }
        if ((BattleController.pokemonBattleModel.getAllyHp1() < 1) && (BattleController.pokemonBattleModel.getAllyHp2() < 1)) {
            BattleController.pokemonBattleModel.setBattleEnd(true);
        }
    }
}
