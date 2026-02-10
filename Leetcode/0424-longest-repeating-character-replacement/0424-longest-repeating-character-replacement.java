class Solution {
    public int characterReplacement(String s, int k) {
        int maxlength=0;
    //     this was the brutforce solution
    //     
    //    for(int i=0;i<s.length();i++)
    //    {
    //     HashMap<Character,Integer> hs=new HashMap<>();
    //     for(int j=i;j<s.length();j++)
    //     {
    //         char ch=s.charAt(j);
    //         if(hs.containsKey(ch))
    //         {
    //             hs.put(ch,hs.get(ch)+1);
    //         }
    //         else
    //         {
    //             hs.put(ch,1);
    //         }
    //         int maxfreq=Collections.max(hs.values());
    //         int change=(j-i+1)-maxfreq;
    //         if(change<=k){
    //             maxlength=Math.max(j-i+1,maxlength);
                
    //         }
    //         else
    //         {
    //             break;
    //         }
    //     }
    //    }
    //
    //   return maxlength;
    //from here the optimal solution is start
    HashMap<Character,Integer> hs=new HashMap<>();
    int i=0;
    int j=0;
    while(j<s.length())
    {
        char ch=s.charAt(j);
        if(hs.containsKey(ch))
        {
            hs.put(ch,hs.get(ch)+1);
        }
        else
        {
            hs.put(ch,1);
        }
        int maxfreq=Collections.max(hs.values());
        int change=(j-i+1)-maxfreq;
        if(change>k)
        {
            char ich=s.charAt(i);
            hs.put(ich,hs.get(ich)-1);
            if(hs.get(ich)==0)
            {
                hs.remove(ich);
            }
            i++;
        }
        if(change<=k)
        {
        maxlength=Math.max(j-i+1,maxlength);
        }
        j++;
    }
    return maxlength;

   }

}