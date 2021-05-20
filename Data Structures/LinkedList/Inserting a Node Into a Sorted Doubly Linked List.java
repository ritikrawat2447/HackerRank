import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        // DoublyLinkedListNode n = head;
        // DoublyLinkedListNode ll = new DoublyLinkedListNode(data);
        // if ( head == null){
        //     head = ll;
        // }
        // if ( data == 1 ){
        //     ll.next = head;
        //     head.prev = ll;
        //     head = ll;
        // }
        // else{
        //     while( n.data < data-1 && n.next != null ){
        //         n = n.next;
        //     }
        //     if ( data == n.next.data){ 
        //         return head;
        //     }else{
        //         DoublyLinkedListNode n1 = n.next;
        //         n.next = ll;
        //         ll.next = n1;
        //         n1.prev = ll;
        //     }
        // }
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode previous = null;
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if ( head == null ){
            return node;
        } 
        
        if( data < current.data ){
            node.next = current;
            node.prev = null;
            current.prev = node;
            return node;
        }
        while ( current != null && data > current.data){
            previous = current;
            current = current.next;
        }
        if ( current == null ){
            node.prev = previous ;
            node.next = null;
            previous.next = node;
            return head;
        }else{
            node.prev = previous;
            node.next = previous.next;
            previous.next = node;
            node.next.prev = node;
        }    
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);