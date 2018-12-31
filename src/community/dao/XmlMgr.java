/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */

package community.dao;

import community.domain.CommunityClass;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlMgr {
    private final String dataPath;
    private final File file;
    private final String fileName;
    
    /**
     * Creates Static XmlMgr
     */
    public static final XmlMgr XMLMGR = new XmlMgr();
    
    /**
     * getInstance() returns instance of XmlMgr
     * @return XmlMgr instance
     */
    public static XmlMgr getInstance() {
        return XMLMGR;
    }

    /**
     * XmlMgr() constructor for XmlMgr object
     */
    private XmlMgr() {
        this.dataPath = System.getProperty("user.dir") + "/Data/";
        this.fileName = "community.xml";
        this.file = new File(dataPath + fileName);
    }
    
    /**
     * loadXml() loads Xml file and reads into CommunityClass object
     * @return CommunityClass object
     */
    public CommunityClass loadXml() {
        try {
            JAXBContext jax = JAXBContext.newInstance(CommunityClass.class);
            Unmarshaller jaxUnmarshaller = jax.createUnmarshaller();
            
            CommunityClass community;
            
            if(file.exists()) {
                community = 
                (CommunityClass) jaxUnmarshaller.unmarshal(file);
            } else {
                community = new CommunityClass();
            }
          
            return community;
        
        } catch (JAXBException e) {}
        return null;
    }
    
    /**
     * saveXml(CommunityClass) creates XML file and converts CommunityClass
     * object to XML code
     * @param community
     * @return boolean whether the save went through
     */
    public boolean saveXml(CommunityClass community) {
        createFile();
        try {
            
            JAXBContext jax = JAXBContext.newInstance(CommunityClass.class);
            Marshaller jaxMarshaller = jax.createMarshaller();
            
            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxMarshaller.marshal(community, file);
            
        } catch (JAXBException e) {
            return false;
        }
        return true;
    }
    
    /**
     * createFile() creates file if it does not exist
     */
    public void createFile() {
        try {
            if(!file.exists()) {
                new File(dataPath).mkdirs();
                file.createNewFile();
                System.out.println("File Created");
            }
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
    
}