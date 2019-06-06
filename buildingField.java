import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        long[][] d = new long[n][n];
        long total = 0;
        
        for(int i = 0; i < n-1; i++) {
            long cur = Long.parseLong(s[i]);
            total += cur;
            d[i][i+1] = cur;
            for(int j = i-1; j >=0; j--) {
                d[j][i+1] = d[j][i] + cur;
            }
        }
        
        if(n-1 >= 0) {
            total += Long.parseLong(s[n-1]);
        }
        
        long arc = total/2;
        
        int resp = 0;
        
        for(int k = 0; k < n; k++) {
            if(Arrays.binarySearch(d[k], arc) >= 0) {
                resp++;
                if(resp == 2) break;
            }
        }
        
        if(resp == 2) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
}