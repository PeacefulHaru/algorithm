import java.util.*;

// 10
// 75 86 115 167 26 96 35 105 80 52

public class P10 {
  
  public static void main(String args[] ) throws Exception {
    // Scanner
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine()); 
    String[] tempA = sc.nextLine().split(" ");

    // Convert given values
    int[] A = new int[N];
    for(int i = 0; i < N; i++) {
      int tempValue = Integer.parseInt(tempA[i]);
      A[i] = tempValue;

    }

    int answer = 0;
    int length = 1;

    while(length <= N) {
      
      for(int i = 0; i < N - length + 1; i++) {
        int sum = 0;

        for(int j = 0; j < length; j++) {
          sum += A[i + j];
        }

        if(sum % 444 == 0) {
          answer++;
        }

      }

      // finally
      length++;
    }

    System.out.println(answer);

 }  
}
