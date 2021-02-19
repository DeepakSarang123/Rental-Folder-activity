package ZIP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IncrementDate {

	public String inc(String hex_dop) throws ParseException {

		String date = hex_dop.substring(0, 10);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(date));
		c.add(Calendar.DATE, 1);
		date = sdf.format(c.getTime());
		String fDate = date + hex_dop.substring(10, hex_dop.length());
		return fDate;
	}

}
