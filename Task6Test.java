import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void testOne() {
        int [] hits = {9};
        int N = 1;
        assertEquals("", Task6.PatternUnlock(N, hits), "TestEmpty is ok!");
    }

    @Test
    void testMain() {
        int [] hits = { 1, 2, 3, 4, 5, 6, 2, 7, 8, 9};
        int N = 10;
        assertEquals("982843", Task6.PatternUnlock(N, hits), "TestMain is ok!");
    }

    @Test
    void testError() {
        int [] hits = {2, 1, 9};
        int N = 3;
        assertEquals("2", Task6.PatternUnlock(N, hits), "TestError is ok!");
    }
    
    @Test
    void testEquals () {
        int [] hits = {2, 1, 9};
        int N = 3;
        assertTrue(Task6.PatternUnlock(N, hits).equals("2"));
    }

}
