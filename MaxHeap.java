/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2si4lab05;

/**
 *
 * @Siddesh Bist 
 */
public class MaxHeap {
    
    private Integer[] heapArray; // instance field that represents array where heap elements will be stored
    private int size; //instance field that represents the size allocated for the array
    private int items; //instance field that represents the nunber of heap elements in the array 
    
    public MaxHeap(int s) //create an object of type MaxHeap when array size is defined
    {
        size = s; //allocate size of array
        items = 0; //number of heap elements is 0
        Integer[]heapArray = new Integer[s];  //size of heaparray is update to match user defined input
    }
    
    public MaxHeap( Integer[] someArray)
    {
        items = someArray.length; 
        size = someArray.length; 
        heapArray = someArray;   //update instance fields
        
        for(int i = (size-1)/2; i>=0; i--) //start from Parent node and perform MaxHeapify
        {
            MaxHeapify(i); //Max heapify starting from parent node
        }
    }
    
    public void insert(int n){
        if(items == size) //size of array is same as number of items 
        {
            size = 2* size; //double the size
            Integer [] newArray= new Integer[size];
            
            for(int i =0; i<items;i++){
                newArray[i] = heapArray[i];
            }
            heapArray = newArray; //update instance field so when modifying heap array can actually modify newArray
        }
        
        heapArray[items] = n; //insert new element at end 
        items++; 
        for(int i = (items-1)/2; i>=0; i--){
            MaxHeapify(i); 
        }     
        
    }    
    
    public int deleteMax(){
        int max = heapArray[0]; //max element is first element of heap array
        
        heapArray[0] = heapArray[items-1]; //first element is swapped with last item
        heapArray[items-1] = null; //last element points to null
        items--;
        
        for(int i= (items-1)/2; i >=0; i--){
            MaxHeapify(i); //build heap by calling maxheapify
        }
        
        return max; //return deleted node
        
    }
    
    public void heapsort(Integer[] arrayToSort){ 
        MaxHeap duplicate = new MaxHeap (arrayToSort);
        Integer[] m = new Integer[duplicate.size];
        for(int i = duplicate.items-1; i>=0; i--){
            int max = duplicate.deleteMax();
            m[i] = max;
        }
        heapArray = m; //Update HeapArray with new Array which contain items in Ascending Order so can print later
        items = arrayToSort.length;
        size = arrayToSort.length; 
    } 
            
    public void swap(int spos, int hpos){
        int temp = heapArray[spos];
        heapArray[spos] = heapArray[hpos];
        heapArray[hpos] = temp; 
    }
    public void MaxHeapify(int i){
        int largest = i;
        int iL = 2*i +1; //left child
        int iR = 2*i +2; //right child
        
        if(iL < items && heapArray[i] < heapArray[iL]){
            largest = iL;
        }
        
        if(iR<items && heapArray[largest] < heapArray[iR]){
            largest = iR;
        }
        
        if(largest != i){
            swap(i,largest);
            MaxHeapify(largest);
        }

    }//swaps all the children that are bigger than their parent with the parent
    
    
    public String toString(){
        String output = "";
        
        for(int i =0; i<items; i++){
            output += heapArray[i] + ", ";
        }
        return output;
    }
    
    public int getItems()
            {
               return items; 
            }
    
    public int getSize()
    {
        return size;
    }
    
}

