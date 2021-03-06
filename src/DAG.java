import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DAG {
    ArrayList<LinkedList<Integer>> graph;
    ArrayList<LinkedList<Integer>> parents;

    DAG(int size){
        graph = new ArrayList<>(size);
        parents = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            graph.set(i, new LinkedList<>());
            parents.set(i, new LinkedList<>());
        }
    }

    public void addEdge(int u, int v){
        graph.get(u).add(v);
        parents.get(v).add(u);
    }

    public ArrayList<Integer> findLCA(int u, int v) {
        if(u >= graph.size() || v >= graph.size() || u < 0 || v <0 || u == v) return null;
        ArrayList<Integer> lca = new ArrayList<>();
        int maxDist = Integer.MAX_VALUE;
        int uDist, vDist;
        for(int i = 0; i < graph.size(); i++)
        {
            if(isParent(i, v) && isParent(i, u))
            {
                uDist = getDistance(i, u);
                vDist = getDistance(i, v);
                if(Integer.max(uDist, vDist) < maxDist)
                {
                    lca = new ArrayList<>();
                    lca.add(i);
                    maxDist = Integer.max(uDist, vDist);
                }
                else if(Integer.max(uDist, vDist) == maxDist)
                {
                    lca.add(i);
                    maxDist = Integer.max(uDist, vDist);
                }
            }
        }
        if(lca.isEmpty()) return null;
        return lca;
    }

    private boolean isParent(int u, int v){
        if(graph.get(u).contains(v)) return true;
        for(int i: graph.get(u)){
            if(isParent(i,v)) return true;
        }
        return false;
    }

    private int getDistance(int u, int v){
        Queue<Integer> bfsQueue = new LinkedList<>();
        int[] distances = new int[graph.size()];
        if(u == v) return 0;
        else{
            bfsQueue.add(u);
            Arrays.fill(distances, -1);
            distances[u] = 0;
            while(!bfsQueue.isEmpty()){
                int i = bfsQueue.remove();
                for(int j: graph.get(i)){
                    if(distances[j] == -1) {
                        bfsQueue.add(j);
                        distances[j] = distances[i] + 1;
                    }
                }
            }
            return distances[v];
        }
    }

}
