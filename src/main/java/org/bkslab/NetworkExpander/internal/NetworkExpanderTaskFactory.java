package org.bkslab.NetworkExpander.internal;

import org.cytoscape.work.TaskIterator;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;

public class NetworkExpanderTaskFactory extends AbstractNetworkViewTaskFactory {

	public TaskIterator createTaskIterator(CyNetworkView networkView){
		return new TaskIterator(new NetworkExpanderTask(networkView) );
	}
}