class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int len=fruits.length;
        int i=0;
        int j=0;
        int answer=0;
        while(j<len)
        {
            int rfruit=fruits[j];

            if(hs.containsKey(rfruit))
            {
                hs.put(rfruit,hs.get(rfruit)+1);
            }
            else
            {
                hs.put(rfruit,1);
            }
            if(hs.size()>2)
            {
                int lfruit=fruits[i];
                hs.put(lfruit,hs.get(lfruit)-1);
                if(hs.get(lfruit)==0)
                {
                    hs.remove(lfruit);
                }
                i++;
            }
            if(hs.size()<=2)
            {
                int size=j-i+1;
                answer=Math.max(size,answer);

            }
            j++;
        }
        return answer;
        
    }
}