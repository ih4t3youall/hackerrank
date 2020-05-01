package com.empanda.hackerrank.triplets;

public class Main {
    public static void main(String[] args) {
        Triplet t = new Triplet(1, 1, 1);
        while (!t.isOverMaxValue()) {
           if (t.findNextTriplet()){
               if (t.hasReachedMaxValue())
                   t.print();
           }
           t.c++;
           t.b = 1;
        }
    }

    public static class Triplet{
       public int a;
       public int b;
       public int c;
       final int maxNumber = 1000;
       public Triplet(int a, int b, int c){
           this.a = a;
           this.b = b;
           this.c = c;
       }
       public boolean findNextTriplet(){
           if (isValid()) return true;
           while (b < c ) {
               while (a < b ) {
                   a++;
                   if (isValid()) return true;
                   if (isOverMaxValue()) break;
               }
               b++;
               a = 1;
               if (isValid()) return true;
               if (isOverMaxValue()) break;
           }
           return false;
       }

       public boolean isValid(){
        int    tmpA = a * a,
               tmpB = b * b,
               tmpC = c * c;
       return tmpA + tmpB == tmpC;
       }

       public int sum(){
          return a+ b + c;
       }

       public void print(){
           System.out.println("La posta es : "+a+"^2 + "+b+"^2 ="+c+"^2");
       }

       public boolean isOverMaxValue(){
           return a+b+c > maxNumber;
       }

        public boolean hasReachedMaxValue() {
            return a+b+c == maxNumber;
        }
    }
}
