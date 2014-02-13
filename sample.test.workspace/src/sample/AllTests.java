package sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ WorkspaceTest.class, WorkspaceCreateFileTest.class })
public class AllTests {
}
