class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lb=0;
        int ub=letters.length-1;
        int position=-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(letters[mid]<=target){
                lb=mid+1;
            }
            else{
               ub=mid-1;
               position=mid;
            }
        }
      // return letters[lb % letters.length];
      if(position!=-1){
        return letters[position];
      }
      else{
        return letters[0];
      }
    }
}