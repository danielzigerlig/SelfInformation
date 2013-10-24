package ch.hsr.dal;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 * 
 */
public class NetworkInformationProperties implements SelfInformationProperties {
	LinkedHashMap<String, String> network = new LinkedHashMap<String, String>();

	public NetworkInformationProperties() throws SocketException {
		collectNetworkProperties();
	}

	private void collectNetworkProperties() throws SocketException {
		Enumeration<NetworkInterface> nets = NetworkInterface
				.getNetworkInterfaces();
		for (NetworkInterface netint : Collections.list(nets)) {
			network.put("Display name", netint.getDisplayName());
			network.put("Name", netint.getName());
			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
			for (InetAddress inetAddress : Collections.list(inetAddresses)) {
				network.put("InetAddress", inetAddress.toString());
			}
		}
	}

	@Override
	public LinkedHashMap<String, String> getProperties() {
		return network;
	}

}
