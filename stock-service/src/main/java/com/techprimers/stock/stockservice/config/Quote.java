package com.techprimers.stock.stockservice.config;

import java.math.BigDecimal;

public class Quote {
    private String quote;
    private BigDecimal price;
    private String week_high_52;

    public Quote(String quote, BigDecimal price, String week_high_52) {
        this.quote = quote;
        this.price = price;
        this.week_high_52 = week_high_52;
    }

    private String getWeek_high_52() {
		return week_high_52;
	}

	private void setWeek_high_52(String week_high_52) {
		this.week_high_52 = week_high_52;
	}

	public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
