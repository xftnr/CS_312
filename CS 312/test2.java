import java.util.Random;

public class test2 {
	public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
    	int result = 0;
        if (numPeople <= 0 || numDaysInYear <= 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople + 
                    ", numDaysInYear: " + numDaysInYear);     
        //CS314 STUDENTS: ADD YOUR CODE HERE
        Random r = new Random();
        
        int[] dayslist = new int[numPeople];
        int[] countshares = new int[numDaysInYear];
        for(int i=0;i< numPeople ;i++){
        	dayslist[i] = r.nextInt(numDaysInYear);
        	countshares[dayslist[i]]++;
        }
        for (int i =0; i<numDaysInYear; i++){
        	if (countshares[i]>1){
        		for(int j=countshares[i]-1; j>0; j--){
        			result +=j;
        		}
        	}
        }
        return result;
	}
	public static void experiments2(){
    	//int total=0;
    	int count=0;
    	for(int i=2; i<101;i++){
    		for(int j=0; j<50000; j++){
    			if (sharedBirthdays(i, 365)>0){
    			    count++;
    			 }
    		}
    		double x=(double)count/50000;
    		System.out.print("Num people: "+i+", number of experiments with one or more shared birthday: "+count+", percentage: ");
    		System.out.printf( "%.2f\n",x*100);
    		count = 0;
    	}
    }
    
    
}