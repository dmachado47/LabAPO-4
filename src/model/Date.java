public class Date{
	
	private int day;
	private int month;
	private int year;
	
	public Date(int xday, int xmonth, int xyear){
		day = xday;
		month = xmonth;
		year = xyear;
	}
	
	public int getday(){
		return day;
	}
	
	public int getmonth(){
		return month;
	}
	
	public int getyear(){
		return year;
	}
	
	public void setday(int xday){
		day = xday;
	}
	
	public void setmonth(int xmonth){
		month = xmonth;
	}
	
	public void setyear(int xyear){
		year = xyear;
	}
	
	public String parseDate(){
		return day + "/" + month + "/" + year;
	}
}