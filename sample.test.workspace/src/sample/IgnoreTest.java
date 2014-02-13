package sample;

import org.junit.Test;

public class IgnoreTest {

    @Test
    public void testIgnore() {
        throw new RuntimeException("Do not run this test case.");
    }

}
