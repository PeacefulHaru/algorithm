
public class P19
{
    //Started on 5/10/19 Fri
    //Finished on 5/10/19 Fri 
    //Around 30 minutes (Stack 4h 30m)
    
    /*
    * Be careful with what the question is asking for.
    * This question does not require so much comment, since it is very simple.
    */
    
	public static void main(String[] args) {
		//input
		int start_yr = 1901;
		int start_month = 1;
		int start_date = 1;
		int day = 2; //0: Sunday 1: Monday and so on ...
		
		int end_yr = 2000; //This is where it ends
		int end_month = 12; //This is where it ends
		int end_date = 31; //This is where it ends
		
		//tools
		int num_of_sundays = 0; // Answer
		
	    //Algorithm Begins
	    while(true){
	        //count
	        if(start_date == 1 && day == 0){
	            //Sunday!
	            num_of_sundays++;
	        }
	        //Check to end the loop
	        if(start_yr == end_yr){
	            if(start_month == end_month){
	                if(start_date == end_date){
	                    break;
	                }
	            }
	        }
	        //next day
	        start_date++;
	        day++;
	        //Month Changing
	        if(start_date > howManyDays(start_yr, start_month)){
	            start_month++;
	            start_date = 1;
	            if(start_month > 12){
	                start_month = 1;
	                start_yr ++;
	            }
	        }
	        //Day Changing
	        if(day > 6){
	            day = 0;
	        }
	    }
	    //Algorithm Ends
		
		//Printing Answer
		System.out.println("Answer: " + num_of_sundays);
	}
	
	public static int howManyDays(int year, int month){
	    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
	        return 31;
	    }else{
	        if(month == 2){
	            if(year % 400 == 0){
        	        return 29;
        	    }else if(year % 4 == 0 && year % 100 != 0){
    	            return 29;
        	    }
        	    return 28;
	        }else{
	            return 30;
	        }
	    }
	}
}

