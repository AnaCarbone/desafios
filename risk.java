import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math; 

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        
        int q = Integer.parseInt(in.readLine());
        int[] a = new int[100001];
        int[][] h = new int[100001][2];
        for(int i = 0; i < q; i++) {
            String line = in.readLine();
            String[] numbers = line.split(" ");
            int n = Integer.parseInt(numbers[0]);
            int k = Integer.parseInt(numbers[1]);
            
            int c = 0;
            int j = 2;
            
            if(h[k][0] != 0) {
                c = h[k][1];
                j = h[k][0] + 1;
            }
            
            for(; j <= n; j++) {
                if(a[j] == 0) {
                    primeFactors(j, a);
                }
                if(a[j] <= k) {
                    c++;
                }
            }
            h[k][0] = n;
            h[k][1] = c;
            System.out.println(c);
        }
        
    }
    
    public static void primeFactors(int n, int[] a) 
    { 
        int initial = n;
        int max = 2;
        while (n%2==0) 
        {
            n /= 2;
            if(a[n] != 0) {
                a[initial] = a[n];
                return;
            } 
        } 
  
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            while (n%i == 0) 
            { 
                max = i;
                n /= i;
                
                if(a[n] != 0) {
                    a[initial] = Math.max(a[n], max);
                    return;
                } 
            } 
        } 
  
        if(n > 2){
            a[initial] = n;
        } else {
            a[initial] = max;
        }
    } 
    
}
