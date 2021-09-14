package ind.chen.adt.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedQuickUnionFindTest {

    @Test
    public void union() {
        int size = StdIn.readInt();
        WeightedQuickUnionFind uf = new WeightedQuickUnionFind(size);
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