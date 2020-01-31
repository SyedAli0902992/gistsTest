package github.gisttest.helper;

import java.util.HashMap;
import java.util.List;

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
	
	/**
	 * This method is used to get Gist Id from Response 
	 * it takes in a Response object and then parse to get an Id
	 * @param response
	 * @return
	 */
	public static String getGistIdOfFirstGistResponse(Response response) {
		List<?> responseBody = response.getBody().jsonPath().get();
		HashMap<?,?> singleGist = (HashMap<?, ?>) responseBody.get(0);
		return singleGist.get("id").toString();
	}

}
