package com.codekul.adapterviews;
/*
* - What is package ?
* - com.codekul.adapterviews ?
* - public ? - who and from where can access ?
* - class ? combination of attributes + behaviours
* - Car ? Name of class
* - { } - scope
*
*
* - Encapsulation
* - Inheritance
* - Abstraction
* - Polymorphism
* */

public class Car {
    int wheel; // properties or variables or fields

    void speedUp() { // function or method
        wheel = wheel + 5;
    }

    void speedUp(int spd) {
        wheel = wheel + spd;
    }

    void setWheel(int wh) {
        wheel = wh;
    }
}

class Bmw extends Car{

    int alignment;

    void speedUp() {
       // super.speedUp();
        wheel = wheel + 5 / alignment;
    }
}

class Xyz {
    public static void main(String []args) {
        Car car = new Car(); // object
        car.speedUp();
        car.speedUp(10);

        //car.wheel = 4;
        car.setWheel(4);

        Bmw bmw = new Bmw();
        bmw.speedUp();
    }
}
