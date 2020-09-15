import java.io.*; //for reading file
import java.util.*; //for arrayList


public class P54_2
{
    //Written on 5/12/19 Sun
    //Moved to P054J-POKER2
    //Some of these codes are logically wrong.
    
    
    //Logically correct.
	public static void main(String[] args) {
	    //input
	    int read_until = 1005;
	    
	    //tools
	    String fileName = "P054J-POKER.txt";
	    int player_one_wins_this_many = 0;
	    
	    //read file
	    ArrayList<String> al = readFile(fileName, read_until);
	        
        //Repeat
	    for(int i = 0 ; i < al.size(); i ++){
	        System.out.print("#" + (i+1)+ " ");
	        //distributing
	        String temp = al.get(i);
	        String[] temp_arr = temp.split(" ");
	        String[] a = new String[5];
	        String[] b = new String[5];
	        for(int j = 0 ; j < 5 ; j++){
	            a[j] = temp_arr[j];
	            b[j] = temp_arr[j+5];
	        }
	        
	        //Check
	        if(compareHand(a, b)){
	            player_one_wins_this_many++;
	            System.out.println("P1 wins ");
	        }else{
	            System.out.println("P2 wins");
	        }
        }
        System.out.println("Answer: " + player_one_wins_this_many);
	    
	}
	
	
	
	public static boolean compareHand(String[] a, String[] b){
	    //if a wins, it returns true, else false.
	    
	    int a_point = 0;
	    if(isStraight(a) && isFlush(a)){
	        //Straight Flush
	        a_point = 8;
	    }else if(isFourKinds(a)){
	        //Four Kinds
	        a_point = 7;
	    }else if(isThreeCards(a) && isOnePair(a)){
	        //Full House
	        a_point = 6;
	    }else if(isFlush(a)){
	        //Flush
	        a_point = 5;
	    }else if(isStraight(a)){
	        //Straight
	        a_point = 4;
	    }else if(isThreeCards(a)){
	        //Three Cards
	        a_point = 3;
	    }else if(isTwoPair(a)){
	        //Two pair
	        a_point = 2;
	    }else if(isOnePair(a)){
	        //One pair
	        a_point = 1;
	    }
	    
	    int b_point = 0;
	    if(isStraight(b) && isFlush(b)){
	        //Straight Flush
	        b_point = 8;
	    }else if(isFourKinds(b)){
	        //Four Kinds
	        b_point = 7;
	    }else if(isThreeCards(b) && isOnePair(b)){
	        //Full House
	        b_point = 6;
	    }else if(isFlush(b)){
	        //Flush
	        b_point = 5;
	    }else if(isStraight(b)){
	        //Straight
	        b_point = 4;
	    }else if(isThreeCards(b)){
	        //Three Cards
	        b_point = 3;
	    }else if(isTwoPair(b)){
	        //Two pair
	        b_point = 2;
	    }else if(isOnePair(b)){
	        //One pair
	        b_point = 1;
	    }
	    
	    System.out.print("P1: " + a_point + " || P2: "+ b_point + " => ");
	    
	    
	    if(a_point > b_point){
	        return true;
	    }else if (a_point == b_point){
	        if(highestCard(a, b)){
	            return true;
	        }else{
	            return false;
	        }
	    }else{
	        return false;
	    }
	    
	    
	}
	
