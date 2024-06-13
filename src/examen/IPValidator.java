package examen;

/**
 * Es un programa el cual comprueba y valida un patron de numeros y letras para devolver un numero y una letra que corresponden a una clase
 * @author SergioNalda
 * @version 1.0
 */

public class IPValidator {
	public static String ipPattern;
	
	/**
	 * Este método lo que hace es validar si la IP de la calse es correcta y si es asi te devuelve su letra y numero correspondiente de dicha clase
	 * @param ip
	 * @param ipClass
	 * @return Este devuelve la validación de la IP de la clase
	 * @see IPValidator
	 */

	public static boolean validateIPAndClass(String ip, char ipClass) {
		boolean validIPClass = true;
		ipPattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
				+ "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ipPattern);
		java.util.regex.Matcher matcher = pattern.matcher(ip);
		if (!matcher.matches()) {
			validIPClass = false;
		} else {
			int firstOctet = Integer.parseInt(matcher.group(1));
			if (firstOctet <= 126) {
				validIPClass = ipClass == 'A';
			} else if (firstOctet <= 191) {
				validIPClass = ipClass == 'B';
			} else if (firstOctet <= 223) {
				validIPClass = ipClass == 'C';
			} else if (firstOctet <= 239) {
				validIPClass = ipClass == 'D';
			} else if (firstOctet <= 255) {
				validIPClass = ipClass == 'E';
			}
		}
		return validIPClass;
	}
}
