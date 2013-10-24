package ch.hsr.bll;

import java.util.Map;

import ch.hsr.dal.SystemProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class SystemInformation extends SelfInformation {

	public SystemInformation() {
		information = new SystemProperties().getProperties();
		
		for (Map.Entry<String, String> entry : information.entrySet()) {
			System.out.println(entry.getKey() + "    " + entry.getValue());
		}
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "SystemProperties";
	}

	/**
	 * @return string or null if no java.runtime.name was found
	 */
	public String getRuntimeName() {
		return information.get("java.runtime.name");
	}

	/**
	 * @return string or null if no user.country.format was found
	 */
	public String getUserCountryFormat() {
		return information.get("user.country.format");
	}

	/**
	 * @return string or null if no java.vm.name is found
	 */
	public String getJavaVmName() {
		return information.get("java.vm.name");
	}

	/**
	 * @return return string or null if no user.country is found
	 */
	public String getUserCountry() {
		return information.get("user.country");
	}

	/**
	 * @return string or null if no java.runtime.version is found
	 */
	public String getJavaRuntimeVersion() {
		return information.get("java.runtime.version");
	}

	/**
	 * @return string or null if no java.library.path is found
	 */
	public String getJavaLibraryPath() {
		return information.get("java.library.path");
	}

	/**
	 * @return string or null if no java.class.version is found
	 */
	public String getJavaClassVersion() {
		return information.get("java.class.version");
	}

	/**
	 * @return string or null if no file.encoding is found
	 */
	public String getFileEncoding() {
		return information.get("file.encoding");
	}

	/**
	 * @return string or null if no user.home is found
	 */
	public String getUserHome() {
		return information.get("user.home");
	}

	/**
	 * @return string or null if no os.version is found
	 */
	public String getOsVersion() {
		return information.get("os.version");
	}

	/**
	 * @return string or null if no java.specification.version is found
	 */
	public String getJavaSpecificationVersion() {
		return information.get("java.specification.version");
	}

	/**
	 * @return string or null if no user.name is found
	 */
	public String getUsername() {
		return information.get("user.name");
	}

	/**
	 * @return string or null if no java.home is found
	 */
	public String getJavaHome() {
		return information.get("java.home");
	}

	/**
	 * @return string or null if no java.class.path is found
	 */
	public String getJavaClassPath() {
		return information.get("java.class.path");
	}

	/**
	 * @return string or null if no java.version is found
	 */
	public String getJavaVersion() {
		return information.get("java.version");
	}
}
