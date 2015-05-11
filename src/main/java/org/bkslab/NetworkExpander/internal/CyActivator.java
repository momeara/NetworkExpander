package org.bkslab.NetworkExpander.internal;

import org.bkslab.NetworkExpander.internal.NetworkExpanderTaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;
import java.util.Properties;

public class CyActivator extends AbstractCyActivator {
	
	public CyActivator() {
		super();
	}
		
	@Override
	public void start(BundleContext context) throws Exception {
		NetworkExpanderTaskFactory networkExpanderTaskFactory = new NetworkExpanderTaskFactory();
		Properties networkExpanderTaskFactoryProps = new Properties();
		networkExpanderTaskFactoryProps.setProperty("preferredMenu", "Apps");
		networkExpanderTaskFactoryProps.setProperty("title", "Network Expander");
		registerService(
				context,
				networkExpanderTaskFactory,
				NetworkViewTaskFactory.class,
				networkExpanderTaskFactoryProps);
	}
}
