
package po2md;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * @author Kopilov Aleksandr<kopilov.ad@gmail.com>
 */
public class Po2md {
	public static ResourceBundle regexp = ResourceBundle.getBundle("po2md.regexp");
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		PrintStream out = System.out;
		String line;
		boolean msgstr = false;
		Pattern firstquote = Pattern.compile(regexp.getString("firstquote"));
		Pattern lastquote = Pattern.compile(regexp.getString("lastquote"));
		Pattern masking =  Pattern.compile(regexp.getString("masking"));
		while ((line = in.readLine()) != null) {
			if (line.startsWith("msgid")) {
				msgstr = false;
			}
			if (line.startsWith("msgstr")) {
				msgstr = true;
				line = line.substring(6);
			}
			if (!msgstr) {
				continue;
			}
			line = firstquote.matcher(line).replaceAll("");
			line = lastquote.matcher(line).replaceAll("");
			line = masking.matcher(line).replaceAll("\"");
			out.println(line);
		}
	}
	
}
