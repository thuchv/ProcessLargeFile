import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByInputStream {
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			new ByInputStream().copyUsingInputStreamNoBuffer();
			long endTime = System.currentTimeMillis();
			System.out.println("TIME ELAPSED: " + (endTime - startTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void copyUsingInputStream() throws IOException {
		try (InputStream inputStream = new FileInputStream("C:/PDF/dummy2.txt");
				OutputStream outputStream = new FileOutputStream("C:/Users/dev006.A691/Desktop/dummmy_out2.txt");) {
			byte[] buffer = new byte[4 * 1024];
			int read;
			while ((read = inputStream.read(buffer, 0, buffer.length)) != -1) {
				outputStream.write(buffer, 0, read);
			}
		}
	}

	private void copyUsingInputStreamNoBuffer() throws IOException {
		try (InputStream inputStream = new FileInputStream("C:/PDF/dummy2.txt");
				OutputStream outputStream = new FileOutputStream("C:/Users/dev006.A691/Desktop/dummmy_out3.txt");) {
			byte[] bt = null;
			int checkLine = 0;
			while ((checkLine = inputStream.available()) > 0) {
				System.out.println(checkLine);
				bt = new byte[checkLine];
				int rst = inputStream.read(bt);
				outputStream.write(bt, 0, bt.length);
				if (rst == -1) {
					break;
				}
			}
		}
	}
}
