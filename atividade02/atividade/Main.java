package atividade;

import java.util.ArrayList;


public class Main {		

	public static int left(int index) 
	{
		return (index+N-1)%N;
	}
	
	public static int right(int index) 
	{
		return (index+1)%N;
	}
	
	public static void main(String[] args) {
		
		// Inicializa todos estados para zero
        for (int i = 0; i < states.length; i++)
        {
            states[i] = 0;
        }

        // Inicializa todos semáforos
        semaphores[0] = new Semaphore(0);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
        semaphores[3] = new Semaphore(0);
        semaphores[4] = new Semaphore(0);

		// Inicializa todos filósofos	        
		philosophers.add(new Philosopher("Platao", 0));
		philosophers.add(new Philosopher("Socrates", 1));	
		philosophers.add(new Philosopher("Aristoteles", 2));	
		philosophers.add(new Philosopher("Tales", 3));	
		philosophers.add(new Philosopher("Sofocles", 4));	
		
		for(Philosopher philosopher : philosophers) 
			philosopher.start();
	}
	
	public static ArrayList<Philosopher> philosophers = new ArrayList<>();
	public static Semaphore mutex = new Semaphore(1);

    // O vetor semáforos são normais e existe um semáforo para cada filósofo
    // que será criado, esses semafóros não recebem valores de inicialização
    // portanto iniciando o contador em 0
    public static Semaphore semaphores[] = new Semaphore[5];

    // Define um vetor para o estado de cada um dos filósofos presentes
    // na aplicação
    public static int states[] = new int[5];

    // Cria 5 filósofos em um vetor para a aplicação
	public static final int N = 5; // número de filósofos	
	public static final int THINKING = 0; //o filósofo está pensando
	public static final int HUNGRY = 1; // o filósofo está tentando pegar garfos
	public static final int EATING = 2; // o filósofo está comendo
}
