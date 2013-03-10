package loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: patronus
 */
public class DefaultFileLoader implements Runnable {
    private final String url;
    private final String filename;

    public DefaultFileLoader(String url, String filename) {
        this.url = url;
        this.filename = filename;
    }

    @Override
    public void run() {
        URL loader = null;
        try {
            loader = new URL(url);
            InputStream inputStream = loader.openStream();
            StreamLoader.load(inputStream, filename);

        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
