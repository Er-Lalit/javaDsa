class Solution {
    public int[] productExceptSelf(int[] arr) {
       // int ans[]=new int[nums.length];
        // for(int i=0;i<nums.length;i++){
        //     int product=1;
        //     for(int j=0;j<nums.length;j++)
        //     {
        //         if(i!=j){
        //             product*=nums[j];
        //         }
        //         ans[i]=product;
        //     }
        // }
        // return ans;
      //  int one[]=new int[2*nums.length];

    //    int prefix[]=new int[nums.length];
    //     int suffix[]=new int[nums.length];

        // prefix[0]=1;
        // this is the line form where we can start command 

        // one[0]=1;
        // for(int i=1;i<nums.length;i++){
        //     one[i]=one[i-1]*nums[i-1];
        // }
        // one[one.length-1]=1;
        // int k=nums.length-2;
        // for(int j=one.length-2;j>=nums.length;j--){
        //     one[j]=one[j+1]*nums[k+1];
        //     k--;
        // }
        // for(int i=0;i<nums.length;i++){
        //     int add=nums.length;
        //     ans[i]=one[i]*one[i+add];
        // }
        // return ans;
             int prefix[]=new int[arr.length];
        int sufix[]=new int[arr.length];
        prefix[0]=1;
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]*arr[i-1];
            System.out.println(prefix[i]);

        }
        sufix[sufix.length-1]=1;
         for(int i=sufix.length-2;i>=0;i--){
            sufix[i]=sufix[i+1]*arr[i+1];

        }
        int ans1[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans1[i]=prefix[i]*sufix[i];
            
        }
         return ans1;
    }
    }
