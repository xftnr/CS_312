import java.util.*;
import java.lang.Math;
import java.util.Random;
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
public class GuitarString{
    private RingBuffer ringBuffer;
    private int count = 0;
    public GuitarString(double frequency){
        int N = (int)Math.ceil(44100/frequency);
        ringBuffer = new RingBuffer(N);
        for (int i = 0; i<N; i++){
            ringBuffer.enqueue(0);
        }
    }// create a guitar string of the given frequency, using a sampling rate of 44,100
    public GuitarString(double[] init){
        ringBuffer = new RingBuffer(init.length);
        for (int i = 0; i<init.length; i++){
            ringBuffer.enqueue(init[i]);
        }
    }// create a guitar string whose size and initial values are given by the array
    public void pluck(){
        Random rand = new Random();
        double buffer = 0;
        for (int i = 0; i<ringBuffer.size(); i++){
            buffer = rand.nextDouble()- 0.5;
            ringBuffer.a[i] = buffer;
        }
    }// set the buffer to white noise
    public void tic(){
        count++;
        ringBuffer.enqueue(.994 * 1/2 * (ringBuffer.dequeue()+ ringBuffer.peek()));
    }// advance the simulation one time step
    public double sample(){
        return ringBuffer.peek();
    }// return the current sample
    public int time(){
        return count;
    }// return number of tics
}