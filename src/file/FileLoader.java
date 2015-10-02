package file;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoader {

	public static List<String> loadOrdbok() {
	
		try {
			Path path = FileSystems.getDefault().getPath("data", "ordbok.txt");
			List<String> words = Files.readAllLines(path, Charset.forName("ISO-8859-1"));
			for (String line : words) {
				System.out.println(line);
			}
			return words;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
