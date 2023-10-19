import java.util.Scanner;
/**
 * This Class contains the method that keeps the game looping while the player still has health
 * There is also a tutorial that shows the player how to make decisions
 */
public class Engine 
{
    //Makes a scanner so the player can input actions
    Scanner scan = new Scanner(System.in);
    /**
     * A tutorial that shows the player how to input actions
     */
    public void tutorial()
    {
        System.out.println("For the following prompts enter the corresponding number to choose your actions, for example which color do you like better? red(1) or blue(2)");
        //The players input
        int answer = scan.nextInt();
        //if the player likes the color red
        if(answer == 1)
        {
            System.out.println("You like the color red\n");
        }
        //if the player likes the color blue
        else if(answer == 2)
        {
            System.out.println("You like the color blue");
        }
        //if the player did not enter the right number
        else
        {
            System.out.println("Incorrect input try again");
            tutorial();
        }
    }

    /**
     * This method is going to run the game for the player
     */
    public void runGame()
    {
        //plays a quick tutorial for the player
        tutorial();
        //makes a new dungeon
        Dungeon game = new Dungeon();
        //gets the difficulty
        int difficulty = game.getDifficulty();
        //makes a dungeon floor
        game.floor(difficulty);
        //makes a Hero
        Hero character = new Hero();
        //The player will choose from 3 classes to play
        character.chooseClass();
        //Loops while the player has health
        while(character.getCurrentHP() > 0)
        {
            //Shows the doors to the players right and left
            game.printOptions();
            System.out.println("Which way would you like to go? left(1) or right(2)\nshow map(3)\nshow stats(4)");
            //Takes players input
            int option = scan.nextInt();
            //The player moves left
            if(option == 1)
            {
                game.move(1, character);
            }
            //the player moves right
            else if(option == 2)
            {
                game.move(2, character);
            }
            //Shows the player all the rooms
            else if(option == 3)
            {
                game.printMap();
            }
            //shows the player all their stats
            else
            {
                game.stats(character);
            }
        }
        //If the players health drops to 0 or below they will be given a prompt to play again
        System.out.println("Game Over, Score = " + game.getCompletions() + "\nWould you like to play again? Yes(1) No(2)");
        int option = scan.nextInt();
        //the player chooses to play again
        if(option == 1)
        {
            runGame();
        }
    }
}
