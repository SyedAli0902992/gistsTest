package github.gisttest.validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import io.restassured.response.Response;

public class ResponseValidator {
	
	public static boolean validateNumberOfFiles(Response response ,int expectedNumberOfFiles)  {
		
		HashMap<?,?> file = (HashMap<?, ?>) response.getBody().jsonPath().get("files");

		return file.keySet().size()==expectedNumberOfFiles;
		
	}
	
	public static boolean validateDiscription(Response response,String expectedDescription) {
		String description = response.getBody().jsonPath().get("description");
		
		return description.equals(expectedDescription);
		}
	
	public static boolean validateGistID(Response response,String expectedId) {
		String description = response.getBody().jsonPath().get("id");
		
		return description.equals(expectedId);
		}
	
	public static boolean validateStatusCode(Response response,int expectedStatusCode) {
		int statusCode = response.getStatusCode();
		
		return (statusCode == expectedStatusCode);
		}
	
	public static boolean validateResponseSize(Response response ,int expectedSize)  {
		
		List<?> responseBody = response.getBody().jsonPath().get("");

		return responseBody.size()==expectedSize;
		
	}
	public static boolean validateUserName(Response response,String expectedUserName) {
		List<?> userName = response.getBody().jsonPath().get("description");
		return false;
		}
	
	public static boolean validateOwnerDetails(Response response,Map<String,String>ExpectedOwnerKeyValues) {
		return false;}
	
	public static boolean validateFileDetails(Response response,Map<String,String>ExpectedFileKeyValues) {
		return false;}
	
	public static boolean validateifTruncated(Response response,boolean iftruncated) {
		return iftruncated;}
	
	public static boolean validateNumberOfGists(Response response,int numberOfGists) {
		return false;}

}
