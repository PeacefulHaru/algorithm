import java.util.*;

/**

3 10 2
7
2
3

 */

class P12 {
  public static boolean found = false;
  public static int M = 0;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Scans the input
    String[] firstLineInput = sc.nextLine().split(" ");
    
    int N = Integer.parseInt(firstLineInput[0]);  
    M = Integer.parseInt(firstLineInput[1]);
    int K = Integer.parseInt(firstLineInput[2]);

    int[] priceList = new int[N];

    // Scan the rest
    for(int i = 0; i < N; i++) {
      priceList[i] = Integer.parseInt(sc.nextLine().trim());
    }
    sc.close();
    // System.out.println("\n");
    
    // Algorithm
    for(int i = K; i >= 1; i--) {
      printCombination(priceList, N, i);
    }

    if(found){
      System.out.println("Yes");
    }else{
      System.out.println("No");
    }
     
  }

  public static void combinationUtil(int arr[], int data[], int start, 
                                int end, int index, int r) 
    { 
        // Current combination is ready to be printed, print it 
        if (!found && index == r) 
        { 
            // for(int i = 0; i < r ; i++) {
            //   System.out.print(data[i] + " ");  
            // }
            // System.out.println();

            int totalPrice = 0; 
            // String possibleAnswer = "";

            for (int j=0; j<r; j++) {
              totalPrice += data[j];
            //   if(totalPrice > M) break;
            //   possibleAnswer += data[j] + " ";
            }
                

            if(totalPrice == M) {
              // Show me the combination
              // System.out.println(possibleAnswer);

              found = true;
            }
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        if(!found){
          for (int i=start; i<=end && end-i+1 >= r-index; i++) 
          { 
              
              data[index] = arr[i]; 
              combinationUtil(arr, data, i+1, end, index+1, r); 
          }
        }
         
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) 
    { 
        // A temporary array to store all combination one by one 
        int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n-1, 0, r); 
    } 

}

