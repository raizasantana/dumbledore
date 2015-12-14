package telas;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ActionBarHome extends ActionBarAdvisor {

	public ActionBarHome(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
	}

	protected void fillMenuBar(IMenuManager menuBar) {
	}

}
