package file;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoader {
	
	/*
	 * Load ordbok.txt using easiest method available in Files with a static path.
	 * May be insufficient for larger file sizes.
	 * Using ISO-8859-1 charset to import special characters æ, ø, and å.
	 */
	public static List<String> loadOrdbok() {
		try {
			Path path = FileSystems.getDefault().getPath("data", "ordbok.txt");
			List<String> words = Files.readAllLines(path, Charset.forName("ISO-8859-1"));
			return words;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
