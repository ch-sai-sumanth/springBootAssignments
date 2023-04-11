package com.jokesApiProject.jokesApi;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class JokesApiApplication {

	public static void main(String[] args) throws Exception{

		URL getUrl=new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection=(HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");

		int responseCode= connection.getResponseCode();

		if(responseCode==200)
		{
			BufferedReader in=new BufferedReader( new InputStreamReader( connection.getInputStream()));
			StringBuilder jsonResponseData=new StringBuilder();
			String readLine=null;

			while( (readLine=in.readLine())!=null)
			{
				jsonResponseData.append(readLine);
			}

			in.close();

			JSONObject masterData=new JSONObject( jsonResponseData.toString());

           // System.out.println("The Joke is : "+masterData.get("value"));
            System.out.println(masterData);


		}


	}

}
