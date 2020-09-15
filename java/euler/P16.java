public class P16
{
    //Written on 5/5/19 Sun
    //Solved on 5/5/19 Sun
    //Around 75 minutes (Stack 3h 30m)
    
    /*
    * The problem does not require so much thinking.
    * Only difficult part is to implement string mutlplying method
    * Since even long can't handle the large number
    */
    
	public static void main(String[] args) {
	    int input = 1000; // 2^input
		String calculated_value = "1";
		for(int i = 0 ; i < input ; i++){
		    calculated_value = stringMultiplier(calculated_value, "2");
		}
		
		String[] ans_arr = calculated_value.split("");
		
		int sum = 0;
		for(int i = 0 ; i < ans_arr.length; i++){
		    sum += Integer.valueOf(ans_arr[i]);
		}
		
		System.out.println("Answer: " + sum);
	}
	
	
	public static String stringMultiplier(String x, String y){
	    //This stringMultiplier has been proved to be CORRECT
	    //This does not handle negative numbers and zero.
	    
	    //basic tool for string multiply
	    //This string multiplier can handle very long numbers.
	    int x_len = x.length();
	    int y_len = y.length();
	    int max = x_len * y_len + 1; // Can be proved with 999*999 cannot have more than 7 digits. 
	    String temp_x_arr[] = x.split("");
	    String temp_y_arr[] = y.split("");
	    int arr_x[] = new int[x_len];
	    int arr_y[] = new int[y_len];
	    int ans[] = new int[max];
	    String answer = "";
	    
	    //flipping numbers in array to understand clearer.
	    for(int i = 0 ; i < x_len ; i++){
	        arr_x[i] = Integer.valueOf(temp_x_arr[x_len - 1 - i]);
	    }
	    for(int i = 0 ; i < y_len ; i++){
	        arr_y[i] = Integer.valueOf(temp_y_arr[y_len - 1 - i]);
	    }
	    //flipping algorithm ends
	    
	    
        
        //First save them each array with integer.
	    for(int i = 0 ; i < x_len ; i++){
	        for(int j = 0 ; j < y_len ; j++){
	            ans[i+j] += arr_x[i] * arr_y[j];
	        }
	    }
	    //Then send back to the next digit and save the remainder.
	    for(int i = 0 ; i < max-1 ; i++){
	        ans[i + 1] += ans[i] / 10;
	        ans[i] %= 10;
	    }

	    //flipping back to the human reading number
	    //This flag method also removes zeros. (This happens when the mulitplied value doesn't get to the maximum digit.)
	    boolean flag = false;
	    for(int i = 0 ; i < max ; i++){
	        if(!flag && !String.valueOf(ans[max - 1 - i]).equals("0")){
	            flag = true;
	        }
	        if(flag){
	            answer += String.valueOf(ans[max - 1 - i]);
	        }
	    }
	    //flipping back ends.
	    
	    return answer;
	    
    }
}




