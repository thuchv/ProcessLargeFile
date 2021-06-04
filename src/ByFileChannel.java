import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByFileChannel {

	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			new ByFileChannel().copyUsingChannel();
			long endTime = System.currentTimeMillis();
			System.out.println("TIME ELAPSED: " + (endTime - startTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void copyUsingChannel() throws IOException {
		try (FileChannel inputChannel = new FileInputStream("C:/PDF/dummy2.txt").getChannel();
				FileChannel outputChannel = new FileOutputStream("C:/PDF/dummy2_out.txt").getChannel();) {
			ByteBuffer buffer = ByteBuffer.allocateDirect(4 * 1024);
			while (inputChannel.read(buffer) != -1) {
				buffer.flip();
				outputChannel.write(buffer);
				buffer.clear();
			}
		}
	}

}
