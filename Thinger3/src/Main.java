/**
 * Created by JJ on 10/21/2018.
 */
public class Main {

    public static void main(String[] args) {
        Protagonist you = new Protagonist("Yote", "fighter");
        Character enemy = new Character("Goblin", 1);
        System.out.println(you.atk[0]);
        System.out.println(you.mag[0]);
        System.out.println(you.mana[0]);
        System.out.println(you.hp[0]);
        System.out.println(you.def[0]);
        System.out.println(you.res[0]);
        System.out.println(enemy.atk[0]);
        System.out.println(enemy.mag[0]);
        System.out.println(enemy.mana[0]);
        System.out.println(enemy.hp[0]);
        System.out.println(enemy.def[0]);
        System.out.println(enemy.res[0]);
        you.reset(true);
        enemy.reset(true);
        you.attack(enemy);

    }

}
