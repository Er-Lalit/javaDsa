package GeeksForGeeks;

import java.util.ArrayList;

public class GrayCode {

    class Solution {
    public ArrayList<String> graycode(int n) {
      return  solve(n);
        
         
    }
    static ArrayList<String> solve(int n)
    {
        
        if(n==1)
        {
            ArrayList<String> ans=new ArrayList<>();
            ans.add("0");
            ans.add("1");
            return ans;
            
        }
        
        ArrayList<String> list=solve(n-1);
        ArrayList<String> result=new ArrayList<>();
        
        for(int i=0;i<list.size();i++)
        {
            String s=list.get(i);
            result.add("0"+s);
            
        }
        for(int i=list.size()-1;i>=0;i--)
        {
            String s=list.get(i);
            result.add("1"+s);
            
        }
        return result;
        
    }
}
    
}
