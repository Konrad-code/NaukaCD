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
			if(input.startsWith(extendedCommand))
				output = input;
		return output;
	}
		
	private static String provideInput(Console cmd, Scanner in, String currentPath) {
		boolean ifProperInput = true;
		String input ="";
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
		int i = 0;
		while(!exit) {
			System.out.print(currentPath + ">");
			input = provideInput(cmd, in, currentPath);
			if(input.equalsIgnoreCase("exit")) { 
				cmd.exit();
				exit = true;
			}else if(input.equalsIgnoreCase("help")) 
				cmd.help();
			else if(input.equalsIgnoreCase("cd")) 
				cmd.executeCD(currentPath);
			else if(input.startsWith("cd ")) {
				currentPath = cmd.createCD(currentPath, input);
			}else if(input.startsWith("mkdir ")) {
				cmd.makeDirectory(currentPath, input);
			}else if(input.equalsIgnoreCase("cmd")) {
				String tempPath = currentPath;
				runConsole(new Console(), in, currentPath);
				currentPath = tempPath;
			}
				
			
			
			
//			i++;
//			if(i == 15)
//				exit = true;
		}
		return currentPath;
	}
	
}