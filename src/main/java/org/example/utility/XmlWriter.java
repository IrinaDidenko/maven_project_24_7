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
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


public class XmlWriter {
   private static final Logger log = Logger.getLogger(XmlWriter.class.getName());
    public XmlWriter() {
    }

    public static void generateXml(DataStructure dataStructure) throws JAXBException {
        try { log.log(INFO, "XML marshalling is started");
            JAXBContext context = JAXBContext.newInstance(DataStructure.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                Files.createDirectory(Path.of("xmlReqs"));
            } catch (IOException e) {
                log.log(INFO, " Directory is already exist ");
            }  log.log(INFO, " New directory created successfully ");

            File file = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");
            marshaller.marshal(dataStructure, file);

        } catch (JAXBException jexc) {
            log.log(INFO, "XML marshalling failed ");
            return;
        } log.log(INFO, "XML marshalling finished successfully ");
    }
}
