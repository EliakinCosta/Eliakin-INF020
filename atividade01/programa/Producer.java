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
	
	public int id;
	public int producaoTotal;

	public static int contador = 0;

	public Producer(int id, int producaoTotal, Programa x, Semaphore m, Semaphore e, Semaphore f) {
		this.id = id;
		this.producaoTotal = producaoTotal;
		a = x;
		mutex = m;
		empty = e;
		full = f;
	}

	public void run() {
		for (int i = 0; i < producaoTotal; i++) {
			empty.down();
			mutex.down();
			contador += 1;
			a.buffer.add(contador);
			System.out.println("produtor:" + id + " producing item " + contador);
			mutex.up();
			full.up();
        }					
	}
}
