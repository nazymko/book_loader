package loader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: patronus
 * Date: 11.03.13
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
public class LoadManager {

    public static final int N_THREADS = 10;
    public final ExecutorService EXECUTOR_SERVICE;

    public LoadManager() {
        EXECUTOR_SERVICE = Executors.newFixedThreadPool(N_THREADS);
    }

    public void addFile(String url,String name){
        DefaultFileLoader defaultFileLoader = new DefaultFileLoader(url, name);
        EXECUTOR_SERVICE.execute(defaultFileLoader);
    }
}
