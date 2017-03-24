package com.p.num;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Normalizer;

public class FileOps {

	public static void main(String[] argv) throws IOException {
		String path = "F:/songs";
		String[] paths={"C:/Users/VINU/Desktop/New folder (2)",
				"C:/Users/VINU/Desktop/21-dec-2015",
				"D:/ebooks",
				"D:/TUTORIAL",
				"D:/bakari",
				"F:/study-materials",
				"F:/Ajax_Tutorial_Part_I_The_Basics",
				"F:/21-dec-2015",
				"G:/21-dec-2015",
				"G:/backup",
				"G:/ebooks",
				"F:/songs",
				"G:/lenovoe420",
				"G:/rimjhim"};
		myout=new PrintStream(new File("myout.txt"));
		for(String p:paths){
			File folder = new File(p);
			changeFilesOfFolder(folder);
		}
		
		
		
	}

	static int count = 0;
	static PrintStream myout=null;
	

	public static void changeFilesOfFolder(File folder) {
		File[] listOfFiles = folder.listFiles();

		if (listOfFiles == null) {
			myout.println("Path without files");
		}

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				File f = new File(folder.getPath() + File.separator
						+ listOfFiles[i].getName());
				// ///////////
				String fileNameee = (f.getName() != null) ? f.getName().trim()
						: null;
				String[] validExtentions = { ".pdf", ".mp3", ".mp4" };

				boolean eligibleExtentionToBeRenamed = false;

				for (String ext : validExtentions) {
					if (fileNameee != null
							&& fileNameee.toLowerCase().endsWith(ext)) {
						eligibleExtentionToBeRenamed = true;
						break;
					}
				}
				if (eligibleExtentionToBeRenamed) {
					myout.println(folder.getPath() + File.separator
							+ f.getName());
					// /////////
					// -- Normalise the file name , remove all non-ASCII
					// characters
					String newFileName = folder.getPath()
							+ File.separator
							+ Normalizer.normalize(fileNameee,
									Normalizer.Form.NFD).replaceAll(
									"[^\\x00-\\x7F]", "");
					// --Remove all characters which creates problem while
					// showing them as filenames and opening file in browser

					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, "&", " and ");
					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, ",", "-");
					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, "-", " ");
					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, "[", " ");
					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, "]", " ");
					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, "(", " ");
					newFileName = CrunchifyStringReplaceDelete.replaceAllChar(
							newFileName, ")", "");

					f.renameTo(new File(newFileName));
					// /////////
					count++;
				}

				// ///////////
				

			} else if (listOfFiles[i].isDirectory()) {
				changeFilesOfFolder(listOfFiles[i]);
			}
		}

	}
}