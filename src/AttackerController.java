import java.util.concurrent.TimeUnit;

public class AttackerController {
    public static void main(String[] args) {
        AttackerModel attackerModel = new AttackerModel();
        if (BattleController.pokemonBattleModel.getAttackerOrDefender() == 3) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println(BattleController.pokemonBattleModel.getAlly1().getName() + " is Preparing to Attack the Wild " + BattleController.pokemonBattleModel.getPokemonAttacked().getName() + "!");
            attackerModel.setAtkPower(BattleController.pokemonBattleModel.getAlly1().getAtkPower());
            attackerModel.setName(BattleController.pokemonBattleModel.getAlly1().getName());
            attackerModel.updateView(BattleController.pokemonBattleModel.getAlly1().getAtkPower(), BattleController.pokemonBattleModel.getAlly1().getName());
            while (BattleController.pokemonBattleModel.getSpiritCharging()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            BattleController.pokemonBattleModel.setSpiritCharging(true);
            double multiplier = attackerModel.getMoveEffectiveness(BattleController.pokemonBattleModel.getAlly1().getAtkType(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType1(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType2());
            int enemyDef = attackerModel.getRandomSTATBUFF()/2 + BattleController.pokemonBattleModel.getPokemonAttacked().getDefPower();
            int spiritBuff = (int)(attackerModel.getTempAtkPower() * ((double)(BattleController.pokemonBattleModel.getSpirit())/100));
            System.out.println("Spirit Charge: " + BattleController.pokemonBattleModel.getSpirit());
            System.out.println(BattleController.pokemonBattleModel.getAlly1().getName() + "'s Attack is Now " + spiritBuff + "!\n");
            BattleController.pokemonBattleModel.setDamage((int)(((double)spiritBuff * multiplier) - enemyDef));
            if (BattleController.pokemonBattleModel.getDamage() < 0) {
                BattleController.pokemonBattleModel.setDamage(0);
            }
            if (BattleController.pokemonBattleModel.getEnemy1() == BattleController.pokemonBattleModel.getPokemonAttacked()) {
                BattleController.pokemonBattleModel.setCatchgauge1(BattleController.pokemonBattleModel.getCatchgauge1() + ((double) BattleController.pokemonBattleModel.getDamage() / (double) BattleController.pokemonBattleModel.getEnemy1().getHp()) * 100);
            } else {
                BattleController.pokemonBattleModel.setCatchgauge2(BattleController.pokemonBattleModel.getCatchgauge2() + ((double) BattleController.pokemonBattleModel.getDamage() / (double) BattleController.pokemonBattleModel.getEnemy2().getHp()) * 100);
            }
            System.out.println("The Wild " + BattleController.pokemonBattleModel.getPokemonAttacked().getName() + "'s Defence Increased to " + enemyDef +"!");
            if (multiplier > 1) {
                System.out.println(BattleController.pokemonBattleModel.getAlly1().getName() + "'s Move Was Super Effective!");
            }
            else if (multiplier < 1) {
                System.out.println(BattleController.pokemonBattleModel.getAlly1().getName() + "'s Move Was Not Very Effective!");
            }
        }
        else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println(BattleController.pokemonBattleModel.getAlly2().getName() + " is Preparing to Attack the Wild " + BattleController.pokemonBattleModel.getPokemonAttacked().getName() + "!");
            attackerModel.setAtkPower(BattleController.pokemonBattleModel.getAlly2().getAtkPower());
            attackerModel.setName(BattleController.pokemonBattleModel.getAlly2().getName());
            attackerModel.updateView(BattleController.pokemonBattleModel.getAlly2().getAtkPower(), BattleController.pokemonBattleModel.getAlly2().getName());
            while (BattleController.pokemonBattleModel.getSpiritCharging()) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            BattleController.pokemonBattleModel.setSpiritCharging(true);
            double multiplier = attackerModel.getMoveEffectiveness(BattleController.pokemonBattleModel.getAlly2().getAtkType(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType1(), BattleController.pokemonBattleModel.getPokemonAttacked().getDefType2());
            int enemyDef = attackerModel.getRandomSTATBUFF()/2 + BattleController.pokemonBattleModel.getPokemonAttacked().getDefPower();
            int spiritBuff = (int)(attackerModel.getTempAtkPower() * ((double)(BattleController.pokemonBattleModel.getSpirit())/100));
            System.out.println("Spirit Charge: " + BattleController.pokemonBattleModel.getSpirit());
            System.out.println(BattleController.pokemonBattleModel.getAlly2().getName() + "'s Attack is Now " + spiritBuff + "!\n");
            BattleController.pokemonBattleModel.setDamage((int)(((double)spiritBuff * multiplier) - enemyDef));
            if (BattleController.pokemonBattleModel.getDamage() < 0) {
                BattleController.pokemonBattleModel.setDamage(0);
            }
            if (BattleController.pokemonBattleModel.getEnemy1() == BattleController.pokemonBattleModel.getPokemonAttacked()) {
                BattleController.pokemonBattleModel.setCatchgauge1(BattleController.pokemonBattleModel.getCatchgauge1() + ((double) BattleController.pokemonBattleModel.getDamage() / (double) BattleController.pokemonBattleModel.getEnemy1().getHp()) * 100);
            } else {
                BattleController.pokemonBattleModel.setCatchgauge2(BattleController.pokemonBattleModel.getCatchgauge2() + ((double) BattleController.pokemonBattleModel.getDamage() / (double) BattleController.pokemonBattleModel.getEnemy2().getHp()) * 100);
            }
            System.out.println("The Wild " + BattleController.pokemonBattleModel.getPokemonAttacked().getName() + "'s Defence Increased to " + enemyDef +"!");
            BattleController.pokemonBattleModel.setSpirit(50);
            if (multiplier > 1) {
                System.out.println(BattleController.pokemonBattleModel.getAlly2().getName() + "'s Move Was Super Effective!");
            }
            else if (multiplier < 1) {
                System.out.println(BattleController.pokemonBattleModel.getAlly2().getName() + "'s Move Was Not Very Effective!");
            }
        }
        if (BattleController.pokemonBattleModel.getCatchgauge1() >= 100 && BattleController.pokemonBattleModel.getCatchgauge2() >= 100) {
            BattleController.pokemonBattleModel.setBattleEnd(true);
        }
    }
}
