/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author pche0001
 *
 */
public class MyDirectoryStream {



	/**
	 *
	 * the DirectoryStream interface is used to visit the contents of a single directory
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("c:\\OmnixDev");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path element : stream) {
				System.out.println(element.getFileName() + "\t" + Files.isDirectory(element));
			}
		}

	}

}
