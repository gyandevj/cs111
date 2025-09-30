class sol {
	private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

	public static String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < VALUES.length; i++) {
			while (num >= VALUES[i]) {
				result.append(ROMAN_NUMERALS[i]);
				num -= VALUES[i];
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		int n = 1994;
		if (args.length > 0) {
			try {
				n = Integer.parseInt(args[0]);
			} catch (NumberFormatException ignored) { }
		}
		System.out.println(intToRoman(n));
	}
}
