package ZIP;

import java.math.BigInteger;

public class IncrementParam {

	public static String incrementParam(String ID) {

		// Creating two empty BigIntegers
		BigInteger bi2, bi3;

		BigInteger bi1 = new BigInteger(ID, 16);
		// System.out.println(bi1);

		bi2 = new BigInteger("1"); // Or BigInteger.ONE

		// incrementing ID by 1 value
		bi3 = bi1.add(bi2);
		// System.out.println(bi3);

		// converting from BigInteger to String
		String str3 = bi3.toString(16);
		// System.out.println(str3);

		return str3;
	}
}
