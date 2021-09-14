package ind.chen.util;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class SortCompareTest {

    @Test
    public void timeRandomInput() {
        Class<SortCompare> c = SortCompare.class;
        Field[] fields = c.getFields();
        for (Field f : fields) {
            String alg;
            try {
                alg = (String) f.get(c);
                System.out.printf(f.getName() + " 规模1000，次数10的总运行时间为: %.5f\n",SortCompare.timeRandomInput(alg, 1000, 10));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}