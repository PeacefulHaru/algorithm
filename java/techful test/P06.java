import java.util.*;

public class P06 {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);
    boolean wrong = false;

    int N = Integer.parseInt(sc.nextLine()); 
    String[] F = sc.nextLine().split(" ");
    
    int M = Integer.parseInt(sc.nextLine()); 
    String[] G = new String[N];

    if (M != 0){
      G = sc.nextLine().split(" ");
      for(String givenCommand : G) {
        boolean found = false;
        for(String correctCommand : F) {
          if(givenCommand.equals(correctCommand)) {
            found = true;
            break;
          }
        }
        if(!found) {
          wrong = true;
          break;
        }
      }
    }

    
    if(wrong && M != 0) {
      System.out.println("NO");
    }else{
      System.out.println("YES");
    }

 }
}