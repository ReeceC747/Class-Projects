import java.util.Random;
import java.util.Scanner;

/**
 * This class contains the class presets the player will choose to play as
 */
public class Hero
{
    int maxHP, currentHP, attack, defense, speed, money, level, xp;
    /**
     * empty constructor
     */
    Hero()
    {
    }

    /**
     * The player will choose from 3 classes to play as
     */
    public void chooseClass()
    {
        //takes the players input
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a class by entering a corresponding number: Barbarian(1), Fighter(2), Rogue(3)");
        int option = scan.nextInt();
        //if the player wants to play a barbarian
        if(option == 1)
        {
            System.out.println("The Barbarian, A force to be reckoned with, they rock a high defense and good attack and are sustainable in combat\n");
            maxHP = 75;
            currentHP = maxHP;
            attack = 5;
            defense = 2;
            speed = 3;
            money = 0;
            level = 1;
            xp = 0;
        }
        //if the player wants to play a fighter
        else if(option == 2)
        {
            System.out.println("The Fighter, a calm and collected warrior, while not as healthy as their reckless counterpart they start off with a higher defnse stat\n");
            maxHP = 55;
            currentHP = maxHP;
            attack = 4;
            defense = 6;
            speed = 2;
            money = 0;
            level = 1;
            xp = 0;
        }
        //if the player wants to play a rogue
        else if(option == 3)
        {
            System.out.println("The Rogue, a quick and evasive character, their high speed and attack allow them to end fights faster than others, but they lack defense and health\n");
            maxHP = 35;
            currentHP = maxHP;
            attack = 8;
            defense = 1;
            speed = 6;
            money = 15;
            level = 1;
            xp = 0;
        }
    }

    /**
     * 
     * @param difficulty
     */
    public void levelUp(int difficulty)
    {
        //If the player has more xp than the requirment to level up
        if(xp >= 100 + Math.pow(difficulty, 2))
        {
            //Removes however much xp they had to have to level up
            xp = (int) (xp - (100 + Math.pow(difficulty, 2)));
            //uses a Random number generator to determine the stat upgrade
            Random gen = new Random();
            int option = gen.nextInt(4) + 1;
            //The players max hp increased by 5
            if(option == 1)
            {
                maxHP = maxHP + 5;
                System.out.println("You leveled up! Your max hp has increased by 5");
            }
            //the players attack increases by 1
            else if(option == 2)
            {
                attack++;
                System.out.println("You leveled up! Your attack has increased by 1");
            }
            //the players defense increases by 1
            else if(option == 3)
            {
                defense++;
                System.out.println("You leveled up! Your defense has increased by 1");
            }
            //the players speed incereases by 1
            else if(option == 4)
            {
                speed++;
                System.out.println("You leveled up! Your speed has increased by 1");
            }
        }
    }

    //-------------------------------------------
    //Getters and Setters
    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
