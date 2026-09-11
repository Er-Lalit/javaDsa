//package Codeforces.CodeforcesRound1119.B_MinusTwo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            int odd = 0;
            int even = 0;
            int evenMod4 = 0;
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (num%2!= 0) {
                    odd++;
                } else if (num % 4 == 0) {
                    evenMod4++;
                } else {
                    even++;
                }
                
            }
            System.out.println(Math.max(odd, Math.max(even, evenMod4)));
        }

    }

}
