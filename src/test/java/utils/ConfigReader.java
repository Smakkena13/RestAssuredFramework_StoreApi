package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties p;
    public static final String config_file_path="C:\\Users\\Happy\\IdeaProjects\\RestAssuredFramework_StoreApi\\config.properties";

    public void configFileLoad(){
        p=new Properties();
        try{
            FileInputStream fileInputStream=new FileInputStream(config_file_path);
            p.load(fileInputStream);
        }catch(Exception e){
            System.out.println("proprties file not loaded "+e.getMessage());
        }
    }

    public String getConfigProperty(String key){
        return p.getProperty(key);
    }

    public int getConfigNumProperty(String key){
        return Integer.parseInt(p.getProperty(key));
    }
}
