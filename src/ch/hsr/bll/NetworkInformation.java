package ch.hsr.bll;

import java.net.SocketException;

import ch.hsr.dal.NetworkInformationProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class NetworkInformation extends SelfInformation {

	public NetworkInformation() throws SocketException {
		information = new NetworkInformationProperties().getProperties();
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "NetworkInformation";
	}

	/**
	 * @return String or null if no inetaddress is found
	 */
	public String getInetAddress() {
		return information.get("InetAddress");
	}
}
