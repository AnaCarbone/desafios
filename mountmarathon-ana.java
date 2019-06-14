import java.io.IOException;
import java.util.*; 

public class Main {
 
    public static void main(String[] args) throws IOException {
 
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int prev = 0;
        int piles = n;
        for(int i = 0; i<n; i++){
            int card = scan.nextInt();
            if(prev!=0 && prev >= card) {
                piles--;
            } 
            prev = card;
        }
        System.out.println(piles);
 
    }
 
}
