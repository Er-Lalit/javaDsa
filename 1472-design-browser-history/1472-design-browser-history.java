class BrowserHistory {
    Stack<String> past;
    Stack<String> future;
    String curr;

    public BrowserHistory(String homepage) {
        past=new Stack();
        future=new Stack();
        past.push(homepage);
        curr=homepage;
        
    }
    
    public void visit(String url) {
        if(!future.isEmpty())
        {
            future.clear();
        }
        past.push(url);
        curr=url;
        
    }
    
    public String back(int steps) {
        while(steps>0 && past.size()>1)
        {
            
            future.push(past.pop());
            steps--;
        }
        return curr=past.peek();
        
    }
    
    public String forward(int steps) {
        if(future.isEmpty())
        {
            return curr;
        }
        while(steps>0 && !future.isEmpty())
        {
            curr=future.pop();
            past.push(curr);
            steps--;
           
        }
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */