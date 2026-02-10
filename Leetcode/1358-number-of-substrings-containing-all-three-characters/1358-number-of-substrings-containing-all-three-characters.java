class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> lastseen=new HashMap<>();
        lastseen.put('a',-1);
        lastseen.put('b',-1);
        lastseen.put('c',-1);
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            lastseen.put(c,i);
            if(lastseen.get('a')!=-1 && lastseen.get('b')!=-1 && lastseen.get('c')!=-1)
            {
                int value=Math.min(Math.min(lastseen.get('a'),lastseen.get('b')),lastseen.get('c'));
                count+=value+1;

            }
            

        }
         return count;
    }
    
}