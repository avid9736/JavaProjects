package com.company;

public class RubberDuck extends Duck implements Quackable{

    @Override
    void display() {
        System.out.print("\ndisplay RubberDuck: ");
    }

    @Override
    public void quack() {
        System.out.print("squeaking | ");
    }
}
