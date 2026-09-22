class LockingTree {
    static int lockedBy[];
    static int parent[];
    static ArrayList<Integer>[] children;

    public LockingTree(int[] parent) {
        lockedBy=new int[parent.length];
        this.parent=parent;
        Arrays.fill(lockedBy,-1);
        children=new ArrayList[parent.length]; 
        for(int i=0;i<parent.length;i++)
        {
            children[i]=new ArrayList<>();
        }   

        for(int i=1;i<parent.length;i++)
        {
            children[parent[i]].add(i);
             
        }
    }
    
    public boolean lock(int num, int user) {
        if(lockedBy[num]!=-1)
        {
            return false;
        }

        lockedBy[num]=user;
        return true;

        
    }
    
    public boolean unlock(int num, int user) {
        if(lockedBy[num]!=user)
        {
            return false;
        }
        lockedBy[num]=-1;
        return true;
        
    }
    
    public boolean upgrade(int num, int user) {
        // three conditions for the upgrade 
        // 1. check the is unlock 
        if(lockedBy[num]!=-1)
        {
            return false;
        }
        //2. Check if there is at least one locked descendant

        if(!checkDescendant(num))
        {
            return false;
        }

        // 3. check that the ancestor does't have 

        int curr=parent[num];
        while(curr!=-1)
        {
            if(lockedBy[curr]!=-1)
            {
                return false;
            }
            curr=parent[curr];
        }

        // now unlocked all the locked node

        unlockDescendant(num);

        //lock current node

        lockedBy[num]=user;

        return true;
        

        
    }

    // check descendant method 
    static boolean checkDescendant(int num)
    {
        for(int child:children[num])
        {
            if(lockedBy[child]!=-1)
            {
                return true;
            }

            if(checkDescendant(child))
            {
                return true;
            }
        }
        return false;
    }

    // unlock all decsendant

    static void unlockDescendant(int num)
    {
        for(int child:children[num])
        {
            lockedBy[child]=-1;

            unlockDescendant(child);

        }
    }



    
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */