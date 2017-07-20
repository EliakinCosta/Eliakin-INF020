/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

public class MultiThread  {

        MultiThread () {
            compartilhada = 1;
        }
    
        int compartilhada;
    
        public static void main(String[] args) {
               MultiThread t = new MultiThread();
               t.run();
        }

        public void run() {
               UmaThread t1,t2,t3;
               
               t1 = new UmaThread("Primeira", this, (int)(Math.random()*8000));

               t2 = new UmaThread("Segunda", this, (int)(Math.random()*8000));

               t3 = new UmaThread("Terceira", this, (int)(Math.random()*8000));
               
               t1.start();

               t2.start();

               t3.start();
        }
}

