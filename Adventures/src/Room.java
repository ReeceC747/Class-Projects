import java.util.Random;

/**
 * Room holds the type of Rooms that can appear in the dungeon, they also hold pointers to rooms next to them
 */
public class Room <E>
{
    //points to the next room in the list
    private Room next;
    //points to the previous room in the list
    private Room previous;
    //holds the type of Room
    private E data;
    //The name of the room
    private String roomName;

    //Constructs a Room with a given Room type and name
    public Room(E userData, String userRoomName)
    {
        roomName = userRoomName;
        data = userData;
        next = null;
        previous = null;    
    }

    //----------------------------------------------
    //Getters and setters
    public void setRoom(E roomType)
    {
        data = roomType;
    }

    public E getRoom()
    {
        return  data;
    }
        
    public void setRoomName(String userRoomName)
    {
        roomName = userRoomName;
    }

    public String getRoomName()
    {
        return roomName;
    }
     
    public Room getNext()
    {
        return next;
    }

    public void setNext(Room userNext)
    {
        next = userNext;
    }

    public Room getPrevious()
    {
        return previous;
    }

    public void setPrevious(Room userPrevious)
    {
        previous = userPrevious;
    }
}