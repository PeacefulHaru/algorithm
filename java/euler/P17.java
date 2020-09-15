public class P17
{
    //Started on 5/5/19 Sun
    //Finished on 5/6/19 Mon 
    //Around 60 minutes (Stack 4h 0m)
    
    /*
    *The problem asks for british way of counting
    *104 = one hundred and four
    The code itself does not require so much explanation due to its simpleness
    */
    
    
	public static void main(String[] args) {
	    //input (only 1~1000)
	    int input = 1000;
	    
	    //basic
	    int sum = 0;
	    int arr[] = new int[101];
	    // int previous = 0; // for testing reason
	    
	    // tools
	    int and = 3;
	    int one_thousand = 11;
	    arr[0] = 0; //none, or zero, but it is 0 because 0 is not pronounced.
	    arr[1] = 3;   //one
	    arr[2] = 3;   //two
	    arr[3] = 5;   //three
	    arr[4] = 4;   //four
	    arr[5] = 4;   //five
	    arr[6] = 3;   //six
	    arr[7] = 5;   //seven
	    arr[8] = 5;   //eight
	    arr[9] = 4;   //nine
	    arr[10] = 3;  //ten
	    arr[11] = 6;  //eleven
	    arr[12] = 6;  //twelve
	    arr[13] = 8;  //thirteen
	    arr[14] = 8;  //fourteen
	    arr[15] = 7;  //fifteen
	    arr[16] = 7;  //sixteen
	    arr[17] = 9;  //seventeen
	    arr[18] = 8;  //eighteen
	    arr[19] = 8;  //nineteen
	    arr[20] = 6;  //twenty
	    arr[30] = 6;  //thirty
	    arr[40] = 5;  //forty         (NOT FOURTY)
	    arr[50] = 5;  //fifty
	    arr[60] = 5;  //sixty
	    arr[70] = 7;  //seventy
	    arr[80] = 6;  //eighty
	    arr[90] = 6;  //ninety        (NOT NINTY)
	    arr[100] = 7; //hundred
	    //tools ends..
	    
	    //counting algorithm begins..
	    for(int j = 1 ; j <= input ; j++){
	        int i = j % 100;
	        if(j == 1000){
	            break;
	        }
	        if(i < 20 || i % 10 == 0){
	            //from 1~19 OR 20, 30, 40 ... 90
    	        sum += arr[i];
	        }else{
    	        //from 20~99 EXCEPT above.
    	        int front_digit = i / 10 * 10; //This removes the end digit, then make it back. (LOGICAL! WARNING!)
    	        int end_digit = i % 10;
    	        sum += arr[front_digit]; //i.e 42's 40
    	        sum += arr[end_digit]; //i.e 42's 2
    	    }
    	    
    	    if(j >= 100){
    	        //if equal or more than 100.
    	        sum += arr[j/100]; //i.e one
    	        sum += arr[100]; //i.e hundred
    	        if(j % 100 != 0){
    	            sum += and; // and 
    	        }
    	    }
    	    
    	    //You can enable the two code below to see the process.
    	    //System.out.println("[" + j +"] has -> " + (sum-previous) + " SUM: " + sum);
    	    //previous = sum; //algorithm for checking each number
        }
        
	    //last one, 1,000
	    if(input == 1000) sum += one_thousand;
	    //counting algorithm ends..
	    
	    //answer
	    System.out.println("Answer: " + sum);
	}
}





