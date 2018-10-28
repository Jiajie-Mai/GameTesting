package entity;

import inventory.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JJ on 10/21/2018.
 */
public class Protagonist extends Character {

    Scanner sc = new Scanner(System.in);
    String classType;
    String userInput;
    String name;
    String race;

    String[] raceList = {"Elf", "Human", "Dwarf", "Amalian"};
    List<String> raceListArray = Arrays.asList(raceList);

    boolean check;

    public Protagonist(String nameInput,String classInput){
        super(nameInput,1);
        classType = classInput;
    }

    public Character createProtag(){

        name = getUserName();
        setRace();


        //TODO replace classInput fighter field at some point
        Protagonist protag = new Protagonist(name, "fighter");
        return protag;

    }

    private String getUserName(){
        System.out.println("What's your name?");
        name = sc.next();

        //this part re-does the name fetch in case the user makes a mistake
        if(confirm(name, "name")){
            return name;
        }
        else{
            getUserName();
        }
        return null;
    }

    public String setRace(){

        System.out.println("Please choose a race:");
        for(int i=0; i < 4; i++){
            System.out.println("\n" + raceList[i]);
        }

        userInput = sc.next().toLowerCase();

        //checks through valid races
        //TODO make this more efficient with contains()
        if(raceListArray.contains(userInput.toLowerCase())){
            confirm(userInput, "race");
        }
        else{
            System.out.println("Invalid race. Please try again.");
            setRace();
        }

        return race;
    }

    //TODO make this work, currently does next to nothing.
    public boolean confirm(String answer, String type){

        switch(type){
            case "race":

                //TODO find a way to swap out a for an when the race starts with a vowel



                System.out.println("You're a " + answer + "?");

            case "name":
                System.out.println("You're called " + answer + ", right?");
        }

        switch(sc.next().toLowerCase()){
            case "yes":
            case "y":
                check = true;

            case "no":
            case "n":
                check = false;

            default:
                check = false;
        }


        return check;
    }

    //gives items and coins to the target
    public void get(Character target){
        for (Item i: target.inventory){
            System.out.println("Obtained " + i + "!");
            inventory.add(i);
        }
        coin += target.coin;
        System.out.println("Gained " + target.coin + "!");
        int amount = target.level[3];
        level[1] += amount;
        System.out.println("Gained " + amount + " experience!");
        levelManager();
    }

    public void levelManager() {
        if(level[1] >= level[0]) {
            level[1] -= level[0];
            level[3]++;
            level[0] = (int) Math.pow((level[3]+1),2);
            System.out.println("Level up! You are now level " + level[3] + "!");
        }
    }

    public void statLevelUp(){
        //base stat
        atk[0] = (int) Math.pow(level[2],1.4) + 5;
        mag[0] = (int) Math.pow(level[2],1.4) + 5;
        mana[0] = (int) (Math.pow(level[2],1.8) + 10 * level[2] + 9)/2;
        hp[0] = (int) Math.pow(level[2],1.8) + 10 * level[2] + 9;
        def[0] = (int) Math.pow(level[2],1.15) + 2;
        res[0] = (int) Math.pow(level[2],1.15) + 2;

        //class up at level 25
        switch(classType){
            //==> ranger
            case "archer":
            case "ranger":
                if (level[3] >= 25) {
                    //atk super plus, mana + mag + def nerf, hp equal
                    atk[0] += 2 * level[3];
                    def[0] -= level[3];
                    mag[0] -= level[3];
                    mana[0] -= level[3];
                }
                else {
                    atk[0] += level[3];
                    def[0] -= level[3]/2;
                    mag[0] -= level[3]/2;
                    mana[0] -= level[3]/2;
                }
                break;
            //==> rouge
            case "thief":
            case "rouge":
                if (level[3] >= 25) {
                    //atk + mag plus, res + hp + def, nerf + mana equal
                    atk[0] += level[3];
                    hp[0] -= level[3];
                    mag[0] += level[3];
                    mana[0] -= level[3];
                    res[0] -= level[3];
                }
                else {
                    atk[0] += level[3]/2;
                    hp[0] -= level[3]/2;
                    mag[0] += level[3]/2;
                    mana[0] -= level[3]/2;
                    res[0] -= level[3]/2;
                }
                break;
            //==> protector
            case "tank":
            case "protector":
                if (level[3] >= 25) {
                    //def + res + hp plus, atk + mag + mana nerf
                    atk[0] -= level[3];
                    hp[0] += level[3];
                    def[0] += level[3];
                    mag[0] -= level[3];
                    mana[0] -= level[3];
                    res[0] += level[3];
                }
                else{
                    atk[0] -= level[3]/2;
                    hp[0] += level[3]/2;
                    def[0] += level[3]/2;
                    mag[0] -= level[3]/2;
                    mana[0] -= level[3]/2;
                    res[0] += level[3]/2;
                }
                break;
            //==> berserk
            case "fighter":
            case "berserk":
                if (level[3] >= 25) {
                    //atk + hp plus, mag + mana nerf, def + res equal
                    atk[0] += level[3];
                    hp[0] += level[3];
                    mag[0] -= level[3];
                    mana[0] -= level[3];
                }
                else {
                    atk[0] += level[3]/2;
                    hp[0] += level[3]/2;
                    mag[0] -= level[3]/2;
                    mana[0] -= level[3]/2;
                }
                break;
            //==> differentiation into different mages:
            //elemental
            //dynamical(light/dark)
            //physical(blood, psychic, kiter)
            case "mage":
            case "fire mage":
            case "water mage":
            case "wind mage":
            case "earth mage":
            case "light mage":
            case "dark mage":
            case "blood mage":
            case "kiting mage":
            case "psychic mage":
                if (level[3] >= 25) {
                    //mag + mana plus, atk + def + hp nerf, res equal
                    atk[0] -= level[3];
                    hp[0] -= level[3];
                    def[0] -= level[3];
                    mag[0] += level[3];
                    mana[0] += level[3];
                }
                else{
                    atk[0] -= level[3]/2;
                    hp[0] -= level[3]/2;
                    def[0] -= level[3]/2;
                    mag[0] += level[3]/2;
                    mana[0] += level[3]/2;
                }
                break;
            //==> priest
            case "cleric":
            case "priest":
                if (level[3] >= 25) {
                    //mag + mana + res plus, atk + def + hp nerf
                    atk[0] -= level[3];
                    hp[0] -= level[3];
                    def[0] -= level[3];
                    mag[0] += level[3];
                    mana[0] += level[3];
                    res[0] += level[3];
                }
                else{
                    atk[0] -= level[3]/2;
                    hp[0] -= level[3]/2;
                    def[0] -= level[3]/2;
                    mag[0] += level[3]/2;
                    mana[0] += level[3]/2;
                    res[0] += level[3]/2;
                }
                break;
        }
    }
}
