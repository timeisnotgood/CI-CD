package DataStructure;
import java.util.LinkedList;
import java.util.List;

/**
 * Disjointset
 */
public class Disjointset {

    List<Integer> parent = new LinkedList<>();
    List<Integer> size = new LinkedList<>();
    Disjointset(int n){
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUlParent(int node){
        if (node == parent.get(node)) {
            return parent.get(node);
        }

        int ulp = findUlParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public boolean isConnected(int u, int v){
        int ulp_u = findUlParent(u);
        int ulp_v = findUlParent(v);
        if (ulp_u == ulp_v){
            return true;  
        }else{
            return false;
        }
    }

    public void union(int u, int v){
        int ulp_u = findUlParent(u);
        int ulp_v = findUlParent(v);
        if (ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}