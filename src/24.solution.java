import java.io.*;
import java.util.*;

class Solution {

  static int[] findDuplicates(int[] arr1, int[] arr2) {
    // your code goes here
  }

  public static void main(String[] args) {
        // debug your code below
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};
        int[] result = findDuplicates(arr1, arr2);

        System.out.print("Duplicates: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}