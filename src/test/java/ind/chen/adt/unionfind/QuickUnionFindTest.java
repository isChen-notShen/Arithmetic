package ind.chen.adt.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import ind.chen.adt.unionfind.QuickUnionFind;
import org.junit.Test;

public class QuickUnionFindTest {

    @Test
    public void union() {
        int size = StdIn.readInt();
        QuickUnionFind uf = new QuickUnionFind(size);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);

        }
        StdOut.println(uf.count() + " components");
    }
}