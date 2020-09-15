import java.util.*;

public class Main {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);
    String given = sc.nextLine(); 

    boolean found = false;

    String[] givenArr = given.replaceAll("\\s", "").split("");
    int length = givenArr.length;

    for(int i = 0; i < length / 2; i++) {
      if(!givenArr[i].equals(givenArr[length - i - 1])) {
        found = true;
        break;
      }
    }

    if(found) {
      System.out.println("No");
    }else{
      System.out.println("Yes");
    }

 }
}