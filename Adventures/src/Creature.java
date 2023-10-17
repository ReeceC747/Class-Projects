public class Creature 
{
    int maxLife, currentLife, attack, defense, speed, money, experience;
    public Creature(int userMaxLife, int userCurrentLife, int userAttack, int userDefense, int userSpeed, int userMoney, int userExperience)
    {
        maxLife = userMaxLife;
        currentLife = userCurrentLife;
        attack = userAttack;
        defense = userDefense;
        speed = userSpeed;
        money = userMoney;
        experience = userExperience;
    }

/****************************** */

    public int getMaxLife()
    {
        return maxLife;
    }

    public void setMaxLife(int userMaxLife)
    {
        maxLife = userMaxLife;
    }

    public int getCurrentLife()
    {
        return currentLife;
    }

    public void setCurrentLife(int userCurrentLife)
    {
        currentLife = userCurrentLife;
    }

    public int getAttack() 
    {
        return attack;
    }

    public void setAttack(int userAttack) 
    {
        attack = userAttack;
    }

    public int getDefense() 
    {
        return defense;
    }

    public void setDefense(int userDefense) 
    {
        defense = userDefense;
    }

    public int getSpeed() 
    {
        return speed;
    }

    public void setSpeed(int userSpeed) 
    {
        speed = userSpeed;
    }

    public int getMoney() 
    {
        return money;
    }

    public void setMoney(int userMoney) 
    {
        money = userMoney;
    }

    public int getExperience()
    {
        return experience;
    }

    public void setExperience(int userExperience)
    {
        experience = userExperience;
    }

    /******************************************** */

    public void attack(Creature target)
    {
        int attack = getAttack();
        int targetDefense = target.getDefense();
        int damage;
        int life = target.getCurrentLife();
        if(attack >= targetDefense)
        {
            damage = attack - defense;
            
            life = life - damage;
            target.setCurrentLife(life);
        }
        else
        {
            target.setCurrentLife(life--);  //still take atleast one damage so your not invincible
        }
    }
}
