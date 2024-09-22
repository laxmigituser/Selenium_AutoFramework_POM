package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Base64;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.qa.base.PropertiesOperation;



public class JiraOperations {
	
	String jiraURL="";
	String jiraUserName = "";
	String jiraAccessKey = "";
	
	public JiraOperations() {
		try {
			jiraURL = PropertiesOperation.getPropertyValueByKey("jiraURL");
			jiraUserName = PropertiesOperation.getPropertyValueByKey("jiraUserName");
			jiraAccessKey = PropertiesOperation.getPropertyValueByKey("jiraSecretKey");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//create Jira Issue as bug
	public String createJiraIssue(String ProjectName, String issueSummary, String issueDescription, String component, String priority,
			String label, String env, String assignee) throws  IOException, ParseException, org.json.simple.parser.ParseException {
		
		String issueId = null; //to store issue / bug id.
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String url = jiraURL+"/rest/api/3/issue";
		HttpPost postRequest = new HttpPost(url);
		postRequest.addHeader("content-type", "application/json");

		//BASE64Encoder base=new BASE64Encoder();
		String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());
		//String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
		postRequest.setHeader("Authorization", "Basic " + encoding);

		StringEntity params = new StringEntity(createPayloadForCreateJiraIssue(ProjectName, issueSummary, issueDescription, 
				component, priority, label, env, assignee));
		postRequest.setEntity(params);
		CloseableHttpResponse response = httpClient.execute(postRequest);

		//convert httpresponse to string
		String jsonString = EntityUtils.toString(response.getEntity());

		//convert sring to Json
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(jsonString);

		//extract issuekey from Json
		issueId = (String) json.get("key");

		return issueId;

	}

	//Add attachment to already created bug / issue in JIRA
		public void addAttachmentToJiraIssue(String issueId, String filePath) throws IOException 
		{
			String pathname= filePath; 
			File fileUpload = new File(pathname);

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			String url = jiraURL+"/rest/api/3/issue/"+issueId+"/attachments";
			HttpPost postRequest = new HttpPost(url);

			//BASE64Encoder base=new BASE64Encoder();
			//String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
			String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());

			postRequest.setHeader("Authorization", "Basic " + encoding);
			postRequest.setHeader("X-Atlassian-Token","nocheck");

			MultipartEntityBuilder entity=MultipartEntityBuilder.create();
			entity.addPart("file", new FileBody(fileUpload));
			postRequest.setEntity( entity.build());
			CloseableHttpResponse response = httpClient.execute(postRequest);
			
			//System.out.println(response.getStatusLine());

			if(response.toString().contains("200 OK")){
				System.out.println("Attachment uploaded");
			} else{
				System.out.println("Attachment not uploaded");
			}
		}
	
	//creates payload for create issue post request
	private static String createPayloadForCreateJiraIssue(String ProjectName, String issueSummary, String issueDescription, 
			String componentId, String priority, String label, String env, String assigneeId) {
		return "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \""+ProjectName+"\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \""+issueSummary+"\",\r\n" + 
				"	   \"description\": {\r\n" + 
				"          \"type\": \"doc\",\r\n" + 
				"          \"version\": 1,\r\n" + 
				"          \"content\": [\r\n" + 
				"				{\r\n" + 
				"                    \"type\": \"paragraph\",\r\n" + 
				"                    \"content\": [\r\n" + 
				"								{\r\n" + 
				"                                    \"text\": \""+issueDescription+"\",\r\n" + 
				"                                    \"type\": \"text\"\r\n" + 
				"								}\r\n" + 
				"							   ]\r\n" + 
				"				}\r\n" + 
				"					]\r\n" + 
				"						}, \r\n" + 
				"		\"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       },\r\n" + 
				"      \"components\": [\r\n" + 
				"      {\r\n" + 
				"        \"id\": \""+componentId+"\"\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"priority\": {\r\n" + 
				"      \"id\": \""+priority+"\"\r\n" + 
				"    },\r\n" + 
				"        \"labels\": [\r\n" + 
				"      \""+label+"\"\r\n" + 
				"    ],\r\n" + 
				"    	\"environment\": {\r\n" + 
				"      \"type\": \"doc\",\r\n" + 
				"      \"version\": 1,\r\n" + 
				"      \"content\": [\r\n" + 
				"        {\r\n" + 
				"          \"type\": \"paragraph\",\r\n" + 
				"          \"content\": [\r\n" + 
				"            {\r\n" + 
				"              \"text\": \""+env+"\",\r\n" + 
				"              \"type\": \"text\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    	\"assignee\": {\r\n" + 
				"      \"id\": \""+assigneeId+"\"\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"}";
	}
	
	
}

