package ch.hsr.dal;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class HardwareInformationProperties implements SelfInformationProperties {
	LinkedHashMap<String, String> hardware = new LinkedHashMap<String, String>();
	private int _numOfCores;
	private long _freeMemory;
	private long _maxMemory;
	private long _totalMemory;
	private ArrayList<String> _freeSpace;
	
	public HardwareInformationProperties() {
		collectHardwareInformation();
	}
	
	private void collectHardwareInformation() {
		collectProcessorAndMemoryInformation();
		collectHarddiskInformation();
	}
	
	private void collectProcessorAndMemoryInformation() {
		setNumOfCores(Runtime.getRuntime().availableProcessors());
		setMaxMemory(Runtime.getRuntime().maxMemory() / (1024*1024));
		setFreeMemory(Runtime.getRuntime().freeMemory() / (1024*1024));
		setTotalMemory(Runtime.getRuntime().totalMemory() / (1024 * 1024));
		
		hardware.put("Available processors (cores)", Integer.toString(getNumOfCores()));
		hardware.put("Free memory (megabytes)", Long.toString(getFreeMemory()));
		hardware.put("Maximum memory (megabytes)", (getMaxMemory() == Long.MAX_VALUE ? "no limit" : Long.toString(getMaxMemory())));
		hardware.put("Total memory (megabytes)", Long.toString(getTotalMemory()));
	}
	
	private void collectHarddiskInformation() {
		File[] roots = File.listRoots();
		setFreeSpace(new ArrayList<String>());
		for (File root : roots) {
			String path = root.getAbsolutePath();
			String freeSpace = Long.toString(root.getFreeSpace() / (1024 * 1024));
			hardware.put(path + " Total space (megabytes)",Long.toString(root.getTotalSpace() / (1024 * 1024)));
			hardware.put(path + " Free space (megabytes)" ,freeSpace);
			getFreeSpace().add(path + " Free space (megabytes) : " + freeSpace);
			hardware.put(path + " Usable space (megabytes)", Long.toString(root.getUsableSpace() / (1024 * 1024)));
		}
	}
	
	@Override
	public LinkedHashMap<String, String> getProperties() {
		return hardware;
	}

	/**
	 * @return int value containing number of processor cores
	 */
	public int getNumOfCores() {
		return _numOfCores;
	}

	/**
	 * @param _numOfCores
	 */
	private void setNumOfCores(int _numOfCores) {
		this._numOfCores = _numOfCores;
	}

	/**
	 * @return long value with free allocated JVM memory
	 */
	public long getFreeMemory() {
		return _freeMemory;
	}

	/**
	 * @param _freeMemory
	 */
	private void setFreeMemory(long _freeMemory) {
		this._freeMemory = _freeMemory;
	}

	/**
	 * @return long value with max allocatable JVM memory
	 */
	public long getMaxMemory() {
		return _maxMemory;
	}

	/**
	 * @param _maxMemory
	 */
	private void setMaxMemory(long _maxMemory) {
		this._maxMemory = _maxMemory;
	}

	/**
	 * @return long value with total allocatable JVM memory
	 */
	public long getTotalMemory() {
		return _totalMemory;
	}

	/**
	 * @param _totalMemory
	 */
	private void setTotalMemory(long _totalMemory) {
		this._totalMemory = _totalMemory;
	}

	/**
	 * @return ArrayList<String> with freespace of each filesystem
	 */
	public ArrayList<String> getFreeSpace() {
		return _freeSpace;
	}

	/**
	 * @param _freeSpace
	 */
	private void setFreeSpace(ArrayList<String> _freeSpace) {
		this._freeSpace = _freeSpace;
	}

}
