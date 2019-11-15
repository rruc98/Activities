package RPG;



public class Duel2 {
    static Dice d = new Dice();
    String winner = "";
    public static void main(String [] args){
        Wizard c1 = new Wizard("The Wizard Bob",20,20,20);//Wizard Character
        Wolf c2 = new Wolf("Howling Dawn",20,20,20);//Wolf Character
        int placeHolder;//Holds value for text
        int wiHealCD,wiUseArmorCD,wiLightCD,woSlashCD,woMaimCD;//Cooldowns
        for(int i = 1;;i++){//Duel starts at round 1 and ends when one character's Life reaches 0
            System.out.println("Round " + i + "! ||" + c1.getName() + ":" + c1.getCurrentLife() +"/"+c1.getMaxLife()+ " Magic: "+c1.getCurrentMagic()+"/"+c1.getMaxMagic()+"||"+ c2.getName() + ":" + c2.getCurrentLife()+"/"+c2.getMaxLife()+ " Stamina: "+c2.getCurrentStamina()+ "/"+ c2.getMaxStamina());
            //Wizard always checks if he needs to heal and has enough magic for it
            if(c1.getCurrentLife() < (c1.getCurrentLife()*0.4) && c1.getCurrentMagic() > 7){
                placeHolder = c1.castHeal();
                System.out.println(c1.getName() + " casts Heal,\n" + c1.getName() + " restores " + placeHolder + " points of Life");
                c1.heal(placeHolder);
            }else if(c1.getCurrentMagic() > 99){ //If wizard doesn't need to or can't cast heal, then casts lightning bolt
                placeHolder = c1.castLightningBolt();
                System.out.println(c1.getName() + " casts Lightning Bolt,\n" + c1.getName() + " zapps for " + placeHolder + " points of damage");
                c2.wound(placeHolder);
            }else{//If wizard can't cast both then wizards either uses armor or weapon
                if(wiUseArmorCD == i){
                    placeHolder = c1.useArmor();
                    System.out.println(c1.getName() + " uses armor instead/n" + c1.getName() + " uses armor and heals for " + placeHolder + " points of Life");
                    c2.wound(placeHolder);
                }
                else{ 
                    placeHolder = c1.useWeapon();
                    System.out.println(c1.getName() + " uses weapon instead/n" + c1.getName() + " clobbers " + c2.getName() + " for " + placeHolder + " damage with his staff");
                    c2.wound(placeHolder);
                }
            }
        }
    }
}
