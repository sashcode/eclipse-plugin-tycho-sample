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
        // �v���W�F�N�g���쐬����Ă���
        assertEquals(true, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());

        operation.delete();

        // �v���W�F�N�g�͍쐬����Ă��Ȃ�
        assertEquals(false, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());
    }

}
