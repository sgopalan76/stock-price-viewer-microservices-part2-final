package com.techprimers.stock.stockservice.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONStock {
	
	@SuppressWarnings("unchecked")
	public static Quote parseStockPrice(String stocks) {
		JSONParser parser = new JSONParser();
		
		Quote quote = null;
		
		try {
			URL url = new URL("https://www.worldtradingdata.com/api/v1/stock?"
					+ "symbol="+stocks+"&"
					+ "api_token=7tZfaVPDpUmFAveR1uMvRUTvSLDvbfikLVIWuH6bAvUZzDuMiv2j6EVPP9qe");
			
			String inline="";
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
			conn.setRequestMethod("GET"); 
			int responsecode = conn.getResponseCode(); 
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext())
			{
			inline+=sc.nextLine();
			}
			System.out.println("\nJSON data in string format");
			System.out.println(inline);
			sc.close();
			
			Object obj = parser.parse(inline);
			//Object obj = parser.parse(stocks);
			JSONObject jsonObj = (JSONObject) obj;
			
			//loop array
			JSONArray stocksArray = (JSONArray) jsonObj.get("data");
			/*
			 * List<String> list = (List<String>) stocksArray.stream() .map(json ->
			 * json.toString()) .collect(Collectors.toList());
			 * 
			 */
			for(int i = 0; i < stocksArray.size(); i++) {
				JSONObject stock = (JSONObject) stocksArray.get(i);
				
				String symbol = (String)stock.get("symbol");
				String price = (String)stock.get("price");
				String week_high_52 = (String)stock.get("52_week_high");
				System.out.println("Symbol "+symbol);
				System.out.println("Price "+new BigDecimal(price));
				quote = new Quote(symbol, new BigDecimal(price), week_high_52);
			}
			
			
		}
		catch(FileNotFoundException e) { e.printStackTrace(); }
		catch(IOException e) { e.printStackTrace(); }
		catch(ParseException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }

		return quote;
		
		
	}
	
	
	public static void main(String s[]) {
		Quote stock = JSONStock.parseStockPrice("AAPL,MSFT,GOOG,IBM");
	}
	
}
