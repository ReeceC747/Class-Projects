import java.util.Random;

public class Room
    {
        private Room next;
        //private Box previous;
        private Object data;
    
    
        public Room(Object userData)
        {
            data = userData;
            next = null;
    
        }

        public Room()
        {
        }
    
        public void setRoom(Object roomType)
        {
            data = roomType;
        }

        public Object getRoom()
        {
            return  data;
        }
    
        public Room getNext()
        {
            return next;
        }

        public void setNext(Room userNext)
        {
            next = userNext;
        }

        public void generateRoomType()
        {
            
        }
    }