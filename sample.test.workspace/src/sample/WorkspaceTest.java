package sample;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

import sample.handlers.ProjectOperation;

public class WorkspaceTest {

    @Test
    public void test() throws ExecutionException, CoreException {
        ProjectOperation operation = new ProjectOperation("test");
        operation.create();
        // プロジェクトが作成されている
        assertEquals(true, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());

        operation.delete();

        // プロジェクトは作成されていない
        assertEquals(false, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());
    }

}
