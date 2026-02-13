class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> number=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            fact*=i;
            number.add(i);

        }
        number.add(n);
        k=k-1;
        StringBuilder sb=new StringBuilder();
        while(true)
        {
            sb.append(number.get(k/fact));
            number.remove(k/fact);
            if(number.isEmpty())
            {
                break;
            }        
            k=k%fact;
            fact=fact/number.size();    
        }
        return sb.toString();

        
    }

}