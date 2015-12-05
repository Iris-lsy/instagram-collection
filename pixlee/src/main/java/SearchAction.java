
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

/* TODO: 
 * Add error message
 * validate input
 * 
 */


public class SearchAction {
	
	private final static String APIKEY = "2012344300.1677ed0.3aa3018c542d42efaff8e294d8bc95d1";
    private List<String> errors;
    
	private String tagString;
	private long startDate;
	private long endDate;

	public String perform(HttpServletRequest request) {
		
		// set up error message
		 errors = new ArrayList<String>();
         request.setAttribute("errors", errors);
		
        SearchForm form = new SearchForm(request);
        errors.addAll(form.getValidationErrors());
        if (!errors.isEmpty()) {
    		return "index.jsp";
        }
		tagString = form.getTagString();
		startDate = form.getStartDate();
		endDate = form.getEndDate();
		
		

		ArrayList<Pic> picArray = getImageByTag(tagString, startDate, endDate);
		request.setAttribute("picArray", picArray);
		System.out.println(tagString);
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println("result: " + picArray.toString());


		
		return "index.jsp";

	}
	
	private static ArrayList<Pic> getImageByTag(String tag, long start, long end) {
		URL url;
		ArrayList<Pic> result = new ArrayList<Pic>();
		try {
			url = new URL("https://api.instagram.com/v1/tags/" + tag
					+ "/media/recent?access_token=" + APIKEY);

			// System.out.println(url.toString());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output = "";
			StringBuilder sb = new StringBuilder();
			while ((output = br.readLine()) != null) {
				sb.append(output);
				// System.out.println(output);

			}
			JSONObject response = new JSONObject(sb.toString());
			JSONArray array = response.getJSONArray("data");
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				long time = obj.getLong("created_time");
				if (time < start || time > end) {
					continue;
				}
				
				String picUrl = obj.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
				String link = obj.getString("link");
				
				Pic pic = new Pic();
				pic.setUrl(picUrl);
				pic.setLink(link);
				
				result.add(pic);

			}
			//array.put(new Pic());
			//for ()
			//System.out.println(result.toString());

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

}