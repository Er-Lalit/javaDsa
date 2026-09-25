class Solution {
    public boolean isValidSerialization(String preorder) {
        int freq=1;
        for(int i=0;i<preorder.length();)
        {
            if(preorder.charAt(i)==',')
            {
                i++;
                continue;
            }
            else if(preorder.charAt(i)=='#')
            {
                freq=freq-1;
                if(freq<0)
                {
                    return false;
                }
                i++;
            }
            else
            {
                while(i<preorder.length() &&Character.isDigit(preorder.charAt(i)))
                {
                    i++;
                }
                if(freq-1<0)
                {
                    return false;
                }
                freq=freq-1+2;
                
            }
        }
        return freq == 0 ? true : false;
        
    }
    
}