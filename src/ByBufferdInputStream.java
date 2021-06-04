import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByBufferdInputStream {

	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			new ByBufferdInputStream().copyUsingChunks();
			long endTime = System.currentTimeMillis();
			System.out.println("TIME ELAPSED: " + (endTime - startTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void copyUsingChunks() throws IOException {
		try (InputStream inputStream = new FileInputStream("C:/PDF/dummy2.txt");
				BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

				OutputStream outputStream = new FileOutputStream("C:/Users/dev006.A691/Desktop/dummmy_out.txt");) {
			byte[] buffer = new byte[4 * 1024];
			int read;
			while ((read = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
				outputStream.write(buffer, 0, read);
			}
		}
	}

}
