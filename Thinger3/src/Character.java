import java.util.ArrayList;

/**
 * Created by JJ on 10/21/2018.
 */
public class Character {

    public String name;
    //index 0 is exp until next level
    //index 1 is current exp
    //index 2 is level
    public int level[] = new int[3];

    //coin or inventory for enemy is drop value
    //oin for protagonist is money and inventory for protagonist is inventory
    public int coin = 0;
    public ArrayList<Item> inventory;

    //index 0 is your normal stat
    //index 1 is current stat
    public int[] atk = new int[2];
    public int[] mag = new int[2];
    //mana is multiplied by 5 while hp is multiplied by 2
    public int[] mana = new int[2];
    public int[] hp = new int[2];
    public int[] def = new int[2];
    public int[] res = new int[2];

    public Character(String inputName,int inputLevel){
        atk[0] = (int) Math.pow(level[2],1.4) + 5;
        mag[0] = (int) Math.pow(level[2],1.4) + 5;
        mana[0] = (int) (Math.pow(level[2],1.8) + 10 * level[2] + 9)/2;
        hp[0] = (int) Math.pow(level[2],1.8) + 10 * level[2] + 9;
        def[0] = (int) Math.pow(level[2],1.15) + 2;
        res[0] = (int) Math.pow(level[2],1.15) + 2;
        name = inputName;
        level[2] = inputLevel;

    }

    //uses attack to decrease health, if def is higher than atk, do random attack from 1% of their hp
    public void attack(Character target){
        int damage;
        if (target.def[1] >= target.atk[1]) {
            damage = (int) Math.random() * hp[1]/100;
            target.hp[1] -= damage;
        }
        else {
            damage = atk[1] - target.def[1]*2/3;
            target.hp[1] -= damage;
        }
        System.out.println("You did " + damage + " damage!\nEnemy has " + target.hp[1] + " health left!");
    }

    //temporary function for magic, same as attack
    public void demoMag(Character target, int manaCost){
        mana[1] -= manaCost;
        int damage;
        if (target.res[1] >= target.mag[1]) {
            damage = (int) Math.random() * hp[1]/100;
            target.hp[1] -= damage;
        }
        else {
            damage = mag[1] - res[1]*2/3;
            target.hp[1] -= damage;
        }
        System.out.println("You did " + damage + " damage!\nEnemy has " + target.hp[1] + " health left!");
    }

    //reset of stats for testing and in the future, rest
    public void reset(boolean fullReset){
        atk[1] = atk[0];
        mag[1] = mag[0];
        if (fullReset) {
            mana[1] = mana[0];
            hp[1] = hp[0];
            if(this instanceof Protagonist) {
                System.out.println(name + " have been revitalized.");
            }
            else {
                System.out.println(name + " has been revitalized.");
            }
        }
    }

    //used in the beginning of the fight
    public void equipItemStat(){
        for (Item i: inventory){
            atk[1] += i.atk;
            mag[1] += i.mag;
            mana[1] += i.mana;
            hp[1] += i.hp;
            res[1] += i.res;
            def[1] += i.def;
        }
    }

}
