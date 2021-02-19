package ZIP;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderCopy {

	public Path create(String repFileName, Path refPath, String dest) {

		try {

			String destination = dest + "\\\\";
			//System.out.println(destination + repFileName);
			Path path1 = refPath;
			Path path2 = Paths.get(destination + repFileName);
			
		    System.out.println("path1 " + path1);
			System.out.println("path2 " + path2);

			Files.copy(path1, path2);
			refPath = path2;
			//System.out.println("refPath is" + refPath);
			
			System.out.println("Folder creation done");

		} catch (Exception e) {
			System.out.println("Error in Folder Creation");
		}
		
		return refPath;
		

	}

}
