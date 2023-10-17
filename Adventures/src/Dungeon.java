import java.util.Random;

/**
 * This class is the main producer of the dungeon floors which uses a circular linked list
 */
public class Dungeon
{

    private Room headRoom = null;
    private Room lastRoom = null;
    private int size = 0;
    private Room position;
    private int floorSize = 9;

//fcasz
    /**
     * adds a room at the start of the list
     * @param roomType type of room 
     */
    public void addRoom(Object roomType)
    {
        if(headRoom == null)
        {
            Room newRoom = new Room(roomType);
            headRoom = newRoom;
            lastRoom = newRoom;
        }
        else
        {
            Room temp = headRoom;
            Room newRoom = new Room(roomType);
            headRoom = newRoom;
            newRoom.setNext(temp);
        }
    }

    public int getSize()
    {
        return size;
    }

    /**
     * used to clear the dungeon after the exit is used
     */
    public void clear()
    {
        headRoom = null;
        lastRoom = null;
        size = 0;
    }



    /**
     * this will create a dungeon floor for the player to traverse
     * There is a gauranteed Exit, shop, and two items on each floor
     */
    public void floor()
    {
        Random generator = new Random();
        int item1;
        int item2;
        do
        {
            item1 = generator.nextInt(floorSize) + 1;
        }
        while(item1 != floorSize / 2);
        
        do
        {
            item2 = generator.nextInt(floorSize);
        }
        while(item2 != item1 && item2 != floorSize / 2);

        for(int i = 0; i < floorSize; i ++)
        {
            int temp = generator.nextInt(100) + 1;
            if(i == floorSize / 2)
            {
                int shopLocation = generator.nextInt(2) + 1;
                if(shopLocation == 1)
                {
                    Shop shop = new Shop();
                    addRoom(shop);
                    Exit exit = new Exit();
                    addRoom(exit);
                }
                else
                {
                    Exit exit = new Exit();
                    addRoom(exit);
                    Shop shop = new Shop();
                    addRoom(shop);
                }
            }
            else if(i == item1)
            {
                Item item = new Item();
                addRoom(item);
            }
            else if(i == item2)
            {
                Item item = new Item();
                addRoom(item);
            }
            else if(temp <= 75)
            {
                Monster monster = new Monster();
                addRoom(monster);
            }
            else if (temp <= 85)
            {
                Shop shop = new Shop();
                addRoom(shop);
            }
            else
            {
                Trap trap = new Trap();
                addRoom(trap);
            }

        }
    }

    public void map()
    {
        
    }
}