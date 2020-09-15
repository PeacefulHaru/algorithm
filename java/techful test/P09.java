import java.util.*;

public class P09 {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    sc.close();

    System.out.print("1");

    if(N == 1) {
      System.exit(0);
    }
    System.out.print(" ");

    int a = 0;
    int b = 1;

    for(int i = 0; i < N - 1; i++) {
      int c = a + b;
      System.out.print(c + " ");
      a = b;
      b = c;
    }
    
 }
}