package org.Projects.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC = O(N^2) --> N is the row number
// SC = O(N) --> recursive stack + space needed to store the rows
public class PascalsTriangleRow { //fiunction to get the ith row of the pascal's triangle
    public List<Integer> getRow(int rowIndex) {
        //base condition
        if(rowIndex == 0){
            return new ArrayList<>(Arrays.asList(1));
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        List<Integer> prev= getRow(rowIndex - 1);

        for(int i=1; i<prev.size(); i++){
            ans.add(prev.get(i) + prev.get(i - 1));
        }

        ans.add(1);

        return ans;
    }
}
