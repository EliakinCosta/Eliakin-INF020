/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Producer extends Thread {
    
        Programa a;
        
        public Semaphore mutex;
        public Semaphore empty;
        public Semaphore full;
        
        public static int contador = 1;

        public Producer(Programa x, Semaphore m, Semaphore e, Semaphore f) {
               a = x;
               mutex = m;
               empty = e;
               full = f;
        }

        public void run() {
            while (true) {
                empty.down();  // decrementa o contador de itens livres no buffer
                mutex.down();  // entra na região crítica
                contador += 1; 
                a.buffer.add(contador);                
                mutex.up();    // sai da região crítica
                full.up();     // incrementa o contador de itens preenchidos no buffer
                System.out.println("produtor: producing item "+contador);
            }
        }    
}
