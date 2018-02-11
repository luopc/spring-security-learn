package com.luopc.test;

import java.io.File;

public class BaseFileTest {
	
	
	public void testDelFile() {
		deleteFile(new File("H:\\视频资料"));
	}

	private void deleteFile(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File childrenFile : file.listFiles()) {
					if (file.isDirectory()) {
						deleteFile(childrenFile);
					} else {
						if (childrenFile.getName().endsWith(".downloading")) {
							System.out.println(childrenFile.getName());
							childrenFile.delete();
						}
					}
				}
			} else {
				if (file.getName().endsWith(".downloading")) {
					System.out.println(file.getName());
					file.delete();
				}
			}

		}
	}
}
