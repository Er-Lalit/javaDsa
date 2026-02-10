class Solution {
    public String minWindow(String s, String t) {
        int i=0;
        int j=0;
        int count=0;
        int sIndex=-1;
        int lIndex=-1;
        int minlen=Integer.MAX_VALUE;
        HashMap<Character,Integer> hs=new HashMap<>();
        for(int k=0;k<t.length();k++)
        {
            char key=t.charAt(k);
            if(hs.containsKey(key))
            {
               hs.put(key,hs.get(key)+1);

            }
            else
            {
                hs.put(key,1);
            }

        }
        while(j<s.length())
        {
            char jkey=s.charAt(j);
            if(hs.containsKey(jkey))
            {
             if( hs.get(jkey)>0)
             {
                count++;  
             }
             hs.put(jkey,hs.get(jkey)-1);
            }
           while(count==t.length())
           {
            if((j-i+1)<minlen){
             sIndex=i;
             lIndex=j;
             minlen=j-i+1;
            }
             char ikey=s.charAt(i);
             if( hs.containsKey(ikey))
             {
                hs.put(ikey,hs.get(ikey)+1);
                if(hs.get(ikey)>0)
                {
                    count--;
                }

             }
             i++;

            } 
            j++;
        }
        if(sIndex==-1 && lIndex==-1)
        {
            return "";
        }
        return s.substring(sIndex,lIndex+1);
    }
}