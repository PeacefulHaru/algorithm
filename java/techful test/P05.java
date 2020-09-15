import java.util.*;

public class P05 {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine()); 
    String[] temp = sc.nextLine().split(" ");

    int A = Integer.parseInt(temp[0]);
    int B = Integer.parseInt(temp[1]);

    boolean found = false;

    for(int i = A; i <= B; i++) {
      // Testing
      // System.out.println(N + " / " + i + " = ?");
      if(N % i == 0) {
        found = true;
        break;
      }

      // Faster performance
      if(i > N / 2) {
        break;
      }
    }

    if(found) {
      System.out.println("Yes");
    }else{
      System.out.println("No");
    }

 }
}