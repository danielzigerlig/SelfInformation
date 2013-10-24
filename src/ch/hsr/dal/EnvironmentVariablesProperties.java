package ch.hsr.dal;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class EnvironmentVariablesProperties implements SelfInformationProperties {
	LinkedHashMap<String, String> variables = new LinkedHashMap<String, String>();

	public EnvironmentVariablesProperties() {
		collectEnvironmentVariables();
	}

	private void collectEnvironmentVariables() {
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			variables.put(key, value);
		}
	}
	
	@Override
	public LinkedHashMap<String, String> getProperties() {
		return variables;
	}

}
