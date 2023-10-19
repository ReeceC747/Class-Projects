import java.util.Random;

/**
 * This class contains the preset items the player can get
 */
public class Item 
{
    int maxLifeMod, currentLifeMod, attackMod, defenseMod, speedMod, moneyMod, expMod;
    String itemName;

    //makes a number from 1 -> 7 which will point towards an item type
    Random generator = new Random();
    int itemType = generator.nextInt(7) + 1;

    /**
     * when an item is made it will be assigned a preset
     */
    public Item()
    {
        generateItem();
    }

    /**
     * contains all the item presets
     */
    public void generateItem()
    {
        //the item is a max hp boost
        if(itemType == 1)
        {
            maxLifeMod = 15;
            itemName = "You found a potion of longevity, your max hp is increased by 15";
        }
        //the item is a hp boost which can overheal
        else if(itemType == 2)
        {
            currentLifeMod = 30;
            itemName = "You found a pickle(yum), it healed you for 30 hp";
        }
        //item is an attack boost
        else if(itemType == 3)
        {
            attackMod = 4;
            itemName = "You found a sword or is it just a really big knife? Your attack increased by 4";
        }
        //item is a defense boost
        else if(itemType == 4)
        {
            defenseMod = 2;
            itemName = "You found a shield, doubles as a dinner plate. Your defense increased by 2";
        }
        //item is a speed boost
        else if(itemType == 5)
        {
            speedMod = 1;
            itemName = "You found a pair of uncreased jays. Your speed increased by 1";
        }
        //item is large sum of gold
        else if(itemType == 6)
        {
            moneyMod = 50;
            itemName = "You found someones will. You earned 50 gold";
        }
        //item is an xp boost
        else
        {
            expMod = 100;
            itemName = "You found a book, I heard that ones a good read. You got 100 xp";
        }
    }

    /**
     * Uses the item to boost the hero
     * @param item the integer that refers to the type of item
     * @param hero the player recieving the buff
     */
    public void useItem(int item, Hero hero)
    {
        //players max hp is increased by 15
        if(item == 1)
        {
            int maxHeroHP = hero.getMaxHP();
            hero.setMaxHP(maxHeroHP + maxLifeMod);
        }
        //players hp is increased by 30
        else if(item == 2)
        {
            int heroHP = hero.getCurrentHP();
            hero.setCurrentHP(heroHP + currentLifeMod);
        }
        //players attack is increased by 4
        else if(item == 3)
        {
            int heroAttack = hero.getAttack();
            hero.setAttack(heroAttack + attackMod);
        }
        //players defense is increased by 2
        else if(item == 4)
        {
            int heroDefense = hero.getDefense();
            hero.setDefense(heroDefense + defenseMod);
        }
        //players speed is increased by 1
        else if(item == 5)
        {
            int heroSpeed = hero.getSpeed();
            hero.setSpeed(heroSpeed + speedMod);
        }
        //players money is increased by 50
        else if(item == 6)
        {
            int heroMoney = hero.getMoney();
            hero.setMoney(heroMoney + moneyMod);
        }
        //players xp is increase by 100
        else if(item == 7)
        {
            int heroXP = hero.getXp();
            hero.setXp(heroXP + expMod);
        }
    }

    //-------------------------------------
    //Getters and setters
    public int getItemType()
    {
        return itemType;
    }

    public int getMaxLifeMod() {
        return maxLifeMod;
    }

    public void setMaxLifeMod(int maxLifeMod) {
        this.maxLifeMod = maxLifeMod;
    }

    public int getCurrentLifeMod() {
        return currentLifeMod;
    }

    public void setCurrentLifeMod(int currentLifeMod) {
        this.currentLifeMod = currentLifeMod;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public void setAttackMod(int attackMod) {
        this.attackMod = attackMod;
    }

    public int getDefenseMod() {
        return defenseMod;
    }

    public void setDefenseMod(int defenseMod) {
        this.defenseMod = defenseMod;
    }

    public int getSpeedMod() {
        return speedMod;
    }

    public void setSpeedMod(int speedMod) {
        this.speedMod = speedMod;
    }

    public int getMoneyMod() {
        return moneyMod;
    }

    public void setMoneyMod(int moneyMod) {
        this.moneyMod = moneyMod;
    }

    public int getExpMod() {
        return expMod;
    }

    public void setExpMod(int expMod) {
        this.expMod = expMod;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    

}
