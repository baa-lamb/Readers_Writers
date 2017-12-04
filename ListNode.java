package org.lab10;

import java.util.Comparator;

/**
 * Created by Alena on 21.05.2017.
 */
public class ListNode{
    private ListNode Prev = null;
    private ListNode Next = null;
    private int value = 0;

    public ListNode(int val, ListNode p, ListNode n){
        value = val;
        Prev = p;
        Next = n;
    }

    public int getValue(){return value;}

    public ListNode getPrev(){ return Prev;}

    public ListNode getNext(){ return Next;}

    public void setPrev (ListNode p) { Prev = p;}

    public void setNext (ListNode n) { Next = n;}

}
