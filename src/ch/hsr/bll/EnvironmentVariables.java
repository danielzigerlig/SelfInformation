package ch.hsr.bll;

import ch.hsr.dal.EnvironmentVariablesProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class EnvironmentVariables extends SelfInformation {

	public EnvironmentVariables() {
		information = new EnvironmentVariablesProperties().getProperties();
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "EnvironmentVariables";
	}

	/**
	 * @return String or null if no USERPROFILE variable is found
	 */
	public String getUserProfile() {
		return information.get("USERPROFILE");
	}

	/**
	 * @return String or null if no JAVA_HOME variable is found
	 */
	public String getJavaHome() {
		return information.get("JAVA_HOME");
	}

	/**
	 * @return String or null if no Path variable is found
	 */
	public String getPath() {
		return information.get("Path");
	}

	/**
	 * @return String or null if no HOMEDRIVE variable is found
	 */
	public String getHomeDrive() {
		return information.get("HOMEDRIVE");
	}

	/**
	 * @return String or null if no LOGONSERVER variable is found
	 */
	public String getLogonserver() {
		return information.get("LOGONSERVER");
	}

	/**
	 * @return String or null if no OS variable is found
	 */
	public String getOS() {
		return information.get("OS");
	}

	/**
	 * @return String or null of no COMPUTERNAME variable is found
	 */
	public String getComputername() {
		return information.get("COMPUTERNAME");
	}

	/**
	 * @return String or null if no NUMBER_OF_PROCESSORS variable is found
	 */
	public String getNumberOfProcessors() {
		return information.get("NUMBER_OF_PROCESSORS");
	}

	/**
	 * @return String or null if no USERNAME variable is found
	 */
	public String getUsername() {
		return information.get("USERNAME");
	}
}
