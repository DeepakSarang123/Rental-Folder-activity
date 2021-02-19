package ZIP;

import java.io.File;

public class RenameFile {

	public void rename(String repFileName, String name, String dest) {
		
        //String Destination = dest + "\\\\";
        //String FileName = repFileName + "\\\\";
        
        //System.out.println("Destination : " + Destination);
        //System.out.println("FileName : " + FileName);
        /*System.out.println(Destination + FileName + name + "    ");
        System.out.println(Destination + FileName + repFileName + "    ");*/
		File inside = new File(dest+ "\\\\" + repFileName+ "\\\\" + name);
		File reName = new File(dest+ "\\\\" + repFileName+ "\\\\" + repFileName);
		
		
		System.out.println(inside.getPath());
        System.out.println(reName.getPath());
        
		boolean success = inside.renameTo(reName);
		if (!success) {
			System.out.println("Error trying to rename file");
		}else {
			System.out.println("Renaming done");
		}

		
	}

}
