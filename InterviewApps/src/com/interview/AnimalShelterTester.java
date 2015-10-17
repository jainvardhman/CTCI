package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class AnimalShelterTester {
    public void invokeTestBasic(){
        AnimalShelter as = new AnimalShelter();
        as.enqueue(1);
        as.enqueue(2);
        as.enqueue(1);
        as.enqueue(1);
        as.enqueue(2);
        as.enqueue(2);
        as.dequeueAny();
        as.dequeueAny();
        as.dequeueAny();
        as.dequeueAny();
        as.dequeueAny();
        as.dequeueAny();
        as.dequeueDog();
        as.dequeueDog();
        as.dequeueCat();
        as.dequeueCat();
        as.dequeueDog();
    }
}
