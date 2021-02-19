package ZIP;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Scanner;

public class MultiplyRenameAndZip {

	public static void replicateFile(String[] names, String name, String dest, String src) throws IOException, ParseException {

		System.out.println("Which paramter you want to change?");
		Scanner sc1 = new Scanner(System.in);
		String param = sc1.nextLine();

		System.out.println("How many copies required?");
		Scanner sc2 = new Scanner(System.in);
		String num = sc2.nextLine();
		int copies = Integer.parseInt(num);

		IncrementParam inc = new IncrementParam();

		Path refPath = Paths.get(src);
		//System.out.println(refPath);
		//System.out.println(dest);

		switch (param.toUpperCase()) {
		case "MACID":
			String macID = names[1];
			System.out.println("Initial MACID is: " + macID);

			// splitting 'mac' from macID
			String hex_mac = macID.substring(3, macID.length());

			// creating 15 new folders
			for (int i = 0; i < copies; i++) {

				// increment macID by calling incrementParam() function
				hex_mac = inc.incrementParam(hex_mac);

				// create macID
				macID = "mac" + hex_mac.toUpperCase();
				names[1] = macID;
				System.out.println("Incremented macid is: " + macID);

				// create the name of file
				FileCreation fc = new FileCreation();
				String repFileName = fc.repFileName(names);
				System.out.println("repFileName is: " + repFileName); // name is ready

				// create a copy of the dmp folder
				FolderCopy fcp = new FolderCopy();
				fcp.create(repFileName, refPath, dest);
				

				// copy contents to dest directory
				ContentsCopy cp = new ContentsCopy();
				cp.create(repFileName, src, dest);
				

				// Renaming the inside file
				RenameFile rf = new RenameFile();
				rf.rename(repFileName, name, dest);
				//System.out.println("Renaming done");

				// zipping the folder
				Zip_Action zip = new Zip_Action();
				zip.ZipIt(repFileName, dest);
				

			}

			break;

		case "UUID":
			String uUID = names[0];
			System.out.println("Initial UUID is: " + uUID);

			// splitting 'mac' from macID
			String hex_uuid = uUID.substring(3, uUID.length());

			// creating 15 new files
			for (int i = 0; i < copies; i++) {

				// increment uUID by calling incrementParam() function
				hex_uuid = inc.incrementParam(hex_uuid);
				System.out.println("Incremented UUID is: " + hex_uuid);

				// create uUID
				uUID = hex_uuid;
				names[0] = uUID;

				// create the name of file
				FileCreation fc = new FileCreation();
				String repFileName = fc.repFileName(names);
				System.out.println("repFileName is: " + repFileName); // name is ready

				// copy to a folder
				FolderCopy fcp = new FolderCopy();
				fcp.create(repFileName, refPath,dest);
				//System.out.println("Folder creation done");

				// copy contents to dest directory
				ContentsCopy cp = new ContentsCopy();
				cp.create(repFileName, src, dest);
				//System.out.println("Files copy done");

				// Renaming the inside file
				RenameFile rf = new RenameFile();
				rf.rename(repFileName, name, dest);
				//System.out.println("Renaming done");

				// zipping the folder
				Zip_Action zip = new Zip_Action();
				zip.ZipIt(repFileName, dest);
				//System.out.println("Zipping done");

			}

			break;

		case "DOP":
			String dop = names[2];
			System.out.println("Initial DOP is: " + dop);

			// splitting 'dat' from DOP
			String hex_dop = dop.substring(3, dop.length());

			// creating 15 new files
			for (int i = 0; i < copies; i++) {

				// increment date
				IncrementDate id = new IncrementDate();
				hex_dop = id.inc(hex_dop);
				System.out.println("Changed date and time is: " + hex_dop);

				// create dop
				dop = "dat" + hex_dop;
				names[2] = dop;
				// System.out.println(dop);

				// create the name of file
				FileCreation fc = new FileCreation();
				String repFileName = fc.repFileName(names);
				System.out.println("repFileName is: " + repFileName); // name is ready

				// copy to a folder
				FolderCopy fcp = new FolderCopy();
				fcp.create(repFileName, refPath, dest);
				System.out.println("Folder creation done");

				// copy contents to dest directory
				ContentsCopy cp = new ContentsCopy();
				cp.create(repFileName, src, dest);
				System.out.println("Files copy done");

				// Renaming the inside file
				RenameFile rf = new RenameFile();
				rf.rename(repFileName, name, dest);
				System.out.println("Renaming done");

				// zipping the folder
				Zip_Action zip = new Zip_Action();
				zip.ZipIt(repFileName, dest);
				System.out.println("Zipping done");

			}

			break;

		default:
			System.out.println("Enter correct parameters!!");
			break;
		}

	}
}