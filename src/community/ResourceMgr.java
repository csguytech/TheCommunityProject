/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community;

import community.err.MissingPropertyException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceMgr {
    private final Properties properties;
    private Locale locale;
    private ResourceBundle msgs;
    
    private static final ResourceMgr SINGLETON;
    
    private static final String PROPERTY_FILE_PATH = 
            "./resources/Community.properties";
    private static final String LANGUAGE_PROP = "language";
    private static final String COUNTRY_PROP = "country";
    
    private static final String UI_RESOURCE_PATH = "community.resources.Msgs";
    
    static {
        SINGLETON = new ResourceMgr();
    }
    
    /**
     * instance() return instance of ResourceMgr SINGLETON
     * @return ResourceMgr SINGLETON
     */
    public static ResourceMgr instance() {
        return SINGLETON;
    }
    
    /**
     * ResourceMgr() sets locale based on Language and Country
     */
    private ResourceMgr() {
        properties = new Properties();
        
        loadProps(PROPERTY_FILE_PATH);
        
        try {
            locale = new Locale(getProp(LANGUAGE_PROP), getProp(COUNTRY_PROP));

            msgs = ResourceBundle.getBundle(UI_RESOURCE_PATH, locale);    
        } catch (MissingPropertyException e) {
            System.out.println(e.toString());
        }

    }
    
    /**
     * getLocale() return locale
     * @return Locale locale
     */
    public Locale getLocale() {
        return locale;
    }
    
    /**
     * string(String) returns String value from matched key
     * @param key
     * @return String value from matched key
     */
    public String string(String key) {
        return msgs.getString(key);
    }
    
    /**
     * getProp(String) searches properties for String key
     * @param name
     * @return String from properties
     * @throws MissingPropertyException
     */
    public String getProp(String name) throws MissingPropertyException {
        if(properties.containsKey(name)) {
            return properties.getProperty(name);
        } else {
            throw new MissingPropertyException(name);
        }
    }
    
    /**
     * loadProps(String) loads properties file
     * @param path 
     */
    private void loadProps(String path) {
        try {
            InputStream strm = getClass().getResourceAsStream(path);
            
            if(strm == null)
                throw new FileNotFoundException(path + " File not Found");
            
            properties.load(strm);
                        
        } catch (FileNotFoundException e) {
            System.out.println("Propery File not Found");
        } catch (IOException e) {
            System.out.println("LoadProps IOException");
        }
    }
}