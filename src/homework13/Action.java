package homework13;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.PrivilegedAction;

/**
 * This class is adapted from 
 * 		https://docs.oracle.com/javase/7/docs/technotes/guides/security/jaas/tutorials/GeneralAcnAndAzn.html
 * 
 * This is a PrivilegedAction that should be executed with the permissions of an authenticated subject. 
 */
public class Action implements PrivilegedAction<Object> {

	/**
	 * This PrivilegedAction performs the following operations: 
	 * 
	 * Read the System property java.home 
	 * Read the System property user.home 
	 * Read the file secret.txt
	 * Write the file topsecret.txt
	 * 
	 * If you login as alice, then the action will throw an exception when trying to write topsecret.txt
	 * If you login as bob/SERVICE, then the action will succeed.
	 */
	public Object run() {
		System.out.println("\nYour java.home property value is: " + System.getProperty("java.home"));

		System.out.println("\nYour user.home property value is: " + System.getProperty("user.home"));

		File f = new File("src/lecture13/secret.txt");

		System.out.printf("\nsecret.txt does %s exist in the current working directory.\n", f.exists() ? "" : "not");

		if(f.exists()) {
			try(BufferedReader r = new BufferedReader(new FileReader(f));) {
				System.out.println(r.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try(PrintWriter w = new PrintWriter(new File("src/lecture13/topsecret.txt"))) {
			w.println("Access control is fun!");
		}  
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
