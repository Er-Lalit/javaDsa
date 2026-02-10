class Solution {
    public boolean checkIfExist(int[] arr) {
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr.length;j++){
        //         if(i==j){
        //             continue;
        //         }
        //       if(  arr[i]==2*arr[j]){
        //         return true;
        //       }
        //     }
        // }
        // return false;
        HashSet<Integer> hs=new HashSet<>();
        int zeroCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zeroCount++;
            }
            hs.add(arr[i]);

        }
        if(zeroCount>=2){
            return true;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && hs.contains(2*arr[i])){
                return true;
            }
        }
        return false;
    }
}