class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> set=new HashSet<>(Arrays.asList(words));
        Map<String,Boolean> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            if(isConcatinate(words[i],set,map))
            {
                ans.add(words[i]);
            }
        }
        return ans;

    }
    static boolean isConcatinate(String word,Set<String> set,Map<String,Boolean> map)
    {
        if(map.containsKey(word))
        {
            return map.get(word);
        }
        for(int i=0;i<word.length();i++)
        {
            String prefix=word.substring(0,i+1);
            String sufix=word.substring(i+1,word.length());
            if(set.contains(prefix) && set.contains(sufix) || set.contains(prefix) && isConcatinate(sufix,set,map))
            {
                map.put(word,true);
                return true;
            }
        }
        map.put(word,false);
        return false;
    }

   
}