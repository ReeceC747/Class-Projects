import java.util.Scanner;

/**
 * a Shop always has the same stock and a player can keep buying from them as long as they have the gold
 */
public class Shop 
{
    /**
     * empty constructor
     */
    public Shop()
    {
    }

    /**
     * method for browsing and buying shopkeeps wares
     * @param player
     */
    public void browse(Hero player)
    {
        System.out.println("You arrive at a shop the shopkeep greets you and you browse their wares");
        //used to keep the player in the shop
        boolean stillBrowsing = true;
        //keep looping until player cant afford an item or chooses to leave
        while(stillBrowsing)
        {

            System.out.println("A room to rest(1) costs 30 gold\nA sword(2) costs 15 gold \nA shield(3) costs 20 gold\nLeave(4)\n" + 
                "You have " + player.getMoney() + " gold\n");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();  
            //if the player does not have enough gold to buy anything they are forced out of the shop
            if(player.getMoney() < 15)
            {
                System.out.println("The shopkeep notices that your pockets are a little light, unimpressed, they politely ask you to leave\n");
                stillBrowsing = false;
            }
            //The player chooses to leave
            else if(option == 4)
            {
                stillBrowsing = false;
                System.out.println("You say goodbye to the shopkeep and head off");
            }
            //if the player chooses to rent a room and has the money for it
            else if(option == 1 && player.getMoney() >= 30)
            {
                System.out.println("You purchase a room to rest in. You feel well rested");
                player.setMoney(player.getMoney() - 30);
                player.setCurrentHP(player.getMaxHP());
            }
            //if the player tries to rent a room and they dont have the money for it
            else if(option == 1 && player.getMoney() < 30)
                {
                System.out.println("As you go to pay to pay for a room you notice you are short some gold pieces, the shopkeeper " +
                    "is unimpressed and asks you to leave");
                stillBrowsing = false;
            }
            //if the player tries to buy a sword and has the money for it
            else if(option == 2 && player.getMoney() >= 15)
            {
                System.out.println("You buy the sword mounted on the wall");
                player.setMoney(player.getMoney() - 15);
                player.setAttack(player.getAttack() + 1);
            }
            //if the player tries to buy the shield and has the money for it
            else if(option == 3 && player.getMoney() >= 20)
            {
                System.out.println("You buy the shield in the display case");
                player.setMoney(player.getMoney() - 20);
                player.setDefense(player.getDefense() + 1);
            }
            //if the player tries to buy the shield and does not have the money for it
            else if(option == 3 && player.getMoney() < 20)
            {
                System.out.println("As you go to pay for the shield you notice that you are short a few gold pieces, " +
                    "unimpressed, the shopkeeper respectfully asks you to leave");
                stillBrowsing = false;
            }
            //There is no else if for when the player doesnt have enough money to buy the sword becuase if they cant afford that
            //then they cant afford anything
        }
    }
}
