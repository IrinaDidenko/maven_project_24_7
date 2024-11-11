package org.example.utility;

import org.example.models.DataStructure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;


public class XmlWriter {
    //TODO LOGGER CREATE OBJ
    public XmlWriter() {
    }

    public static void generateXml(DataStructure dataStructure) throws JAXBException {
        try { //TODO LOGGER START
            JAXBContext context = JAXBContext.newInstance(DataStructure.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                Files.createDirectory(Path.of("xmlReqs"));
            } catch (IOException e) {
//TODO Logger SUCCESS
            }  //TODO LOGGER ALREADY EXISTS

            File file = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");
            marshaller.marshal(dataStructure, file);

        } catch (JAXBException jexc) {
//TODO LOGGER FAIL
            return;
        } //TODO LOGGER SUCCESS
    }
}
