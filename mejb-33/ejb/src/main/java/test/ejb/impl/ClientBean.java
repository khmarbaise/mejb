package test.ejb.impl;

import javax.ejb.Stateless;

import test.ejb.interfaces.ClientRemote;

@Stateless(name = "ClientBean", mappedName = "ClientRemote", description = "Her er en beskrivelse paa Local")
public class ClientBean implements ClientRemote {

	public void sendMessage() {
        try {
        	System.out.println("===== Bean Invoked ===================");

        	// DO SOM Metro WS Call
        } catch(Throwable e) {
        	System.err.println("Failure : " + e);
        	e.printStackTrace();
        }
	}

}
