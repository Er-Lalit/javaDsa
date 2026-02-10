class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
        
    }
    static List<Integer> solve(String s)
    {
        List<Integer> result=new ArrayList();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='+'|| s.charAt(i)=='-' ||s.charAt(i)=='*')
            {
                List<Integer> leftL=solve(s.substring(0,i));
                List<Integer> rightL=solve(s.substring(i+1));

                for(int x: leftL)
                {
                    for(int y:rightL)
                    {
                        if(s.charAt(i)=='+')
                        {
                            result.add(x+y);
                        }
                        else if(s.charAt(i)=='-')
                        {
                            result.add(x-y);
                        }
                        else
                        {
                            result.add(x*y);
                        }
                    }
                }

            }
            
        }
        if(result.isEmpty())
        {
            result.add(Integer.parseInt(s));
        }
        return result;
    
    }
}