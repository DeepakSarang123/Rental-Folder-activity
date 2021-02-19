package ZIP;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Scanner;

public class DoAll {

	public static void main(String args[]) throws java.io.IOException, ParseException {

		System.out.println("Enter path of source file");
		Scanner sc1 = new Scanner(System.in);
		String src = sc1.nextLine();
		src = src.replace("\\", "\\\\");
		
		System.out.println("Enter path of destination");
		Scanner sc2 = new Scanner(System.in);
		String dest = sc2.nextLine();	
		dest = dest.replace("\\", "\\\\");

		/*System.out.println("Source path is: " + src);
		System.out.println("Destination path is: " + dest);*/
		
		Path file = Paths.get(src);

		String name = file.getFileName().toString();
		System.out.println(name);
		String[] names = name.split("_");

		String uUID = names[0];
		String macID = names[1];
		String DOP = names[2];

		System.out.println("UUID is: " + uUID + "\n" + "MACID is: " + macID + "\n" + "DOP is: " + DOP);

		MultiplyRenameAndZip obj = new MultiplyRenameAndZip();
		obj.replicateFile(names, name, dest, src);
		
		
	}

}
