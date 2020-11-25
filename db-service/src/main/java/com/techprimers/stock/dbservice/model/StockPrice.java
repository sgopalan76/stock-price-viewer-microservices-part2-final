package com.techprimers.stock.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "StockPrice", catalog = "test")
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stockId")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "stock")
    private String quote;
    
    @Column(name = "stockDesc")
    private String quoteDesc;
    
    @Column(name = "stockHistory")
    private String stockHistory;
    
    @Column(name = "stockDate")
    private String stockDate;
    
    @Column(name = "stockTrans")
    private String stockTrans;

    private String getQuoteDesc() {
		return quoteDesc;
	}

	private void setQuoteDesc(String quoteDesc) {
		this.quoteDesc = quoteDesc;
	}

	private String getStockHistory() {
		return stockHistory;
	}

	private void setStockHistory(String stockHistory) {
		this.stockHistory = stockHistory;
	}

	private String getStockDate() {
		return stockDate;
	}

	private void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

	private String getStockTrans() {
		return stockTrans;
	}

	private void setStockTrans(String stockTrans) {
		this.stockTrans = stockTrans;
	}

	public StockPrice() {
    }

    public StockPrice(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
