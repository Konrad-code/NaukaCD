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
	
	private void fillHelp() {
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
	}
	
	private void sortHelp() {
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
	
	private void fillDisksList() {
		File[] partitions = File.listRoots();
	    for (File p : partitions) {
	    	StringBuilder temp = new StringBuilder(p.toString());
	    	temp.deleteCharAt(temp.length() - 1);
	    	drivesList.add(temp.toString());
		}
	}
	
	public ArrayList<String> getSimpleCommands() {
		return simpleCommands;
	}

	public ArrayList<String> getExtendedCommands() {
		return extendedCommands;
	}

	private boolean checkLegit(String addPath) {
		char[] pathLetters = addPath.toCharArray();
		boolean legitCheck = true;
//		System.out.println("Extracted path: " + addPath);
		char temp = 'a';
		for (char c : pathLetters) {
			if(!(c >= ' ' && c <= '~') || c == '/' || c == ':' || c == '*' || c == '?' || c == '"' || c == '<' || c == '>' || c == '|')
				legitCheck = false;
			if(c == '\\' && c == temp)
				legitCheck = false;
			temp = c;
		}
//		if(addPath.charAt(0) == '\\') {
//			legitCheck = false;
//			System.out.println("entered");
//		}
		return legitCheck;
	}
	
	private ArrayList<String> preparePath(String addPath, String currentPath) {
		ArrayList<String> pathInception = new ArrayList<String>();
		int size = 0;
		String tmp = "";
		if(addPath.length() > 2) {			// DISCLAIMER FOR PARTITION CHECK "X:\"
			tmp = addPath.substring(0, 2);
			addPath = addPath.substring(2);
		}
		boolean legitCheck = checkLegit(addPath);
		System.out.println(legitCheck);
		if(!legitCheck) 
			return null;
		else {
			addPath = tmp.concat(addPath);						// DISCLAIMER REVERSAL
			if(addPath.charAt(addPath.length() - 1) == '\\') 
				addPath = new StringBuilder(addPath).deleteCharAt(addPath.length() - 1).toString();
			char[] pathLetters = addPath.toCharArray();
			for(char c : pathLetters) {
				if(c == '\\')
					size++;
			}
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
		for(String p : pathInception) {													// print out path structure
			System.out.println("Folder: " + p);
		}
			char[] spaceSearch = pathInception.get(0).toCharArray();
			StringBuilder newString = new StringBuilder();
			boolean flag = false;
			System.out.println(pathInception.get(0));
			if(spaceSearch[0] == ' ') {
				for(int i = 0; i < spaceSearch.length; i++) {
					if(flag) {
						newString.append(spaceSearch[i]);
						System.out.println("i" + i + "znak: " + spaceSearch[i]);
					}
					if(i + 1 < spaceSearch.length && !flag)
						if(spaceSearch[i + 1] != ' ')
							flag = true;
				}
				System.out.println("pierwsze ze spacja");
			}
		for(String p : pathInception) {													// print out path structure
			System.out.println(p);
		}
			if(flag) {
				pathInception.set(0, newString.toString());
				System.out.println("weszlo");
			}else
				return null;
		}
		return pathInception;
	}
	
	private String changePathCD(String addPath, String currentPath) {
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePath(addPath, currentPath);
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
		}else 																			// PENETRATING ENTRY CASE
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
		ArrayList<String> pathInception = preparePath(addPath, currentPath);
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
	
	public void exit() {
		System.out.println("Zamknieto instancje okna komend");
	}
	
	public void help() {
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
	
	public void executeCD(String currentPath) {
		System.out.println(currentPath);
	}
	
	public String createCD(String currentPath, String input) {
		String newPath = "";
		String addPath = input.substring(3);
		boolean ifOnDisksList = false;
		for(String d : drivesList)
	    	if(addPath.equalsIgnoreCase(d))
	    		ifOnDisksList = true;
		if(currentPath.length() >= addPath.length() && (ifOnDisksList || currentPath.substring(0, (addPath.length()) - 1).equalsIgnoreCase(addPath)))
			newPath = addPath;
		else
		newPath = changePathCD(addPath, currentPath);
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	
	
	
	
	
	
	
	
	
	public String createCDSimple(String currentPath, String input) {
		String newPath = "";
		String addPath = input.substring(3);
		newPath = changePathCDSimple(addPath, currentPath);
		if(newPath.equals(">fail")) {
			System.out.println("User entered invalid(unexisting) path. Operation aborted.");
			newPath = currentPath;
		}
		return newPath;
	}
	
	private boolean checkLegitSimple(String addPath) {
		char[] pathLetters = addPath.toCharArray();
		boolean legitCheck = true;
//		System.out.println("Extracted path: " + addPath);
		char temp = 'a';
		for (char c : pathLetters) {
			if(!(c >= ' ' && c <= '~') || c == '/' || c == ':' || c == '*' || c == '?' || c == '"' || c == '<' || c == '>' || c == '|')
				legitCheck = false;
			if(c == '\\' && c == temp)
				legitCheck = false;
			temp = c;
		}
//		if(addPath.charAt(0) == '\\') {
//			legitCheck = false;
//			System.out.println("entered");
//		}
		return legitCheck;
	}
	
	private ArrayList<String> preparePathSimple(String addPath, String currentPath) {
		ArrayList<String> pathInception = new ArrayList<String>();
		int size = 0;
		char[] slashSearch = addPath.toCharArray();
		StringBuilder slashString = new StringBuilder();
		boolean flagSlash = false;
		if(slashSearch[slashSearch.length - 1] == '\\') {
			for(int i = slashSearch.length - 1; i >= 0; i--) {
				if(flagSlash) {
					slashString.append(slashSearch[i]);
					System.out.println("i" + i + "znak: " + slashSearch[i]);
				}
				if(i - 1 < 0 && !flagSlash)
					if(slashSearch[i - 1] != '\\')
						flagSlash = true;
			}
			slashString.reverse();
			if(flagSlash) {
				addPath = slashString.toString();
				System.out.println("weszlo");
			}else
				return null;
		}
			
		boolean legitCheck = checkLegitSimple(addPath);
		if(!legitCheck) 
			return null;
		else {
			char[] pathLetters = addPath.toCharArray();
			for(char c : pathLetters) {
				if(c == '\\')
					size++;
			}
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
		for(String p : pathInception) {													// print out path structure
			System.out.println("Folder: " + p);
		}
			char[] spaceSearch = pathInception.get(0).toCharArray();
			StringBuilder newString = new StringBuilder();
			boolean flag = false;
			System.out.println(pathInception.get(0));
			if(spaceSearch[0] == ' ') {
				for(int i = 0; i < spaceSearch.length; i++) {
					if(flag) {
						newString.append(spaceSearch[i]);
						System.out.println("i" + i + "znak: " + spaceSearch[i]);
					}
					if(i + 1 < spaceSearch.length && !flag)
						if(spaceSearch[i + 1] != ' ')
							flag = true;
				}
				System.out.println("pierwsze ze spacja");
			}
		for(String p : pathInception) {													// print out path structure
			System.out.println(p);
		}
			if(flag) {
				pathInception.set(0, newString.toString());
				System.out.println("weszlo");
			}else
				return null;
		}
		return pathInception;
	}
	
	private String changePathCDSimple(String addPath, String currentPath) {
		String errorMessege = ">fail";
		ArrayList<String> pathInception = preparePathSimple(addPath, currentPath);
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
		}else 																			// PENETRATING ENTRY CASE
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
	
	