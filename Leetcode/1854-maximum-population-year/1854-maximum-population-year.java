class Solution {
    public int maximumPopulation(int[][] logs) {
        int year[]=new int[101];
        for(int i=0;i<logs.length;i++){
            int birth=logs[i][0]-1950;
            int death=logs[i][1]-1950;
           year[birth]++;
           year[death]--;
        }
        // now we count the prefix sum
        for(int i=1;i<year.length;i++){
            year[i]=year[i]+year[i-1];
        }
        int max=0;
        int index=-1;
        for(int i=0;i<year.length;i++){
            if(year[i]>max){
                max=Math.max(year[i],max);
                index=i;
            }

        }
        return 1950+index;
        
    }
}