package ind.chen.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    int[] a;
    int key;

    @Before
    public void setUp() {
        a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
        }
        key = StdRandom.uniform(1, 101);
    }

    @Test
    public void rank() {
        assertEquals(key, BinarySearch.rank(key, a) + 1);
    }
}