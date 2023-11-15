package com.adobe.aem.guides.wknd.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Session;
import javax.servlet.Servlet;

import java.io.PrintWriter;

@Component(service = Servlet.class,
property = {
        Constants.SERVICE_DESCRIPTION + "=Get servlet for AUSST connection",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=/bin/getAUSSTConnection",
})
public class AUSSTConnectionServlet extends SlingAllMethodsServlet  {

		private final Logger log = LoggerFactory.getLogger(getClass());
	    private static final long serialVersionUID = 1L;

	    UserManager userManager;
	    
	    public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) {
	        resp.setContentType("application/json");
	        ResourceResolver resourceResolver = req.getResourceResolver();
	        Session session = resourceResolver.adaptTo(Session.class);
	        PrintWriter out = null;
	        
	        try {

			
	        // Prep for JSON response
	        ObjectMapper mapper = new ObjectMapper();
	        ObjectNode rootObject = mapper.createObjectNode();
			
			
	        rootObject.putPOJO("sample", "value");
			
			// Write the response
	        out = resp.getWriter();
	        resp.setCharacterEncoding("UTF-8");

	        out.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootObject));
	        } catch (Exception e) {
	            log.error(e.getMessage());;
	        }
	        if(out != null) {
	            out.flush();
	        }
	    }
	}


