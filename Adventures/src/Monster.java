import java.util.Random;
import java.util.Scanner;

/**
 * this Class contains all the preset monsters and has the battle method
 */
public class Monster
{
    int life, attack, defense, speed, money, level, exp;
    String monsterName, monsterPrompt;
    //generates a number that corresponds to a preset
    Random generator = new Random();
    int monsterType = generator.nextInt(5) + 1;

    //generates a Monster preset with the difficulty modifier
    public Monster(int difficulty)
    {
        generateMonster(difficulty);
    }

    //will assign stats from the preset with a difficulty modifier that always starts at 1
    public void generateMonster(int difficulty)
    {
        if(monsterType == 1)
        {
            life = 20 + (10 * difficulty);
            attack = 1 + (2 * difficulty);
            defense = (1 * difficulty);
            speed = (1 * difficulty);
            money = 10 + (5 * difficulty);
            level = difficulty;
            exp = 10 + (10 * difficulty);
            monsterPrompt = "Its a slime! No it doesn't taste like jello";
            monsterName = "Slime";
        }
        else if(monsterType == 2)
        {
            life = 5 + (5 * difficulty);
            attack = 4 + (3 * difficulty);
            defense = 1 + (1 * difficulty);
            speed = 2 + (1 * difficulty);
            money = 4 + (4 * difficulty);
            level = difficulty;
            exp = (10 * difficulty);
            monsterPrompt = "Its a goblin! He does not want to be your friend";
            monsterName = "Goblin";
        }
        else if(monsterType == 3)
        {
            life = (5 * difficulty);
            attack = (2 * difficulty);
            defense = 4 + (3 * difficulty);
            speed = (1 * difficulty);
            money = (5 * difficulty);
            level = difficulty;
            exp = (15 * difficulty);
            monsterPrompt = "Its a suit of armor! ITS ALIVE";
            monsterName = "Suit of Armor";
        }
        else if(monsterType == 4)
        {
            life = 15 + (5 * difficulty);
            attack = 1 + (1 * difficulty);
            defense = (1 * difficulty);
            speed = 4 + (1 * difficulty);
            money = (5 * difficulty);
            level = difficulty;
            exp = (10 * difficulty);
            monsterPrompt = "Its a swarm of rats! Hopefully you arent carrying any cheese";
            monsterName = "Swarm of Rats";
        }
        else if(monsterType == 5)
        {
            life = (30 * difficulty);;
            attack = 4 + (4 * difficulty);
            defense = 3 + (3 * difficulty);
            speed = 1 + (1 * difficulty);
            money = 30 + (20 * difficulty);
            level = difficulty;
            exp = (35 * difficulty);
            monsterPrompt = "Its a chest!... wait, why does it have teeth?";
            monsterName = "Mimic";
        }
    }

    /**
     * has the monster and the player attack each other until one runs out of health
     * @param player 
     */
    public void battle(Hero player)
    {
        //Scanner takes inputs on whether the player attacks or flees
        Scanner scan = new Scanner(System.in);
        System.out.println("You face the " + monsterName + " What do you want to do?");
        //battle loops until either opponent dies
        while(life > 0 && player.getCurrentHP() > 0)
        {
            //player inputs whether to attack or flee
            System.out.printf("Attack(1)\nFlee(2)\n");
            int action = scan.nextInt();
            //The player attacks
            if(action == 1)
            {  
                //if Monsters speed is greater than or equal to the players the monster will attack first
                if(speed >= player.getSpeed())
                {
                    //monster attacks player
                    attack(player);
                    //if the player is not dead they will attack back
                    if(player.getCurrentHP() > 0)
                    {
                        //player attacks monster
                        defend(player);
                    }
                }
                //if the players speed is greater than the monsters speed
                else if(player.getSpeed() > speed)
                {
                    //player attacks first
                    defend(player);
                    //if the monster isnt dead then they attack back
                    if(life > 0)
                    {
                        //The monster attacks the player
                        attack(player);
                    }
                }
                //if the monster is dead give the player the monsters gold and exp
                if(life  <= 0)
                {
                    System.out.println("You defeated the " + monsterName + ". You recieved " + money + " gold and gained " + exp + "xp");
                    System.out.println();
                    //adds the monsters gold to the players gold
                    player.setMoney(player.getMoney() + money);
                    //adds the monsters exp to the players xp
                    player.setXp(player.getXp() + exp);
                }
            }
            //the player chooses to flee
            else if(action == 2)
            {
                //Evade chance is 10 times the players speed stat
                int evade = generator.nextInt(100);
                //if the player fails to evade they suffer an attack without armor reduction
                if(evade >= (player.getSpeed() * 10))
                {
                    //players health is reduced by the monsters attack
                    player.setCurrentHP(player.getCurrentHP() - attack);
                    System.out.println("You escape but take a blow to the back as you escape");
                    break;
                }
                //if the player evades they get away without taking any damage
                else
                {
                    System.out.println("You narrowly escaped the " + monsterName);
                    break;
                }
            }
        }
    }

    /**
     * method used for when the monster tries to attack the player
     * @param player the player
     */
    public void attack(Hero player)
    {
        //Generates a number from 1 -> 100
        int hitChance = generator.nextInt(100) + 1;
        //the players dodge chance
        int playerDodgeChance = player.getSpeed() * 10;
        //The monster has to roll higher than the players dodge to hit them
        if(hitChance > playerDodgeChance)
        {
            //damage is calculated as the monsters attack - the players defense
            int playerDefense = player.getDefense();
            int damage;
            //if the players defense is higher than the attack then a minumum of 1 damage will be applied
            if(playerDefense >= attack)
            {
                damage = 1;
            }
            else
            {
                damage = attack - playerDefense;
            }
            //sets the players hp
            int playerLife = player.getCurrentHP();
            player.setCurrentHP(playerLife - damage);
            System.out.println("you took " + damage + " damage. You are now at " + player.getCurrentHP() + " HP");
        }
        //The monster did not roll high enough
        else
        {
            System.out.println("You dodged the attack");
        }
    }

    /**
     * used for when the player attacks the monster
     * @param player
     */
    public void defend(Hero player)
    {
        //the player must roll a higher number then the monsters dodge chance * 10
        int playerHitChance = generator.nextInt(100)  + 1;
        int dodgeChance = speed * 10;
        if(playerHitChance > dodgeChance)
        {
            //damage is calculated as attack - defense
            int damage;
            int playerAttack = player.getAttack();
            //if the defense is higher than attack then a minimum of 1 damage will be done
            if(defense >= playerAttack)
            {
                damage = 1;
            }
            else
            {
                damage = playerAttack - defense;
            }
            //sets the monsters life
            life = life - damage;
            System.out.println("You dealt " + damage + " damage to the " + monsterName);
        }
        //The monster missed
        else
        {
            System.out.println("You missed");
        }
    }

    //-----------------------------
    //getters and setters
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
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
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMonsterType()
    {
        return monsterType;
    }

    

}
