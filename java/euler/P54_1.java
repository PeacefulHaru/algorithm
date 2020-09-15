import java.io.*; //for reading file
import java.util.*; //for arrayList

//Started on 5/12/19 Sun from P054J-POKER
//Solved on 5/25/19 Sat
//Spent 14 days
//Difficulty Level 10%
    
/*
*This program's each algorithm has an assumption of pre-arranged array of cards
*I had a 5 days long train camp in the army so It is offcially took 9 days to Solve
*Many testing tools are used to find the logical error, which eventually led to the answer.
*I made it easier to compare by using integer value rather than string.
*/

public class P54_1
{
    
	    
	public static void main(String[] args) {
	    //input (You can test the range)
	    int begin_from = 1;
    	int read_until = 1000;
    	boolean testing = false; //This allows the printing mechanism
    	    
        //tools
    	String fileName = "P054J-POKER.txt";
    	int a_winning_count = 0;
    	
	    //read file
		ArrayList<String> al = readFile(fileName, begin_from, read_until);
		
		//Algorithm begins
		for(int i = 0 ; i < al.size(); i ++){
		    //Basic arranging the values read from text file
            String[] temp_arr = al.get(i).split(" ");
            int[] a = new int[5];
            int[] b = new int[5];
            for(int j = 0 ; j < 5 ; j++){
                a[j] = intger_converter(temp_arr[j]);
                b[j] = intger_converter(temp_arr[j+5]);
            }
            Arrays.sort(a); //pre-arranging (Very important)
	        Arrays.sort(b); //pre-arranging (Very important)
            
            //Testing
            if(testing){
                readCard(a);
                System.out.print(" || ");
                readCard(b);
            }
            
            //Testing Tool
            int temp_winning_count = a_winning_count;
            
            //Comparing
            int a_score = compare_tool(a, b, testing);
            int b_score = compare_tool(b, a, testing);
            
            //Scoring
            if(a_score % 10 > b_score % 10){
                //if A wins
                a_winning_count++;
            }else if(a_score % 10 < b_score % 10){
                //B Wins (Nothing happens)
            }else{
                //if ties
                if(a_score / 10 > b_score / 10){
                    //if A wins
                    a_winning_count++;
                }else{
                    //B Wins (Nothing happens)
                }
            }
            
            //Testing
            if(testing){
                if(temp_winning_count != a_winning_count){
                    System.out.println("A WON");
                }else{
                    System.out.println("B WON");
                }
            }
            
		}
		
		//Write the result
	    System.out.println("Answer: " + a_winning_count);	
	}
	
	public static int compare_tool(int[] a, int[] b, boolean testing){
	    if(isStraightFlush(a) > isStraightFlush(b)){
            //Straight Flush
            if(testing)
                System.out.print(" || STRAIGHT FLUSH "); //Testing
            return isStraightFlush(a) * 10 + 8;
        }else if(isFourKind(a) > isFourKind(b)){
            //four kind
            if(testing)
                System.out.print(" || FOUR KIND "); //Testing
            return isFourKind(a) * 10 + 2;
        }else if(isFullHouse(a) > isFullHouse(b)){
            //Full House
            if(testing)
                System.out.print(" || FULL HOUSE "); //Testing
            return isFullHouse(a) * 10 + 7;
        }else if(isFlush(a) > isFlush(b)){
            //Flush
            if(testing)
                System.out.print(" || FLUSH "); //Testing
            return isFlush(a) * 10 + 6;
        }else if(isStraight(a) > isStraight(b)){
            //Straight
            if(testing)
                System.out.print(" || STRAIGHT "); //Testing
            return isStraight(a) * 10 + 5;
        }else if(isThreeCard(a) > isThreeCard(b)){
            //Three card
            if(testing)
                System.out.print(" || THREE CARD "); //Testing
            return isThreeCard(a) * 10 + 4;
        }else if(isTwoPair(a) > isTwoPair(b)){
            //Two Pair
            if(testing)
                System.out.print(" || TWO PAIR "); //Testing
            return isTwoPair(a) * 10 + 3;
        }else if(isOnePair(a) > isOnePair(b)){
            //One Pair
            if(testing)
                System.out.print(" || ONE PAIR "); //Testing
            return isOnePair(a) * 10 + 2;
        }else if(isHighest(a) > isHighest(b)){
            //Highest
            if(testing)
                System.out.print(" || HIGHEST "); //Testing
            return isHighest(a) * 10 + 1;
        }
        
        return 0; 
            
	}
	
	//This was used for testing algorithm
	public static void readCard(int[] a){
        for(int i = 0 ; i < 5 ; i++){
            System.out.print(a[i] / 10);
            if(a[i] % 10 == 0){
                System.out.print("♤");
            }else if(a[i] % 10 == 1){
                System.out.print("♢");
            }else if(a[i] % 10 == 2){
                System.out.print("♥");
            }else{
                System.out.print("♧");
            }
            System.out.print(" ");
        }   
	}
        
    //Simple logic
    public static int isStraightFlush(int[] a){
        if(isStraight(a) > 0 && isFlush(a) > 0){
            return isHighest(a);
        }else{
            return 0;
        }
    } 
	
	//Simple logic
	public static int isHighest(int[] a){
	    return a[4] / 10;
	}
	
	public static int isOnePair(int[] a){
	    //Assuming All higher card is already checked
	    
	    //Simple algorithm with assumption
	    for(int i = 0 ; i < 4 ; i++){
	        if(a[i] / 10 == a[i+1] /10){
	            return a[i] / 10;
	        }
	    }
	    
	    //Returning (Failed the test)
	    return 0;
	    
	}
	
