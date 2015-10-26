package ie.decoder.xsd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import ie.decoder.xsd.Grid;

import org.xml.sax.SAXException;

public class Unmarshall {

    /** Path to XML schema */
    private final static String SCHEMA = "resources/Grid.xsd";
    /** Path to XML document */
    private final static String FILE = "resources/Grid.xml";

    public Unmarshall() {
    
    }
    
    public Grid UnmarshallTheDocument() throws Exception, NullPointerException, JAXBException, SAXException {
        
        Grid grid = null;
        try {
        	ClassLoader classLoader = getClass().getClassLoader();
            File xmlFile = new File(classLoader.getResource(FILE).getFile());        	
            if(!xmlFile.exists()) {
                String errMsg = "Did not find xml : " + FILE + " at the specified location:";
                throw new Exception(errMsg);
            }

            File xsdFile = new File(classLoader.getResource(SCHEMA).getFile());
            if(!xsdFile.exists()) {
                String errMsg = "Did not find xsd : " + FILE + " at the specified location:";
                throw new Exception(errMsg);
            }

            SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema;
            schema = sf.newSchema(xsdFile);
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Grid.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new DocumentEventHandler());
            grid = (Grid) unmarshaller.unmarshal(xmlFile);
            
        } catch (NullPointerException  ex) {
            throw new Exception(ex);     
        } catch (JAXBException ex) {
            throw new Exception(ex);     
        } catch (SAXException ex) {
            throw new Exception(ex);     
        }
        return grid;
    }
    
    public class DocumentEventHandler implements ValidationEventHandler {
        public boolean handleEvent(ValidationEvent event) {
            
           String eventMsg = "\nEvent: Severity:  " + event.getSeverity()
                   + ", Message:  " + event.getMessage()
                   + ", Linked Exception:  " + event.getLinkedException()
                   + ", LOCATOR   Line Number:  " + event.getLocator().getLineNumber()
                   + ", Column Number:  " + event.getLocator().getColumnNumber()
                   + ", Offset:  " + event.getLocator().getOffset()
                   + ", Object:  " + event.getLocator().getObject()
                   + ", Node:  " + event.getLocator().getNode()
                   + ", Url:  " + event.getLocator().getURL();
           System.out.println("MigrationDocumentEventHandler : " + eventMsg);

           return false;
        }
     }
    
    /**
     * Gets the schema definition resource from the class loader
     * 
     * @param classLoader
     *            The class loader to user
     * @param resourcePath
     *            The path of the resource to look for
     * @return A URL to the resource
     * @throws CommonRuntimeException
     *             Thrown if the resource cannot be found or an error querying the class loader
     */
    private URL getConfigurationResource(ClassLoader classLoader, String resourcePath) throws Exception {

        Enumeration<URL> urls;
        try {
            urls = classLoader.getResources(resourcePath);
        } catch (IOException e) {
            String errMsg = "Failed to retrieve resource '" + resourcePath + "'";
            throw new Exception(errMsg);
        }

        if (!urls.hasMoreElements()) {
            String errMsg = "Resource '" + resourcePath + "' not found";
            throw new Exception(errMsg);
        }

        URL url = urls.nextElement();

        if (urls.hasMoreElements()) {
            String errMsg = "Found more that one resource '" + resourcePath + "'";
            System.out.println(errMsg);
        }

        return url;
    }
    
}
