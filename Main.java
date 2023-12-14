
/**
 * Main - Driver class
 *
 * @Cindy Weng 
 * @Dec. 6
 */

import java.util.*;
public class Main{
    private static int wins=0;
    private static int total=0;
    
    public static void Main(){
        findPI();
        fractionQuiz();
        /*Fraction f1=new Fraction("10/19");
        Fraction f2=new Fraction("14/15");
        System.out.println(Fraction.subtraction(f1, f2));*/
    }
    
    /**
     * find the closest fraction to PI
     */
    public static void findPI(){
        Fraction MILU = new Fraction( 355, 113 );
        
        final double EPSILON = Math.abs( Math.PI - MILU.toDouble() );

        Fraction newFraction=new Fraction();
        while(Math.abs(newFraction.toDouble()-Math.PI)>=EPSILON){
            if(newFraction.toDouble()-Math.PI>0){
                newFraction.setDenom(newFraction.getDenom()+1);
            }else if(newFraction.toDouble()-Math.PI<0){
                newFraction.setNum(newFraction.getNum()+1);
            }
        }
        
        System.out.println(newFraction.toString());
    }
    
    /**
     * give fraction operation quizzes 
     */
    public static void fractionQuiz(){
        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
        total=0; 
        wins=0;
        generateQestions();
    }
    
    /**
     * generate fraction questions
     * check the answer 
     * if "quit" entered, end the quiz
     */
    public static void generateQestions(){
        int operation=(int)(Math.random()*4);
        total++;
        Scanner sc=new Scanner(System.in);
        
        Fraction f1=new Fraction();
        Fraction f2=new Fraction();
        
        if(operation==0){
            System.out.println(f1.toString()+" + "+f2.toString()+" = "); 
        }else if(operation==1){
            System.out.println(f1.toString()+" - "+f2.toString()+" = "); 
        }else if(operation==2){
            System.out.println(f1.toString()+" * "+f2.toString()+" = "); 
        }else if(operation==3){
            System.out.println(f1.toString()+" / "+f2.toString()+" = "); 
        }
        
        String input=sc.nextLine();
        
        if(input.equals("quit")){
            Fraction ratio=new Fraction(wins, total-wins);
            int percent=(int)(ratio.toDouble()*100);
            System.out.println("Your wins/loss ratio was "+ratio+", "+percent+"%. ");
        }else{
            Fraction userAns=new Fraction(input);
            Fraction ans=new Fraction("1/1");
            
            if(operation==0){
                ans=Fraction.add(f1,f2);
            }else if(operation==1){
                ans=Fraction.subtraction(f1,f2);
            }else if(operation==2){
                ans=Fraction.multiply(f1,f2);
            }else if(operation==3){
                ans=Fraction.divide(f1,f2);
            }
            
            if(userAns.equals(ans)){
                System.out.println("Correct!");
                wins++;
            }else{
                System.out.println("Wrong! the answer was "+ans);
            }
            
            generateQestions();
        }
    }
    
    
}
