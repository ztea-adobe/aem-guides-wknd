package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.AusstApplicationJson;
import com.adobe.aem.guides.wknd.core.models.AusstApplicationPackage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Component(service = Servlet.class,
property = {
        Constants.SERVICE_DESCRIPTION + "=Get servlet for AUSST connection",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=/bin/getAUSSTConnection",
})
public class AUSSTConnectionServlet extends SlingAllMethodsServlet  {

		private final Logger log = LoggerFactory.getLogger(getClass());
	    private static final long serialVersionUID = 1L;

	    private HttpGet generateHTTPGet() {
			try {
			// Do not want to use URI builder because it will replace special characters
			URI newURI = new URI("http://asfausst.corp.adobe.com/updates/ACC/services/ffc/packages/PHSP/24.0/macuniversal/Application.json");
			
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
			.setAuthenticationEnabled(false).build();
			
			HttpGet httpget = new HttpGet(newURI);
			httpget.setConfig(requestConfig);
			
			return httpget;
			} catch (Exception e) {
			log.error("Exception occurred while generating URI using host", e);
			return null;
			}
	    }
	    
	    private String connectToAusst() {
	    	HttpGet method = generateHTTPGet();
	    	String returnString = "";
	    	
	    	try (CloseableHttpClient client = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler(3, false)).build()) {
	            CloseableHttpResponse response = client.execute(method);
	            
	            log.error(response.toString());
	            log.error(response.getEntity().toString());
	            
	            
	            
	            HttpEntity ent = response.getEntity();
	            String entityStr = EntityUtils.toString(ent);
	            
	            
	            Gson gson = new GsonBuilder().create();
	            // Deserialize the press release json feed
	            AusstApplicationJson gsonObject = gson.fromJson(entityStr, AusstApplicationJson.class);
	            log.error(gsonObject.getName());
	            StringBuilder st = new StringBuilder();
	            st.append(gsonObject.getName() + " ");
	            st.append(gsonObject.getSAPCode() + " ");
	            st.append(gsonObject.getCodexVersion() + " ");
	            st.append(gsonObject.getAssetGuid() + " ");
	            st.append(gsonObject.getBaseVersion() + " ");
	            st.append(gsonObject.getPlatform() + " ");
	            String str = st.toString();
	            log.error(str);
	            
	            StringBuilder packageListStr = new StringBuilder();
	            List<AusstApplicationPackage> list = gsonObject.getPackageList().getPackageList();
	            for (int i = 0; i < list.size(); i++) {
	            	packageListStr.append(list.get(i).getPackageName() + " Size is: " + list.get(i).getDownloadSize() + " | ");
	            }
	            log.error(packageListStr.toString());
	            
	            returnString = packageListStr.toString();
	            
	            response.close();
	        } catch (ClientProtocolException cpe) {
	            /* Modified to use cache variable declared above */
	            log.error("ClientProtocolException occurred while executing the HttpGet method", cpe);
	           
	        } catch (IOException e) {
	        	log.error("IOException", e);
			}
	    	return returnString;
	    }
	    
	    public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) {
	        resp.setContentType("application/json");
	        ResourceResolver resourceResolver = req.getResourceResolver();
	        Session session = resourceResolver.adaptTo(Session.class);
	        PrintWriter out = null;
	        
	        try {

	        	String responseValue = connectToAusst();
			
	        // Prep for JSON response
	        ObjectMapper mapper = new ObjectMapper();
	        ObjectNode rootObject = mapper.createObjectNode();
			
			
	        rootObject.putPOJO("sample", "value");
	        rootObject.putPOJO("response", responseValue);
	        
			
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


