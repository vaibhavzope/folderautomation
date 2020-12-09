package com.demo.example;

import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OpenFolder {
	
	void listFolder(File dir) throws IOException {
		File[] subDirs = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.isDirectory();
			}
		});
		
		System.out.println("Directory path=============================: " + dir.getAbsolutePath());
		
		listFile(dir);
		
		for(File folder: subDirs) {
			listFolder(folder);
		}
	}
	
	private void listFile(File dir) throws IOException {
		File[] files = dir.listFiles();
		for(File file : files) {
			System.out.println("file.getAbsoluteFile()=======================" + file.getAbsoluteFile());
			//File filePathName = file.getAbsoluteFile();
			System.out.println("file.getName()=======================" + file.getName());
			
			if(file.getName().endsWith("zip")) {
				System.out.println("This is zip file===============");
				System.out.println("This is zip file absolute path==================" + file.getAbsolutePath());
				
				//String zipFilePathName = file.getAbsoluteFile();
				String zipFilePathName = file.getAbsolutePath();
				
		//		Path temp = Files.move(Paths.get(zipFilePathName), Paths.get("E:\\Demo\\abc\\arc\\"), StandardCopyOption.REPLACE_EXISTING);
				
				file.renameTo(new File("E:\\Demo\\abc\\arc\\" + file.getName()));
				
			}

			
			//checkZipFIle(file);
		}
	}

	/*
	public void checkZipFIle(File filePathName) {
//		File f = new File(filePathName.getAbsoluteFile());
		
		FilenameFilter file2 = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				if(name.endsWith("zip")) {
					System.out.println("This is zip file===============");
				}
				
				return false;
			}
		};
	}
	*/
	
	public static void main(String[] args) throws IOException {
		/*
		 * Desktop desk = Desktop.getDesktop(); File file = new File("E:\\Demo");
		 * desk.open(file); File[] subDirectory = file.listFiles();
		 */		
		
		new OpenFolder().listFolder(new File("E:\\Demo"));
		
	}

}

