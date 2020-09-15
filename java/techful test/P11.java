import java.util.*;

class P11 {
  /**
   * 
   * 
   *  
      6 10
      .......@..
      .###......
      ..@.......
      ...#######
      ......@...
      ..........
      
   */

  public static int H = 0; 
  public static int W = 0; 

  // Has the order of Right Up Left Down.
  public static int[] row = {0, -1, 0, 1};
  public static int[] col = {1, 0, -1, 0};
  public static boolean[][] wallMatrix; 

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Scans the input
    String[] multipleUserInputs = sc.nextLine().split(" ");
    H = Integer.parseInt(multipleUserInputs[0]);
    W = Integer.parseInt(multipleUserInputs[1]);

    int[][] matrix = new int[H][W]; // This matrix contains the value
    int[][] ownerMatrix = new int[H][W];
    wallMatrix = new boolean[H][W];
    int numberOfOwners = 0;

    int theShortestRecord = H * W; // Maximum 2,500

    LinkedList<Integer> m = new LinkedList<Integer>();
    LinkedList<Integer> n = new LinkedList<Integer>();

    // Put values into the matrices
    for(int i = 0; i < H; i++) {
      String[] multipleUserWidthInputs = sc.nextLine().split(""); // [. . # .]

      for(int j = 0; j < W; j++) {
        matrix[i][j] = -1;
        ownerMatrix[i][j] = -1;
        wallMatrix[i][j] = false;

        // if the space is @
        if(multipleUserWidthInputs[j].equals("@")) {
          matrix[i][j] = 0;
          ownerMatrix[i][j] = numberOfOwners;

          numberOfOwners += 1;

          // (m, n)
          m.addFirst(i);
          n.addFirst(j);
        }

        // elif the space is # (wall)
        else if(multipleUserWidthInputs[j].equals("#")){
          wallMatrix[i][j] = true;
        }

      }
    }
    sc.close();

    // Algorithm begins here:
    while(m.size() != 0) {

      int currM = m.pollLast();
      int currN = n.pollLast();
      int currVal = matrix[currM][currN];
      int ownerId = ownerMatrix[currM][currN];

      // Testing
      // printMatrix(matrix, H, W, currM, currN);
      
      for(int i = 0; i < 4; i++) {
        int newM = currM + col[i];
        int newN = currN + row[i];
        // Check if it is wall or out of range
        // Nothing helps else.
        if(isSafe(newM, newN)) {

          // check if it is empty matrix
          if(matrix[newM][newN] == -1) {
            m.addFirst(newM);
            n.addFirst(newN);
            matrix[newM][newN] = currVal + 1;
            ownerMatrix[newM][newN] = ownerId;

          }
          // check if it is other's
          else if(ownerMatrix[newM][newN] != ownerId) {
            // Compare the distance with the shortest value
            // And put the shortest value inside
            int calculatedDistance = currVal + matrix[newM][newN];
            theShortestRecord = theShortestRecord < calculatedDistance ? 
                                theShortestRecord : calculatedDistance;
            
          }
        }
      }
    }
    
    // Algorithm ends (Since the zero itself is not added.)
    System.out.println(theShortestRecord + 1);
  }

  public static boolean isSafe(int m, int n) {
    if(!isInRange(m, n)) return false;
    if(wallMatrix[m][n]) return false;

    return true;
  }

  public static boolean isInRange(int m, int n) {
    if(m < 0 || m >= H) return false;
    if(n < 0 || n >= W) return false;

    return true;
  }

  public static void printMatrix(int[][] matrix, int H, int W, int m, int n) {
    System.out.println("At (" + m + ", " + n + ")");
    for(int i = 0; i < H; i++) {
      for(int j = 0; j < W; j++) {
        if(wallMatrix[i][j]) System.out.print("W  "); 
        else if (matrix[i][j] >= 0) System.out.print(matrix[i][j] + "  ");
        else System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}