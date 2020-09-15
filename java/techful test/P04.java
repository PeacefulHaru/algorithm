import java.util.*;

public class P04 {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine()); 
    long D = (long) Integer.parseInt(sc.nextLine());
    String[] temp = sc.nextLine().split(" ");
    // [5, 4, 7, 2]

    long count = 0L;

    for(int i = 0; i < N; i++) {
      long target = (long) Integer.parseInt(temp[i]);
      count += target / D;
      if(target % D != 0) count++;
      // System.out.println(i+" | " + count);
    }

    System.out.println(count);

 }
}