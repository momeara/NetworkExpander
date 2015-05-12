package org.bkslab.NetworkExpander.internal;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableUtil;
import org.cytoscape.task.AbstractNetworkViewTask;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskMonitor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;





public class NetworkExpanderTask extends AbstractNetworkViewTask {

	public NetworkExpanderTask(CyNetworkView view) {
		super(view);
	}

	@Override
	public void run(TaskMonitor taskMonitor)  {
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
		System.out.println("Number of selected nodes is:" + node_names.size());
		
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("zinc15.docking.org", 443),
                new UsernamePasswordCredentials("", ""));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        try {
            HttpGet httpget = new HttpGet("http://zinc15.docking.org/targets/DRD2_HUMAN/substances/subsets/purchasable.smi?count=all");

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                EntityUtils.consume(response.getEntity());
            } finally {
                response.close();
            }
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
            
        } finally {
        	try {
        		httpclient.close();
        	} catch (IOException e){
        		System.err.println("Caught IOException: " + e.getMessage());
        	}
        }
		
	}

	
	
}