package ch.hsr.bll;

import java.util.ArrayList;

import ch.hsr.dal.HardwareInformationProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class HardwareInformation extends SelfInformation {
	private HardwareInformationProperties hw = new HardwareInformationProperties();

	public HardwareInformation() {
		information = hw.getProperties();
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "HardwareInformation";
	}

	/**
	 * @return long value with free allocated JVM memory
	 */
	public long getFreeMemory() {
		return hw.getFreeMemory();
	}

	/**
	 * @return long value with max allocatable JVM memory
	 */
	public long getMaxMemory() {
		return hw.getMaxMemory();
	}

	/**
	 * @returnint value with number of processor cores
	 */
	public int getNumOfCores() {
		return hw.getNumOfCores();
	}

	/**
	 * @return long value with total JVM allocated memory
	 */
	public long getTotalMemory() {
		return hw.getTotalMemory();
	}

	/**
	 * @return ArrayList<String> with freespace of each filesystem
	 */
	public ArrayList<String> getFreeSpace() {
		return hw.getFreeSpace();
	}

}
