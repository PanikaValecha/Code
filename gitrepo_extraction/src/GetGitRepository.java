import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.ParseException;

public class GetGitRepository 
{
	public static void main(String[] args) throws IOException, ParseException 
	{
		sendGET(args[0]);
		System.out.println("GET DONE");
	}		
	private static void sendGET(String outFile) throws IOException
	{
		String USER_AGENT = "Mozilla/5.0";
		String GET_URL="https://api.github.com/search/repositories?q=data%20mining&sort=stars&order=desc";
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		BufferedWriter output = new BufferedWriter(new FileWriter(outFile));;
		if (responseCode == HttpURLConnection.HTTP_OK) //success
		{ 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				output.write(inputLine);
			}
			output.close();
			in.close();	
		}
		else 
		{
			System.out.println("GET request not worked");
		}
	}
}
