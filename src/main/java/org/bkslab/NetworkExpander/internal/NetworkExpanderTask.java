package org.bkslab.NetworkExpander.internal;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableUtil;
import org.cytoscape.task.AbstractNetworkViewTask;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskMonitor;





public class NetworkExpanderTask extends AbstractNetworkViewTask {

	public NetworkExpanderTask(CyNetworkView view) {
		super(view);
	}

	@Override
	public void run(TaskMonitor taskMonitor) {
		if (view == null) {
			return;
		}

		CyNetwork net = view.getModel();
		List<CyNode> nodes = CyTableUtil.getNodesInState(net, "selected", true);
		
		List<String> node_names = new ArrayList<String>();

		Iterator<CyNode> it = nodes.iterator();
		while (it.hasNext()) {
			CyNode node = it.next();
			node_names.add(net.getRow(node).get("name", String.class));
		}
	}

}