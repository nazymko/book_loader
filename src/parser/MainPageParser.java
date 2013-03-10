package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

/**
 * User: patronus
 */
public class MainPageParser extends DefaultHandler {
    private boolean isThisHref;
    private String href;
    private String name;
    private HashMap<String, String> urlName = new HashMap<String, String>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        this.isThisHref = "a".equals(qName);
        System.out.println(qName);

        if (isThisHref) {
            this.href = attributes.getValue(attributes.getIndex("href"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isThisHref) {
            this.name = new String(ch, start, length);
            save();
        }
    }

    private void save() {
        if (href != null && name != null) {
            urlName.put(href, name);
            System.err.println(href+":"+name);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.name = null;
        this.isThisHref = false;
        this.href = null;
    }
}
