import java.util.TreeSet;

class ExamRoom {
    int size=0;
    TreeSet<Integer> seats;

    public ExamRoom(int n) {
         size=n-1;
        seats=new TreeSet<>();

        
    }
    
    public int seat() {
        if(seats.isEmpty()){
            seats.add(0);
            return 0;
        }
        int index=0;
        int maxDistance=seats.first();
        int pre=-1;
        for(Integer curr:seats){
            if(pre!=-1){
                int d=(curr-pre)/2;
                if(d>maxDistance){
                    maxDistance=d;
                    index=pre+d;
                }

            }
            pre=curr;
        }
        if((size-seats.last())>maxDistance){
            index=size;
        }
        seats.add(index);
        return index;
    }
    
    public void leave(int p) {
        seats.remove(p);
        
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */