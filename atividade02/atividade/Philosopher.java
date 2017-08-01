package atividade;

import java.util.Random;
import atividade.Main;

public class Philosopher extends Thread
{

    public Philosopher (String nome, int ID)
    {
        super(nome);
        this.ID = ID;
    }
    
    public void hungry()
    {
        Main.states[this.ID] = Main.HUNGRY;
        System.out.println("O Filósofo " + getName() + " está FAMINTO!");
    }

    public void eat()
    {        
        Main.states[this.ID] = Main.EATING; 
        System.out.println("O Filósofo " + getName() + " está COMENDO!");
        try
        {
            Thread.sleep(1000L);
        }
        catch (InterruptedException ex)
        {         
            System.out.println("ERROR>" + ex.getMessage());
        }
    }

    public void think()
    {
        Main.states[this.ID] = 0;
        System.out.println("O Filósofo " + getName() + " está PENSANDO!");

        try
        {
            Thread.sleep(1000L);
        }
        catch (InterruptedException ex)
        {        
            System.out.println("ERROR>" + ex.getMessage());
        }
    }

    public void putFork()
    {
        Main.mutex.down();

        this.think();

        Main.philosophers.get(Main.left(this.ID)).tryToTakeFork();
        Main.philosophers.get(Main.right(this.ID)).tryToTakeFork();        

        Main.mutex.up();
    }

    // Método para o filósofo pegar um garfo na mesa
    public void takeFork()
    {
        // Decrementa o semáforo mutex principal da classe, isso permite
        // informar que o atual método está operando na mesa dos filósofos
        Main.mutex.down();

        // Deixa o filósofo faminto por determinado tempo
        this.hungry();

        // Após o filósofo o período de fome, ele vai verificar com seus
        // vizinhos se ele pode pegar os garfos
        this.tryToTakeFork();

        // Após operar, volta o semáforo mutex para o estado normal
        // indicando que já realizou todos procedimentos na mesa
        Main.mutex.up();
        // Decrementa seu semáforo
        Main.semaphores[this.ID].down();
    }

    public void tryToTakeFork()
    {      
        if (Main.states[this.ID] == Main.HUNGRY &&
    		Main.states[Main.left(this.ID)] != Main.EATING && 
			Main.states[Main.left(this.ID)] != Main.EATING)
        {
            // Então este filósofo pode comer
            this.eat();
            // E incrementa o seu semáforo
            Main.semaphores[this.ID].up();
        }

    }

    // Método de execução da classe, onde o ambiente do filósofo será rodado
    @Override
    public void run ()
    {

        try
        {
            this.think();
            do
            {
                this.takeFork();
                Thread.sleep(1000L);
                this.putFork();
            }
            while (true);
        }
        catch (InterruptedException ex)
        {
            System.out.println("ERROR>" + ex.getMessage());        
            return;
        }
    }
    
    private int ID;      
}