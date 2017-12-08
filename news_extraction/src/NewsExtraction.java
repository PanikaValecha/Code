import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NewsExtraction 
{
	public static void main(String[] args) throws Exception 
	{
		sendGET(args);
		System.out.println("GET DONE");

	}
	private static void sendGET(String[] args) throws Exception 
	{
		int fileCOunter = 1;
		int page=0;

		while(page<=1000)
		{
			String GET_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=7c810037c1c14c5db5a0cda4c3aab82b&q="+args[0]+"&page="+page+"&sort=newest";
			System.out.println("URL:" + GET_URL);
			URL obj = new URL(GET_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) 
				{
					response.append(inputLine);
				}
				in.close();

				JSONParser parser = new JSONParser();
				Object jobj = null;
				try 
				{
					jobj = parser.parse(response.toString());
				} 
				catch (Exception e) {
					e.printStackTrace();}

				JSONObject msg = (JSONObject) jobj;
				if (!msg.isEmpty()) {
					JSONObject jsonObject = (JSONObject) msg.get("response");
					JSONArray jsonArray = (JSONArray) jsonObject.get("docs");

					Iterator<JSONObject> iterator = jsonArray.iterator();

					while (iterator.hasNext()) {
						BufferedWriter outFileResponse = new BufferedWriter(new FileWriter(args[1]+"/NYTDetails" + fileCOunter + ".txt"));
						JSONObject jsonObject1 = (JSONObject) iterator.next();
						if (jsonObject1.get("_id") != null) {
							outFileResponse.write("ID :" + jsonObject1.get("_id").toString() + "\n");
							outFileResponse.write("\n");
						}
						else
						{
							outFileResponse.write("ID :" + " Is Empty" + "\n");
						}

						if (jsonObject1.get("pub_date") != null) {
							outFileResponse.write("Published Date :" + jsonObject1.get("pub_date").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Published Date :" + " Is Empty" + "\n");
						}

						if (jsonObject1.get("web_url") != null) {
							outFileResponse.write("Web URL :" + jsonObject1.get("web_url").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Web URL :" + " Is Empty" + "\n");
						}
						if (jsonObject1.get("snippet") != null) {
							outFileResponse.write("Snippet :" + jsonObject1.get("snippet").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Snippet :" + " Is Empty" + "\n");
						}
						if (jsonObject1.get("abstract") != null) {
							outFileResponse.write("Abstract :" + jsonObject1.get("abstract").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Abstract :" + " Is Empty" + "\n");
						}

						if (jsonObject1.get("lead_paragraph") != null) {
							outFileResponse.write("Lead Paragraph :" + jsonObject1.get("lead_paragraph").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Lead Paragraph :" + " Is Empty" + "\n");
						}

						if (jsonObject1.get("section_name") != null) {
							outFileResponse.write("Section Name :" + jsonObject1.get("section_name").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Section Name :" + " Is Empty" + "\n");
						}
						if (jsonObject1.get("subsection_name") != null) {
							outFileResponse.write("Subsection Name :" + jsonObject1.get("subsection_name").toString() + "\n");
						}
						else
						{
							outFileResponse.write("Subsection Name :" + " Is Empty" + "\n");
						}

						outFileResponse.close();
						fileCOunter++;
					}

				}

			}//if ends
			else {

				System.out.println("GET request not worked for page"+page);
				Thread.sleep(40000);
				continue;

			}
			page++;
		}//while ends


	}

}