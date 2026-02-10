class Solution {
    public int countPrimes(int n) {
        List<Boolean> list=new ArrayList<>(Collections.nCopies(n+1,true));
        // for(int i=0;i<=n;i++){
        //     list.add(true);
        // }
        int count=0;
        for(int i=2;i<n;i++){
            if(list.get(i)){
                count++;
                for(int j=i*2;j<n;j=j+i){
                    list.set(j,false);
                }
            }
        }
        return count;
        
    }
}