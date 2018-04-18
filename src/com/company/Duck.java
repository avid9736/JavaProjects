package com.company;

public abstract class Duck {

    void swim() {
        System.out.print("swimming | ");
    }

    abstract void display();

}

class MallardDuck extends Duck implements Flyable, Quackable {

    @Override
    void display() {
        System.out.print("\ndisplay MallardDuck: ");
    }

    @Override
    public void fly() {
        System.out.print("flying | ");
    }

    @Override
    public void quack() {
        System.out.print("quacking | ");
    }
}

class RedheadDuck extends Duck implements Flyable, Quackable {

    @Override
    void display() {
        System.out.print("\ndisplay RedheadDuck: ");
    }

    @Override
    public void fly() {
        System.out.print("flying | ");
    }

    @Override
    public void quack() {
        System.out.print("quacking | ");
    }
}
