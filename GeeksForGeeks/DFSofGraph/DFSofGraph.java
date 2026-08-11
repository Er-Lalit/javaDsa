package GeeksForGeeks.DFSofGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSofGraph {

    class Solution {
        static ArrayList<Integer> result;

        public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

            Map<Integer, List<Integer>> mp = new HashMap();
            for (int u = 0; u < adj.size(); u++) {
                List<Integer> ls = new ArrayList();
                for (int v : adj.get(u)) {
                    ls.add(v);

                }
                mp.put(u, ls);
            }
            result = new ArrayList();
            boolean visited[] = new boolean[adj.size()];
            dfs(mp, visited, 0);
            return result;

        }

        static void dfs(Map<Integer, List<Integer>> mp, boolean visited[], int u) {
            if (visited[u] == true) {
                return;
            }
            visited[u] = true;
            result.add(u);
            for (int v : mp.get(u)) {
                if (!visited[v]) {
                    dfs(mp, visited, v);

                }
            }

        }
    }

}
