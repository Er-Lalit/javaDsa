class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<aliceSizes.length;i++){
            sum1+=aliceSizes[i];
        }
        for(int i=0;i<bobSizes.length;i++){
            sum2+=bobSizes[i];
        }
        int ans[]=new int[2];
        // for(int i=0;i<aliceSizes.length;i++){
        //     for(int j=0;j<bobSizes.length;j++){
        //         if(sum1-aliceSizes[i]+bobSizes[j]==sum2-bobSizes[j]+aliceSizes[i]){
        //             ans[0]=aliceSizes[i];
        //             ans[1]=bobSizes[j];
        //             return ans;

        //         }
        //     }
        // }
        // return ans;
        int equalSum=(sum1+sum2)/2;
        int delta=(sum2-sum1)/2;
        HashSet<Integer> hs=new HashSet<>();
        for(int a:bobSizes){
            hs.add(a);
        }
        for(int i=0;i<aliceSizes.length;i++){
            int  value=aliceSizes[i];
            int difSumValue=sum1-value;
            int v1=equalSum-difSumValue;
            // if(difSumValue+v1==equalSum && hs.contains(v1)){
            //     ans[0]=value;
            //     ans[1]=v1;
            //     return ans;
            // }
            // or we can write that  
             if(hs.contains(delta+value)){
                ans[0]=value;
                ans[1]=delta+value;
                return ans;

            }
        }
return ans;
    }
}