package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    String node1;
    String node2;
    String node3;
    String node4;

    @Before
    public void startup(){
        node1 = "Node1";
        node2 = "Node2";
        node3 = "Node3";
        node4 = "Node4";
    }

    @Test
    public void addTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        Assert.assertEquals(node1,singlyLinkedList.get(0));
        Assert.assertEquals(node2,singlyLinkedList.get(1));
        Assert.assertEquals(node3,singlyLinkedList.get(2));
    }

    @Test
    public void add2Test(){
        singlyLinkedList.add(node1);

        singlyLinkedList.add(node2,0);

        Object data = singlyLinkedList.get(0);
        Assert.assertEquals(node2,singlyLinkedList.get(0));
    }
    @Test
    public void removeTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        singlyLinkedList.remove(1);

        Assert.assertEquals(node2,singlyLinkedList.get(1));
    }
    @Test
    public void sizeTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        int actual = singlyLinkedList.size();

        Assert.assertEquals(29,actual);
    }
    @Test
    public void containsTest(){
        String node1 = "Node1";
        String node2 = "Node2";
        String node3 = "Node3";
        String node4 = "Node4";

        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        Boolean actual = singlyLinkedList.contains(node4);

        Assert.assertEquals(false,actual);

    }
    @Test
    public void findTest(){
        String node1 = "Node1";
        String node2 = "Node2";
        String node3 = "Node3";
        String node4 = "Node4";

        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        int actual = singlyLinkedList.find(node3);
        Assert.assertEquals(0,actual);
    }
    @Test
    public void getTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2,0);

        Assert.assertEquals(node2,singlyLinkedList.get(0));
    }
    @Test
    public void getTestNot0(){
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node1,1);

        Assert.assertEquals(node1,singlyLinkedList.get(1));
    }
    @Test
    public void copyTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        SinglyLinkedList actual = singlyLinkedList.copy();

        Assert.assertEquals(singlyLinkedList.get(0),actual.get(0));
        Assert.assertEquals(singlyLinkedList.get(1),actual.get(1));
        Assert.assertEquals(singlyLinkedList.get(2),actual.get(2));
    }
    @Test
    public void sortTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        String node4 = "Node2";
        singlyLinkedList.add(node4);
        singlyLinkedList.add(node3);

        singlyLinkedList.sort(singlyLinkedList);
        SinglyLinkedList expected = new SinglyLinkedList();
        expected.add(node1);
        expected.add(node2);
        expected.add(node3);

        Assert.assertEquals(singlyLinkedList.get(0),expected.get(0));
        Assert.assertEquals(singlyLinkedList.get(1),expected.get(1));
        //Assert.assertEquals(singlyLinkedList.get(2),expected.get(2));
        //Assert.assertEquals(singlyLinkedList.get(3),expected.get(3));
        //Assert.assertEquals(singlyLinkedList.get(4),expected.get(4));

    }
    @Test
    public void sliceTest(){
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);
        String node4 = "Node4";
        singlyLinkedList.add(node4);
        String node5 = "Node5";
        singlyLinkedList.add(node5);

        SinglyLinkedList actual = singlyLinkedList.slice(2,4);

        Assert.assertEquals(singlyLinkedList.get(2),actual.get(0));
        Assert.assertEquals(singlyLinkedList.get(3),actual.get(1));
    }

}
