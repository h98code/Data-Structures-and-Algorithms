package org.Projects.Recursion;

public class BasicQueSolutions {

    //  ========================================================
    //  TC = O(N)
    //  SC = O(N) --> recursive stack
    public void reverseString(char[] s) { // fucntion to reverse the string
        int st = 0, end = s.length - 1;
        reverseStringHelper(s, st, end);
    }

    public void reverseStringHelper(char[] s, int st, int end){
        //base condition
        if(st >= end){
            return;
        }

        //swapping the starting and ending characters
        char temp = s[st];
        s[st] = s[end];
        s[end] = temp;

        reverseStringHelper(s, st + 1, end - 1);
    }

    //  ========================================================
    //  TC = O(N)
    //  SC = O(N) --> recursive stack
    private void printNumberOneToN(int n){ // funtion to print numbers from 1 to N
        if(n == 0){
            return;
        }

        printNumberOneToN(n-1);
        System.out.println(n);
    }

    //  ========================================================
    public static void main(String[] args) {
        BasicQueSolutions obj = new BasicQueSolutions();
        obj.printNumberOneToN(5);

    }
}

