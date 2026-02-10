import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ll=new ArrayList<>();
        int greater=0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>greater){
                greater=candies[i];
            }
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=greater){
                ll.add(true);
            }
            else{
                ll.add(false);
            }
        }
        return ll;
    }
}