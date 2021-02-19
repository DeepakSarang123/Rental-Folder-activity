package ZIP;

public class FileCreation {

	public String repFileName(String[] names) {
		String reps = new String();
		for (String ix : names) {
			reps = reps + ix + "_";
		}

		String repFileName = reps.substring(0, reps.length() - 1);
		return repFileName;
	}
}
