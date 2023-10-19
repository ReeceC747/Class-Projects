import java.util.Random;

/**
 * A Class that holds all the trap presets and has evade method
 */
public class Trap
{
    int hpMod, maxHPMod, attackMod, defenseMod, speedMod, moneyMod;
    String trapName;
    /**
     * A trap is generated upon construction
     */
    public Trap()
    {
        generateTrap();
    }

    //generator to assign the traptype 
    Random generator = new Random();
    int trapType = generator.nextInt(6) + 1;
    /**
     * assigns the modifiers depending on the traptype
     */
    public void generateTrap()
    {

        if(trapType == 1)
        {
            hpMod = 10;
            trapName = "The ceiling caved in under you!";
        }
        else if(trapType == 2)
        {
            maxHPMod = 5;
            trapName = "You found a fountain and you feel a little parched";
        }
        else if(trapType == 3)
        {
            attackMod = 1;
            trapName = "You open the door to find a blacksmith, they offer to upgrade your weapon";
        }
        else if(trapType == 4)
        {
            defenseMod = 1;
            trapName = "You find some really cool looking armor";
        }
        else if(trapType == 5)
        {
            speedMod = 1;
            trapName = "You enter the room and see a large table";
        }
        else if(trapType == 6)
        {
            moneyMod = 20;
            trapName = "You come to a room with a locked door, on the door is a sign \"Your dungeon+ subscription has run out, please enter payment information to continue\"\n";
        }
    }

    /**
     * checks whether the player will dodge the trap or not
     * @param player
     */
    public void evade(Hero player)
    {
        //dodge chance is reliant on the player (the higher the better)
        int attackToHit = generator.nextInt(100) + 1;
        int evadeChance = player.getSpeed() * 10;
        //If the player fails to dodge the trap
        if(attackToHit >= evadeChance)
        {
            if(trapType == 1)
            {
                player.setCurrentHP(player.getCurrentHP() - hpMod);
                System.out.println("A piece of rubble falls on your head and you fall to the ground. You take " + hpMod 
                    + " damage. You are now at " + player.getCurrentHP() + " HP");
            }
            else if(trapType == 2)
            {
                player.setMaxHP(player.getMaxHP() - maxHPMod);
                System.out.println("You drink from the fountain, afterwards you see a sign saying \"Fountain of Aging\" " +
                    "Your max HP decreased by 5");
            }
            else if(trapType == 3)
            {
                player.setAttack(player.getAttack() - attackMod);
                System.out.println("You accept the blacksmiths offer, they smack your weapon with a hammer under an anvil 3 times. "
                + "Your attack decreased by 1");
            }
            else if(trapType == 4)
            {
                player.setDefense(player.getDefense() - defenseMod);
                System.out.println("You swap it with what your wearing, it has worse stats, but hey you look pretty dapper. "
                    + "Your defense decreased by 1");
            }
            else if(trapType == 5)
            {
                player.setSpeed(player.getSpeed() - speedMod);
                System.out.println("You try going around the table and stub your toe on a table leg. Your speed decreased by 1");
            }
            else if(trapType == 6 && player.getMoney() >= 20)
            {
                player.setMoney(player.getMoney() - moneyMod);
                System.out.println("You begrudgingly pay to renew your dungeon+ subscription");
            }
            else if(trapType == 6 && player.getMoney() < 20)
            {
                player.setCurrentHP(0);
                System.out.println("Unable to renew your dungeon+ subscription you are unable to continue through the dungeon");
            }
        }
        //if the player succeeds in dodging the trap
        else if(evadeChance > attackToHit)
        {
            if(trapType == 1)
            {
                System.out.println("You evade all the falling rubble");
            }
            else if(trapType == 2)
            {
                System.out.println("You see the sign \"Fountain of Aging\" and decide to skip drinking from the fountain");
            }
            else if(trapType == 3)
            {
                System.out.println("You decline the blacksmiths offer seeing they only have a hammer and an anvil");
            }
            else if(trapType == 4)
            {
                System.out.println("You decide to pass as its worse than what your already wearing");
            }
            else if(trapType == 5)
            {
                System.out.println("You succsessfully navigate around the table and safely make it to the other side unharmed");
            }
            else if(trapType == 6)
            {
                System.out.println("You find a free month of dungeon+ coupon lying around and are able to pass for free");
            }
        }
    }

    /**
     * returns trapName
     * @return trapName
     */
    public String getTrapName()
    {
        return trapName;
    }
}
