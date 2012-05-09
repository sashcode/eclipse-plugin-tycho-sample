package sample;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.junit.Test;

public class WorkspaceTest {

	@Test
	public void test() throws ExecutionException {
		// �v���W�F�N�g���쐬
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		IProjectDescription description = ResourcesPlugin.getWorkspace().newProjectDescription("test");
		description.setNatureIds(new String[] { "natureid" });
		// CreateProjectOperation���s
		history.execute(new CreateProjectOperation(description, "�v���W�F�N�g�쐬"), null, null);
		// �v���W�F�N�g���쐬����Ă���
		assertEquals(true, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());
		// �v���W�F�N�g�̍쐬��Undo
		history.undo(WorkspaceUndoUtil.getWorkspaceUndoContext(), null, null);
		// �v���W�F�N�g�͍쐬����Ă��Ȃ�
		assertEquals(false, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());
	}

}
