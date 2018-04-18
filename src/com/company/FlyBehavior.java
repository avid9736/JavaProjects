package com.company;

public interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.print("Flying | ");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.print("<< Not Flying >> | ");
    }
}
