  
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 1; i <= cases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(in);
        }
        in.close();
    }

    public static void solve(Scanner in) {
        int parties = in.nextInt();
        int[] members = new int[parties];
        int total = 0;
        for (int i = 0; i < parties; i++) {
            members[i] = in.nextInt();
            total += members[i];
        }
        while (total > 0) {
            int max = 0;
            int indexMax = 0;
            int max2 = 0;
            int indexMax2 = 0;
            if (members[0] < members[1]) {
                max = members[1];
                indexMax = 1;
                max2 = members[0];
                indexMax2 = 0;
            } else {
                max = members[0];
                indexMax = 0;
                max2 = members[1];
                indexMax2 = 1; 
            }
            for (int i = 2; i < parties; i++) {
                if (members[i] > max) {
                    max2 = max;
                    indexMax2 = indexMax;
                    max = members[i];
                    indexMax = i;
                } else if (members[i] > max2) {
                    max2 = members[i];
                    indexMax2 = i;
                }
            }
            
            System.out.print((char) (indexMax + 'A'));
            members[indexMax]--;
            total--;
            if ((float) max2 / (float) total > 0.50f) {
                System.out.print((char) (indexMax2 + 'A'));
                total--;
                members[indexMax2]--;
            }
            if (total != 0) {
                System.out.print(" ");
            } else {
               System.out.println();
            }
        }
    }
}