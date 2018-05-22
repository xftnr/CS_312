import java.util.*;
/**
 * CS312 Assignment 12.
 *
 * On MY honor, <PENGDI XIA>, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Pengdi Xia
 * UTEID:px353
 * email address: xiapengdi@yahoo.com
 * Number of slip days used on this assignment:0
 * 
 */
public class RingBuffer{
    public double[] a;
    private int count;
    private double preitem;
    private int first = -1;
    private int last = -1;
    private double temp;
    private int premove = -1; // 1 means enqueue, 0 means dequeue
    public RingBuffer(int capacity){
        a = new double[capacity];
    }// create an empty ring buffer, with given max capacity
    public int size(){
        if (first== -1 && last ==-1){
            return 0;
        }
        else if (first != last){
            if (first < last){
                return last-first;
            }
            else{
                return a.length - (first-last);
            }
        }
        else{
            if (premove == 1){
                return a.length;
            }
            else{
                return 0;
            }
        }
    }// return number of items currently in the buffer
    public boolean isEmpty(){
        return size() == 0;
    }// is the buffer empty (size equals zero)?
    public boolean isFull(){
        return size() == a.length;
    }// is the buffer full  (size equals capacity)?
    public void enqueue(double x){
        // when the array is not inited
        if (first== -1 && last == -1) {
            first = 0;
            last = 0;
        }   
        if (!isFull()){
            a[last] = x;
            if (last < a.length - 1){
                last++;
            }
            else{
                last = 0;
            }
            premove = 1;
        } 
        else {
            throw new IllegalStateException();
        }
    }// add item x to the end (as long as the buffer is not full)
    public double dequeue(){
        if(!isEmpty()){
            temp = a[first];
            a[first] = 0.0;
            if (first < a.length -1){
                first++;
            }
            else{
                first = 0;
            }
            premove = 0;
        }
        else{
            throw new NoSuchElementException();
        }
        return temp;
    }// delete and return item from the front (as long as the buffer is not empty)
    public double peek(){
        if(!isEmpty()){
            return a[first];
        }
        else{
            throw new NoSuchElementException();
        }
    }// return (but do not delete) item from the front of the buffer
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        else{
            String b = a[first]+"";
            for (int i = 1 ; i < size(); i++){
                b+= ", " + a[(first+i)%a.length];
            }
            return "["+b+"]";
        }
    }// override toString. Return a String of the form [front, next, next, last]
}
