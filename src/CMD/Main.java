package CMD;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static File fileSelected = null;
	
	public static void main(String[] args) {
		String homePath = System.getProperty("user.home");
		Scanner in = new Scanner(System.in);
		runConsole(new Console(), in, homePath);
		in.close();
	}
		
	private static void printWelcome() {
		System.out.println("+------------------------------------+");
		System.out.println("|                                    |");
		System.out.println("|     Welcome to Command Prompt!     |");
		System.out.println("|                                    |");
		System.out.println("+------------------------------------+");
	}
	
	private static void printLine(String path, String input) {
		System.out.println(path + ">" + input);
	}
	
	private static String getInputSimple(String input, Console cmd){
		String output = "no match";
		for(String simpleCommand : cmd.getSimpleCommands())
			if(input.equalsIgnoreCase(simpleCommand))
				output = input;
		return output;
	}
		
	private static String getInputExtended(String input, Console cmd){
		String output = "no match";
		for(String extendedCommand : cmd.getExtendedCommands())
			if(input.startsWith(extendedCommand) && extendedCommand.length() < input.length())
				output = input;
		return output;
	}
		
	private static String provideInput(Console cmd, Scanner in, String currentPath) {
		boolean ifProperInput = true;
		String input = "";
		while(ifProperInput) {
			input = in.nextLine();
//            input = input.toLowerCase();
			try {
				String inputSimple = getInputSimple(input, cmd);
				String inputExtended = getInputExtended(input, cmd);
				if(inputSimple.equals("no match") && inputExtended.equals("no match"))
					throw new ExceptionInput();
				if(inputSimple.equals("no match"))
					input = inputExtended;
				else if(inputExtended.equals("no match"))
					input = inputSimple;
				ifProperInput = false;
			}catch(ExceptionInput ex){
				System.out.println("'" + input + "' is not recognized as an internal or external command,\r\n" + 
						"operable program or batch file.\n");
				System.out.print(currentPath + ">");
			}
		}
		return input;
	}
	
	public static String runConsole(Console cmd, Scanner in, String homePath){
		printWelcome();
		boolean exit = false;
		String currentPath = homePath;
		String input = "";
		while(!exit) {
			boolean isForMkdirCommand = false;
			System.out.print(currentPath + ">");
			input = provideInput(cmd, in, currentPath);
			if(input.equalsIgnoreCase("exit")) { 
				cmd.exit();																				// 1
				exit = true;
			}else if(input.equalsIgnoreCase("help")) 
				cmd.help();																				// 2
			else if(input.equalsIgnoreCase("cd")) 
				cmd.executeCD(currentPath);																// 3
			else if(input.startsWith("cd ")) {
				String temp = cmd.spaceSearchDirect(cmd.clearSlash(input.substring(3)));
				if(temp.length() > 1 && temp.charAt(1) == ':')
					currentPath = cmd.createCDDirect(currentPath, input, isForMkdirCommand);			// 4
//		 			works correct for for example: <cd    C:\\\Users\mHm_MaXi\\\Desktop\AKADEMIA KODU\\\23 zajecia\2 zadanie (logowania) Konrad\\\\\>
				else if(temp.length() > 1 && temp.substring(0, 2).equals("/D"))
					currentPath = cmd.createCDDiskDirect(currentPath, input);							// 5
				else
					currentPath = cmd.createCDSimple(currentPath, input, isForMkdirCommand);			// 6
			}else if(input.equalsIgnoreCase("cd.."))
				currentPath = cmd.enterPrevious(currentPath);											// 7
			else if(input.startsWith("mkdir ")) {
				String temp = cmd.spaceSearchDirect(cmd.clearSlash(input.substring(6)));
				temp = cmd.makeCompatible(temp);
				if(temp.length() > 5 && temp.charAt(4) == ':') {
					cmd.makeDirectoryDirect(currentPath, temp);											// 8
				}else
					cmd.makeDirectorySimple(currentPath, temp);											// 9
			}else if(input.equalsIgnoreCase("cmd")) {
				String tempPath = currentPath;
				runConsole(new Console(), in, currentPath);												// 10
				currentPath = tempPath;
			}else if(input.equalsIgnoreCase("chdir")) 
				cmd.executeCHDIR(currentPath);															// 11
			else if(input.startsWith("chdir ")) {
				String temp = cmd.spaceSearchDirect(cmd.clearSlash(input.substring(6)));
				if(temp.length() > 1 && temp.charAt(1) == ':')
					currentPath = cmd.createCHDIRDirect(currentPath, input);							// 12
//			 		works correct for for example: <chdir    C:\\\Users\mHm_MaXi\\\Desktop\AKADEMIA KODU\\\23 zajecia\2 zadanie (logowania) Konrad\\\\\>
				else if(temp.length() > 1 && temp.substring(0, 2).equals("/D"))
					currentPath = cmd.createCHDIRDiskDirect(currentPath, input);						// 13
				else
					currentPath = cmd.createCHDIRSimple(currentPath, input);							// 14
			}else if(input.equalsIgnoreCase("chdir.."))
				currentPath = cmd.enterPreviousCHDIR(currentPath);										// 15
			else if(input.startsWith("md ")){
				String temp = cmd.spaceSearchDirect(cmd.clearSlash(input.substring(3)));
				temp = cmd.makeCompatible(temp);
				if(temp.length() > 5 && temp.charAt(4) == ':') {
					cmd.makeDirectoryDirect(currentPath, temp);
				}else
					cmd.makeDirectorySimple(currentPath, temp);
			}else if(input.equalsIgnoreCase("time"))
				cmd.showTime();																			// 16
			else if(input.equalsIgnoreCase("ver"))
				cmd.showVersion();																		// 17
			else if(input.startsWith("del "))
				cmd.deleteFile(currentPath, input);														// 18
			else if(input.startsWith("rmdir "))
				cmd.removeDirectory(currentPath, input);												// 19
			else if(input.startsWith("rename "))
				cmd.renameFile(currentPath, input);														// 20
			else if(input.startsWith("replace "))
				cmd.replaceFile(currentPath, input);													// 21
			else if(input.startsWith("ren "))
				cmd.renFile(currentPath, input);
			else if(input.startsWith("copy "))
				cmd.copyFile(currentPath, input);														// 22
			else if(input.startsWith("move "))
				cmd.moveFile(currentPath, input, in);													// 23
			else if(input.equalsIgnoreCase("dir"))
				cmd.showDir(currentPath);																// 24
		}
		return currentPath;
	}
	
}