class Solution {
  public int maxValue(int n, int index, int maxSum) { 
    long lb=1;
    long ub=maxSum;
    long result=0;
    while(lb<=ub){
        long mid=lb+(ub-lb)/2;
        long leftCount=Math.min(index,mid-1);
        long leftSum=formula(leftCount,mid);
        leftSum+=Math.max(0,index-(mid-1));
        long rightCount=Math.min(n-index-1,mid-1);
        long rightSum=formula(rightCount,mid);
         rightSum+=Math.max(0,(n - 1 - index)-(mid-1));
        long totalSum=leftSum+rightSum+mid;
        if(totalSum<=maxSum){
            result=Math.max(mid,result);
            lb=mid+1;

        }
        else{
            ub=mid-1;
        }
    }
 return (int)result;
    }
  static long formula(long count,long x){
    long result=count*x-((count*(count+1))/2);
    return result;

  }
}

