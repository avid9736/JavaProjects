package com.company;

public class Main {

    public static void main(String[] args) {
        Duck malDuck1 = new MallardDuck();
        malDuck1.display(); malDuck1.swim();
        malDuck1.performFly(); malDuck1.performQuack();

        Duck redDuck1 = new RedheadDuck();
        redDuck1.display(); redDuck1.swim();
        redDuck1.performFly(); redDuck1.performQuack();

        Duck decDuck1 = new DecoyDuck();
        decDuck1.display(); decDuck1.swim();
        decDuck1.performQuack(); decDuck1.performFly();

        Duck rubDuck1 = new RubberDuck();
        rubDuck1.display(); rubDuck1.swim();
        rubDuck1.performQuack(); rubDuck1.performFly();

    }
}
