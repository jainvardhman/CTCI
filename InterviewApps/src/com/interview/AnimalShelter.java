package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */

// Cat = 1
//Dog = 2
public class AnimalShelter {
    Queue cat;
    Queue dog;
    //int firstAnimal;
    int latestAnimal;
    public AnimalShelter(){
        cat = new Queue();
        dog = new Queue();
        //firstAnimal = 0;
        latestAnimal = -1;
    }

    public void enqueue(int animal){
        int currAnimal = -1;
        if(cat.isEmpty() && dog.isEmpty()){
            //firstAnimal = animal;
            currAnimal = 1;
            latestAnimal = currAnimal;
        }
        else {
            currAnimal = latestAnimal + 1;
        }

        if(animal == 1){
            System.out.println("Adding cat");
            System.out.println("Animal number " + currAnimal);
            cat.enqueue(currAnimal);
        }
        else {
            System.out.println("Adding dog");
            System.out.println("Animal number " + currAnimal);
            dog.enqueue(currAnimal);
        }

        latestAnimal = currAnimal;
    }

    public void dequeueCat(){
        if(!cat.isEmpty()) {
            System.out.println("Cat dequeued: Animal number = " + cat.peek().data);
            cat.dequeue();
        }
        else {
            System.out.println("No cats left");
        }
    }

    public void dequeueDog(){
        if(!dog.isEmpty()) {
            System.out.println("Dog dequeued: Animal number = " + dog.peek().data);
            dog.dequeue();
        }
        else
            System.out.println("No dogs left");
    }

    public void dequeueAny(){
        if(!cat.isEmpty() && !dog.isEmpty()){
            System.out.println("Both not empty");
            if(cat.peek().data < dog.peek().data) {
                System.out.println("Dequeuing cat");
                dequeueCat();
            }
            else if(dog.peek().data < cat.peek().data) {
                System.out.println("Dequeuing dog");
                dequeueDog();
            }
        }

        else if(!cat.isEmpty() && dog.isEmpty()) {
            System.out.println("Dequeuing cat, dog empty");
            dequeueCat();
        }

        else if(!dog.isEmpty() && cat.isEmpty()) {
            System.out.println("Dequeuing dog, cat empty");
            dequeueDog();
        }

        else
            System.out.println("No animals left in the shelter");
    }
}

