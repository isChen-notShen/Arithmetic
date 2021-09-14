package ind.chen.adt.unionfind;

import ind.chen.adt.unionfind.UnionFind;

/**
 * @Description QuickUnion版本的UnionFind算法，在该算法中成员变量id[]的含义是，下标index代表着触点，而id[index]代表着与该触点处于
 * 同一连通分量的下一个触点，着种联系成为“链接”，在这个链接的末尾是该连通分量的根触点，该触点是一个自己链接自己的触点。可以通过该根触点来判断两个触点是否处于同一连通分量。
 * @Author Mr.Chen
 * @Create 2021-04-11
 **/
public class QuickUnionFind extends UnionFind {
    private final int[] id;
    private int count;

    QuickUnionFind(int size){
        id = new int[size];
        count = size;
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
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
