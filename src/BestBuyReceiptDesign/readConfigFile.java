package BestBuyReceiptDesign;

import java.io.FileInputStream;
import java.util.Properties;


public class readConfigFile {
    private Properties configFile;

    public readConfigFile(){
        try {
            configFile = new java.util.Properties();
            configFile.load(new FileInputStream("config.properties"));
        }catch(Exception eta){
            eta.printStackTrace();
        }
    }
    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }

}

