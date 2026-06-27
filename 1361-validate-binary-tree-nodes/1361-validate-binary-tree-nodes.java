class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> c_To_P = new HashMap<>();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int node = i;
            int leftc = leftChild[i];
            int rightc = rightChild[i];
            if (leftc != -1) {
                if (!adj.containsKey(node)) {
                    adj.put(node, new ArrayList<>());
                }
                adj.get(node).add(leftc);

                if (c_To_P.containsKey(leftc)) {
                    return false;
                }
                c_To_P.put(leftc, node);
            }
            if (rightc != -1) {
                if (!adj.containsKey(node)) {
                    adj.put(node, new ArrayList<>());
                }
                adj.get(node).add(rightc);
                if (c_To_P.containsKey(rightc)) {
                    return false;
                }
                c_To_P.put(rightc, node);
            }
        }
        // here i am try to check that did there is only one root or not 
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (!c_To_P.containsKey(i)) {
                if (root != -1)
                    return false;

                root = i;
            }
        }

        if (root == -1)
        {
            return false;
        }    
        // find did all node are connected or not 
        int N = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[]=new boolean[n];
        q.offer(root);
        visited[root]=true;
        while (!q.isEmpty()) {
            int node = q.poll();
            N += 1;
            List<Integer> ls = adj.get(node);
            if(ls==null)
            {
                continue;
            }
            for (int i : ls) {
                if(visited[i])
                {
                   return false;
                }
                visited[i]=true;
                q.offer(i);
                
            }
        }
        if (n == N) {
            return true;
        } else {
            return false;
        }
    }
}