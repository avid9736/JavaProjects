package com.company;

public class Main {

    public static void main(String[] args) {

        MallardDuck malDuck1 = new MallardDuck();
        RedheadDuck redheadDuck1 = new RedheadDuck();
        RubberDuck rubberDuck1 = new RubberDuck();
        DecoyDuck decoyDuck1 = new DecoyDuck();

        malDuck1.display(); malDuck1.swim(); malDuck1.quack(); malDuck1.fly();

        redheadDuck1.display(); redheadDuck1.swim(); redheadDuck1.quack(); redheadDuck1.fly();

        rubberDuck1.display(); rubberDuck1.swim(); rubberDuck1.quack();
        //rubberDuck1.fly(); // can't fly

        decoyDuck1.display(); decoyDuck1.swim();
        //decoyDuck1.quack(); decoyDuck1.fly(); // can't quack nor fly
    }
}
