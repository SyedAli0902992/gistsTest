package github.gisttest.restservices;

import java.util.HashMap;
import java.util.Map;

import github.gisttest.constants.Constants;
import github.gisttest.requestmappings.RequestsMappings;
import github.gisttest.requests.model.RequestParameters;
import io.restassured.response.Response;

public class RestServices {

	public RestServices() {
		this.RequestsMappings = new RequestsMappings();
		this.requestParameters = new RequestParameters();
		this.headers = new HashMap<String, String>();
		headers.put("Authorization", Constants.TOKENHELPER1+Constants.TOKENHELPER2+Constants.TOKENHELPER3);
	}

	RequestsMappings RequestsMappings;
	RequestParameters requestParameters;
	Map<String, String> headers;

	public Response getGistsForOneUser(String username) {
	
		requestParameters.setRequestMapping("/users/" + username + "/gists");
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response createAGists(String body) {

		requestParameters.setRequestBody(body);
		requestParameters.setRequestMapping("/gists");
		requestParameters.setHeaders(headers);

		return RequestsMappings.postRequestsResponse(requestParameters);

	}

	public Response getAllPublicGists() {

		requestParameters.setRequestMapping("gists/public");
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response getAllStarredGists() {

		requestParameters.setRequestMapping("gists/starred");
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response getASingleGists(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId);
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response getASpecificRevisionOfGist(String gistId, String sha) {

		requestParameters.setRequestMapping("gists/" + gistId + "/" + sha);
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response patchAGists(String body, String gistsId) {

		requestParameters.setRequestBody(body);
		requestParameters.setRequestMapping("gists/" + gistsId);
		requestParameters.setHeaders(headers);

		return RequestsMappings.patchRequestsResponse(requestParameters);

	}

	public Response getGistsCommits(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId + "/commits");
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response starAGists(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId + "/star");
		requestParameters.setHeaders(headers);

		return RequestsMappings.putRequestsResponse(requestParameters);

	}

	public Response unstarAGists(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId + "/star");
		requestParameters.setHeaders(headers);

		return RequestsMappings.deleteRequestsResponse(requestParameters);

	}

	public Response checkIfAGistsIsStarred(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId + "/star");
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response forkAGists(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId + "/forks");
		requestParameters.setHeaders(headers);

		return RequestsMappings.postRequestsResponse(requestParameters);

	}

	public Response ListGistsForks(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId + "/forks");
		requestParameters.setHeaders(headers);

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response deleteAGists(String gistId) {

		requestParameters.setRequestMapping("gists/" + gistId);
		requestParameters.setHeaders(headers);

		return RequestsMappings.deleteRequestsResponse(requestParameters);

	}
}
