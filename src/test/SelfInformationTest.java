package test;

/*import static org.junit.Assert.*;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ch.hsr.bll.EnvironmentVariables;
import ch.hsr.bll.HardwareInformation;
import ch.hsr.bll.NetworkInformation;
import ch.hsr.bll.SelfInformation;
import ch.hsr.bll.SystemInformation;

/**
 * Tests for SelfInformation.
 * 
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 */
//@RunWith(JUnit4.class)
public class SelfInformationTest {
/*	EnvironmentVariables ev;
	HardwareInformation hi;
	NetworkInformation ni;
	SystemInformation si;

	@Before
	public void initialize() {
		ev = new EnvironmentVariables();
		hi = new HardwareInformation();
		try {
			ni = new NetworkInformation();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		si = new SystemInformation();
	}

	public void testNoExceptions() {
		try {
			List<SelfInformation> classList = new ArrayList<SelfInformation>();
			classList.add(new EnvironmentVariables());
			classList.add(new HardwareInformation());
			classList.add(new NetworkInformation());
			classList.add(new SystemInformation());

			for (SelfInformation si : classList) {
				si.getHTML();
				si.getJSON();
				si.getXML();
			}
		} catch (Exception ex) {
			fail();
		}
	}

	@Test
	public void testNetworkInformation() {
		assertNotNull(ni.getInetAddress());
	}

	@Test
	public void testNumOfCores() {
		assertNotNull(hi.getNumOfCores());
	}

	@Test
	public void testFreeJVMMemory() {
		assertNotNull(hi.getFreeMemory());
	}

	@Test
	public void testMaxJVMMemory() {
		assertNotNull(hi.getMaxMemory());
	}

	@Test
	public void testTotalJVMMemory() {
		assertNotNull(hi.getTotalMemory());
	}

	@Test
	public void testFreeSpace() {
		assertNotNull(hi.getFreeSpace().get(0));
	}

	@Test
	public void testRuntimeName() {
		assertNotNull(si.getRuntimeName());
	}

	@Test
	public void testUserCountryFormat() {
		assertNotNull(si.getUserCountryFormat());
	}

	@Test
	public void testJavaVmName() {
		assertNotNull(si.getJavaVmName());
	}

	@Test
	public void testUserCountry() {
		assertNotNull(si.getUserCountry());
	}

	@Test
	public void testJavaRuntimeVersion() {
		assertNotNull(si.getJavaRuntimeVersion());
	}

	@Test
	public void testJavaLibraryPath() {
		assertNotNull(si.getJavaLibraryPath());
	}

	@Test
	public void testJavaClassVersion() {
		assertNotNull(si.getJavaClassVersion());
	}

	@Test
	public void testFileEncoding() {
		assertNotNull(si.getFileEncoding());
	}

	@Test
	public void testUserHome() {
		assertNotNull(si.getUserHome());
	}

	@Test
	public void testOsVersion() {
		assertNotNull(si.getOsVersion());
	}

	@Test
	public void testJavaSpecificationVersion() {
		assertNotNull(si.getJavaSpecificationVersion());
	}

	@Test
	public void testJavaClassPath() {
		assertNotNull(si.getJavaClassPath());
	}

	@Test
	public void testUsername() {
		assertNotNull(si.getUsername());
	}

	@Test
	public void testJavaHome() {
		assertNotNull(si.getJavaHome());
	}

	@Test
	public void testJavaVersion() {
		assertNotNull(si.getJavaVersion());
	}*/
}