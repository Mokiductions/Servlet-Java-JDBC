/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class XmlDataHandler {

    public XmlDataHandler() {

    }

    public String alumneToXml(Alumnes al) {
        String s = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Alumnes.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(al, sw);
            s = sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            return s;
        }
        
    }
}
