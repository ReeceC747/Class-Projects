import java.util.Random;

/**
 * This class contains the generation of dungeon floors, moving between them and shows the rooms to the player
 * uses a circularly linked list to make the dungeon floor
 */
public class Dungeon
{
    //difficulty of the game, goes up every 5 floors, modifies Monsters stats
    private int difficulty = 1;
    //total number of floors completed
    private int completions;
    //Most recently created Room or the Room to the players right
    private Room headRoom = null;
    //Oldest Room or the Room to the players left
    private Room lastRoom = null;
    //used to point to whatever room the player is in
    private Room position;
    //Affects how many floors are made
    private int floorSize = 8;



    /**
     * Adds a new room to the start of the linked list
     * @param roomType
     * @param userRoomName
     */
    public void addRoom(Object roomType, String userRoomName)
    {
        //if there are no rooms made
        if(headRoom == null)
        {
            //Makes a new Room with the correspond Room type and given name
            Room newRoom = new Room(roomType, userRoomName);
            //Sets headRoom to point to this room
            headRoom = newRoom;
            //This room will always be at the end of the list
            lastRoom = newRoom;

        }
        //if there are other rooms, make this one at the start of the list
        else
        {
            //temp Room pointing to headRoom
            Room temp = headRoom;
            //Makes a new Room with the correspond Room type and given name
            Room newRoom = new Room(roomType, userRoomName);
            //sets the older room to point to the newer Room
            temp.setPrevious(newRoom);
            //sets the start of the list to point to this new Room
            headRoom = newRoom;
            //sets the new Room to point to the older Room
            newRoom.setNext(temp);
        }
    }

    /**
     * used to clear the dungeon after the exit is used
     */
    public void clear()
    {
        //severs the connection from start of the list
        headRoom = null;
        //severs the connection from the back of the list
        lastRoom = null;
    }




    /**
     * Creates a series of Rooms with an exit in the middle of the circularly linked list,
     * @param difficulty how much harder the stats of Monsters are going to be
     */
    public void floor(int difficulty)
    {
        //generator made to generate the room type
        Random generator = new Random();

        //Loops until 8 Rooms are made with the addition of 2 exits
        for(int i = 0; i < floorSize + 1; i ++)
        {
            //generates a number from 1 -> 100
            int temp = generator.nextInt(100) + 1;
            //When the loop gets to half its cycle, make two floors (one for each path)
            if(i == floorSize / 2)
            {
                //make a new Exit and add it to the Linked list
                Exit exit = new Exit();
                addRoom(exit, "Exit");
            }
            //65% chance of Rooms to be Monsters
            else if(temp <= 65)
            {
                //Make a new Monster and add it to the Linked List
                Monster monster = new Monster(difficulty);
                addRoom(monster, "Monster");
            }
            //10% chance for Rooms to be Shops
            else if (temp <= 75)
            {
                //Make a new Shop and add it to the Linked list
                Shop shop = new Shop();
                addRoom(shop, "Shop");
            }
            //15% chance for Rooms to be Traps
            else if(temp <= 90)
            {
                //Make a new Trap and add it to the Linked List, named Item to lure players to go through them
                Trap trap = new Trap();
                addRoom(trap, "Item");
            }
            //10% chance for Rooms to be Items
            else
            {
                //Make a new Item and add it to the linked list
                Item item = new Item();
                addRoom(item, "Item");
            }
        }
    }

    /**
     * prints the Rooms to the players left and right
     */
    public void printOptions()
    {
        System.out.printf("The door to your left reads: " + lastRoom.getRoomName() + 
            "\nThe room to your right reads: " + headRoom.getRoomName() + "\n");
    }

