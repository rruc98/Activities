package RPG;



public class TestCharacter {
    public static void main(String [] args){
        Character c1 = new Character ("Joe",10,10,10);
        Character c2 = new Character("Bob",5,5,5);
        int damage;
        String Winner = "";
        for(int i = 1; i < 4;i++){
            System.out.println("Round " + i + "!");
            System.out.println(c1.getName() + " attacks " + c2.getName() + " for " + (damage = c1.attack()) + " damage | " + c2.getName() + "'s Current Life now is " + (c2.getCurrentLife()-damage));
            c2.wound(damage);
            if (c2.getCurrentLife()<1){
                Winner = c1.getName();
                break;
            }
            System.out.println(c2.getName() + " attacks " + c1.getName() + " for " + (damage = c2.attack())+ " damage | " + c1.getName() + "'s Current Life now is " + (c1.getCurrentLife()-damage));
            c1.wound(damage);
            if (c1.getCurrentLife()<1){
                Winner = c1.getName();
                break;
            }     
        }
            if(Winner.matches("Joe") || Winner.matches("Bob"))
                System.out.println(Winner + " wins the match!");
            else if(c1.getCurrentLife() > c2.getCurrentLife())
                System.out.println(c1.getName() + " wins the match!");
            else if(c1.getCurrentLife() == c2.getCurrentLife())
                System.out.println("It's a draw!");
            else
                System.out.println(c2.getName() + " wins the match!");
    }
}
/*
 * import java.util.Scanner;



public class ShowStudent {
    public static void main(String [] args){
        Student totoy = new Student("01-0978-644",3,12);
        totoy.computeGradePointAverage();
        char remark;
        System.out.println("Student #" + totoy.getIDNumber() + "\nCredit Hours Earned: " + totoy.getCreditHours() 
                            + "\nPoints: " + totoy.getPoints() + "\nGrade Point Average: " + totoy.getGradePointAverage()
                            + "\nRemark: " + totoy.getRemark());
    }
}
* 
 */