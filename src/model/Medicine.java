import java.util.ArrayList;

public class Medicine{
	
	//Atributos
	private String drugName;
	private int dose;
	private double doseCost;	
	private int doseFrequency;
	
	
	public Medicine(String xdrugName, int xdose, double xdoseCost, int xdoseFrequency) {
	
		drugName = xdrugName;
		dose = xdose;
		doseCost = xdoseCost;
		doseFrequency = xdoseFrequency;
		
	}
	
	//getters 
	
	public String getdrugName(){
		return drugName;
	}
	public int getdose(){
		return dose;
	}
	public double getdoseCost(){
		return doseCost;
	}
	public int getdoseFrequency(){
		return doseFrequency;
	}
	
	//setters
	
	public void setdrugName (String xdrugName){
		drugName = xdrugName;
	}
	public void setdose (int xdose){
		dose = xdose;
	}
	public void setdoseCost (double xdoseCost){
		doseCost = xdoseCost;
	}
	public void setdoseFrequency (int xdoseFrequency){
		doseFrequency = xdoseFrequency;
	}
}