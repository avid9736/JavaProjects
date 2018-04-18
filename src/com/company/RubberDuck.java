package com.company;

public class RubberDuck extends Duck {

    @Override
    void display() {
        System.out.print("\ndisplay RubberDuck: ");
    }

    void quack(){
        System.out.print("squeaking | ");
    }

    void fly(){
        System.out.print("not flying | ");
    }
    
}
