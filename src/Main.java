import org.xml.sax.SAXException;
import parser.MainPageParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: patronus
 * Date: 10.03.13
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static String url = "http://www.intechopen.com/download/books/books_isbn/978-953-51-0892-4";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        MainPageParser handler=new MainPageParser();
        SAXParser saxParser = factory.newSAXParser();
        URL openUrl=new URL("http://www.intechopen.com/");
        InputStream inputStream = openUrl.openStream();
        saxParser.parse(inputStream,handler);
    }
}