	public static int isTwoPair(int[] a){
	    //Assuming No Full House
	    
	    //tool
	    int different_count = 0;
	    int first_pair_val = 0;
	    int second_pair_val = 0;
	    
	    //Algorithm
	    for(int i = 0 ; i < 4 ; i++){
	        if(a[i] / 10 == a[i+1] / 10){
	            if(first_pair_val == 0){
	                first_pair_val = a[i+1] / 10;
	            }else if(a[i+1] / 10 != first_pair_val){
	                second_pair_val = a[i+1] / 10;
	            }
	        }else{
	            different_count++;
	        }
	        if(different_count > 2){
	            return 0;
	        }
	    }
	    
	    return second_pair_val * 100 + first_pair_val;
	}
	
	public static int isThreeCard(int[] a){
	    //Assuming that four card + Full house is already checked 
	    
	    //tool
	    // int checking_count = 0;

	    //Algorithm
	    for(int i = 0 ; i < 4 ; i++){
            int temp_count = 0;
            int last_position = 0;
	        for(int j = i + 1 ; j < 5 ; j ++){
	            if(a[i] / 10 == a[j] / 10){
	                temp_count++;
	                last_position = j;
	            }
	        }
	        if(temp_count == 2){
	            return a[last_position] / 10;
	        }
	    }
	    
	    //Returning, failed the test
	    return 0;
	}    
	    
	
	
	public static int isStraight(int[] a){
	    for(int i = 0 ; i < 4 ; i++){
	        if((a[i] / 10) + 1 != a[i+1] / 10){
	            return 0;
	        }
	    }
	    
	    //returning (The array has been tested to be correct + sending the highest value)
	    return (a[4] / 10);
	    
	}
	
	public static int isFlush(int[] a){
	    //tool
	    int fixed = a[0] % 10;
	    
	    //algorithm
	    for(int i = 1 ; i < 5 ; i++){
	        if(fixed != a[i] % 10){
	            return 0;
	        }
	    }
	    
	    //returns .. (Passed all tests + Returning higest card)
	    return a[4] / 10;
	}
	
	public static int isFullHouse(int[] a){
	    //Assumption that the int array is already sorted.
	    //Assuption four card has been already checked
        
        //tool 
        // int returning_value = a[4] / 10 * 100 + a[0] / 10;
        // int potential_three_card_position = 0;
        boolean flag = false;

        //Algorithm
        for(int i = 0 ; i < 4 ; i++){
            int a_int = a[i] / 10;
            int b_int = a[i+1] / 10;
            if(a_int != b_int){
                if(flag){
                    return 0;
                }
                flag = true;
            }
                
        }
        
        //returning value calculation (Medium Logic)
        if(a[2] / 10 == a[3] / 10){
            return a[4] / 10 * 100 + a[0] / 10;
        }else{
            return a[0] / 10 * 100 + a[4] / 10;
        }
        
        
	}
	
	public static int isFourKind(int[] a){
	    //if it has four kind, then it will send the highest value
	    //if not four kind then it will send 0
	    
	    //tool
	    int returning_value = 0;
	   
	    //algorithm
	    for(int i = 0 ; i < 2 ; i++){
	        int fixed_value = a[i] / 10;
	        int temp_count = 0;
	        for(int j = i + 1 ; j < 5; j++){
	            int temp_next_value = a[j] / 10;
	            if(fixed_value == temp_next_value){
	                temp_count++;
	            }
	        }
	        if(temp_count >= 3){
	            //Since it only needs three matches with the initial one (Medium Difficult Logic)
	            returning_value = fixed_value;
	        }
	    }
	    
	    //ends
	    return returning_value;
	}
	
	//TESTED & CORRECT on 5/25/19 #2
	//This is used for comparing value with integer
	public static int intger_converter(String temp_str){
	    //tool
	    int returning_value = 0;
	    
	    if(temp_str.charAt(0) == 'T'){
            returning_value = 100;
        }else if(temp_str.charAt(0) == 'J'){
            returning_value = 110;
        }else if(temp_str.charAt(0) == 'Q'){
            returning_value = 120;
        }else if(temp_str.charAt(0) == 'K'){
            returning_value = 130;
        }else if(temp_str.charAt(0) == 'A'){
            returning_value = 140;
        }else{
            returning_value = Character.getNumericValue(temp_str.charAt(0)) * 10;
        }
        
        if(temp_str.charAt(1) == 'S'){
            //Spade
            //I will say spade has teh value of 0 (Unchanged)
        }else if(temp_str.charAt(1) == 'D'){
            //Diamond
            returning_value += 1;
        }else if(temp_str.charAt(1) == 'H'){
            //Heart
            returning_value += 2;
        }else{
            //Clover
            returning_value += 3;
        }
        
        return returning_value;
	}
	
	//TESTED & CORRECT on 5/12/19 #1
	public static ArrayList<String> readFile(String fileName, int begin_from, int read_until){
	    //This text file reader code has been copied from web the modified for own
	    String line = null;
	    int cnt = 0; //counting tools 
	    ArrayList<String> al = new ArrayList<String>();
	    
	    try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(begin_from < cnt + 2){
                    //System.out.println(line);
                    if(cnt >= read_until){
                        break;
                    }
                    al.add(line);
                    
                }
                cnt++;
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	    
	    return al;
	}
}
