package Homework3;

public class StockPrice
{
	private int month;
	private int day;
	private int year;
	private String name;
	private double open;
	private double close;

	public StockPrice(String date, String name, double open, double close)
	{
		this.name = name;
		this.open = open;
		this.close = close;
		String[] StockDate = null;
		for (int i = 0; i < 3; i++) {
			StockDate = date.split("/");
		}
		this.month = Integer.parseInt(StockDate[0]);
		this.day = Integer.parseInt(StockDate[1]);
		this.year = Integer.parseInt(StockDate[2]);
	}

	public String toString()
	{
		return "Stock Date: " + this.month + "/" + this.day + "/" + this.year + ", Name: " + this.name + ", Open: " + this.open + ", Close: " + this.close;
	}

	public int getMonth()
	{
		return this.month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getDay()
	{
		return this.day;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public int getYear()
	{
		return this.year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getOpen()
	{
		return this.open;
	}

	public void setOpen(double open)
	{
		this.open = open;
	}

	public double getClose()
	{
		return this.close;
	}

	public void setClose(double close)
	{
		this.close = close;
	}
}
