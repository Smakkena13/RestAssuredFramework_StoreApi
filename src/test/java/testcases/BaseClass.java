package testcases;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import routes.Routes;
import utils.ConfigReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class BaseClass {

    public ConfigReader cf;
    RequestLoggingFilter requestLoggingFilter;
    ResponseLoggingFilter responseLoggingFilter;

    @BeforeClass
    void setUp() throws FileNotFoundException {
        RestAssured.baseURI= Routes.BASE_URL;

        cf=new ConfigReader();
        cf.configFileLoad();

        // Setup filters for logging
        FileOutputStream fos = new FileOutputStream(".\\logs\\test_logging.txt");
        PrintStream log = new PrintStream(fos, true);
        requestLoggingFilter = new RequestLoggingFilter(log);
        responseLoggingFilter = new ResponseLoggingFilter(log);
        RestAssured.filters(requestLoggingFilter, responseLoggingFilter);
    }

    boolean sortDesc(List<Integer> li){
        for(int i=0;i<li.size()-1;i++){
            if(li.get(i)<li.get(i+1)){
                return false;
            }
        }
        return true;
    }

    boolean sortAsc(List<Integer> li){
        for(int i=0;i<li.size()-1;i++){
            if(li.get(i)>li.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
