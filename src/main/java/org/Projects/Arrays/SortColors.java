package org.Projects.Arrays;

public class SortColors {

    // TC = O(N)
    // SC = O(1)
    // single pass solution using 3 pointers
    public void sortColors(int[] a) {
        int l = 0, r = a.length - 1;

        for(int mid = 0; mid <= r; mid++) {
            if(a[mid] == 0) {
                swap(a, l++, mid);
            } else if(a[mid] == 2) {
                swap(a, mid--, r--);
            }
        }
    }

    private void swap(int[] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
