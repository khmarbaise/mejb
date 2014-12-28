package test.ejb.interfaces;

import java.util.Properties;

import javax.ejb.Remote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

@Remote
public interface ClientRemote {

	public static class Factory {
		public static ClientRemote getInstance() throws NamingException {
			Properties properties = new Properties();

			properties.put("java.naming.factory.initial",
					"org.jnp.interfaces.NamingContextFactory");
			properties.put("java.naming.factory.url.pkgs",
					"org.jboss.naming:org.jnp.interfaces");
			properties.put("java.naming.provider.url", "127.0.0.1:1099");
			InitialContext initialContext = new InitialContext(properties);

			String beanName = "ClientRemote";
			Logger.getLogger(ClientRemote.class).debug("LOOKUP BEAN : " + beanName);
			ClientRemote client = (ClientRemote) initialContext
					.lookup(beanName);
			Logger.getLogger(ClientRemote.class).debug("BEAN : " + client);

			return client;
		}
	}

	public void sendMessage();

}
