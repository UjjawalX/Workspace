package com.misys.bankfusion.postingengine.financialgateway;

import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class CheckJars {
	public static void main(String[] args) {
		File dir = new File(args[0]);
		checkDirectoryorFile(dir);
	}

	/**
	 * <p>
	 * check for directory and files
	 * 
	 * @param dir
	 */
	private static void checkDirectoryorFile(File dir) {
		File[] listfiles = dir.listFiles();
		if (listfiles != null) {
			for (File file : listfiles) {
				if (file.isDirectory()) {
					checkDirectoryorFile(file);
				} else {
					checkCorruptJars(file);
				}
			}
		}
	}

	/**
	 * <p>
	 * check the corrupted jars
	 * </p>
	 * 
	 * @param listfiles
	 */
	private static void checkCorruptJars(File file) {
		if(file!=null) {
			
			try {
				ZipFile filez = new ZipFile(file);
				Enumeration<? extends ZipEntry> e = filez.entries();
				while (e.hasMoreElements()) {
					ZipEntry entry = e.nextElement();
					// System.out.println(entry.getName());
				}
				
			} catch (Exception e) {
				System.out.println(file.getAbsolutePath());
			}
		}
	}

}
