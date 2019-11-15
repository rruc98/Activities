package RPG;
    /**
    * The Character class models a character for a roleplaying game.
    * A character has a name and 3 stats: strength, dexterity, and
    intelligence, as
    * well as maximum allowed life points and the current value.
    */
public abstract class Character {
    /** static variables */
    static Dice dice = new Dice();
    /** instance variables */
    String name;
    int strength;
    int dexterity;
    int intelligence;
    int maxLife;
    int currentLife;
    
    /**
    * Constructor takes 4 parameters: n,s,d,i and assigns them to
    * instance variables name, strength, dexterity, intelligence.
    * Also uses the dice instance to assign a random
    * number to maxlife. currentlife is initialized to maxlife
    */
    public Character(){
       name = "N";
       strength = 1;
       dexterity = 2;
       intelligence = 3;
       maxLife = 4;
       currentLife = maxLife;
    }
    
    public Character(String n, int s, int d, int i) {
        name = n;
        strength = s;
        dexterity = d;
        intelligence = i;
        maxLife = dice.roll()*10;
        currentLife = maxLife;
        System.out.println("Name: " + n + " Strength: " + s + " Dexterity: " + d +" Intelligence: " + i + " Life: " + maxLife);
    }
    
    /**
    * Returns a random die roll using the roll method in the
    * Dice.java, *modified by the character's strength
    */
    public abstract int attack();
    /**
    * Decreases currentlife by the damage parameter
    */
    public void wound(int damage) {
        currentLife -= damage;
        if(currentLife < 0)
            currentLife = 0;
    }
    /**
    * Increases currentlife by the heal parameter.
    * currentlife cannot be greater than maxlife
    */
    public void heal(int heal) {
        if(currentLife < maxLife)
            currentLife += heal;
        if(currentLife > maxLife)
            currentLife = maxLife;
    }
    /**
    * Returns name
    */
    public String getName() {
        return name;
    }
    /**
    * Returns strength
    */
    public int getStrength() {
        return strength;
    }
    /**
    * Returns dexterity
    */
    public int getDexterity() {
        return dexterity;
    }
    /**
    * Returns intelligence
    */
    public int getIntelligence() {
        return intelligence;
    }
    /**
    * Returns currentlife
    */
    public int getCurrentLife() {
        return currentLife;
    }
    /**
    * Returns maxlife
    */
    public int getMaxLife() {
        return maxLife;
    }
}