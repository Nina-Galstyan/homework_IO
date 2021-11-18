package task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DownloadFromNetToHtml downloadFromNetToHtml= new DownloadFromNetToHtml();
        try {
            downloadFromNetToHtml.downloadBy8kbBuffer("http://example.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            downloadFromNetToHtml.downloadByteByByte("http://example.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
