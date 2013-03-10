package loader;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: patronus
 * Date: 10.03.13
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class StreamLoader {

    public static final int BUFFER_SIZE = 1024 * 16;

    public static void load(InputStream in, String filename) throws IOException {
        byte[] buff = new byte[BUFFER_SIZE];
        File f = new File(filename);
        if (!f.exists()) {
            f.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
        int read=0;
        while ((read=in.read(buff)) != -1) {
            bos.write(buff,0,read);
        }

        bos.close();

    }

}
