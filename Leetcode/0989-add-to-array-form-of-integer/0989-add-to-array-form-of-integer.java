import java.util.*;
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ll=new ArrayList();
        int len=num.length-1;
        int add=0;
        int carry=0;
        int result=0;
        int i=len;

       while(i>=0 || k>0){
             int v1=0;
        int v2=0;
        if(i>=0){
        v1=num[i];
        i--;
        }
        if(k!=0){
            v2=k%10;
            k=k/10;
        }
        add=v1+v2+carry;
        carry=(int)add/10;
        result=(int)add%10;
        ll.add(result);



        }
        if(carry!=0){
            ll.add(carry);
        }
       
        Collections.reverse(ll);
        return ll;
    }
}