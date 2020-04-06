package CMD;

import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Console {
	private ArrayList<String> simpleCommands = new ArrayList<String>(Arrays.asList("cd", "cd..", "help", "dir", "exit", "cmd"));
	private ArrayList<String> extendedCommands = new ArrayList<String>(Arrays.asList("cd ", "mkdir ", "replace ", "rename ", "rmdir ", "del "));
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
//		helpCommands.put("CD..", "Changes the current directory to a higher directory");
//		helpCommands.put("MKDIR", "Creates a directory");
		helpCommands.put("HELP", "Provides Help information for Windows commands");
//		helpCommands.put("DIR", "Displays a list of files and subdirectories in a directory");
		helpCommands.put("EXIT", "Quits the CMD.EXE program");
//		helpCommands.put("REPLACE", "Replaces files");
//		helpCommands.put("RENAME", "Renames a file");
//		helpCommands.put("RMDIR", "Removes a directory");
//		helpCommands.put("DEL", "Deletes one file");
		helpCommands.put("CMD", "Starts a new instance of the Windows command interpreter");
		helpCommands.put("CD [..]", "  ..   Specifies that you want to change to the parent directory");
		helpCommands.put("CD [/D] [drive:][path]", "Use the /D switch to change current drive in addition to changing current directory for a drive");
		
	}
	
	private void sortHelp() {															// method sorting help commands hashmap keys by alphabet
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
	
	private void fillDisksList() {														// method filling arraylist with names of user's partitions in format <C:>
		File[] partitions = File.listRoots();
	    for (File p : partitions) {
	    	StringBuilder temp = new StringBuilder(p.toString());
	    	temp.deleteCharAt(temp.length() - 1);
	    	drivesList.add(temp.toString());
		}
	}
	
	public ArrayList<String> getSimpleCommands() {										// getter for list of simple commands
		return simpleCommands;
	}

	public ArrayList<String> getExtendedCommands() {									// getter for list of extended commands
		return extendedCommands;
	}

	public String clearSlash(String addPath) {											// reduce multiple slashes in path
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
	
	private boolean checkLegit(String addPath) {										// method checking if path doesn't contain forbidden signs
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
	
	private ArrayList<String> spaceSearch(ArrayList<String> pathInception){				// reduce space chars before exact path
				for(String p : pathInception) {													// print out path structure
					System.out.println("Folder: " + p);
				}
		char[] spaceSearch = pathInception.get(0).toCharArray();
		StringBuilder newString = new StringBuilder();
		boolean ifEntered = false, nonSpaceSpotted = false;
//			System.out.println(pathInception.get(0));
		if(spaceSearch[0] == ' ') {
			ifEntered = true;
			for(int i = 0; i < spaceSearch.length; i++) {
				if(nonSpaceSpotted) {
					newString.append(spaceSearch[i]);
					System.out.println("i" + i + "znak: " + spaceSearch[i]);
				}
				if(i + 1 < spaceSearch.length && !nonSpaceSpotted)
					if(spaceSearch[i + 1] != ' ')
						nonSpaceSpotted = true;
			}
			System.out.println("pierwsze ze spacja");
		}
				for(String p : pathInception) {													// print out path structure
					System.out.println(p);
				}
		if(nonSpaceSpotted) {
			pathInception.set(0, newString.toString());
//			System.out.println("weszlo");
		}else if(ifEntered && !nonSpaceSpotted)
			return null;
		return pathInception;
	}
	
	public String spaceSearchDirect(String addPath){									// reduce space chars before exact path for direct path method
		char[] spaceSearch = addPath.toCharArray();
		StringBuilder newString = new StringBuilder();
		boolean ifEntered = false, nonSpaceSpotted = false;
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
//			System.out.println("pierwsze ze spacja");
		}
		if(nonSpaceSpotted) {
			addPath = newString.toString();
			System.out.println("weszlo");
		}else if(ifEntered && !nonSpaceSpotted)
			return null;
		return addPath;
	}
	
	private ArrayList<String> createArray(int size, String addPath) {					// create arraylist which consists of folders making full path
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
	
	private ArrayList<String> preparePathDirect(String addPath, String currentPath) {	// method preparing path as an arraylist with included calls of methods: clearSlash, spaceSearchDirect, checkLegit, createArray; for direct path entry method 
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
//		System.out.println(legitCheck);
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
	
	private ArrayList<String> preparePathSimple(String addPath, String currentPath) {	// method preparing path as an arraylist with included calls of methods: clearSlash, spaceSearchDirect, checkLegit, createArray; for indirect/path-penetrating entry method
		ArrayList<String> pathInception = new ArrayList<String>();
		int size = 0;
		System.out.println(addPath);
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
	
	private String changePathCDDirect(String addPath, String currentPath) {				// method changing currentPath to new direct path entry if path leads to existing folder
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathDirect(addPath, currentPath);
//		for(String p : pathInception) {													// print out path structure
//			System.out.println(p);
//		}
		if(pathInception == null) 
			return errorMessege;
		boolean ifDirectPath = false;
		for(String d : drivesList)
	    	if(pathInception.get(0).equalsIgnoreCase(d))
	    		ifDirectPath = true;
		if(ifDirectPath) {																// DIRECT PATH ENTRY CASE
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
		}
//		System.out.println("Final path: " + currentPath);
		return currentPath;
	}
	
	private String changePathCDSimple(String addPath, String currentPath) {				// method changing currentPath to new indirect/path-penetrating entry if path leads to existing folder
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
	
	private String changePathDirectory(String addPath, String currentPath) {
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathDirect(addPath, currentPath);
//		for(String p : pathInception) {													// print out path structure
//			System.out.println(p);
//		}
		if(pathInception == null) 
			return errorMessege;
		boolean ifDirectPath = false;
		for(String d : drivesList)
	    	if(pathInception.get(0).equalsIgnoreCase(d))
	    		ifDirectPath = true;
		if(ifDirectPath) {																// DIRECT PATH ENTRY CASE
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
		}else 																			// PENETRATING ENTRY CASE
			for(String nextFolder : pathInception) {
					currentPath = currentPath.concat("\\").concat(nextFolder);
					File toEnter = new File(currentPath);
					if(!toEnter.exists()) {
						toEnter.mkdir();
						System.out.println("Created bridge folder at: " + currentPath);
					}
			}
//		System.out.println("Final path: " + currentPath);
		return currentPath;
	}
	
	public void exit() {																// exit method
		System.out.println("Zamknieto instancje okna komend");
	}
	
	public void help() {																// help menu method
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
	
	public void executeCD(String currentPath) {											// simple printing current working directory path
		System.out.println(currentPath);
	}
	
	public String createCDDirect(String currentPath, String input) {					// method for direct path entries or changing working driveto bare drive location as for eg. <C:\>
		String newPath = "";
		String addPath = input.substring(3);
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
		if(!ifOnDisksList && diskChange)
			newPath = ">fail";
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
		
	public String createCDSimple(String currentPath, String input) {					// method for indirect path entries (basing on extending current path)
		String newPath = "";
		String addPath = input.substring(3);
		newPath = changePathCDSimple(addPath, currentPath);
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	public String createCDDiskDirect(String currentPath, String input) {				// method for direct path entries with special functionality of changing working drive to an exact level of specified direct location
		System.out.println("wywolano Disk Change Direct");
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
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void makeDirectory(String currentPath, String input) {
		String addPath = input.substring(6);
		int slashCounter = 0;
		int newFolderLength = 0;
		File newFolder;
		String folder = "";
		if(addPath.charAt(addPath.length() - 1) == '\\')
			addPath = addPath.substring(0, addPath.length() - 1);
		char[] path = addPath.toCharArray();
		for(char c : path) {
			if(c == '\\')
				slashCounter++;
		}
		if(slashCounter > 0) {
			StringBuilder sb = new StringBuilder(addPath);
			sb.reverse();
			char[] reversedPath = sb.toString().toCharArray();
			for(int i = 0; reversedPath[i] != '\\'; i++) {
				newFolderLength++;
			}
			folder = addPath.substring(addPath.length() - newFolderLength);
			addPath = addPath.substring(0, addPath.length() - (newFolderLength + 1));
//			System.out.println(addPath + " " + folder);
		}else
			folder = addPath;
		if(checkLegit(folder)) {
			if(slashCounter > 0) {
				String newPath = changePathDirectory(addPath, currentPath);
				if(newPath.equals(">fail"))
					System.out.println("User entered invalid path consisting of illegal symbols. Operation aborted.");
				newFolder = new File(newPath + "\\" + folder);
			}else {
				newFolder = new File(currentPath + "\\" + folder);
			}
			if(newFolder.exists()) {
				System.out.println("Specified directory for name entered by user already exists");
			}else
				newFolder.mkdir();
		}
	}
	
	
}
	
	