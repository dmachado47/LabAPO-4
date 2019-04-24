import java.util.ArrayList;

public class Veterinary {
	
	public static final int NUMBER_ROOMS = 8;

	private String name;
  
	private ArrayList<User> people;
	private ArrayList<ClinicHistory> histories;
	private ArrayList<Medicine> medicines;
	private Miniroom[] rooms;
	
	/**
	* <b>Description: </b> This method creates a new instance of the class Veterinary. <br>
	* <b>pre: </b> The name of the vet is not null and the number of minirooms is known. <br>
	* <b>post: </b> A new Veterinary object has been created. <br>
	* @param <b>theName</b> name of the new Veterinary.
	*/

	public Veterinary (String theName) {
		name = theName;
	
		people = new ArrayList<User>();
		histories = new ArrayList<ClinicHistory>();
		medicines = new ArrayList<Medicine>();
		rooms = new Miniroom[NUMBER_ROOMS];
	}
	
	/**
	* <b>Description: </b> This method registers a new user to the vet. <br>
	* <b>pre: </b> The list of users already exists. <br>
	* <b>post: </b> A new user has been added to the vet database. <br>
	* <b>post: </b> If the user already exists, an error message is displayed. <br>
	* @param <b>xuserName</b> the name of the new user, not null.
	* @param <b>xidNumber</b> the ID number of the new user.
	* @param <b>xAddress</b> the home address of the new user, not null.
	* @param <b>xphoneNumber</b> the phone number of the new user.
	*/
	
	public void registerUser (String xuserName, int xidNumber, String xAddress, int xphoneNumber){
		if(searchUser(xidNumber) == null){
			User client = new User (xuserName,xidNumber,xAddress,xphoneNumber);
			people.add(client);
		} else {
			System.out.println("Error: The user already exists.");
		}
	}	
	
	/**
	* <b>Description: </b> This method looks for a user with an ID number. <br>
	* <b>pre: </b> The list of users already exists. <br>
	* <b>post: </b> An user is found in the list of users. <br>
	* @param <b>xid</b> the name of the new user.
	* @return the user matching the solicited ID, <b>null</b> if there's no user with such ID.
	*/
	
	public User searchUser(int xid){
		User searching = null;
		boolean found = false;
		int numberUsers = people.size();
		for (int j=0; j<numberUsers && !found; j++){
			int idSearch = people.get(j).getidNumber(); 
			if (xid == idSearch){
				searching = people.get(j);
				found = true;
			}
		}
		return searching;
	}
	
	/**
	* <b>Description: </b> This method adds a new pet and associates it with an user. <br>
	* <b>pre: </b> The list of users already exists. <br>
	* <b>post: </b> A new pet is registered and has an owner. <br>
	* @param <b>xpetName</b> the name of the new pet, not null.
	* @param <b>xanimalType</b> the animal type of the new pet, not null.
	* @param <b>xage</b> the age of the new pet.
	* @param <b>xweight</b> the weight of the new pet.
	* @param <b>xidOwner</b> the ID of a user whom the pet will be associated.
	* @return <b>true</b> if the pet has been added and associated, <b>false</b> if there's no owner with the solicited ID.
	*/
	
	public boolean registerPet(String xpetName, String xanimalType, int xage, double xweight, int xidOwner){
		boolean registered = false;
		Animal newPet = new Animal(xpetName, xanimalType, xage, xweight);
		User newOwner = searchUser(xidOwner);
		if (newOwner != null){
			newOwner.getPets().add(newPet);
			registered = true;
		}
		return registered;
	}
		//Buscar disponiblidad en los minicuartos
	public int searchAvailable(){
		int available = -1;
		boolean exists = false;
		for (int i=0; i<NUMBER_ROOMS && !exists; i++){
			if (rooms[i].getAnimal()==null){
				available = i;
				exists = true;
			}
		}
		return available;
	}
		//Añadir mascota al minicuarto
	public int addPettoMiniroom(int xOwner, String xPet){
		int add = -1;
		User u = searchUser(xOwner);
		if( u != null){
			Animal a = u.searchPet(xPet);
			if(a != null){
				Miniroom x = rooms[searchAvailable()];
				if(x != null){
					x.setAnimal(a);
					add = searchAvailable();
				}
			}
		}
		return add;
	}
	
	public Animal searchPet(String xName){
		Animal searching = null;
		int numberOwners = people.size();
		boolean found = false;
		for (int x=0; x < numberOwners && !found; x++){
			User temp = people.get(x);
			Animal a = temp.searchPet(xName);
			if (a.getpetName().equals(xName)){
				searching = a;
				found = true;
			}
		}
		return searching;
	}
	
	public Animal searchPetByRoom(String xName){
		Animal pet = null;
		boolean exists = false;
		for (int i=0; i<NUMBER_ROOMS && !exists; i++){
			Animal ta = rooms[i].getAnimal();
			if (ta != null){
				if(ta.getpetName().equals(xName)){
					pet = ta;
					exists = true;
				}
			}
		}
		return pet;
	}
	
	public int searchRoomNumber(String xName){
		int petN = -1;
		boolean exists = false;
		for (int i=0; i<NUMBER_ROOMS && !exists; i++){
			Animal ta = rooms[i].getAnimal();
			if (ta != null){
				if(ta.getpetName().equals(xName)){
					petN = i;
					exists = true;
				}
			}
		}
		return petN;
	}
	
