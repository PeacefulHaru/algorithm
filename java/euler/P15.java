public class P15
{
    //Written on 5/4/19
    //Solved on 5/4/19
    
    /*
    *The first step of the problem is to figure out how this Lattice Systemw works
    *I believe myself that I won't forget, but just in case, you can just simply look static
    *the code below and you will figure out the algorithm
    *long has been used for val array since the answer is 137,846,528,820 or 137 billion
    */
    
	public static void main(String[] args) {
		int grid = 20; //The problem asks 20 * 20
		long val[][] = new long[grid + 1][grid +1]; // if grid is 20, there should be 21 boxes 2D array
		
		//Setting the outside parts with the value '1'
		for(int i = 0 ; i < grid + 1 ; i++){
		    val[i][0] = 1;
		}
		//Setting the outside parts with the value '1'
		for(int j = 0 ; j < grid + 1; j++){
	        val[0][j] = 1;
	    }
		
		int xxx = 0; 
		//This is algorithm; Simple. If you forget how to do, just understand this.
		for(int i = 1 ; i <= grid ; i++){
		    for(int j = 1 ; j <= grid ; j++){
		        val[i][j] += val[i-1][j];
		        val[i][j] += val[i][j-1];
		        xxx++;
		    }
		}
		//printing out the answer. (Iterative Solution: My idea)
		System.out.println("Answer: " + val[grid][grid]);
		System.out.println("Steps: " + xxx);
		
		//Combination based algorithm; Not my idea (Source: Project Euler PDF File)
		combination_based_route_counting(grid);
		
		
	}
	
	
	//This function is not my idea
	//This is O(N) when the Iterative Solutionv above is O(N^2)
	//The PDF file says: Since the length of the route always stays the same
	//And the order does not matter, so binomial combination can be used
    //We can say: C(2n, n) or 2n! / (n! * (2n-n)!)
    //Wich can be simplified into 
    //Sigma from i = 1 until n = (n + i) / i
    //I understood this process around 70%
	public static void combination_based_route_counting(int n){
	    long result = 1;
	    int xxx = 0;
	    
	    for(int i = 1 ; i <= n ; i++){
	        result = result * (n + i) / i;
	        xxx++;
	    }
	    
	    System.out.println("Answer: " + result);
	    System.out.println("Steps: " + xxx);
	}
}



