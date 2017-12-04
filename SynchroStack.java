package org.lab10;

import static java.lang.Thread.sleep;

/**
 * Created by Alena on 21.05.2017.
 */
public class SynchroStack {
    private int size = 0;
    private ListNode first = null;
    private ListNode last = null;

    public void push(int value){
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
    }

    public int pop() {
        if(size == 0)
            return -1;
        ListNode l = last;
        if(size > 1)
            last = last.getPrev();
        else
            last = null;
        size--;
        return l.getValue();

    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if(size != 0)
        {
            ListNode l = first;
            while(l != last){
                str.append(l.getValue() + " ");
                l = l.getNext();
            }
            str.append(last.getValue() + " ");
        }
        return str.toString();
    }
}
