package com.dc.bip.ide.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.dc.bip.ide.views.objects.TreeNode;
import com.dc.bip.ide.wizards.composite.CompositeSvcWizard;

public class NewCompSvcAction implements IObjectActionDelegate {

	private TreeNode treeNode;
	
	/**
	 * Constructor for Action1.
	 */
	public NewCompSvcAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			CompositeSvcWizard csw = new CompositeSvcWizard(treeNode.getProjectName());
	        WizardDialog dialog = new WizardDialog(shell, csw);
	        dialog.setTitle("新建组合服务");
	        dialog.open();  
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {		
		if (selection instanceof IStructuredSelection) {
            Object first = ((IStructuredSelection) selection).getFirstElement();
            if (first instanceof TreeNode) {
            	treeNode = (TreeNode) first;
            }
        }
	}

}
