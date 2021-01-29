import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.beanio.stream.xml.XmlReader;
import org.w3c.dom.Document;
import pojo.RoverBot;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

//IMPLEMENT XML Reader
public class BeanIOReader extends XmlReader {

    public BeanIOReader(Reader reader, Document base) {
        super(reader, base);
    }

    public void readXMLInputPosition(){
        StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource ("beans.xml");

        //read it from the classpath : src/main/resources
        InputStream in = this.getClass().getResourceAsStream("/input.xml");

        BeanReader reader = factory.createReader("RoverBot", new InputStreamReader(in));
        Object record = null;
        RoverBot roverBot = new RoverBot();
        // read records from "input.xml"
        while ((record = reader.read()) != null)
        {

        }

    }

    public static void main(String[] args)
    {
        new BeanIOReader().readXMLInputPosition();
    }

}
