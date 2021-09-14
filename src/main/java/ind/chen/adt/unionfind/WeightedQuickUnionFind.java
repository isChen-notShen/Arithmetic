package ind.chen.adt.unionfind;

import java.util.Arrays;

/**
 * @Description 加权版本的QuickUnionFind，使在union过程中，小树指向大树，而非大树指向小树，减少在find过程中访问数组的次数。
 * @Author Mr.Chen
 * @Create 2021-04-11
 **/
public class WeightedQuickUnionFind extends UnionFind {
    private int[] id;   //  父链接数组（由触点索引）
    private int[] sz;   //  触点所在的树的大小
    private int count;  //  连通分量的数量

    public WeightedQuickUnionFind(int size){
        count = size;
        id  = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        sz = new int[size];
        Arrays.fill(sz, 1);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
