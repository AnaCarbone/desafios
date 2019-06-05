import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] duration = new int[n];
        double[] cost = new double[n];
        double[] discounts = {1.00, 2.00, 4.00, 4.00, 4.00, 4.00};
        for(int i = 0; i<n; i++) {
            duration[i] = scan.nextInt();
            cost[i] = scan.nextDouble();
        }
        double minCost = solve(cost, duration, discounts, 0);
        System.out.println(minCost);
        
    }
    
    public static double solve(double []cost, int[]duration, double[]discount, int index) {
        if(index>duration.length) return 0;
        int partialDuration = 0;
        double partialCost = 0;
        double min= Double.MAX_VALUE;
        for(int i = 0; i<6 && partialDuration<120 && index+i<duration.length; i++){
            partialCost += cost[index + i]/discount[i];
            if(index+i+1<duration.length) {
                min = Math.min(min, partialCost + solve(cost, duration, discount, index + i + 1));
            } else min = partialCost;
            partialDuration += duration[index];
        }
        return min;
    }
}
