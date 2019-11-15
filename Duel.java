package RPG;


public class Duel {
    static Dice d = new Dice();
    static String winner;
    public static void main(String [] args){
        Wizard c1 = new Wizard ("The Wizard Bob",d.roll(),d.roll(),d.roll());
        Wolf c2 = new Wolf("Howling Dawn",d.roll(),d.roll(),d.roll());
        int placeHolder;//Holds value for text
        int decision;
        int wiHealCD, wiLightCD, wiUseArmorCD,woUseArmorCD;
        //Dev Tool System.out.println(c1.getCurrentLife()*0.4 + " " + c1.getCurrentMagic());
        double wizardLowHP = c1.getCurrentLife()*0.4;
        for(int i = 1;;i++){
            System.out.println("Round " + i + "! ||" + c1.getName() + ":" + c1.getCurrentLife() +"/"+c1.getMaxLife()+ " Magic: "+c1.getCurrentMagic()+"/"+c1.getMaxMagic()+"||"+ c2.getName() + ":" + c2.getCurrentLife()+"/"+c2.getMaxLife()+ " Stamina: "+c2.getCurrentStamina()+ "/"+ c2.getMaxStamina());
            //Wizard decides which skill to use; Attack, Lightning Bolt or Heal
            decision = d.roll();
            //Cast heal if HP <= 40% and MP is atleast 8 points
            if(c1.getCurrentLife() < wizardLowHP  && c1.getCurrentMagic() > 7){
                int heal = c1.castHeal();
                c1.heal(heal);
                System.out.println(c1.getName() + " casted heal.\n" + c1.getName() + " restores " + heal + " health.\n" + c1.getName() + "'s Health is now " + c1.getCurrentLife());
            }//If dice rolled anything between 0 and 4 Wizard will cast Lightning Bolt
            else if(decision >0 && decision <4 && c1.getCurrentMagic()>99){
                placeHolder = c1.castLightningBolt();
                System.out.println(c1.getName() + " casts Lightning Bolt! \nDamages " + c2.getName() + " for " + placeHolder + " damage.");
                c2.wound(placeHolder);
            }//Otherwise attacks normally
            else{
                decision = d.roll();
                if (decision >0 && decision < 4){
                    placeHolder = c1.useWeapon();
                    System.out.println(c1.getName() + " uses weapon and attacks " + c2.getName() + " for " + placeHolder + " damage.");
                    c2.wound(placeHolder);
                }else{
                    placeHolder = c1.useArmor();
                    c1.heal(placeHolder);
                    System.out.println();
                }    
            }if(c2.getCurrentLife() <= 0){
                winner = c1.getName();
                System.out.println();
                break;
            }/*
             * 
             * Wolf's Turn
             * 
             */
            decision = d.roll();
            //Wolf decides which skill to use; Attack, Slash or Maim
            if(decision >0 && decision <4) {
                //Checks if Stamina is atleast 3 points
                if(c2.getCurrentStamina() >= 10){
                    placeHolder = c2.slash();
                    System.out.println(c2.getName() + " slashes " + c1.getName() + " for " + placeHolder + " damage");
                    c1.wound(placeHolder);
                    placeHolder = c2.lifeSteal(placeHolder);
                    System.out.println(c2.getName() + "'s attack heals for " + placeHolder + " health");
                    c2.heal(placeHolder);
                }else{
                    placeHolder = c2.attack();
                    System.out.println(c2.getName() + " attacks " + c1.getName() + " for " + placeHolder + " damage");
                    c1.wound(placeHolder);
                    placeHolder = c2.lifeSteal(placeHolder);
                    System.out.println(c2.getName() + "'s attack heals for " + placeHolder + " health");
                    c2.heal(placeHolder);
                }
            }//If decision is 4 then use ultimate
            else if(decision == 4) {
                //Checks if Stamina is atleast 15 points
                if(c2.getCurrentStamina() >= 30){
                    placeHolder = c2.maim();
                    System.out.println(c2.getName() + " maims " + c1.getName() + " for " + placeHolder + " damage");
                    c1.wound(placeHolder);
                    placeHolder = c2.lifeSteal(placeHolder);
                    System.out.println(c2.getName() + "'s attack heals for " + placeHolder + " health");
                    c2.heal(placeHolder);
                }else{
                    placeHolder = c2.attack();
                    System.out.println(c2.getName() + " attacks " + c1.getName() + " for " + placeHolder + " damage");
                    c1.wound(placeHolder);
                    placeHolder = c2.lifeSteal(placeHolder);
                    System.out.println(c2.getName() + "'s attack heals for " + placeHolder + " health");
                    c2.heal(placeHolder);
                }
            }//Else just regular attack
            else{
                placeHolder = c2.attack();
                System.out.println(c2.getName() + " attacks " + c1.getName() + " for " + placeHolder + " damage");
                c1.wound(placeHolder);
                placeHolder = c2.lifeSteal(placeHolder);
                System.out.println(c2.getName() + "'s attack heals for " + placeHolder + " health");
                c2.heal(placeHolder);
            }if(c1.getCurrentLife() <= 0){
                winner = c2.getName();
                System.out.println();
                break;
            }System.out.println(c2.getName() + " replenishes 5 stamina.\n");
            c2.replenishStamina(5);
        }System.out.println("The winner is " + winner +"!");
        
    }
    
//    private void check(){
//        
//    }
}