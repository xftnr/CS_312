
public class finalReview
{
    public static boolean alternateSigns(int[] data){
        int count = 0;
        if (data.length<=1){
            return true;
        }
        else {
            for (int i = 0; i < data.length - 1; i ++){
                if (!((data[i] > 0 && data [ i +1] <0)||data[i] <0 && data[i+1]>0)){
                    return false;
                }
            }
            return true;
        }
    }
}
