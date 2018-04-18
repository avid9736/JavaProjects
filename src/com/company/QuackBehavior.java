package com.company;

public interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.print("Quack | ");
    }
}

class Squeak implements QuackBehavior{

    @Override
    public void quack() {
        System.out.print("Squeak | ");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.print("<< Silence >> | ");
    }
}