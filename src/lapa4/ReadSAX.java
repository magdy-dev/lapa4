import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.IOException;

public class ReadSAX {
    public static void main(String[] args)
    {
        try
        {
            SAXParserFactory fact =  SAXParserFactory.newInstance();
            SAXParser saxParser = fact.newSAXParser();
            DefaultHandler handler = new DefaultHandler()
            {
                boolean bmake= false, bmodel=false, bmileage=false, bproductionYear=false;
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                {
                    if(qName.equals("Make"))
                    {
                        bmake = true;
                    }
                    if(qName.equals("Model"))
                    {
                        bmodel=true;
                    }
                    if(qName.equals("Mileage"))
                    {
                        bmileage=true;
                    }
                    if(qName.equals("ProductionYear"))
                    {
                        bproductionYear=true;
                    }
                }
                public void endElement(String uri, String localName, String qName)
                {

                }
                public void characters(char[] ch, int start, int length)
                {
                    if(bmake)
                    {
                        System.out.println("____________________________________");
                        System.out.println("Make: "+new String(ch, start, length));
                        bmake=false;
                    }
                    if(bmodel)
                    {
                        System.out.println("Model: "+new String(ch, start, length));
                        bmodel=false;
                    }
                    if(bmileage)
                    {
                        System.out.println("Mileage: "+new String(ch, start, length));
                        bmileage=false;
                    }
                    if(bproductionYear)
                    {
                        System.out.println("Production year: "+new String(ch, start,length));
                        System.out.println("____________________________________");
                        bproductionYear=false;
                    }
                }
            };
            saxParser.parse("src/cars.xml",handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
