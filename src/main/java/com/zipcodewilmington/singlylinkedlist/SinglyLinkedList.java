package com.zipcodewilmington.singlylinkedlist;

import com.sun.source.tree.BreakTree;

import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {
    private static int counter;
    private Node head;

    class Node<T extends Comparable<T>> implements Comparator<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }

    }

    //counter Handling
    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    public void add(T data) {
        //Initialize Node only when first Node
        if (head == null) {
            head = new Node(data);
        }
        Node temp = new Node(data);
        Node current = head;

        if (current != null) {
            //Browse through elements to reach the end
            while (current.getNext() != null) {
                current = current.getNext();
            }
            //add the last node
            current.setNext(temp);
        }
        //Increment number of elements variable
        incrementCounter();
    }

    public void add(T data, int index) {
        //if no Node in linkedList, create and make new as head
        if (head == null) {
            head = new Node(data);
        }
        Node tempNode = new Node(data);
        Node current = head;

        //if first node present, loop through the list will getNext == null and i < index
        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
            //set the Node's next node reference to current node's next reference
            tempNode.setNext(current.getNext());

            //set current Node's next to new node
            current.setNext(tempNode);

        }
        //Increment counter, which will help us to get size
        incrementCounter();
    }

    public void remove(int index) {
        Node current;
        if (head != null) {
            current = head;
            for (int i = 0; i <= index; i++) {
                if (current.getNext() != null) {
                    current = current.getNext();
                }

            }
            current.setNext(current.getNext());

        }
        decrementCounter();
    }

    public int size() {
        return getCounter();
    }

    public Boolean contains(T o) {
        Node current;
        if (head != null) {
            current = head;
            for (int i = 0; i <= size() && current.getNext() != null; i++) {
                if (current.getNext() != null) {
                    current = current.getNext();
                }

            }
            current.setNext(current.getNext());

        }
        return false;
    }
    public int find(T o){
        Node current;
        if (head != null) {
            current = head;
            for (int i = 0; i <= size() && current.getNext() != null; i++) {
                if (current.getNext() != null) {
                    current = current.getNext();
                }

            }
            current.setNext(current.getNext());

        }

        return 0;
    }

    public T get(int index){
        if(head == null){
            return null;
        }
        Node current = head;
        if(head != null){
            current = head;
            for (int i = 0; i <= index ; i++) {
                if(current.getNext() != null){
                    current = current.getNext();
                }

            }
            T obj = (T) current.getData();
            return obj;
        }
        return null;
    }
    public SinglyLinkedList copy(){
        SinglyLinkedList list = new SinglyLinkedList();
        T temp = null;
        Node current = head.getNext();

        if(current != null){
            while (current.getNext() != null){
                temp = (T) current.getData();
                list.add(temp);
                current = current.getNext();
            }
            list.add(current.getData());
        }
        return list;
    }
    public void sort(SinglyLinkedList list){
        int currentSize = list.size();
        for (int i = 0; i < currentSize-1; i++) {
            T currentI = get(i);
            for (int j = 0; j < currentSize; j++) {
                T currentJ = get(j);
                if(currentI.compareTo(currentJ) > 0){
                    swap(currentI,currentJ);
                    currentI = currentJ;
                }

            }

        }
    }

    private void swap(T currentI, T currentJ) {
        Node<T> temp = head;
        Node<T> tempNodePrev = null;
        Node<T> tempNodeNext = null;
        Node<T> tempNodeNextNext = null;

        tempNodePrev = temp;
        Boolean swapped = false;
        while (temp != null && !swapped){
            if(temp.getData().equals(currentI)){
                tempNodeNext = temp.getNext();
                tempNodeNextNext = tempNodeNext.getNext();
                tempNodePrev.setNext(tempNodeNext);
                tempNodeNext.setNext(temp);
                temp.setNext(tempNodeNextNext);

                swapped = true;
            }else{
                tempNodePrev = temp;
                temp = temp.getNext();

            }
        }

    }
    public SinglyLinkedList slice(int start, int end){
        SinglyLinkedList sliceList = new SinglyLinkedList();
        T temp = null;
        Node current = head.getNext();

        if(current != null){
            for (int i = 0; i < end; i++) {
                if(i >= start){
                    temp = (T) current.getData();
                    sliceList.add(temp);
                    current = current.getNext();
                }else{
                    current = current.getNext();
                }

            }
        }return sliceList;
    }
}