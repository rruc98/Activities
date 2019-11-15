package RPG;



public class Wolf extends Character implements Weapon, Armor{
    private int maxStamina;
    private int currentStamina;
    
    public Wolf(String n, int s, int d, int i){
        this.name = n;
        this.strength = s;
        this.dexterity = d*2;
        this.intelligence = i;
        this.maxLife = dice.roll()*20;
        this.currentLife = maxLife;
        maxStamina = dice.roll()*this.dexterity;
        currentStamina = maxStamina;
    }
    
    public int slash(){
        double slash;
        if (currentStamina >= 10){
            currentStamina -= 10;
            slash = dice.roll()+(this.dexterity*1.2);
        }else
            slash = 0;
        return (int) slash;            
    }
    
    public int maim() {
        double maim;
        if (currentStamina >= 30){
            currentStamina -= 30;
            maim = dice.roll()+(this.dexterity*4);
        }else
            maim = 0;
        return (int) maim;            
    }
    
    public int lifeSteal(int attack){
        double lifeSteal = attack *0.4;
        return (int) lifeSteal;
    }
    
    public void replenishStamina(int s) {
        currentStamina += s;
        if(currentStamina > maxStamina)
            currentStamina = maxStamina;
    }
    
    public int getMaxStamina() {
        return maxStamina;
    }
    
    public int getCurrentStamina(){
        return currentStamina;
    }
    
    public void setCurrentStamina(int s){
        this.currentStamina = s;
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
        double rolled = strength + dice.roll();
        return (int)rolled;
    }
}
