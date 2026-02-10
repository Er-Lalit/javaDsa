class Solution {
    public int numTilePossibilities(String tiles) {
        // this is for brutforce approach
        // Stack<Character> st=new Stack<>();
        // Set<String> result=new HashSet<>();
        // boolean arr[]=new boolean[tiles.length()];
        // solve(tiles,arr," ",result);
        // return result.size()-1;
        int freq[]=new int[26];
        for(int i=0;i<tiles.length();i++)
        {
            freq[tiles.charAt(i)-'A']++;
        }
        return solve(freq);
        
    }
    // this was a brut force approach
    // static void solve(String s,boolean arr[],String u,Set<String> result)
    // {
    //     if(result.contains(u))
    //     {
    //         return;
    //     }
    //     result.add(u);
    //     for(int i=0;i<s.length();i++)
    //     {
    //         if(arr[i]==true)
    //         {
    //             continue;
    //         }
    //         arr[i]=true;
    //         solve(s, arr,u+s.charAt(i),result);
    //         arr[i]=false;           


    //     }

    // }
    // this is the optimal approach
    static int solve(int [] freq)
    {
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(freq[i]==0)
            {
                continue;
            }
            count++;
            freq[i]--;
            count+=solve(freq);
            freq[i]++;

        }
        return count;
    }
}