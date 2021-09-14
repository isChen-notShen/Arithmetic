package ind.chen.adt.unionfind;

import ind.chen.adt.unionfind.UnionFind;

/**
 * @Description UnionFind的QuickFind版本，拥有常数级的find方法，但在union方法执行时需要遍历整个数组。数组id的含义是，id[index]的下标代表
 * 着触点，id[index]代表着该触点所在的连通分量，连通分量用它拥有的触点之一的标识来表示。
 * @Author Mr.Chen
 * @Create 2021-04-11
 **/
public class UnionQuickFind extends UnionFind {
    private final int[] id;
    private int count;

    public UnionQuickFind(int size) {
        count = size;
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
        count--;
    }

    @Override
    public int find(int p) {
        if (p < 0 || p > id.length)
            throw new IllegalArgumentException("The parameter p should be within the range 0 to size");
        return id[p];
    }

    @Override
    public int count(){
        return count;
    }
}
