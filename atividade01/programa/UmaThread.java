/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

class UmaThread extends Thread {

        private int delay;
        
        MultiThread a;

        public UmaThread(String identificacao, MultiThread x, int delay) {

               super(identificacao);
               a = x;
               
               this.delay = delay;

        }

        public void run() {

               String identificacao = this.getName();

               try {

                        sleep(delay);
                        a.compartilhada = a.compartilhada + 2;
               }

               catch(InterruptedException e) {

                       System.out.println("Thread:  "+ identificacao + " foi interrompida"); 

               }

               System.out.println(">>" + identificacao + " " + delay);
               System.out.println("Variavel = " + a.compartilhada + " ");
               

        }

}

