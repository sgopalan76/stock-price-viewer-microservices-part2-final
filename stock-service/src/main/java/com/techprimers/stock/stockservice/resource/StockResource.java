package com.techprimers.stock.stockservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techprimers.stock.stockservice.config.Config;
import com.techprimers.stock.stockservice.config.JSONStock;
import com.techprimers.stock.stockservice.config.Quote;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {
    
    @Autowired
    Config config;

    @GetMapping("/{username}")
    public List<Quote> getStock(@PathVariable("username") final String userName) {

        ResponseEntity<List<String>> quoteResponse = config.restTemplate().exchange("http://db-service/rest/db/" + userName, 
        		HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });


        List<String> quotes = quoteResponse.getBody();
        return quotes
                .stream()
                .map(quote -> {
                    Quote stock = JSONStock.parseStockPrice(quote);
                	
                    /*ResponseEntity<String> stockResponse = restTemplate.exchange("https://www.worldtradingdata.com/api/v1/stock?"
        					+ "symbol="+stock+"&"
        					+ "api_token=7tZfaVPDpUmFAveR1uMvRUTvSLDvbfikLVIWuH6bAvUZzDuMiv2j6EVPP9qe", 
                    		HttpMethod.GET,
                            null, new ParameterizedTypeReference<String>() {
                            });
                    
                    stock = JSONStock.parseStockPrice(stockResponse.getBody());*/
                    
                    return stock; //Hardcoded for now
                    //return stockResponse;
                })
                .collect(Collectors.toList());
    }
    
    @GetMapping("/hello")
	public String getResponseFromDocker() {
		return "Hello from Stock Service";
	}

	/*
	 * private Stock getStockPrice(String quote) { try { return
	 * YahooFinance.get(quote); } catch (IOException e) { e.printStackTrace();
	 * return new Stock(quote); } }
	 */

}
