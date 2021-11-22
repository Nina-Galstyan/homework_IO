package task3;

import java.io.File;

public class RemoveFromTemp {
    public static void main(String[] args) {
        String dirPath = "/temp";
        File file = new File(dirPath);
        File[] listFiles = file.listFiles();
        removeFile(listFiles);
    }

    private static void removeFile(File[] listFiles) {
        for (File listFile : listFiles) {
            if (listFile.isFile() && listFile.getAbsolutePath().endsWith(".tmp")) {
                listFile.delete();
            } else {
                if (listFile.isDirectory()) {
                    File[] subDir = listFile.listFiles();
                    removeFile(subDir);
                }
            }
        }
    }

}
