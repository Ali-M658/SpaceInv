import java.util.*;

public class Solution {
    int number = 7;
    public static void solution(int number) {
        List<Integer> SumArray = new ArrayList<>();

        for (int i = 1; i<= number;) {
            if (i%3 ==0) {
                SumArray.add(i);
                System.out.println("Fizz");
            }
            else if (i%5 == 0) {
                SumArray.add(i);
                System.out.println("Buzz");
            }
            else {
                System.out.println("Numbers in order: "+i);
            }
        }
        boolean breakPoint = true;
        int totalSum = 0;
        while (breakPoint) {
            for (int x = 1; x <= SumArray.size();) {
                totalSum += SumArray.get(x);
            }
        }
        System.out.println("This is the total sum: " + totalSum);

    }
}