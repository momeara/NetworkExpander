package org.bkslab.NetworkExpander.internal;

import org.cytoscape.NetworkExpander.internal.NetworkExpanderTaskFactory;

import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;

public class CyActivator extends AbstractCyActivator {
	
	public CyActivator() {
		super();
	}
		
	@Override
	public void start(BundleContext context) throws Exception {
		NetworkExpanderTaskFactor networkExpanderTaskFactory = new NetworkExpanderTaskFactory();
		Properties networkExpanderTaskFactoryProps = new Properties();
		networkExpanderTaskFactoryProps.setProperty("preferredMenu", "Apps");
		networkExpanderTaskFactoryProps.setProperty("title", "Network Expander");
		registerService(
				bc,
				networkExpanderTaskFactory,
				NetworkViewTaskFactory.class,
				networkExpanderTaskFactoryProps);
	}
}
