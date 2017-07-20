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
	public Semaphore mutex;
	public Semaphore empty;
	public Semaphore full;

	Programa a;

	public Consumer(Programa x, Semaphore m, Semaphore e, Semaphore f) {
		a = x;
		mutex = m;
		empty = e;
		full = f;
	}

	public void run() {

		while (true) {
			full.down(); // decrementa o contador de itens preenchidos no buffer
			mutex.down(); // entra na área crítica
			int item;
			item = (Integer) a.buffer.get(0);
			a.buffer.remove(0);
			mutex.up(); // sai da área crítica
			System.out.println("consumer: consuming item" + item);
			empty.up(); // incrementa o contador de itens livres no buffer
		}

	}
}
