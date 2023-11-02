package org.muir.bbc.util;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Parameters extends Properties {

    public static final String PROPERTY_NAME_EMAIL_ADDRESS = "email.address";
    public static final String PROPERTY_NAME_PASSWORD = "password";

    public Parameters() {
        File parametersFile = new File( "src/main/resources/parameters.properties" );
        try {
            FileReader fr = new FileReader( parametersFile );
            this.load( fr );
        }
        catch( Exception e ) {
            System.err.println( e.getMessage() );
            e.printStackTrace( System.err );
        }
    }
}
