package test.war;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import test.ejb.interfaces.ClientRemote;

public class TestServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(TestServlet.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String getServiceName() {
        return "TestServlet";
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        logger.info("TestServlet doPost...");
        doit();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        logger.info("TestServlet doGet...");
        doit();
    }

    private void doit() {
        try {
            logger.info("Invoke EJB");
            ClientRemote.Factory.getInstance().sendMessage();
            
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
