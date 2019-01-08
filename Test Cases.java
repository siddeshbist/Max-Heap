/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2si4lab05;

/**
 *
 * @author Owner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] x = {5,12,64,1,37,90,91,97};
        Integer[] y = {40,60,10,20,50,30,40}; //contain duplicates
        Integer[] z = {9,2,6,7,7,23,4,59,101,99,44,3,2};
        MaxHeap a = new MaxHeap(x);
        MaxHeap b = new MaxHeap(y);
        MaxHeap c = new MaxHeap(z);
        System.out.println("SIZE= "+ a.getItems());
        System.out.println("arraysize" + a.getSize());
        System.out.println("Testing Constructor: 8 Items and Size 16-------------------------------------------");
        a.insert(97); 
        System.out.println(a.toString());
        System.out.println("Items = " + a.getItems() + " Size = " + a.getSize());
        
        
        System.out.println("\nTesting DeleteMax - DeleteMax = 97, Items should be 7, Size should be 8---------------------------------");
        a.deleteMax();
        System.out.println(a.toString());
        System.out.println("Items = " + a.getItems() + " Size = " + a.getSize());
        
        System.out.println("\nDeleteMax = 97, Items should be 7, Size should be 8--------------------------------------");
        a.deleteMax();
        System.out.println(a.toString());
        System.out.println("Items = " + a.getItems() + " Size = " + a.getSize());
        
        System.out.println("\nTesting Constructor: Duplicate numbers-----------------------------------------");
        System.out.println(b.toString());
        
        System.out.println("\nTesting Insert: Insert 45, Items = 8, Size = 14-----------------------------------");
        b.insert(45);
        b.insert(45);
        System.out.println(b.toString());
        System.out.println("Items = " + b.getItems() + " Size = " + b.getSize());
        
        System.out.println("\nTesting HeapSort: Should output Ascneding sorted list");
        c.heapsort(z);
        System.out.println(c.toString());                
    }
                
}