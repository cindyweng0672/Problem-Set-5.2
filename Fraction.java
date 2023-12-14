
/**
 * Write a description of class Fraction here.
 *
 * @Cindy Weng
 * @version 1.0
 */
public class Fraction {
   //instance variables
   private int numerator;
   private int denominator;
   
   //constructor
   /**
    * default constructor
    * the default value a random fraction with numerator and denominator less than 20
    */
   public Fraction(){
       numerator=(int)(20*Math.random())+1;
       denominator=(int)(20*Math.random())+1;
    }
   
    /**
     * A contructor taking the numerator and the denominator as seperate integers
     * @param n the numerator of the Fraction object 
     * @param d the denominator of the Fraction object
     * Postcondition: the denominator cannot be 0
     */
    public Fraction(int n, int d){
       is0(d);
       if(d<0&&n>0){
           d=Math.abs(d);
           n=-n;
       }
       numerator=n;
       denominator=d;
   }
   
   /**
    * A contructor taking the fraction as a string with the numerator and the denominator sepreated by a "/"
    * @param fraction a string that takes a fraction in the format of a string with the numerator and the denominator sepreated by a "/"
    * @throws number format exception if the string is entered in a wrong format 
    * Postcondition: the denominator cannot be 0
    */
   public Fraction(String fraction){
       if(!fraction.contains("/")){
           throw new NumberFormatException("wrong format, has to be num1/num2");
       }else{
           String[] temp=fraction.split("/");
           if(temp.length<2){

           }
           numerator=Integer.parseInt(temp[0]);
           denominator=Integer.parseInt(temp[1]);
           is0(denominator);
       }
   }
   
   /**
    * A constructor that copy a Fraction object's values
    * @param f a Fraction object that is copied
    */
   public Fraction(Fraction f){
       numerator=f.numerator;
       denominator=f.denominator;
   }
   
   //behaviour methods
   //accessor 
   /**
    * get the numerator of a Fraction objct 
    * @return return the numerator of the Fraction
    */
   public int getNum(){
       return numerator;
   }
   
   /**
    * get the denominator of a Fraction object 
    * @return return the denominator of the Fraction
    */
   public int getDenom(){
       return denominator;
   }
   
   /**
    * put the numerator and the denominator into a string in the forat of a fraction
    * @return return the Fraction as a String with numerator and denominator written in the normal form
    */
   public String toString(){
       return numerator+"/"+denominator;
   }
   
   /**
    * turn the Fraction into a decimal number
    * @return return the fraction in a decimal 
    */
   public double toDouble(){
       return (double)numerator/denominator;
   }
   
   /**
    * reduce the fraction to the lowest term 
    */
   public void reduce(){
       int gcf=GCF(numerator, denominator);
       numerator/=gcf;
       denominator/=gcf;
   }
   
   /**
    * change the numerator outside the class
    * @param the new numerator 
    */
   public void setNum(int n){
       numerator=n;
   }
   
   
   /**
    * change the denominator outside the class
    * @param the new denominator 
    */
   public void setDenom(int d){
       denominator=d;
   }
   
   //operations 
   /**
    * multiply two fractions together 
    * @param n1 the multiplicand 
    * @param n2 the multiplier 
    * @return return the product 
    */
   public static Fraction multiply(Fraction n1, Fraction n2){
       return new Fraction(n1.getNum()*n2.getNum(), n1.getDenom()*n2.getDenom());
   }
   
   /**
    * divide two fractions
    * @param n1 the dividend 
    * @param n2 the divisor 
    * @return return the quotient 
    */
   public static Fraction divide(Fraction n1, Fraction n2){
       return new Fraction(n1.getNum()/n2.getNum(), n1.getDenom()/n2.getDenom());
   }
   
   /**
    * add two fractions together 
    * @param n1 the first fraction to be added 
    * @param n2 the second fraction to be added
    * @return return the sum
    */
   public static Fraction add(Fraction n1, Fraction n2){
       int denom=n1.getDenom()*n2.getDenom();
       
       int num1=n1.getNum()*n2.getDenom();
       int num2=n2.getNum()*n1.getDenom();
       
       int num=num1+num2;
       
       Fraction f=new Fraction(num, denom);
       f.reduce();
       
       return f;
   }
   
   /**
    * add one fraction onto another 
    * @param n the fraction to be added onto the instance calling the method
    * @return return the sum
    */
   public Fraction add(Fraction n){
       this.denominator=this.getDenom()*n.getDenom();
       
       int num1=this.getNum()*n.getDenom();
       int num2=n.getNum()*this.getDenom();
       
       this.numerator=num1+num2;
       
       this.reduce();
       
       return this;
   }
   
   /**
    * subtract two fractions 
    * @param n1 the minuend 
    * @param n2 the subtrahend 
    * @return return the difference 
    */
   public static Fraction subtraction(Fraction n1, Fraction n2){
       int denom=n1.getDenom()*n2.getDenom();
       
       int num1=n1.getNum()*n2.getDenom();
       int num2=n2.getNum()*n1.getDenom();
       
       int num=num1-num2;
       
       Fraction f=new Fraction(num, denom);
       f.reduce();
       
       return f;
   }
   
   //helper methods 
   /**
    * check if the number is 0
    * @param n the number to be checked 
    * @throws an exception if the number is 0 
    */
   private void is0(int n){
       if(n==0){
            throw new ArithmeticException("the denominator cannot be 0");
       }
   }
   
   /** 
    * find the GCF of two numbers 
    * @param n the first number in the operation 
    * @param d the second number in the operation 
    * @return return the GCF
    */
   private static int GCF(int n, int d){
       n=Math.abs(n);
       d=Math.abs(d);
       int max=Math.max(n, d);
       int min=Math.min(n, d);  
       while(max!=min){
           max-=min;
           if(min>max){
               int temp=min;
               min=max;
               max=temp;
           }
       }
       return max;
   }
   
   /**
    * Returns true if Fraction f is identical to this fraction. It does not take into
    * account if two fractions are equal in value, just if the numerators and
    * denominators are the same.
    *   
    * @param f      The fraction to compare with
    * @return    A boolean value that represents whether f was equal to this Fraction
    */
   public boolean equals(Fraction f){
       if(f.getNum()==this.getNum()&&f.getDenom()==this.getDenom()){
           return true;
       }
       return false;
   }
   
}
