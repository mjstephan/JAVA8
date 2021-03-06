/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author pche0001
 *
 */
public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("Deleting file: " + file.toAbsolutePath());
		Files.delete(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		if (exc != null) {
			System.out.println("Exception encountered " + exc.toString());
			throw exc;
		}
		System.out.println("Deleting directory: " + dir.toAbsolutePath());
		Files.delete(dir);
		return FileVisitResult.CONTINUE;
	}

}
