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
import java.util.ArrayList;

public class Programa {
    
        ArrayList buffer;
        
        public Semaphore mutex;
        public Semaphore full;
        public Semaphore empty;
        public static final int BUFFER_SIZE = 8;
    
        public Programa () {
            buffer = new ArrayList(); 
   
        }
    
        public static void main(String[] args) {
               Programa t = new Programa();
               t.run();
        } 
        
        public void run() {
            mutex = new Semaphore(1);
            empty = new Semaphore(BUFFER_SIZE);
            full = new Semaphore();
            Consumer c = new Consumer(this, mutex, empty, full);
            Producer p = new Producer(this, mutex, empty, full);
            c.start();
            p.start();
                     
            Consumer c1 = new Consumer(this, mutex, empty, full);
            Producer p1 = new Producer(this, mutex, empty, full);
            c1.start();
            p1.start();
        }
    
    
}