    /**
     * Prints all the Rooms to the players right and all the Rooms on the players left
     */
    public void printMap()
    {
        //shows the path to the players left
        System.out.print("On your left is the path that lies ahead: ");
        //used to get the sequence of rooms starting from oldest to newest
        position = lastRoom;
        //Goes until the room is an Exit
        while(!(position.getRoom() instanceof Exit))
        {
            //prints the Rooms name
            System.out.print(position.getRoomName() + " ");
            //moves to the previous room
            position = position.getPrevious();
        }
        //prints the exit
        System.out.println(position.getRoomName() + " ");
        

        //Shows the path on the players right
        System.out.print("On your right is the path that lies ahead: ");
        //used to get the sequence of rooms starting from newest to oldest
        position = headRoom;
        //goes until the Room is an exit
        while(!(position.getRoom() instanceof Exit))
        {
            //prints the Rooms name
            System.out.print(position.getRoomName() + " ");
            //moves to the next Room
            position = position.getNext();
        }
        //prints the exit
        System.out.println(position.getRoomName() + " ");
    }

    /**
     * This moves the player to either the Room to their left or right and preforms the actions that correspond to the Room
     * @param userMove Is going to be either 1 (player moves left) or 2(player moves right)
     * @param player used to have the player interact with Rooms (Item, Monster, Trap, and Shop)
     */
    public void move(int userMove, Hero player)
    {
        //player moves left and removes the room they're in out of the list
        if(userMove == 1)
        {
            //sets the players position to the oldest Room
            position = lastRoom;
            //gets the previous Room
            Room PreviouRoom = lastRoom.getPrevious();
            //disconnects the Room from the list
            lastRoom.setNext(null);
            lastRoom.setPrevious(null);
            //sets the previous Room as the one at the end of the list
            lastRoom = PreviouRoom;
        }
        //player moves right and removes the room they're in out of the list
        else if(userMove == 2)
        {
            //sets the players position to the newest Room
            position = headRoom;
            //gets the next Room
            Room nextRoom = headRoom.getNext();
            //disconnects the Room from the list
            headRoom.setNext(null);
            headRoom.setPrevious(null);
            //sets the next Room as the one at the start of the list
            headRoom = nextRoom;
        }

        //gets the type of Room the player is in
        Object room = position.getRoom();
        
        //If the Room is an Exit
        if(room instanceof Exit)
        {
            System.out.println("Exit Reached(good job). Generating new floor");
            //Removes any remaining Rooms
            clear();
            //makes a new series of Rooms with a difficulty modifier
            floor(difficulty);
            //imcrements amount of floors cleared by 1
            completions++;
            //Increase the difficulty ever 4 floors
            if(completions % 4 == 0)
            {
                difficulty++;
            }
        }
        //if the Room is an Item
        else if(room instanceof Item)
        {
            //gets a number that corresponds to a type of item
            int itemType = ((Item)room).getItemType();
            //uses the item on the player using the corresponding number
            ((Item)room).useItem(itemType, player);
            //prints the item name/description
            System.out.println(((Item)room).getItemName());
        }
        //if the room is a monster
        else if(room instanceof Monster)
        {
            //gets the type of monster that corresponds to a number
            int monsterType = ((Monster)room).getMonsterType();
            //the player battles the monster until one of them run out of hp
            ((Monster)room).battle(player);
        }
        //if the room is a shop
        else if(room instanceof Shop)
        {
            //the player can buy items until they run out of money or until they dont want to anymore
            ((Shop)room).browse(player);
        }
        //if the room is a trap
        else if(room instanceof Trap)
        {
            //prints the traps name/description
            System.out.println(((Trap)room).getTrapName());
            //the player will try to dodge the trap
            ((Trap)room).evade(player);
        }
        //checks if the player has enough xp to level up a random stat
        player.levelUp(difficulty);
    }

    /**
     * prints all the players stats which includes: max hp, hp, attack, defense, speed, money, level, and xp
     * @param player
     */
    public void stats(Hero player)
    {
        System.out.println("Max HP: " + player.getMaxHP() + "\nCurrent HP: " + player.getCurrentHP() + "\nAttack: " + player.getAttack()
            + "\nDefense: " + player.getDefense() + "\nSpeed: " + player.getSpeed() + "\nGold: " + player.getMoney()
            + "\nLevel: " + player.getLevel() + "\nExperience: " + player.getXp());
    }

    /**
     * returns the difficulty
     * @return difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * returns the completions
     * @return completions
     */
    public int getCompletions()
    {
        return completions;
    }
}