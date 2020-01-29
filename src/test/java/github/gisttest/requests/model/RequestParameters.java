package github.gisttest.requests.model;

import java.util.HashMap;
import java.util.Map;

public class RequestParameters {
	
	
	private String requestMapping;
	
	private String requestBody;
	
	private Map<String,String> headers = new HashMap<String,String>();
	
	
	private Map<String,String> queryParameters = new HashMap<String,String>();
	
	

	public String getRequestMapping() {
		return requestMapping;
	}

	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(Map<String, String> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((headers == null) ? 0 : headers.hashCode());
		result = prime * result + ((queryParameters == null) ? 0 : queryParameters.hashCode());
		result = prime * result + ((requestBody == null) ? 0 : requestBody.hashCode());
		result = prime * result + ((requestMapping == null) ? 0 : requestMapping.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestParameters other = (RequestParameters) obj;
		if (headers == null) {
			if (other.headers != null)
				return false;
		} else if (!headers.equals(other.headers))
			return false;
		if (queryParameters == null) {
			if (other.queryParameters != null)
				return false;
		} else if (!queryParameters.equals(other.queryParameters))
			return false;
		if (requestBody == null) {
			if (other.requestBody != null)
				return false;
		} else if (!requestBody.equals(other.requestBody))
			return false;
		if (requestMapping == null) {
			if (other.requestMapping != null)
				return false;
		} else if (!requestMapping.equals(other.requestMapping))
			return false;
		return true;
	}

}
