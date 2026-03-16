package org.Projects.Recursion;

public class KthSymbolInGrammar {

    // TC = O(2^N) --> length of the string generated in Nth row is 2^(N-1)
    // SC = O(2^N) --> space used to store the string generated in Nth row + recursive stack space.
    public int kthGrammarS1(int n, int k) {
        String row = generateRow(n);
        return row.charAt(k - 1) - '0';
    }

    public String generateRow(int n){
        if(n == 1){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        String prevRow = generateRow(n - 1);
        for(int i=0; i<prevRow.length(); i++){
            if(prevRow.charAt(i) == '0'){
                sb.append("01");
            }else{
                sb.append("10");
            }
        }

        return sb.toString();
    }

        // TC = O(N) --> we are visiting each row once.
        // SC = O(N) --> recursive stack space.
    public int kthGrammar(int n, int k) {
        //using n and k we have to find out from whichi part of the n - 1th string,
        // we are getting the kth symbol of the current string.
        // suppose we have (5,9) so the 9th value would be generated from the 5th value of the 4th row.
        // and hence f(n,k) = f(n-1, (k+1)/2) + some checking.

//         if(n == 1) return 0;
//         if(k == 1) return 0;
//         if(n == 2 && k == 2) return 1;
        // can we improve on the base conditions?

        // base condition
        if(k <= 2){
            return k - 1;
        }

        int parentVal = kthGrammar(n - 1, (k + 1) / 2);
        if(parentVal == 0){
            if((k & 1) == 1)
                return 0;
            else
                return 1;
        }else{
            if((k & 1) == 1)
                return 1;
            else
                return 0;
        }
    }
}
