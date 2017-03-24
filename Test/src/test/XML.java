package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

public class XML {


    /**
     * @param args
     */
    public static void main(String[] args) {
        XML xml = new XML();
        xml.makeFile();
    }

    public void makeFile()
    {
        Node item = null;         
        Document xmlDoc = new DocumentImpl();                
        Element root = xmlDoc.createElement("root");
        
        Element booking=xmlDoc.createElement("booking");
        
        for(int i=0;i<10;i++){
        	item = xmlDoc.createElement("bookingID");
            item.appendChild(xmlDoc.createTextNode((115+i*10)+""));
            booking.appendChild(item);
        }
        
        root.appendChild(booking);
        xmlDoc.appendChild(root);

        try 
        {            
            Source source = new DOMSource(xmlDoc); 
            File xmlFile = new File("yourFile.xml");            
            StreamResult result = new StreamResult(new OutputStreamWriter(new FileOutputStream(xmlFile), "ISO-8859-1"));
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.transform(source, result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}