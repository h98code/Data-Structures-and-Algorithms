package org.Projects.Arrays;

import org.Projects.Util.Car;

import java.util.Arrays;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        for(int i=0; i<cars.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (Car c1, Car c2) -> Integer.compare(c1.pos, c2.pos));

        double prevTime = ((double)target  - cars[cars.length - 1].pos) / cars[cars.length - 1].sp;
        int count = 1;

        for(int i=cars.length - 2; i>=0; i--) {
            double currTime = ((double)target - cars[i].pos) / cars[i].sp;

            if(currTime > prevTime){
                count++;
                prevTime = currTime;
            }
        }

        return count;
    }
}
