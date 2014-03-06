package samplegroovy


import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.operations.IOperationHistory
import org.eclipse.core.commands.operations.IUndoContext
import org.eclipse.core.commands.operations.OperationHistoryFactory
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.ui.ide.undo.CreateProjectOperation
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil

class ProjectOperation {

    private String projectName;

    public ProjectOperation(String projectName) {
        this.projectName = projectName;
    }

    public void create() throws ExecutionException {
        // プロジェクトを作成
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        if (project.exists()) {
            return;
        }

        IOperationHistory history = OperationHistoryFactory.getOperationHistory();
        IProjectDescription description = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
        description.setNatureIds({ "natureid" });
        // CreateProjectOperation実行
        history.execute(new CreateProjectOperation(description, "プロジェクト作成"), null, null);

    }

    public void delete() throws CoreException {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        if (!project.exists()) {
            return;
        }
        project.delete(true, null);
    }

    public void undo() throws CoreException, ExecutionException {
        IOperationHistory history = OperationHistoryFactory.getOperationHistory();
        IUndoContext context = WorkspaceUndoUtil.getWorkspaceUndoContext();
        if (history.canUndo(context)) {
            history.undo(context, null, null);
        }
    }

    public void redo() throws CoreException, ExecutionException {
        IOperationHistory history = OperationHistoryFactory.getOperationHistory();
        IUndoContext context = WorkspaceUndoUtil.getWorkspaceUndoContext();
        if (history.canRedo(context)) {
            history.redo(context, null, null);
        }
    }
}
