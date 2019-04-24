import java.util.ArrayList;

public class User{
	
	//Atributos
	private String userName;
	private int idNumber;
	private String address;
	private int phoneNumber;
	
	private ArrayList<Animal> pets;
	
	public User(String xuserName, int xidNumber, String xAddress, int xphoneNumber){
	
		userName = xuserName;
		idNumber = xidNumber;
		address = xAddress;
		phoneNumber = xphoneNumber;
		
		pets = new ArrayList<Animal>();
		
	}
	
	//getters
	public String getuserName(){
		return userName;
	}
	
	public int getidNumber(){
		return idNumber;
	}
	
	public String getAddress(){
		return address;
	}
	
	public int getphoneNumber(){
		return phoneNumber;
	}
	
	public ArrayList<Animal> getPets(){
		return pets;
	}
	
	// Setters
	
	public void setuserName (String xuserName){
		userName = xuserName;
	}
	
	public void setidNumber (int xidNumber){
		idNumber = xidNumber;
	}
	
	public void setAddress (String xAddress){
		address = xAddress;
	}
	
	public void setphoneNumber (int xphoneNumber){
		phoneNumber = xphoneNumber;
	}
	
	public void setPets(ArrayList<Animal> xPets){
		pets = xPets;
	}
	
	public Animal searchPet(String xname){
		Animal search = null;
		int numberPets = pets.size();
		for (int x=0; x<numberPets; x++){
			String searchName = pets.get(x).getpetName(); 
			if (xname.equals(searchName)){
				search = pets.get(x);
			}
		}
		return search;
	}
}