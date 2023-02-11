package WorkingClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Database.Connect;

public class PointDestrubutionByApi {
	Connect co = new Connect();
	Statement st = null;

	public void PointDestrubutionByApiUsingPHP() {
		co.cLogin();
		try {
			URL url = new URL("http://localhost/reward/");
			HttpURLConnection hr = (HttpURLConnection) url.openConnection();
			if (hr.getResponseCode() == 200) {
				String query = "UPDATE student_reward_points t1 , temporytable t2 SET t1.reward_points= t1.reward_points + t2.temp_point WHERE t1.reward_email=t2.temp_email";

				st = co.conn.createStatement();
				st.executeUpdate(query);

				String truncate = "TRUNCATE TABLE  temporytable";
				st.executeUpdate(truncate);
			} else {
				JOptionPane.showMessageDialog(null, "");
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void pointDestrubutionThroughDatabase() {
		String jsonText = "";
		co.cLogin();
		try {
			URL url = new URL(
					"https://script.google.com/macros/s/AKfycbxCGCb0z61irjn6ezJmHtdPSR1LGO38PLL4TQvmuY0heKH4DrqLL5MHj6rEMZAnd_0/exec?action=getUser");
			HttpURLConnection hr = (HttpURLConnection) url.openConnection();
			if (hr.getResponseCode() == 200) {
				InputStream im = hr.getInputStream();
				StringBuffer sb = new StringBuffer();
				BufferedReader br = new BufferedReader(new InputStreamReader(im));
				String line = br.readLine();
				while (line != null) {
					jsonText += line + "\n";
					line = br.readLine();
				}

				im.close();
				br.close();
			}
			JSONParser parser = new JSONParser();
			try {
				// Parse the string into a JSONArray object
				JSONArray jsonArray = (JSONArray) parser.parse(jsonText);

				// Iterate over the JSONArray
				for (Object object : jsonArray) {
					// Convert each object of the JSONArray to a JSONObject
					JSONObject jsonObject = (JSONObject) object;

					// Read the values
					String email = (String) jsonObject.get("temp_email");
					long points = (Long) jsonObject.get("temp_point");
					String query1 = "insert into temporytable(temp_email,temp_point) values(?,?)";
					PreparedStatement ps1 = co.conn.prepareStatement(query1);
					ps1.setString(1, email);
					ps1.setLong(2, points);
					ps1.executeUpdate();
					// Print the values

				}
				String query = "UPDATE student_reward_points t1 , temporytable t2 SET t1.reward_points= t1.reward_points + t2.temp_point WHERE t1.reward_email=t2.temp_email";

				st = co.conn.createStatement();
				st.executeUpdate(query);

				String truncate = "TRUNCATE TABLE  temporytable";
				st.executeUpdate(truncate);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
