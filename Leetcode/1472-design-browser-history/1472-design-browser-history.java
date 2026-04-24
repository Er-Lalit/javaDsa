// this implement using the stack 
// class BrowserHistory {
//     Stack<String> past;
//     Stack<String> future;
//     String curr;

//     public BrowserHistory(String homepage) {
//         past=new Stack();
//         future=new Stack();
//         past.push(homepage);
//         curr=homepage;
        
//     }
    
//     public void visit(String url) {
//         if(!future.isEmpty())
//         {
//             future.clear();
//         }
//         past.push(url);
//         curr=url;
        
//     }
    
//     public String back(int steps) {
//         while(steps>0 && past.size()>1)
//         {
            
//             future.push(past.pop());
//             steps--;
//         }
//         return curr=past.peek();
        
//     }
    
//     public String forward(int steps) {
//         if(future.isEmpty())
//         {
//             return curr;
//         }
//         while(steps>0 && !future.isEmpty())
//         {
//             curr=future.pop();
//             past.push(curr);
//             steps--;
           
//         }
//         return curr;
//     }
// }

// try to implement using the doulbly linkedlist 


class BrowserHistory {
    Node head;
    Node curr;
    private class Node
    {
        Node prev;
        Node next;
        String url;
        Node(String url)
        {
            this.url=url;
        }

    }
    

    public BrowserHistory(String homepage) {
        Node node=new Node(homepage);
        head=node;
        curr=node;
       
    }
    
    public void visit(String url) {
        Node node=new Node(url);
        curr.next=node;
        node.prev=curr;
        curr=curr.next;

       
        
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps>0)
        {
            curr=curr.prev;
            steps--;
        }
        return curr.url;
        
        
        
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps>0)
        {
            curr=curr.next;
            steps--;
        }
        return curr.url;
       
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */