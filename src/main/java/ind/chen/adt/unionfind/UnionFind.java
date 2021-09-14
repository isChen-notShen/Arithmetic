package ind.chen.adt.unionfind;

/**
 * @Description 动态连通性问题
 * @Author Mr.Chen
 * @Create 2021-04-11
 **/
public abstract class UnionFind {

    public abstract void union(int p, int q);

    public abstract int find(int p);

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public abstract int count();
}
