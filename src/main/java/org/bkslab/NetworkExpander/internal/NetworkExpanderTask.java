package org.bkslab.NetworkExpander.internal;

import java.awt.Color;
//import java.util.Collection;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewTask;

public class CreateNetworkExpanderTask extends AbstractNetworkViewTask {

	private CyNetworkView view;
	
	public CreateNetworkExpanderTask(CyNetworkView view) {
		this.view = view;
	}
	
	public creatTaskIterator(CyNetworkView view){
	
	@Override
	public void run(TaskMonitor taskMonitor) throws Exception {
		if(view == null){
			return;
		}
	
    	// Set the background of current view to RED 	
    	view.setVisualProperty(BasicVisualLexicon.NETWORK_BACKGROUND_PAINT, Color.red);
    	view.updateView();
		
//		List<CyIdentifiable> nodeList = get_selected_nodes(this.view);
//		
//		// Set name for new nodes
//		myNet.getRow(node1).set(CyNetwork.NAME, "Node1");
//		myNet.getRow(node2).set(CyNetwork.NAME, "Node2");
	}

//	// Get all of the selected nodes
//	// from https://github.com/RBVI/structureViz2/blob/master/src/main/java/edu/ucsf/rbvi/structureViz2/internal/tasks/AlignStructuresTaskFactory.java
//	public List<CyIdentifiable> get_selected_nodes(CyNetworkView netView) {
//		List<CyIdentifiable> nodeList = new ArrayList<CyIdentifiable>();
//		nodeList.addAll(CyTableUtil.getNodesInState(netView.getModel(), CyNetwork.SELECTED, true));
//		return nodeList;
//	}
	

}

//  // To get a reference of CyNetworkFactory at CyActivator class of the App
//  CyNetworkFactory networkFactory = getService(bc, CyNetworkFactory.class);
//
//  // Add two nodes to the network
//  CyNode node1 = myNet.addNode();
//  CyNode node2 = myNet.addNode();
//                
//  // Set name for new nodes
//  myNet.getRow(node1).set(CyNetwork.NAME, "Node1");
//  myNet.getRow(node2).set(CyNetwork.NAME, "Node2");
//                
//  // Add an edge
//  myNet.addEdge(node1, node2, true);

