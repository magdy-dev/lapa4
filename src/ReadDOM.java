import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadDOM {
    public static void main(String[] args)
    {
        try
        {
            File xmlDoc = new File("src/cars.xml");
            DocumentBuilderFactory docFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFact.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlDoc);

            System.out.println("Root element: "+doc.getDocumentElement().getNodeName()+"\n");

            NodeList nList = doc.getElementsByTagName("Car");
            for (int i=0; i<nList.getLength(); i++)
            {
                Node node = nList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    System.out.println("____________________________________");
                    System.out.println("Car make: "+element.getElementsByTagName("Make").item(0).getTextContent());
                    System.out.println("Car model: "+element.getElementsByTagName("Model").item(0).getTextContent());
                    System.out.println("Car mileage: "+element.getElementsByTagName("Mileage").item(0).getTextContent());
                    System.out.println("Car production year: "+element.getElementsByTagName("ProductionYear").item(0).getTextContent());
                    System.out.println("____________________________________" +"\n");

                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
