package org.lab10;

import static java.lang.Thread.sleep;

/**
 * Created by Alena on 21.05.2017.
 */
public class SynchroStackFast {
    private int size = 0;
    private boolean flag = false;
    private ListNode first = null;
    private ListNode last = null;

    public synchronized void push(int value){
        flag = true;
        ListNode l = new ListNode(value, last, null);
        if(size == 0)
            first = l;
        if(size != 0) {
            ListNode lis = l.getPrev();
            lis.setNext(l);
            l.setPrev(lis);
        }
        size++;
        last = l;
        System.out.println("writer is put value");
        flag = false;
    }

    public synchronized int pop() {
        flag = true;
        if(size == 0)
            return -1;
        ListNode l = last;
        if(size > 1)
            last = last.getPrev();
        else
            last = null;
        size--;
        System.out.println("writer is pop value");
        flag = false;
        return l.getValue();
    }

    public String toString() {
        while(flag)
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        StringBuilder str = new StringBuilder();
        if(size != 0)
        {
            ListNode l = first;
            while(l != last){
               // str.append(l.getValue() + " ");
                l = l.getNext();
            }
            //str.append(last.getValue() + " ");
        }
        System.out.print("reader is read stack");
        return str.toString();
    }
}
