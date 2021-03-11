

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] ==1){
                    uf.union(i, j);
                }
            }            
        }
        return uf.count;
    }
    class UnionFind {
        private int count;

        private int[] parent;

        public UnionFind(int n){
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int rootp = find(p);
            int rootq = find(q);
            if (rootp == rootq){return;};
            parent[rootp] = rootq;
            count--;
        }
    }
}
