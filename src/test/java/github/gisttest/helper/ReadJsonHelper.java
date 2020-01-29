package github.gisttest.helper;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonHelper {
	
	
	/**
	 * This method is used to generate Post/Patch request's body
	 * To pass a request body as a string could sometimes be difficult 
	 * with all escape sequences hence this method could be very
	 * useful as it would take json as inupt from file and convert it to
	 * a string which can then be passed as a request body
	 * @param jsonName
	 * @return String
	 */
	public static String getParsedJsonAsString(String jsonName) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject) parser.parse(new FileReader("src/test/resources/bodyJsons/"+jsonName+".json"));
			return jsonObj.toString(); 
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

}
