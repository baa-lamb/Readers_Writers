package org.lab10;

/**
 * Created by Alena on 21.05.2017.
 */
public class WritersReaders {

    private SynchroStack list;

    public WritersReaders(){
        list = new SynchroStack();
    }

    public void goReadWrite(){
        int f = 0; int val = 0;
       /* for(int i = 0; i < 10; i++){
            list.push(val);
            val++;
        }
        System.out.println(list);
        list.pop();
        list.pop();
        System.out.println(list);*/
        for(int i = 0; i < 200; i++){
            list.push(i);
        }
        for(int i = 0; i < 100; i++){
            list.pop();
        }
        for(int i = 0; i < 300; i++){
            System.out.println(list);
        }
    }


}