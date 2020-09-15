import java.util.*;

/**
 
5
5
1
9
3
7

 */
// 9 7 5 3 1


/**
 * https://techful-programming.com/user/event/session/PlTmUubG/problem/coding/14
 */

public class P03 {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine()); 
    long[] intArr = new long[N];
    

    for(int i = 0; i < N ; i++) {
      intArr[i] = (long) Integer.parseInt(sc.nextLine());
    }
    Arrays.sort(intArr);

    sc.close();

    for(int i = 0; i < N; i++) {
      System.out.print(intArr[N - i - 1] + " ");
    }
 }
}