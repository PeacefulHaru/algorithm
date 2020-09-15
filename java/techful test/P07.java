import java.util.*;

public class Main {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine()); // N = 12

    int count = 1; // Skip N = 1
    int target = 3;
    int lastPrime = 2;
    int stack = 0;

    while(true) {
      boolean isPrime = false;

      if(target % 2 != 0) {
        // if it is odd number
        int theStartingNumber = (int) Math.floor(Math.pow(target, 0.5));
        if(theStartingNumber % 2 == 0) theStartingNumber--; // if even, make it odd.
        
        boolean flag = false;

        for(int i = theStartingNumber; i >= 2 ; i -= 2) {
          if(target % i == 0) {
            // This is not prime..
            // finish the test
            flag = true;
            break;
          }
        }

        // if flag is stil false, it is prime number!
        if(!flag) isPrime = true;

        //Testing
        // System.out.println(target + ": " + flag);
      }

      // Now you have the result of the target if it is prime or not.
      if(isPrime) {
        count += (target * stack);
        lastPrime = target;
        stack =0;

        //ending the while algorithm
        if(N < target) {
          break;
        }

      }else {
        // if it is not prime..
        if(N >= target) { // only happens when target is still inside
          count -= lastPrime;
          stack++;
        }
      }

      if(N < target & target % 2 != 0) {
        // For skipping even numbers for faster speed
        target++; 
      }

      target++;

    }// end of while

    System.out.println(count);

 }
}