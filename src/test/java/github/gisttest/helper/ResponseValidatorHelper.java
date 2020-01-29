package github.gisttest.helper;

import io.restassured.response.Response;

public class ResponseValidatorHelper {
	
	/**
	 * This method is used to get Gist Id from Response 
	 * it takes in a Response object and then parse to get an Id
	 * @param response
	 * @return
	 */
	public static String getGistIdFromResponse(Response response) {
		return response.getBody().jsonPath().get("id");
	}

}
