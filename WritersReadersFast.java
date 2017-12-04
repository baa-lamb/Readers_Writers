package org.lab10;

/**
 * Created by Alena on 21.05.2017.
 */
public class WritersReadersFast {

    private SynchroStackFast list;
    private Treads t;

    public WritersReadersFast(int tNum){
        list = new SynchroStackFast();
    }

    public class Treads extends Thread {
        private Treads t;
        private int flag = 0;
        private int i = 0;

        public Treads(int f, int I){
            flag = f;
            i = I;
        }

        public void run(){
           /* if(flag == 1)
                list.push(i);
            if(flag == 0)
                list.pop();
            else
                System.out.println(list);*/
            if(flag == 1) {
                for(int i = 0; i < 200; i++){
                    list.push(i);
                }
            }
            if(flag == 0) {
                for(int i = 0; i < 100; i++){
                    list.pop();
                }
            }
            else {
                for(int i = 0; i < 300; i++){
                    System.out.println(list);
                }
            }
        }
    }

    public void goReadWriteFast(int NumberOfThreads) {
        int f = 0; int val = 0;
        /*for(int i = 0; i < 10; i++) {
            if(i < NumberOfThreads - 2)
                f = 1;
            else if(i == NumberOfThreads - 1)
                f = -1;
            else
                f = 0;
            t = new Treads(f, val);
            t.start();
            val++;
        }*/
       /* for(int i = 0; i < 50; i++){
            t = new Treads(1, i);
            t.start();
        }
        for(int i = 0; i < 20; i++){
            t = new Treads(0, i);
            t.start();
        }
        for(int i = 0; i < 30; i++){
            t = new Treads(-1, i);
            t.start();
        }*/
        t = new Treads(1, 1);
        t.start();
        t = new Treads(0, 1);
        t.start();
        t = new Treads(-1, 1);
        t.start();
    }
}
