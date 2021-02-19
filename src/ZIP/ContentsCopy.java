package ZIP;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ContentsCopy {

	public void create(String repFileName, String src, String dest) {

		File srcDir = new File(src);

		String Destination = dest + "\\" + repFileName;
		File destDir = new File(Destination);

		try {
			FileUtils.copyDirectory(srcDir, destDir);
			System.out.println("Files copy done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
