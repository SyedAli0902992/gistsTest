package github.gisttest.testsuite;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import github.gisttest.helper.ReadJsonHelper;
import github.gisttest.helper.ResponseValidatorHelper;
import github.gisttest.restservices.GistsRestServicesCaller;
import github.gisttest.validators.ResponseValidator;
import io.restassured.response.Response;

public class GetGistsForOneUserTests {

	GistsRestServicesCaller gistsRestServicesCaller;
	
	@Before
	public void init() {
		this.gistsRestServicesCaller = new GistsRestServicesCaller();
	}
	/*This test is validate if POST is successfully inserting a gist
	 * it will insert a record and validate its contents
	 * then use get to check if that gist Id exsists
	 * then use delete to delete that gist using id
	 * */
	@Test
	public void  testSuccesfullinsertionAndDeletion() {
		//create a gist
		Response response = gistsRestServicesCaller.createAGists(ReadJsonHelper.getParsedJsonAsString("testSuccesfulInsertionAndDeletion"));
		
		String gistId = ResponseValidatorHelper.getGistIdFromResponse(response);
		//validate the gist created
		assertTrue(ResponseValidator.validateNumberOfFiles(response,2));
		assertTrue(ResponseValidator.validateDiscription(response, "test a succefull insertion"));
		//validate the gist with get call
		response = gistsRestServicesCaller.getASingleGists(gistId);
		assertTrue(ResponseValidator.validateNumberOfFiles(response,2));
		assertTrue(ResponseValidator.validateGistID(response, gistId));
		//delete the gist created
		response = gistsRestServicesCaller.deleteAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		//validate that the gist no longer exists
		response = gistsRestServicesCaller.getASingleGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 404));
		
	}

	/*This test is validate if Patch is successfully editing a gist
	 * it will insert a record and validate its contents
	 * then use get to check if that gist Id exsists
	 * then it will patch the gist
	 * then use get to check if that gist Id patched
	 * then use delete to delete that gist using id
	 * */
	@Test
	public void  testSuccesfullinsertionPatchAndDeletion() {
		//create a gist
		Response response = gistsRestServicesCaller.createAGists(ReadJsonHelper.getParsedJsonAsString("testSuccesfulInsertionAndDeletion"));
		
		String gistId = ResponseValidatorHelper.getGistIdFromResponse(response);
		
		//validate the gist created
		assertTrue(ResponseValidator.validateNumberOfFiles(response,2));
		assertTrue(ResponseValidator.validateDiscription(response, "test a succefull insertion"));
		
		//validate the gist with get call
		response = gistsRestServicesCaller.getASingleGists(gistId);
		assertTrue(ResponseValidator.validateNumberOfFiles(response,2));
		assertTrue(ResponseValidator.validateGistID(response, gistId));
		
		//edit the gist with patch call
	
		response = gistsRestServicesCaller.patchAGists(ReadJsonHelper.getParsedJsonAsString("testSuccesfulInsertionPatchAndDeletion"), gistId);
		assertTrue(ResponseValidator.validateNumberOfFiles(response,3));
		assertTrue(ResponseValidator.validateDiscription(response, "test a succefull Patch"));
		
		//validate edited gist with get call
		response = gistsRestServicesCaller.getASingleGists(gistId);
		assertTrue(ResponseValidator.validateNumberOfFiles(response,3));
		assertTrue(ResponseValidator.validateGistID(response, gistId));
		
		//delete the gist created
		response = gistsRestServicesCaller.deleteAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//validate that the gist no longer exists
		response = gistsRestServicesCaller.getASingleGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 404));
		
	}

	/*This test is validate if a gist is successfully starred and unstarred
	 * it will insert a record and validate its contents
	 * then use get to check if that gist Id exsists
	 * then use delete to delete that gist using id
	 * */
	@Test
	public void  testSuccesfullGistStarAndUnstar() {
		//create a gist
		Response response = gistsRestServicesCaller.createAGists(ReadJsonHelper.getParsedJsonAsString("testSuccesfulInsertionAndDeletion"));
		
		String gistId = ResponseValidatorHelper.getGistIdFromResponse(response);
		
		//validate the gist created
		assertTrue(ResponseValidator.validateNumberOfFiles(response,2));
		assertTrue(ResponseValidator.validateDiscription(response, "test a succefull insertion"));
		
		//star the gist with patch call
	    response = gistsRestServicesCaller.starAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//validate a starred gist
		response = gistsRestServicesCaller.checkIfAGistsIsStarred(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//Unstar a Gist
		response = gistsRestServicesCaller.unstarAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//validate a Unstarred gist
		response = gistsRestServicesCaller.checkIfAGistsIsStarred(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 404));
		
		//delete the gist created
		response = gistsRestServicesCaller.deleteAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//validate that the gist no longer exists
		response = gistsRestServicesCaller.getASingleGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 404));
		
	}
	
	
	/*This test is validate multiple gists are succefully starred and Unstarred
	 * it will insert a record and validate its contents
	 * then use get to check if that gist Id exsists
	 * then use delete to delete that gist using id
	 * */
	@Test
	public void  testSuccesfullListOfStarredGist() {
		//create multiple gist
		List<String> listOfGistId = new ArrayList<String>();
		String gistId;
		Response response = gistsRestServicesCaller.createAGists(ReadJsonHelper.getParsedJsonAsString("createMultipleGist1"));
		gistId = ResponseValidatorHelper.getGistIdFromResponse(response);
		listOfGistId.add(gistId);
		response = gistsRestServicesCaller.starAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		response = gistsRestServicesCaller.createAGists(ReadJsonHelper.getParsedJsonAsString("createMultipleGist2"));
		gistId = ResponseValidatorHelper.getGistIdFromResponse(response);
		listOfGistId.add(gistId);
		response = gistsRestServicesCaller.starAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		response = gistsRestServicesCaller.createAGists(ReadJsonHelper.getParsedJsonAsString("createMultipleGist2"));
		gistId = ResponseValidatorHelper.getGistIdFromResponse(response);
		listOfGistId.add(gistId);
		response = gistsRestServicesCaller.starAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		//validate the gist created
		
		//star the gist with patch call
	    response = gistsRestServicesCaller.getAllStarredGists();
		assertTrue(ResponseValidator.validateStatusCode(response, 200));
	    assertTrue(ResponseValidator.validateResponseSize(response, 3));
		
		//validate a starred gist
		response = gistsRestServicesCaller.checkIfAGistsIsStarred(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//Unstar a Gist
		response = gistsRestServicesCaller.unstarAGists(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 204));
		
		//validate a Unstarred gist
		response = gistsRestServicesCaller.checkIfAGistsIsStarred(gistId);
		assertTrue(ResponseValidator.validateStatusCode(response, 404));
		
		//delete all gists created
		listOfGistId.forEach(gist ->{;
		Response responseDelete = gistsRestServicesCaller.deleteAGists(gist);
		assertTrue(ResponseValidator.validateStatusCode(responseDelete, 204));
		
		//validate that the gist no longer exists
		responseDelete = gistsRestServicesCaller.getASingleGists(gist);
		assertTrue(ResponseValidator.validateStatusCode(responseDelete, 404));
		});
		
	}
}
