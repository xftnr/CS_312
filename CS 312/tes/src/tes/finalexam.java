package tes;

import java.util.Random;

public class finalexam {
	private Random randNumGen = new Random();
	
	
	public static int clickerPoints (String answers, String responses) {//fall15 4
		int score= 0;
		int countcorrect = 0;
		int countwrong = 0;
		for (int i= 0 ; i < answers.length(); i++){
			if (answers.charAt(i)== responses.charAt(i)){
				score +=5;
				countcorrect++;
				
			}
			else if (answers.charAt(i)=='*'){
				score +=5;
				countcorrect++;
		//��������Ѿ�else if����ô���滹�費��Ҫ��벿�ֵ�����		
			}
			else if (responses.charAt(i) != '-' /*&& answers.charAt(i) !='*'*/){
				score +=2;
				countwrong ++;
				
			}
			
		}
		if ((countcorrect + countwrong) == answers.length()){
			score +=5;
		}
		if (((double)countcorrect/answers.length()) > 0.8){
			score +=10;
		}
	}
	public static int insert(int[] data, int newValue) {//5
		//int[] result = new int[data.length];
		//int count = 0;
		//for (int i =0 ; i < data.length; i ++){

			//if (data[i] > newValue && count <1){
			//	result[i]= newValue;
			//	count ++;
		//	}
		//	else result[i] = data[i];
			
		//}
		//data[data.length]= newValue;
		return data[data.length];
	}
	public static int longestRunLength(String[] strs, char target) { 
		int count = 0;
		
		for (int i =0; i < strs.length-1; i++){
			if (strs[i]!= null){
				for (int j=0; j< strs[i].length();j++){
					if (strs[i].indexOf(target)>-1 ){
						count =1;
					}
				}
				for (int k = 1; k< strs.length - i;k++){
					if (strs[i+k].indexOf(target)>-1){
						count++;
					}
				}
			}
		}
		return count;
	}
	//public static double averageOfNeighborhood(int[][] mat,int cenRow, int cenCol, int rows, int cols) {
		//int disrow = cenRow - rows;
		//int dis
		//for()
		//for (int i =0 ; i<)
	}
	
}
