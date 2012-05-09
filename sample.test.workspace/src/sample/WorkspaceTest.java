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
		// プロジェクトを作成
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		IProjectDescription description = ResourcesPlugin.getWorkspace().newProjectDescription("test");
		description.setNatureIds(new String[] { "natureid" });
		// CreateProjectOperation実行
		history.execute(new CreateProjectOperation(description, "プロジェクト作成"), null, null);
		// プロジェクトが作成されている
		assertEquals(true, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());
		// プロジェクトの作成をUndo
		history.undo(WorkspaceUndoUtil.getWorkspaceUndoContext(), null, null);
		// プロジェクトは作成されていない
		assertEquals(false, ResourcesPlugin.getWorkspace().getRoot().getProject("test").exists());
	}

}
