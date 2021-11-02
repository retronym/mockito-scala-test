package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DemoTest {
    interface I {
        int i();
    }

    public static class NokUnfinishedStubbing {
        @Mock I i;
        @Before public void before() {
            MockitoAnnotations.initMocks(this);
            when(i.i()); // missing .thenReturn
        }
        @After
        public void after() {
            Mockito.validateMockitoUsage();
        }

        @Test public void nok() {

        }
    }
    public static class OkNormalUsage {
        @Mock I i;
        @Before public void before() {
            MockitoAnnotations.initMocks(this);
            when(i.i()).thenReturn(42); // missing .thenReturn
        }
        @After
        public void after() {
            Mockito.validateMockitoUsage();
        }

        @Test public void ok() {
            assertEquals(42, i.i());

        }
    }
}
