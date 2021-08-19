package com.finance.pojo;

public class StockInformation {


    String symbol;
    String name;
    int numShares;
    double price;
    double total;

    public StockInformation(String mySymbol, String myName, int myNumShares, double myPrice, double myTotal) {
        this.symbol = mySymbol;
        this.name = myName;
        this.numShares = myNumShares;
        this.price = myPrice;
        this.total = myTotal;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
