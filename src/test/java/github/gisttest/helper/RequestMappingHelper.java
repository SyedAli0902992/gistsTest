package github.gisttest.helper;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Map;

import github.gisttest.requests.model.RequestParameters;

public class RequestMappingHelper {
	
	/**
	 * This method is used to create given() request specification
	 * it takes in an object of Request Parameter and then forms the 
	 * request specification based on the states of the object
	 * @param requestParameters
	 * @return
	 */
	
	public static RequestSpecification createGiven(RequestParameters requestParameters)
	{
		RequestSpecification requestSpecification = null ;
		
		if(!requestParameters.getHeaders().isEmpty()) {
			requestSpecification = addHeaders(requestParameters.getHeaders(),requestSpecification);
			
		}
		if(!requestParameters.getQueryParameters().isEmpty()) {
			requestSpecification = addQueryParameter(requestParameters.getQueryParameters(),requestSpecification);
		}
        if(null != requestParameters.getRequestBody())
        {
        	requestSpecification.given().body(requestParameters.getRequestBody());
        }
		return requestSpecification;
		
	}
	
	  /**
	 * This method is used to add headers to request specification
	 * @param map
	 * @param requestSpecification
	 * @return
	 */
	
	private static RequestSpecification addHeaders(Map<String,String> map,
			  RequestSpecification requestSpecification) {
		  
		  for (Map.Entry<String, String> entry : map.entrySet()) {
		        
				requestSpecification = given().header(entry.getKey(),entry.getValue());
		        
		    };
		    return requestSpecification;
		  
	  }
	  
	 /**
		 * This method is used to add query parameter to request specification
		 * @param map
		 * @param requestSpecification
		 * @return
		 */
	
	  private static RequestSpecification addQueryParameter(Map<String,String> map,
			  RequestSpecification requestSpecification) {
		  
		  for (Map.Entry<String, String> entry : map.entrySet()) {
		        
				requestSpecification = given().queryParam(entry.getKey(),entry.getValue());
		        
		    };
		    return requestSpecification;
			  
		  }
	  
	 

}
