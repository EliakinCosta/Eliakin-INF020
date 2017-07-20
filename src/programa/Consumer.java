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
public class Consumer extends Thread {

	public int id;
	public int consumoTotal;
	public Semaphore mutex;
	public Semaphore empty;
	public Semaphore full;

	Programa a;

	public Consumer(int id, int consumoTotal, Programa x, Semaphore m, Semaphore e, Semaphore f) {
		this.id = id;
		this.consumoTotal = consumoTotal;
		a = x;
		mutex = m;
		empty = e;
		full = f;
	}

	public void run() {
		for (int i = 0; i < consumoTotal; i++) {
			full.down();
			mutex.down();
			int item;
			item = (Integer) a.buffer.get(0);
			a.buffer.remove(0);
			System.out.println("consumer:" + id + " consuming item " + item);			
			mutex.up();
			empty.up();
		}
	}
}
	