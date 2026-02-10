class Solution {
    public void reverseString(char[] s) {
        reverseMethod(s,0,s.length-1);
        
    }
    static void reverseMethod(char[] arr,int start,int end)
    {
        if(start>=end)
        {
            return ;
        }
        char temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
         reverseMethod(arr,start+1,end-1);
    }
}