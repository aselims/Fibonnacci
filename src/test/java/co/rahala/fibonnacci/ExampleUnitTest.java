package co.rahala.fibonnacci;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testZero() throws Exception{
        ArrayList<Long> longArrayList = Util.fibLimit(0);
        int size = longArrayList.size();
        assertEquals(new Long(0), new Long(longArrayList.get(size-1)));

    }

    @Test
    public void testOne() throws Exception{
        ArrayList<Long> longArrayList = Util.fibLimit(1);
        int size = longArrayList.size();
        assertEquals(new Long(1), new Long(longArrayList.get(size-1)));

    }

    @Test
    public void test10() throws Exception{
        ArrayList<Long> longArrayList = Util.fibLimit(10);
        int size = longArrayList.size();
        assertEquals(new Long(55), new Long(longArrayList.get(size-1)));

    }
}