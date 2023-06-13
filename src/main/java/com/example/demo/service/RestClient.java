package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public final class RestClient {

  public String getData(String url) {
    StringBuilder response = new StringBuilder();
    try {
      URL a = new URL(url);
      HttpURLConnection c = (HttpURLConnection) a.openConnection();
      c.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response.toString();
  }
  
  public void sendData(String apiUrl, String json) throws IOException {
	    URL url = new URL(apiUrl);
	    HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    con.setRequestMethod("POST");
	    con.setRequestProperty("Content-Type", "application/json; utf-8");
	    con.setDoOutput(true);

	    try(OutputStream os = con.getOutputStream()) {
	        byte[] input = json.getBytes("utf-8");
	        os.write(input, 0, input.length);
	    } catch (IOException e) { 
	        e.printStackTrace(); 
        
	    }

	    int responseCode = con.getResponseCode();
	    if (responseCode != HttpURLConnection.HTTP_OK) {
	        throw new RuntimeException("Failed : HTTP error code : " + responseCode);
	    }
	    
	    con.disconnect();
	}
}

