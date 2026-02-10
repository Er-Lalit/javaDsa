
class Solution {
    public int lengthOfLongestSubstring(String s) {
      int l=0;
      int r=0;
      int n=s.length();
      int ans=0;
      int hash[]=new int[256];
      for(int i=0;i<hash.length;i++)
      {
         hash[i]=-1;
      }
      while(r<n)
      {
         if(hash[s.charAt(r)]!=-1)
         {
            if(l<=hash[s.charAt(r)])
            {
                l=hash[s.charAt(r)]+1;
            }
         }
         int length=r-l+1;
         hash[s.charAt(r)]=r;
         r++;
         ans=Math.max(length,ans);

        }
        return ans;
    }
}