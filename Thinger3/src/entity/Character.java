package entity;

import inventory.Item;

import java.util.ArrayList;

/**
 * Created by JJ on 10/21/2018.
 */
public class Character {

    protected String name;
    //index 0 is exp until next level
    //index 1 is current exp
    //index 2 is level
    protected int level[] = new int[3];

    //coin or inventory for enemy is drop value
    //oin for protagonist is money and inventory for protagonist is inventory
    protected int coin = 0;
    protected ArrayList<Item> inventory;

    //index 0 is your normal stat
    //index 1 is current stat
    //index 2 is stat from items
    protected int[] atk = new int[3];
    protected int[] mag = new int[3];
    //mana is multiplied by 5 while hp is multiplied by 2
    protected int[] mana = new int[3];
    protected int[] hp = new int[3];
    protected int[] def = new int[3];
    protected int[] res = new int[3];
    //used to calculate turns
    protected int[] spd = new int[3];

    private boolean itemEquipped;

    public Character(String inputName,int inputLevel){
        atk[0] = (int) Math.pow(level[2],1.4) + 5;
        mag[0] = (int) Math.pow(level[2],1.4) + 5;
        mana[0] = (int) (Math.pow(level[2],1.8) + 10 * level[2] + 9)/2;
        hp[0] = (int) Math.pow(level[2],1.8) + 10 * level[2] + 9;
        def[0] = (int) Math.pow(level[2],1.15) + 2;
        res[0] = (int) Math.pow(level[2],1.15) + 2;
        spd[0] = 10 + (int) 2.4 * level[2];
        name = inputName;
        level[2] = inputLevel;
        itemEquipped = false;
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

    //used in when equipping stats from items
    public void itemStat(){
        for (Item i: inventory){
            atk[2] += i.getAtk();
            mag[2] += i.getMag();
            mana[2] += i.getMana();
            hp[2] += i.getHp();
            res[2] += i.getRes();
            def[2] += i.getDef();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getLevel() {
        return level;
    }

    public void setLevel(int[] level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int[] getAtk() {
        return atk;
    }

    public void setAtk(int[] atk) {
        this.atk = atk;
    }

    public int[] getMag() {
        return mag;
    }

    public void setMag(int[] mag) {
        this.mag = mag;
    }

    public int[] getMana() {
        return mana;
    }

    public void setMana(int[] mana) {
        this.mana = mana;
    }

    public int[] getHp() {
        return hp;
    }

    public void setHp(int[] hp) {
        this.hp = hp;
    }

    public int[] getDef() {
        return def;
    }

    public void setDef(int[] def) {
        this.def = def;
    }

    public int[] getRes() {
        return res;
    }

    public void setRes(int[] res) {
        this.res = res;
    }

    public int[] getSpd() {
        return spd;
    }

    public void setSpd(int[] spd) {
        this.spd = spd;
    }

    public boolean isItemEquipped() {
        return itemEquipped;
    }

    public void setItemEquipped(boolean itemEquipped) {
        this.itemEquipped = itemEquipped;
    }
}
