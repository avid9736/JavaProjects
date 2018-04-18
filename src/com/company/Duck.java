package com.company;

public abstract class Duck {

    void quack() {
        System.out.print("quacking | ");
    }

    void swim() {
        System.out.print("swimming | ");
    }

    abstract void display();

    void fly(){
        System.out.print("flying | ");
    }

}

class MallardDuck extends Duck {

    @Override
    void display() {
        System.out.print("\ndisplay MallardDuck: ");
    }
}

class RedheadDuck extends Duck {

    @Override
    void display() {
        System.out.print("\ndisplay RedheadDuck: ");
    }
}