	public static boolean highestCard(String[] a, String[] b){
	    //true means a is bigger, else otherwise.
	    
	    int arr_a[] = new int[5];
	    int arr_b[] = new int[5];

	    for(int i = 0 ; i < 5 ; i++){
	        if(a[i].charAt(0) == 'T'){
	            arr_a[i] = 10;
	        }else if(a[i].charAt(0) == 'J'){
	            arr_a[i] = 11;
	        }else if(a[i].charAt(0) == 'Q'){
	            arr_a[i] = 12;
	        }else if(a[i].charAt(0) == 'K'){
	            arr_a[i] = 13;
	        }else if(a[i].charAt(0) == 'A'){
	            arr_a[i] = 14;
	        }else{
	            arr_a[i] = Integer.valueOf(String.valueOf(a[i].charAt(0)));
	        }
	        
	    }
	    
	    for(int i = 0 ; i < 5 ; i++){
	        if(b[i].charAt(0) == 'T'){
	            arr_b[i] = 10;
	        }else if(b[i].charAt(0) == 'J'){
	            arr_b[i] = 11;
	        }else if(b[i].charAt(0) == 'Q'){
	            arr_b[i] = 12;
	        }else if(b[i].charAt(0) == 'K'){
	            arr_b[i] = 13;
	        }else if(b[i].charAt(0) == 'A'){
	            arr_b[i] = 14;
	        }else{
	            arr_b[i] = Integer.valueOf(String.valueOf(b[i].charAt(0)));
	        }
	        
	    }
	    
	    Arrays.sort(arr_a);
	    Arrays.sort(arr_b);
	    
	    for(int i = 4 ; i >= 0 ; i--){
	        if(arr_a[i] > arr_b[i]){
	            return true;
	        }else if(arr_a[i] < arr_b[i]){
	            return false;
	        }
	    }
	    
	    return false; //This should not happen with the problem logic mentioned.
	}
	
	public static boolean isOnePair(String[] a){
	    //As long as it has one pair, it will be considered true
	    //Unless it is three cards
	    
	    int arr[] = new int[5];
	    for(int i = 0 ; i < 5 ; i++){
	        if(a[i].charAt(0) == 'T'){
	            arr[i] = 10;
	        }else if(a[i].charAt(0) == 'J'){
	            arr[i] = 11;
	        }else if(a[i].charAt(0) == 'Q'){
	            arr[i] = 12;
	        }else if(a[i].charAt(0) == 'K'){
	            arr[i] = 13;
	        }else if(a[i].charAt(0) == 'A'){
	            arr[i] = 14;
	        }else{
	            arr[i] = Integer.valueOf(String.valueOf(a[i].charAt(0)));
	        }
	    } 
	    
	    for(int i = 0 ; i < 4 ; i++){
	        int cnt = 0;
	        for(int j = i + 1 ; j < 5 ; j++){
	            if(arr[i] == arr[j]){
	                cnt++;
	            }
	        }
	        if(cnt > 1){
	            return false;
	        }else if (cnt == 1){
	            return true;
	        }
	    }
	    
	    return false; //Failed the test
	}
	
	//TESTED & CORRECT on 5/19/19 #6
	public static boolean isTwoPair(String[] a){
	    int temp = 0; //Tool
	    
	    int arr[] = new int[5];
	    for(int i = 0 ; i < 5 ; i++){
	        if(a[i].charAt(0) == 'T'){
	            arr[i] = 10;
	        }else if(a[i].charAt(0) == 'J'){
	            arr[i] = 11;
	        }else if(a[i].charAt(0) == 'Q'){
	            arr[i] = 12;
	        }else if(a[i].charAt(0) == 'K'){
	            arr[i] = 13;
	        }else if(a[i].charAt(0) == 'A'){
	            arr[i] = 14;
	        }else{
	            arr[i] = Integer.valueOf(String.valueOf(a[i].charAt(0)));
	        }
	    } 
	    for(int i = 0 ; i < 4 ; i++){
	        int fixed = arr[i];
	        
	        int cnt = 0;
	        for(int j = i + 1 ; j < 5 ; j++){
	            if(fixed == arr[j]){
	                cnt++;
	            }
	        }
	        
	        if(cnt == 1){
	            if(temp == 1){
	                //Two pairs detected.
	                return true;
	            }else{
	                //One pair or three cards detected
	                temp = 1;
	            }
	            
	        }else if (cnt > 1){
	            return false;
	        }
	    }
	    
	    return false; // Test failed 
	        
	    
	}
	
