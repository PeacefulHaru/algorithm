import java.util.*;

public class Main {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine()); 

    //handle when N = 0
    if(N == 0){
      System.exit(0);
    }

    String[] tempA = sc.nextLine().split(" ");
    sc.close();

    double sum = 0;

    // Make the array with int, then sort it out
    int[] A = new int[N];
    for(int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(tempA[i]);
    }
    Arrays.sort(A);

    // Algorithm begins with bitmasks

    for(int i = 1; i < (1 << N); i++) {
      Stack<Integer> tempArr = new Stack<Integer>();

      int target = i;
      int count = 0;
      while(target != 1) {
        if(target % 2 == 1) {
          tempArr.push(A[count]);
        }
        count++;
        target /= 2;
      }

      // finally
      tempArr.push(A[count]);

      // Testing
      // System.out.println(tempArr);

      int tempLength = tempArr.size();
      if(tempLength % 2 == 0) {
        // if even
        int midPoint = tempLength / 2; // if 4, => 2 (Bigger one)
        double tempAvg = (double) (tempArr.get(midPoint) + tempArr.get(midPoint - 1)) / 2;
        sum += tempAvg;

      }else{
        // if odd
        int midPoint = tempLength / 2; //if 3, => 1.5 => 1 (Good)
        sum += tempArr.get(midPoint);
      }

      // Testing
      // System.out.println(sum);
    }
    

    System.out.println((long)sum); // it used to be (int), but it was out of range.

 }
}