package com.empanda.hackerrank.triplets;

public class Main {
    public static void main(String[] args) {
        Triplet t = new Triplet(1, 1, 1);
        t.max = 1000;
        while (!t.isSumOverMax()) {
            t.next();
            if (t.hasReachedMax())
                t.print();
        }
    }

    public static class Triplet{
       public int a;
       public int b;
       public int c;
       public int max;

       public Triplet(int a, int b, int c){
           this.a = a;
           this.b = b;
           this.c = c;
       }

       public void next(){
           a = 1;
           b = 1;
           c++;
           if (isValid()) return;
           while (b < c ) {
               while (a < b ) {
                   a++;
                   if (isValid()) return;
                   if (isSumOverMax()) break;
               }
               b++;
               a = 1;
               if (isValid()) return;
               if (isSumOverMax()) break;
           }
       }

       public boolean isValid(){
        int    tmpA = a * a,
               tmpB = b * b,
               tmpC = c * c;
       return tmpA + tmpB == tmpC;
       }

       public void print(){
           System.out.println("La posta es : "+a+"^2 + "+b+"^2 ="+c+"^2");
       }

       public boolean isSumOverMax(){
           return a+b+c > max;
       }

        public boolean hasReachedMax() {
            return a+b+c == max;
        }
    }
}