	public int removePetFromMiniroom(String xPet){
		int remove = -1;
		boolean cleared = true;
		for (int i=0; i<NUMBER_ROOMS && !cleared; i++){
			Animal ta = rooms[i].getAnimal();
			if (ta != null){
				if(ta.getpetName().equals(xPet)){
					rooms[i].setAnimal(null);
					remove = i;
					cleared = true;
				}
			}
		}
		return remove;
	}
	
		//
	public boolean hospitalize(int idOwner, String xPet, int xday, int xmonth, int xyear, String xsym, String xdiag, ArrayList<Medicine> xmed){
		boolean hospitalized = false;
		int petinMiniroom = addPettoMiniroom(idOwner, xPet);
		if(petinMiniroom != -1){
			User owner = searchUser(idOwner);
			Animal a = owner.searchPet(xPet);
			Miniroom associated = rooms[petinMiniroom];
			ClinicHistory history = new ClinicHistory(ClinicHistory.ABIERTA, xday, xmonth, xyear, xsym, xdiag, a, owner, xmed, associated);
			histories.add(history);
			a.setanimalMedicines(xmed);
			hospitalized = true;
		}
		return hospitalized;
	}
	
	public String generateHistoryReport(){
		String report = "";
		int numberHistory = histories.size();
		for(int i=0; i < numberHistory; i++){
			ClinicHistory temp = histories.get(i);
			String rt = temp.generateIndividualReport();
			report += rt;
		}
		return report;	
	}
	
	public String generateHistoryHospitalizedReport(){
		String report = "";
		int numberHistory = histories.size();
		for(int i=0; i < numberHistory; i++){
			ClinicHistory temp = histories.get(i);
			if(temp.getroomAssociated() != null){
				String rt = temp.generateIndividualReport();
				report += rt;
			}
		}
		return report;	
	}
	
	public Animal searchAnimalByHistory(String xPetName){
		Animal animalHistory = null;
		boolean found = false;
		for (int z=0; z < histories.size() && !found; z++){
			String sName = histories.get(z).getanimalData().getpetName();
			if(sName.equals(xPetName)){
				animalHistory = histories.get(z).getanimalData();
				found = true;
			}
		}
		return animalHistory;
	}
	
	public ClinicHistory searchHistoryByAnimal(String animalName){
		ClinicHistory h = null;
		boolean exists = false;
		for (int z=0; z < histories.size() && !exists; z++){
			String sName = histories.get(z).getanimalData().getpetName();
			if (sName.equals(animalName)){
				h = histories.get(z);
				exists = true;
			}
		}
		return h;
	}
		
	public double calculateCostAnimalType(String type, double weight){
		double c = 0.0;
		if (type.equals(Animal.CAT)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 10000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 12000.0; 
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 15000.0;
			} else if (weight > 20.0) {
				c = 20000.0;
			}
		} else if (type.equals(Animal.DOG)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 15000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 17000.0;
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 20000.0;
			} else if (weight > 20.0) {
				c = 25000.0;
			}
		} else if (type.equals(Animal.BIRD)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 10000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 12000.0;
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 20000.0;
			} else if (weight > 20.0) {
				c = 25000.0;
			}
		} else if (type.equals(Animal.OTHER)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 10000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 17000.0;
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 30000.0;
			} else if (weight > 20.0) {
				c = 33000.0;
			}
		}
		return c;
	}
	
	public double calculateCostMedicineDose(ArrayList<Medicine> x){
		double cost = 0.0;
		for (int k=0; k < x.size(); k++){
			double tcost = x.get(k).getdoseCost();
			int tDose = x.get(k).getdose();
			int tFreq = x.get(k).getdoseFrequency();
			cost += (tcost * tDose);
		}
		return cost;
	}
	
	public double calculateHospitalizationCost(String animal){
		double cost = 0.0;
		Animal a = searchAnimalByHistory(animal);
		if (searchAnimalByHistory(animal) != null){
			String animalT = a.getanimalType();
			double animalW = a.getweight();
			double costType = calculateCostAnimalType(animalT, animalW);
			
			double historyCost = 0.0;
			ClinicHistory h = searchHistoryByAnimal(animal);
			if (h != null){
				ArrayList<Medicine> m = h.getmedicinesHistory();
				historyCost = calculateCostMedicineDose(m);
			}
			cost = costType + historyCost;
		}
		return cost;
	}
	
	public String discharge(String petName){
		String discharged = "";
		Animal petRoom = searchPetByRoom(petName);
		Animal petHistory = searchAnimalByHistory(petName);
		if (petRoom != null && petHistory != null){
			ClinicHistory hs = searchHistoryByAnimal(petName);
			hs.setroomAssociated(null);
			hs.setstatus(ClinicHistory.CERRADA);
			petRoom.setanimalMedicines(new ArrayList<Medicine>());
			int removed = removePetFromMiniroom(petName);
			
			discharged += "Reporte de mascota dada de alta \n \n";
			discharged += hs.generateIndividualReport();
		} else {
			discharged += "Error! El animalito no figura en nuestra base de datos.";
		}
		return discharged;
	}
	
	public double getHospitalizationIncomes(){
		double incomes = 0.0;
		for(int i = 0; i < NUMBER_ROOMS; i++){
			Miniroom mr = rooms[i];
			Animal s = mr.getAnimal();
			if( s != null){
				ArrayList<Medicine> m = s.getanimalMedicines();
				incomes += calculateCostMedicineDose(m);
			}
		}
		return incomes;		
	}
}