package ZIP;

import com.chilkatsoft.CkTar;

public class Zip_Action {

	public void ZipIt(String repFileName, String dest)

	{

		// This example assumes the Chilkat API to have been previously unlocked.

		// See Global Unlock Sample for sample code.
		try {

			System.setProperty("java.library.path",
					"C:\\Chilkat\\chilkat-9.5.0-jdk8-win32\\chilkat.dll");

			System.loadLibrary("chilkat");

		} catch (UnsatisfiedLinkError e) {

			System.err.println("Native code library failed to load.\n" + e);

			System.exit(1);

		}

		CkTar tar = new CkTar();

		// The TAR component will produce a GNU tar 1.13.x format

		// archive by default.

		// It is also possible to create PAX -- POSIX 1003.1-2001 format

		// or USTAR -- POSIX 1003.1-1988 format.

		// Set the WriteFormat property to "gnu", "pax", or "ustar" to

		// choose the output TAR format:

		tar.put_WriteFormat("gnu");

		// Add a directory tree to be included in the output TAR archive:

		boolean success = tar
				.AddDirRoot(dest + "\\" + repFileName);

		if (success != true) {

			System.out.println(tar.lastErrorText());

			return;

		}

		// Create the compressed TAR archive.

		// Note: You may use UNC paths, absolute, or relative paths.

		success = tar.WriteTarGz(dest + "\\" + repFileName + ".tgz");

		if (success != true) {

			System.out.println(tar.lastErrorText());

			return;

		}else {
			System.out.println("Zipping done");
		}

	}

}
