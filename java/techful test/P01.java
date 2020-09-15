import java.util.*;

/**
 * Questions in Google Drive named..
 * 2020-3A Pro Logic Question
 */

public class Main {
  public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		int G = Integer.parseInt(sc.nextLine());
		int X = Integer.parseInt(sc.nextLine());
		String[] tempUV = sc.nextLine().split(" ");

		int U = Integer.parseInt(tempUV[0]);
		int V = Integer.parseInt(tempUV[1]);
		sc.close();

		int techDistance = T * U;
		techDistance = G < techDistance ? G : techDistance;

		int turtleDistance = T * V + X;
		turtleDistance = G < turtleDistance ? G : turtleDistance;

		System.out.println(Math.abs(techDistance - turtleDistance));
 }
}