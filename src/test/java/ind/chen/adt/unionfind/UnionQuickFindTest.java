package ind.chen.adt.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import ind.chen.adt.unionfind.UnionQuickFind;
import org.junit.Test;

public class UnionQuickFindTest {

    @Test
    public void union(){
        int size = StdIn.readInt();
        UnionQuickFind uf = new UnionQuickFind(size);
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