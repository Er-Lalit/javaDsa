package Codeforces.LittleElephantandProblem;

import java.util.*;

public class LittleElephantandProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sortArr[] = arr.clone();   // copy original array
        Arrays.sort(sortArr);          // sorted version

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != sortArr[i]) {
                count++;
            }
        }

        if (count <= 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}