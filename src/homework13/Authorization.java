package homework13;
 
import javax.security.auth.Subject; 
import javax.security.auth.login.*;
import java.security.PrivilegedAction;

/**
 * This class is adapted from 
 * 		https://docs.oracle.com/javase/7/docs/technotes/guides/security/jaas/tutorials/GeneralAcnAndAzn.html
 * 
 * This class attempts to authenticate a user using Kerberos authentication service.
 * If successful, it then run an Action object where access control checks for security-sensitive operations 
 *                will be based on the permissions of the subject that runs the code.
 */
public class Authorization {

	/*
	 * Set system properties for JAAS configuration file location, Kerberos realm, and KDC server.
	 */
	static void setProperties() {  
		// TODO
	}
	
    public static void main(String[] args) {

    	setProperties();
    	
        // 1. Obtain a LoginContext needed for authentication. 
    	//    Tell it to use the LoginModule implementation specified by the
        //    entry named "kerberos" in the JAAS login configuration file and 
    	//    to also use the PlaintextCallbackHandler from lecture 12
	
	// TODO

        // 2. attempt authentication (you must stop the program if an exception is thrown)
	
	// TODO

        System.out.println("Authentication succeeded!");

        // 3. now try to execute the Action on behalf of the authenticated Subject
	
	// TODO

    }
}
