class Solution {
    public long countCommas(long num) {
        if(num<=999)
        {
            return 0;
        }
        long ans=0;
        if(num>999999)
        {
            ans+=999999-1000+1;
        }
        else
        {
            return ans+=num-1000+1;
        }
        if(num>999999999)
        {
            ans+=2*(999999999-1000000+1);
        }
        else
        {
            return ans+=2*(num-1000000+1);
        }
        if(num>999999999999L)
        {
            ans+=3*(999999999999L-1000000000L+1);
        }
        else
        {
            return ans+=3*(num-1000000000L+1);
        }


        ans+=(4*(num-1000000000000L+1));
        if(num==1000000000000000L)
        {
            ans+=1;
        }
        return ans;
    }
}