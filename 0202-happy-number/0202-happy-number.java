class Solution {
    public boolean isHappy(int n) {
        int s=n;
        int f=n;
        do
        {
            s=digitSquare(s);
            f=digitSquare(digitSquare(f));

        }while(s!=f);
        if(s==1)
        {
            return true;
        }
        return false;
        
    }
    static int digitSquare(int num)
    {
        int ans=0;
        while(num>0)
        {
            int digit=num%10;
            ans+=digit*digit;
            num=num/10;
        }
        return ans;
    }
}