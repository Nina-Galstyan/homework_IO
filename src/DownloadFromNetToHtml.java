import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFromNetToHtml {
    private static final String DOWNLOAD_PATH = "homework_IO/src/downloadFiles";

    public void downloadByteByByte(String urlStr) throws IOException {
        String fileName = DOWNLOAD_PATH + urlStr + System.currentTimeMillis() + ".html";
        URL website = new URL(urlStr);
        try (ReadableByteChannel rbc = Channels.newChannel(website.openStream());
             FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.getChannel().read((ByteBuffer) rbc);
        }
    }

    public void downloadBy8kbBuffer(String urlStr) throws IOException {
        String fileName = DOWNLOAD_PATH + urlStr + System.currentTimeMillis() + ".html";
        URL website = new URL(urlStr);
        byte[] buffer = new byte[8192];
        try (ReadableByteChannel rbc = Channels.newChannel(website.openStream());
             FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.getChannel().transferFrom(rbc, 0, 8192);
        }
    }
}
