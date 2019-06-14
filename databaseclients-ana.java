import java.io.IOException;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Set<String> emails = new LinkedHashSet<>();
        while(scan.hasNextLine()) {
            String email = scan.nextLine();
            if(!email.equals("")){
                String[] splitedEmail = email.split("@");
                emails.add(splitedEmail[0].replaceAll("\\+.*", "").replace(".", "").concat(splitedEmail[1]));
            }
        }
        System.out.println(emails.size());
    }
 
}
