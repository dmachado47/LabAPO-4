import java.util.ArrayList;

public class Animal{
	
	//Constantes 
	public final static String DOG = "Dog";
	public final static String CAT = "Cat";
	public final static String BIRD = "Bird";
	public final static String OTHER = "Other";
	
	//Atributos
	private String petName;
	private String animalType;
	private int age;
	private double weight;
	private ArrayList<Medicine> animalMedicines;
	
	
	public Animal(String xpetName, String xanimalType, int xage, double xweight){
	
		petName = xpetName;
		animalType = xanimalType;
		age = xage;
		weight = xweight;
		animalMedicines = new ArrayList<Medicine>();
		
	}
	
	//getters
	
	public String getpetName(){
		return petName;
	}
	public String getanimalType(){
		return animalType;
	}
	public int getage(){
		return age;
	}
	public double getweight(){
		return weight;
	}
	public ArrayList<Medicine> getanimalMedicines(){
		return animalMedicines;
	}
	
	//setters
	
	public void setpetName (String xpetName){
		petName = xpetName;
	}
	public void setanimalType (String xanimalType){
		animalType = xanimalType;
	}
	public void setage (int xage){
		age = xage;
	}
	public void setweight (double xweight){
		weight = xweight;
	}
	public String setanimalMedicines(String xanimalMedicines){
		return xanimalMedicines;
	}
	public void setanimalMedicines(ArrayList<Medicine> xmedicines){
		animalMedicines = xmedicines;
	}
}