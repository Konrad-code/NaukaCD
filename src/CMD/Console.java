package CMD;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.Collator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Console {
	private ArrayList<String> simpleCommands = new ArrayList<String>(Arrays.asList("cd", "cd..", "help", "dir", "exit", "cmd", "chdir", "chdir..", "time", "ver"));
	private ArrayList<String> extendedCommands = new ArrayList<String>(Arrays.asList("cd ", "mkdir ", "replace ", "rename ", "rmdir ", "del ", "chdir ", "md ", "ren ", "copy ", "move "));
	private HashMap<String, String> helpCommands = new HashMap<String, String>();
	private List<Map.Entry<String, String>> sortedHelpCommands = new ArrayList<Map.Entry<String, String>>(helpCommands.entrySet());
	private ArrayList<String> drivesList = new ArrayList<String>();
	
	public Console() {
		fillHelp();
		sortHelp();
		fillDisksList();
	}
	
	private void fillHelp() {															// filling of hashmap of help commands and their desctriptions from Windows CMD				
		helpCommands.put("CD", "Displays the name of or changes the current directory");
		helpCommands.put("CD..", "Changes the current directory to a higher directory");
		helpCommands.put("MKDIR", "Creates a directory");
		helpCommands.put("HELP", "Provides Help information for Windows commands");
		helpCommands.put("DIR", "Displays a list of files and subdirectories in a directory");
		helpCommands.put("EXIT", "Quits the CMD.EXE program");
		helpCommands.put("REPLACE", "Replaces a file");
		helpCommands.put("RENAME", "Renames a file");
		helpCommands.put("RMDIR", "Removes a directory");
		helpCommands.put("DEL", "Deletes one file");
		helpCommands.put("CMD", "Starts a new instance of the Windows command interpreter");
		helpCommands.put("CD [path]", "Changes the current directory to specified in a direct path");
		helpCommands.put("CD [/D] [drive:][path]", "Use the /D switch to change current drive in addition to changing current directory for a drive");
		helpCommands.put("CHDIR", "Displays the name of or changes the current directory");
		helpCommands.put("CHDIR..", "Changes the current directory to a higher directory");
		helpCommands.put("CHDIR [path]", "Changes the current directory to specified in a direct path");
		helpCommands.put("CHDIR [/D] [drive:][path]", "Use the /D switch to change current drive in addition to changing current directory for a drive");
		helpCommands.put("MKDIR [path]", "Creates a directory as specified in a direct path");
		helpCommands.put("MD", "Creates a directory");
		helpCommands.put("MD [path]", "Creates a directory as specified in a direct path");
		helpCommands.put("TIME", "Displays or sets the system time");
		helpCommands.put("REN", "Renames a file");
		helpCommands.put("COPY", "Copies one file to another location");
		helpCommands.put("MOVE", "Moves file from one location to another");
	}
	
	private void sortHelp() {																		// method sorting help commands hashmap keys by alphabet
		final Collator collator = Collator.getInstance(new Locale("us"));
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(helpCommands.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
		    @Override
		    public int compare(Entry<String, String> o1, Entry<String, String> o2) {
		        return collator.compare(o1.getKey(), o2.getKey());
		    }
		});
		sortedHelpCommands.addAll(list);
	}
	
	private void fillDisksList() {																	// method filling arraylist with names of user's partitions in format <C:>
		File[] partitions = File.listRoots();
	    for (File p : partitions) {
	    	StringBuilder temp = new StringBuilder(p.toString());
	    	temp.deleteCharAt(temp.length() - 1);
	    	drivesList.add(temp.toString());
		}
	}
	
	public ArrayList<String> getSimpleCommands() {													// getter for list of simple commands
		return simpleCommands;
	}

	public ArrayList<String> getExtendedCommands() {												// getter for list of extended commands
		return extendedCommands;
	}

	public String makeCompatible(String temp) {														// method adding "cd " before path to adapt it being modified by next methods
		String cd = "cd ";
		temp = cd.concat(temp);
		return temp;
	}
	
	public String clearSlash(String addPath) {														// reduce multiple slashes in path
		char[] slashSearch = addPath.toCharArray();
		StringBuilder slashString = new StringBuilder();
		char c, temp = slashSearch[slashSearch.length - 1];
		for(int i = slashSearch.length - 1; i >= 0; i--) {
			c = slashSearch[i];
			if(!(c == '\\' && c == temp))
				slashString.append(slashSearch[i]);
			temp = c;
		}
		slashString.reverse();
		addPath = slashString.toString();
		if(addPath.charAt(addPath.length() - 1) == '\\') 					// delete last slash
			addPath = new StringBuilder(addPath).deleteCharAt(addPath.length() - 1).toString();
//		System.out.println("weszlo");
		return addPath;
	}
	
	private boolean checkLegit(String addPath) {													// method checking if path doesn't contain forbidden signs
		char[] pathLetters = addPath.toCharArray();
		boolean legitCheck = true;
//		System.out.println("Extracted path: " + addPath);
		for (char c : pathLetters) {
			if(!(c >= ' ' && c <= '~') || c == '/' || c == ':' || c == '*' || c == '?' || c == '"' || c == '<' || c == '>' || c == '|')
				legitCheck = false;
		}
//		if(addPath.charAt(0) == '\\') {
//			legitCheck = false;
//			System.out.println("entered");
//		}
		return legitCheck;
	}
	
	private ArrayList<String> spaceSearch(ArrayList<String> pathInception){							// reduce space chars before exact path
//				for(String p : pathInception) {													// print out path structure
//					System.out.println("Folder: " + p);
//				}
		char[] spaceSearch = pathInception.get(0).toCharArray();
		StringBuilder newString = new StringBuilder();
		boolean ifEntered = false, nonSpaceSpotted = false;
//			System.out.println(pathInception.get(0));
		if(spaceSearch[0] == ' ') {
			ifEntered = true;
			for(int i = 0; i < spaceSearch.length; i++) {
				if(nonSpaceSpotted) {
					newString.append(spaceSearch[i]);
//					System.out.println("i" + i + "znak: " + spaceSearch[i]);
				}
				if(i + 1 < spaceSearch.length && !nonSpaceSpotted)
					if(spaceSearch[i + 1] != ' ')
						nonSpaceSpotted = true;
			}
		}
//				for(String p : pathInception) {													// print out path structure
//					System.out.println(p);
//				}
		if(nonSpaceSpotted) 
			pathInception.set(0, newString.toString());
		else if(ifEntered && !nonSpaceSpotted)
			return null;
		return pathInception;
	}
	
	public String spaceSearchDirect(String addPath){												// reduce space chars before exact path for direct path method
		char[] spaceSearch = addPath.toCharArray();
		StringBuilder newString = new StringBuilder();
		boolean ifEntered = false, nonSpaceSpotted = false;
		if(spaceSearch[0] == ' ') {
			ifEntered = true;
			for(int i = 0; i < spaceSearch.length; i++) {
				if(nonSpaceSpotted) {
					newString.append(spaceSearch[i]);
				}
				if(i + 1 < spaceSearch.length && !nonSpaceSpotted)
					if(spaceSearch[i + 1] != ' ')
						nonSpaceSpotted = true;
			}
		}
		if(nonSpaceSpotted) 
			addPath = newString.toString();
		else if(ifEntered && !nonSpaceSpotted)
			return null;
		return addPath;
	}
	
	private ArrayList<String> createArray(int size, String addPath) {								// create arraylist which consists of folders making full path
		ArrayList<String> pathInception = new ArrayList<String>();
		String path = addPath;
		String toAdd = "";
		for(int i = 0; i <= size; i++) {
//				System.out.println("path = " + path);
			if(path.indexOf("\\") != -1) {
				toAdd = path.substring(0, path.indexOf("\\"));
				path = path.substring(path.indexOf("\\") + 1);
//					System.out.println("path = " + path + ", a toAdd dodawany do tab = " + toAdd);
			}else {
				toAdd = path;
			}
			pathInception.add(toAdd);
		}
		return pathInception;
	}
	
	private ArrayList<String> preparePathSimple(String addPath, String currentPath) {				// method preparing path as an arraylist with included calls of methods: clearSlash, spaceSearchDirect, checkLegit, createArray; for indirect/path-penetrating entry method
		ArrayList<String> pathInception = new ArrayList<String>();
		int size = 0;
		addPath = clearSlash(addPath);
		boolean legitCheck = checkLegit(addPath);
		if(!legitCheck) 
			return null;
		char[] pathLetters = addPath.toCharArray();
		for(char c : pathLetters) {
			if(c == '\\')
				size++;
		}
		pathInception.addAll(createArray(size, addPath));

		return spaceSearch(pathInception);
	}
	
	private ArrayList<String> preparePathDirect(String addPath, String currentPath) {				// method preparing path as an arraylist with included calls of methods: clearSlash, spaceSearchDirect, checkLegit, createArray; for direct path entry method 
		ArrayList<String> pathInception = new ArrayList<String>();
		addPath = clearSlash(addPath);
		addPath = spaceSearchDirect(addPath);
		int size = 0;
		String tmp = "";
		if(addPath.length() > 2) {							// DISCLAIMER FOR PARTITION CHECK <C:\>
			tmp = addPath.substring(0, 2);
			addPath = addPath.substring(2);
		}
		boolean legitCheck = checkLegit(addPath);
		if(!legitCheck) 
			return null;
		addPath = tmp.concat(addPath);						// DISCLAIMER REVERSAL
		char[] pathLetters = addPath.toCharArray();
		for(char c : pathLetters) {							// depth of folder penetration encounter
			if(c == '\\')
				size++;
		}
		pathInception.addAll(createArray(size, addPath));

		return pathInception;
	}
	
	private String changePathCDSimple(String addPath, String currentPath) {							// method changing currentPath to new indirect/path-penetrating entry if path leads to existing folder
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathSimple(addPath, currentPath);
//		for(String p : pathInception) {													// print out path structure
//			System.out.println(p);
//		}
		if(pathInception == null) 
			return errorMessege;														// PENETRATING ENTRY CASE (INDIRECT)
		for(String nextFolder : pathInception) {
				currentPath = currentPath.concat("\\").concat(nextFolder);
				File toEnter = new File(currentPath);
				if(!toEnter.exists()) {
					System.out.println("Penetrating entry failed at: " + currentPath);
					return errorMessege;
				}
		}
//		System.out.println("Final path: " + currentPath);
		return currentPath;
	}
	
	private String changePathCDDirect(String addPath, String currentPath) {							// method changing currentPath to new direct path entry if path leads to existing folder
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathDirect(addPath, currentPath);
		if(pathInception == null) 
			return errorMessege;
		boolean ifDirectPath = false;
		for(String d : drivesList)
	    	if(pathInception.get(0).equalsIgnoreCase(d))
	    		ifDirectPath = true;
		if(ifDirectPath) {												// DIRECT PATH ENTRY CASE
			String directPath = "";
			for(String nextFolder : pathInception) {
				if(directPath.length() == 0)
					directPath = directPath.concat(nextFolder);
				else
					directPath = directPath.concat("\\").concat(nextFolder);
				File toEnter = new File(directPath);
				if(!toEnter.exists()) {
					System.out.println("Direct path failed at: " + directPath);
					return errorMessege;
				}
				currentPath = directPath;
			}
		}else
			System.out.println("Cannot find specified disk");
		return currentPath;
	}
	
	private String makePathDirectorySimple(String addPath, String currentPath) {					// method realizing functionality of folder creation if given path has penetrating character
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathSimple(addPath, currentPath);
		if(pathInception == null) 
			return errorMessege;																	// PENETRATING ENTRY CASE
		for(String nextFolder : pathInception) {
			currentPath = currentPath.concat("\\").concat(nextFolder);
			File toEnter = new File(currentPath);
			if(!toEnter.exists()) {
				toEnter.mkdir();
				System.out.println("Created bridge folder at: " + currentPath);
			}
		}
		return currentPath;
	}
	
	private String makePathDirectoryDirect(String addPath, String currentPath) {					// method realizing functionality of folder creation if given path is direct
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathDirect(addPath, currentPath);
		if(pathInception == null) 
			return errorMessege;
		boolean ifDirectPath = false;
		for(String d : drivesList)
	    	if(pathInception.get(0).equalsIgnoreCase(d))
	    		ifDirectPath = true;
		if(ifDirectPath) {
			String directPath = "";
			for(String nextFolder : pathInception) {
				if(directPath.length() == 0)
					directPath = directPath.concat(nextFolder);
				else
					directPath = directPath.concat("\\").concat(nextFolder);
				File toEnter = new File(directPath);
				if(!toEnter.exists()) {
					toEnter.mkdir();
					System.out.println("Created bridge folder at: " + directPath);
				}
				currentPath = directPath;
			}
		}else
			System.out.println("Cannot find specified disk");
		return currentPath;
	}
		
	public void exit() {																			// exit method
		System.out.println("Zamknieto instancje okna komend");
	}
	
	public void help() {																			// help menu method
		System.out.println("For more information on a specific command, contact the author of the code\n");
		
//		PRINTING UNSORTED VALUES OF HELP MAP 
//		Set<String> keys = helpCommands.keySet();
//		for(String s : keys)
//			System.out.println(s + " " + helpCommands.get(s));

		for(Map.Entry<String, String> entry : sortedHelpCommands){
			if(entry.getKey().length() > 7)
				System.out.println(entry.getKey() + "\t" + entry.getValue());
			else
				System.out.println(entry.getKey() + "\t\t" + entry.getValue());
	    }
	}
	
	public void executeCD(String currentPath) {														// simple printing current working directory path
		System.out.println(currentPath);
	}
	
	public String createCDSimple(String currentPath, String input, boolean isForMkdirCommand) {		// method for indirect path entries (basing on extending current path)
		String addPath = input.substring(3);
		String newPath = changePathCDSimple(addPath, currentPath);
		if(newPath.equals(">fail")) {
			if(!isForMkdirCommand)
				System.out.println("The system cannot find the specified path.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	public String createCDDirect(String currentPath, String input, boolean isForMkdirCommand) {		// method for direct path entries or changing working driveto bare drive location as for eg. <C:\>
		String newPath = "";
		String addPath = input.substring(3);
		String currentDisk = currentPath.substring(0, 1);									// get disk from current path
		boolean diskChange = true, ifOnDisksList = false;
		for(String d : drivesList)															// check if user wants to change path to just clear disk path which is allowed
	    	if(addPath.equalsIgnoreCase(d))
	    		ifOnDisksList = true;
		if(currentPath.length() >= addPath.length() && (ifOnDisksList || currentPath.substring(0, (addPath.length()) - 1).equalsIgnoreCase(addPath)))		// condition for same path & shallower folder penetration or changing to bare disk path
			newPath = addPath;
		else
			newPath = changePathCDDirect(addPath, currentPath);
		String newPathDisk = newPath.substring(0, 1);										// get disk from new path
//		System.out.println("newPathDisk = " + newPathDisk + " currentDisk = " + currentDisk);
    	if(newPathDisk.equalsIgnoreCase(currentDisk))										// check if disk from new path is the same as in current path
    		diskChange = false;
		if(!ifOnDisksList && diskChange && !newPath.equalsIgnoreCase(currentPath))													// if user changes path to another disk and its not a clear disk path
			newPath = ">fail";
		if(newPath.equals(">fail")) {
			if(!isForMkdirCommand)
				System.out.println("The system cannot find the specified path.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	public String createCDDiskDirect(String currentPath, String input) {							// method for direct path entries with special functionality of changing working drive to an exact level of specified direct location
//		System.out.println("wywolano Disk Change Direct");
		String newPath = "";
		String addPath = input.substring(6);
		boolean ifOnDisksList = false;
		for(String d : drivesList)
	    	if(addPath.equalsIgnoreCase(d))
	    		ifOnDisksList = true;
		if(currentPath.length() >= addPath.length() && (ifOnDisksList || currentPath.substring(0, (addPath.length()) - 1).equalsIgnoreCase(addPath)))
			newPath = addPath;
		else
		newPath = changePathCDDirect(addPath, currentPath);
		if(newPath.equals(">fail")) {
			System.out.println("The system cannot find the specified path.");
			newPath = currentPath;
		}
		return newPath;
	}
		
	public String enterPrevious(String currentPath) {												// method returns path of higher folder
		if(currentPath.indexOf('\\') != -1) {
			StringBuilder newPath = new StringBuilder(currentPath);
			newPath.reverse();
			newPath.delete(0, newPath.indexOf("\\") + 1).reverse();
			currentPath = newPath.toString();
		}
		return currentPath;
	}
	
	public void makeDirectorySimple(String currentPath, String input) {								// method creating new directory starting from current path
		boolean isForMkdirCommand = true;
		String cdDirectEntry = createCDSimple(currentPath, input, isForMkdirCommand);		// if entry is successful, returns path different from currentPath
		if(!currentPath.equalsIgnoreCase(cdDirectEntry))
			System.out.println("A subdirectory or file eclipse already exists.");
		else{
			String addPath = input.substring(3);
			String newPath = makePathDirectorySimple(addPath, currentPath);
			if(newPath.equals(">fail"))
				System.out.println("The file name, directory name, or volume label syntax is incorrect, or unknown error has occured");
		}
	}
	
	public void makeDirectoryDirect(String currentPath, String input) {								// method creating new directory using given direct path
		boolean isForMkdirCommand = true;
		String cdDirectEntry = createCDDirect(currentPath, input, isForMkdirCommand);		// if entry is successful, returns path different from currentPath
		if(!currentPath.equalsIgnoreCase(cdDirectEntry))
			System.out.println("A subdirectory or file eclipse already exists");
		else {
			String addPath = input.substring(3);
			String newPath = addPath;
			newPath = makePathDirectoryDirect(addPath, currentPath);
			if(newPath.equals(">fail"))
				System.out.println("The file name, directory name, or volume label syntax is incorrect, or unknown error has occured");
		}
	}
	
	public void executeCHDIR(String currentPath) {													// simple printing current working directory path
		System.out.println(currentPath);
	}
	
	public String createCHDIRDirect(String currentPath, String input) {								// method for direct path entries or changing working driveto bare drive location as for eg. <C:\>
		String newPath = "";
		String addPath = input.substring(6);
		String currentDisk = currentPath.substring(0, 1);
		boolean diskChange = true, ifOnDisksList = false;
		for(String d : drivesList)
	    	if(addPath.equalsIgnoreCase(d))
	    		ifOnDisksList = true;
		if(currentPath.length() >= addPath.length() && (ifOnDisksList || currentPath.substring(0, (addPath.length()) - 1).equalsIgnoreCase(addPath)))
			newPath = addPath;
		else
			newPath = changePathCDDirect(addPath, currentPath);
		String newPathDisk = newPath.substring(0, 1);
//		System.out.println("newPathDisk = " + newPathDisk + " currentDisk = " + currentDisk);
    	if(newPathDisk.equalsIgnoreCase(currentDisk))
    		diskChange = false;
		if(!ifOnDisksList && diskChange && !newPath.equalsIgnoreCase(currentPath))
			newPath = ">fail";
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
		
	public String createCHDIRSimple(String currentPath, String input) {								// method for indirect path entries (basing on extending current path)
		String newPath = "";
		String addPath = input.substring(6);
		newPath = changePathCDSimple(addPath, currentPath);
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	public String createCHDIRDiskDirect(String currentPath, String input) {							// method for direct path entries with special functionality of changing working drive to an exact level of specified direct location
//		System.out.println("wywolano Disk Change Direct");
		String newPath = "";
		String addPath = input.substring(9);
		boolean ifOnDisksList = false;
		for(String d : drivesList)
	    	if(addPath.equalsIgnoreCase(d))
	    		ifOnDisksList = true;
		if(currentPath.length() >= addPath.length() && (ifOnDisksList || currentPath.substring(0, (addPath.length()) - 1).equalsIgnoreCase(addPath)))
			newPath = addPath;
		else
		newPath = changePathCDDirect(addPath, currentPath);
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	public String enterPreviousCHDIR(String currentPath) {											// method returns path of higher folder
		if(currentPath.indexOf('\\') != -1) {
			StringBuilder newPath = new StringBuilder(currentPath);
			newPath.reverse();
			newPath.delete(0, newPath.indexOf("\\") + 1).reverse();
			currentPath = newPath.toString();
		}
		return currentPath;
	}

	public void showTime() {																		// show time
		DateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
		Calendar currentDate = Calendar.getInstance();
		System.out.println(currentTime.format(currentDate.getTime()));
	}

	public void showVersion() {																		// show os version
		System.out.println("Microsoft " + System.getProperty("os.name"));
	}
	
	public void deleteFile(String currentPath, String input) {										// method for deleting files
		String fileName = input.substring(4);
		if(fileName.length() > 0) {
			File toDelete = new File(currentPath + "\\" + input);
			if(toDelete.isFile())
				toDelete.delete();
			else
				System.out.println("Could Not Find " + input);
		}else
			System.out.println("The syntax of the command is incorrect");
	}
	
	public void removeDirectory(String currentPath, String input) {									// method for removing directories
		String directoryName = input.substring(6);
		if(directoryName.length() > 0) {
			File directoryToRemove = new File(currentPath + "\\" + input);
			if(directoryToRemove.isDirectory())
				directoryToRemove.delete();
			else
				System.out.println("Couldn't find specified file");
		}else
			System.out.println("The syntax of the command is incorrect");
	}
	
	public void renameFile(String currentPath, String input) {										// method for renaming files
		String command = input.substring(6);
		String NameOfFileToBeRenamed, newName;
		String[] names = command.split(" ");
		if(names.length == 2) {
			NameOfFileToBeRenamed = names[0];
			newName = names[1];
			File fileToBeRenamed = new File(currentPath + "\\" + NameOfFileToBeRenamed);
			File newFileName = new File(currentPath + "\\" + newName);
			if(fileToBeRenamed.exists())
				fileToBeRenamed.renameTo(newFileName);
			else
				System.out.println("Couldn't find specified file");
		}else
			System.out.println("The syntax of the command is incorrect");
	}
	
	public void renFile(String currentPath, String input) {											// method for renaming files
		String command = input.substring(4);
		String NameOfFileToBeRenamed, newName;
		String[] names = command.split(" ");
		if(names.length == 2) {
			NameOfFileToBeRenamed = names[0];
			newName = names[1];
			File fileToBeRenamed = new File(currentPath + "\\" + NameOfFileToBeRenamed);
			File newFileName = new File(currentPath + "\\" + newName);
			if(fileToBeRenamed.exists())
				fileToBeRenamed.renameTo(newFileName);
			else
				System.out.println("Couldn't find specified file");
		}else
			System.out.println("The syntax of the command is incorrect");
	}
	
	public void replaceFile(String currentPath, String input) {										// method for files replacement
		String command = input.substring(8);
		String NameOfDeeperDirectory, donorName;
		String[] names = command.split(" ");
		if(names.length == 2) {
			donorName = names[0];
			NameOfDeeperDirectory = names[1];
			File replacingFile = new File(currentPath + "\\" + donorName);
			File fileToBeReplaced = new File(currentPath + "\\" + NameOfDeeperDirectory + "\\" + donorName);
			if(fileToBeReplaced.exists() && replacingFile.exists()) {
				try {
					Files.copy(replacingFile.toPath(), fileToBeReplaced.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else
				System.out.println("Couldn't find specified file");
		}else
			System.out.println("The syntax of the command is incorrect");
	}
	
	public void copyFile(String currentPath, String input) {										// method for copying files
		String command = input.substring(5);
		String NameOfFileToBeCopied, copyPathName;
		String[] names = command.split(" ");
		if(names.length == 2) {
			NameOfFileToBeCopied = names[0];
			copyPathName = names[1];
			File fileToBeCopied = new File(currentPath + "\\" + NameOfFileToBeCopied);
			File copyPath = new File(currentPath + "\\" + copyPathName);
			if(fileToBeCopied.exists() && fileToBeCopied.isFile()) {
				try {
					Files.copy(fileToBeCopied.toPath(), copyPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else
				System.out.println("Couldn't find specified file");
		}else
			System.out.println("The syntax of the command is incorrect");
	}
	
	public void moveFile(String currentPath, String input, Scanner in) {							// method for moving files
		String command = input.substring(5);
		String NameOfFileToBeMoved, movePathName;
		String[] names = command.split(" ");
		if(names.length == 2) {
			NameOfFileToBeMoved = names[0];
			movePathName = names[1];
			File fileToBeMoved = new File(currentPath + "\\" + NameOfFileToBeMoved);
			File movePath = new File(currentPath + "\\" + movePathName);
			if(fileToBeMoved.exists() && fileToBeMoved.isFile()) {
				if(movePath.exists() && movePath.isDirectory())
					movePath = new File(currentPath + "\\" + movePathName + "\\" + NameOfFileToBeMoved);
				if(movePath.exists() && movePath.isFile()) {
					String makeChoice = "NO", optionYes = "YES", optionNo = "NO";
					boolean exit = true;
					while(exit) {
						System.out.print("Overwrite " + movePath + "? (Yes/No):");
						makeChoice = in.nextLine();
						if(makeChoice.equalsIgnoreCase(optionYes) || makeChoice.equalsIgnoreCase(optionNo))
							exit = false;
					}
					boolean ifWantsOverrite = false;
					if(makeChoice.equalsIgnoreCase("YES"))
						ifWantsOverrite = true;
					if(ifWantsOverrite) {
						try {
							Files.copy(fileToBeMoved.toPath(), movePath.toPath(), StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e) {
							e.printStackTrace();
						}
						fileToBeMoved.delete();
					}
				}else {
					try {
						Files.copy(fileToBeMoved.toPath(), movePath.toPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
					fileToBeMoved.delete();
				}
			}else
				System.out.println("Couldn't find specified file");
		}else
			System.out.println("The syntax of the command is incorrect");
	}

	public void showDir(String currentPath) {														// method listing all files and directories in actual working directory
		File currentDirectory = new File(currentPath);
		String[] directoryContent = currentDirectory.list();
		for(String positionOnList : directoryContent)
			System.out.println(positionOnList);
	}
}
	
	