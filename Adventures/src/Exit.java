import java.util.Random;

public class Exit extends Room
{
    private Random generator = new Random();

    public Exit()
    {
    }

    public void newDungeon()
    {
        Dungeon newDungeon = new Dungeon();
        
    }

    public Object generateRoomType()
    {
        int room = generator.nextInt(7) + 1;
        if(room == 1)
        {
            Item item = new Item();
            return item;
        }
        if(room == 2)
        {
            Shop shop = new Shop();
            return shop; 
        }
        if(room == 3)
        {
            Trap trap = new Trap();
            return trap;
        }
        Monster monster = new Monster();
        return monster;
    }
}
