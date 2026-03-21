package org.Projects.Recursion;

public class xToThePowerN {
    public double myPow(double x, int n) {
        long pow = n;

        if(n < 0){
            return helper(1/x, Math.abs(pow));
        }

        return helper(x, pow);
    }

    // TC = O(log n) since the power is reduced by 2 in almost every iteration.
    // SC = O(log n) depth of recursion call stack
    public double helper(double x, long pow){
        if(pow == 0)
            return 1;

        if((pow & 1) == 1){ // if the power is odd
            return x * helper(x, pow - 1);
        }

        double halfPower = helper(x, pow / 2);
        return halfPower * halfPower;
    }
}

