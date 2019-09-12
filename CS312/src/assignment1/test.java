package assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
	public static void main (String [] args)
    {
		int[][] A = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		int temp = maxIncreaseKeepingSkyline(A);
		System.out.println(temp);
    }
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topbottom = new int[grid[0].length];
        int[] leftright = new int[grid.length];
        int originsize = compute(grid);
        computeskyline(topbottom,leftright,grid);
        System.out.println(Arrays.toString(topbottom));
        System.out.println(Arrays.toString(leftright));
        int[][] result = new int[grid.length][grid[0].length];
        for (int i =0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(leftright[i]>topbottom[j]){
                    result[i][j] = topbottom[j];
                }
                else{
                    result[i][j] = leftright[i];
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        int resultsize = compute(result);
        return resultsize-originsize;
    }
    public static int compute(int[][] grid){
        int result = 0;
        for (int i =0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                result +=grid[i][j];
            }
        }
        return result;
    }
    public static void computeskyline(int[] topbottom, int[]leftright, int[][]grid){
        for (int i =0; i<grid.length; i++){
        	int maxl = 0;
            int max_ = 0;
            for (int j=0; j<grid[0].length; j++){
                if(max_<grid[i][j]){
                    max_ = grid[i][j];
                }
                if(maxl<grid[j][i]){
                    maxl = grid[j][i];
                }
            }
            topbottom[i]=maxl;
            leftright[i]=max_;
        }
    }
}
