package inventory;

/**
 * Created by JJ on 10/21/2018.
 */
public abstract class Item {

    private String name;
    private String desc;

    protected int atk = 0;
    protected int mag = 0;
    protected int mana = 0;
    protected int hp = 0;
    protected int def = 0;
    protected int res = 0;
    protected int spd = 0;

    public int getAtk() {
        return atk;
    }

    public int getMag(){
        return mag;
    }

    public int getMana() {
        return mana;
    }

    public int getHp() {
        return hp;
    }

    public int getDef() {
        return def;
    }

    public int getRes() {
        return res;
    }

    public int getSpd() {
        return spd;
    }

    abstract public void smith();

    public String toString(){
        return name;
    }

    public String stat(){
        String output = new String();
        if (atk != 0) {
            output += "\nAttack : " + atk;
        }
        if (mag != 0) {
            output += "\nMagic: " + mag;
        }
        if (mana != 0) {
            output += "\nMana: " + mana;
        }
        if (hp != 0) {
            output += "\nHealth: " + hp;
        }
        if (def != 0 ) {
            output += "\nDefense: " + def;
        }
        if (res != 0) {
            output += "\nResistance: " + res;
        }
        return output;
    }

    public String flavorText() {
        return desc;
    }

}