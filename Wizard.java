
package RPG;
/**
* The Wizard class extends Character, adding two new instance
* variables: maxmagic, and currentmagic, as well as the
* castLightningBolt() and castHeal() methods, which represent
* casting magic spells.
*/
public  class Wizard extends Character implements Weapon, Armor{
    private int maxMagic;
    private int currentMagic;
    
    public Wizard(String n, int s, int d, int i) {
        this.name = n;
        this.strength = s;
        this.dexterity = d;
        this.intelligence = i*2;
        this.maxLife = (dice.roll()*20)+(this.strength * 2);
        this.currentLife = maxLife;
        maxMagic = (dice.roll()+ 20)*this.intelligence;
        currentMagic = maxMagic;
    }
    
    /**
    * Returns a random die roll using the roll method in the
    * Dice.java, *modified by the character's intelligence
    */
    public int castLightningBolt() {
        if(currentMagic >= 100){
            int lightningBolt = dice.roll()+ this.intelligence*2;
            return lightningBolt;
        }else
            return 0;
    }
    
    /**
    * castHeal() represents casting a magic spell. The method first
    * checks that currentmagic is greater than/equal to 8. If it
    * is, currentmagic is reduced by 8 and the character's heal()
    * method is called with a random number, modified by the
    * character's intelligence score. The amount healed is also
    * returned by the method.
    */
    public int castHeal() {
        double cHeal;
        if(currentMagic >= 8) {
            currentMagic -= 8;
            cHeal = dice.roll()+(this.intelligence*1.5) + (this.maxLife * 0.3);
        }else
            cHeal = 0;
        return (int)cHeal;
    }
    
    /**
    * Returns maxmagic
    */
    public int getMaxMagic(){
        return maxMagic;
    }
    
    /**
    * Returns currentmagic
    */
    public int getCurrentMagic() {
        return currentMagic;
    }

    @Override
    public int attack() {
        double attack = (strength * 0.4) + dice.roll();
        return (int)attack;
    }

    @Override
    public int useWeapon() {
        double rolled = strength + dice.roll();
        return (int)rolled;
    }

    @Override
    public int useArmor() {
        double rolled = (strength * 0.5) + dice.roll();
        return (int)rolled;
    }
}