	//TESTED & CORRECT on 5/19/19 #5
	public static boolean isThreeCards(String[] a){
	    //This does not make four card or two card etc three cards.
	    int arr[] = new int[5];
	    for(int i = 0 ; i < 5 ; i++){
	        if(a[i].charAt(0) == 'T'){
	            arr[i] = 10;
	        }else if(a[i].charAt(0) == 'J'){
	            arr[i] = 11;
	        }else if(a[i].charAt(0) == 'Q'){
	            arr[i] = 12;
	        }else if(a[i].charAt(0) == 'K'){
	            arr[i] = 13;
	        }else if(a[i].charAt(0) == 'A'){
	            arr[i] = 14;
	        }else{
	            arr[i] = Integer.valueOf(String.valueOf(a[i].charAt(0)));
	        }
	    }
	    
	    for(int i = 0 ; i < 3 ; i++){
	        int fixed = arr[i];
	        int cnt = 0;
	        for(int j = i + 1 ; j < 5 ; j++){
	            if(fixed == arr[j]){
	                cnt++;
	            }
	        }
	        if(cnt == 2){
	            return true;
	        }
	    }
	    
	    return false; //Since it failed the test!
	}
	
	//TESTED & CORRECT on 5/19/19 #4
	public static boolean isStraight(String[] a){
	    int arr[] = new int[5];
	    for(int i = 0 ; i < 5 ; i++){
	        if(a[i].charAt(0) == 'T'){
	            arr[i] = 10;
	        }else if(a[i].charAt(0) == 'J'){
	            arr[i] = 11;
	        }else if(a[i].charAt(0) == 'Q'){
	            arr[i] = 12;
	        }else if(a[i].charAt(0) == 'K'){
	            arr[i] = 13;
	        }else if(a[i].charAt(0) == 'A'){
	            arr[i] = 14;
	        }else{
	            arr[i] = Integer.valueOf(String.valueOf(a[i].charAt(0)));
	        }
	    }
	    
	    //Sorting
	    Arrays.sort(arr);
	    
	    //Checking
	    int temp_val = arr[0];
	    for(int i = 1 ; i < 5 ; i++){
	        if(arr[i] != temp_val + 1){
	            //Not straight
	            return false;
	        }else{
	            temp_val = arr[i];
	        }
	    }
	    
	    return true; //Since it passed all checking
	}
	
	//TESTED & CORRECT on 5/19/19 #3
	public static boolean isFlush(String[] a){
	    //if not flush, then it returns 0, else it returns 1
	    
	    char fixed = a[0].charAt(1); //Inexplainable, yet simple logic.
	    
	    for(int i = 1 ; i < 5 ; i++){
	        if(a[i].charAt(1) != fixed){
	            //Different!
	            return false;
	        }else{
	            //Same! Stay here.. 
	        }
	    }
	    
	    return true; //Since it passed all the requirements!
	}
	
	//TESTED & CORRECT on 5/12/19 #2
	public static int isFourKinds (String[] a){
	    //if not fourkind, then it returns 0, else it returns the value.
	    
	    int arr[] = new int[5];
	    for(int i = 0 ; i < 5 ; i++){
	        if(a[i].charAt(0) == 'T'){
	            arr[i] = 10;
	        }else if(a[i].charAt(0) == 'J'){
	            arr[i] = 11;
	        }else if(a[i].charAt(0) == 'Q'){
	            arr[i] = 12;
	        }else if(a[i].charAt(0) == 'K'){
	            arr[i] = 13;
	        }else if(a[i].charAt(0) == 'A'){
	            arr[i] = 14;
	        }else{
	            arr[i] = Integer.valueOf(String.valueOf(a[i].charAt(0)));
	        }
	    }
	    
	    for(int i = 0 ; i < 2 ; i++){
	        int stack = 0;
	        int current_value = arr[i];
	        for(int j = i + 1; j < 5 ; j++){
	            if(arr[i] == arr[j]){
	                stack++;
	            }
	            if(stack >= 3){
	                return current_value;
	            }
	        }
	    }
	    
	    return 0; //failed the test
	}
	
	//TESTED & CORRECT on 5/12/19 #1
	public static ArrayList<String> readFile(String fileName, int read_until){
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
                //System.out.println(line);
                if(cnt >= read_until){
                    break;
                }
                al.add(line);
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