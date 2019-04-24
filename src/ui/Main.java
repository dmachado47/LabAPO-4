import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	
	public static final Veterinary vet = new Veterinary("Mi Pequeña Mascota");
	
	public static void main(String[] args){
		
		// Create the users
		vet.registerUser("Ronaldinho", 1049, "Cra 1", 312652846);
		vet.registerUser("Neymar", 1195, "Cra 7", 315645722);
		vet.registerUser("Ricardo", 3265, "Cra 5", 322540619);
		
		// Create the pets
		vet.registerPet("Sacha", "Dog", 4, 12.0, 1049);
		vet.registerPet("Goku", "Cat", 6, 7.5, 1195);
		vet.registerPet("Tom", "Cat", 8, 11.0, 1195);
		vet.registerPet("Snoopy", "Dog", 5, 10.4, 1195);
		
		// Create the medicines
		Medicine m1 = new Medicine("Acetaminofen", 3, 7000.0, 2);
		Medicine m2 = new Medicine("Desparasitante", 2, 24500.0, 4);
		Medicine m3 = new Medicine("Amoxicilina", 3, 11750.0, 1);
		
		ArrayList<Medicine> vetm = new ArrayList<Medicine>();
		
		ArrayList<Medicine> am1 = new ArrayList<Medicine>();
		ArrayList<Medicine> am2 = new ArrayList<Medicine>();
		ArrayList<Medicine> am3 = new ArrayList<Medicine>();
		
		vetm.add(m1);vetm.add(m2);vetm.add(m3);
		
		am1.add(m1); am1.add(m3);
		am2.add(m2); am2.add(m3);
		am3.add(m1); am3.add(m2);
		
		// Hospitalize the pets
		vet.hospitalize(1049, "Sacha", 13, 2, 2019, "Fever", "Intestine infection", am3);
		vet.hospitalize(1195, "Goku", 8, 1, 2019, "Headache", "Intestine infection", am3);
		vet.hospitalize(1195, "Tom", 25, 2, 2019, "Wound", "Stabbed cat", am2);
		vet.hospitalize(3265, "Snoopy", 5, 3, 2019, "Threw up", "Discomfort", am1);
		
		// Make functions available
		
		System.out.println("Welcome to the vet Mi pequeña Mascota!");
		System.out.println("To interact with the app, you've got the following options:");
		System.out.println("1. Register a new pet and associate it with an owner");
		System.out.println("2. Hospitalize a pet");
		System.out.println("3. Generate report of hospitalized pets");
		System.out.println("4. Generate report of all clinical histories in vet");
		System.out.println("5. Show hospitalization cost for an animal");
		System.out.println("6. Discharge a pet");
		System.out.println("7. Show vet's incomes in hospitalizations");
		System.out.println("8. Show a miniroom's number based on animal's name");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch (option) {
			case 1:
				
			break;
			case 2:
				System.out.println("Enter the owner's ID");
				int oid = sc.nextInt();
				System.out.println("Enter the animal's name");
				String pn = sc.nextLine();
				System.out.println("Enter the day");
				int d = sc.nextInt();
				System.out.println("Enter the month");
				int m = sc.nextInt();
				System.out.println("Enter the year");
				int y = sc.nextInt();
				System.out.println("Enter the animal's symptoms");
				String ps = sc.nextLine();
				System.out.println("Enter the animal's diagnostic");
				String pd = sc.nextLine();
				
				System.out.println("Enter the animal's medicine");
				
				//
				
				vet.hospitalize(oid,pn,d,m,y,ps,pd,null);
				
			break;
			case 3:
				String hospitalPets = vet.generateHistoryHospitalizedReport();
				System.out.println(hospitalPets);
			break;
			case 4:
				String wholeReport = vet.generateHistoryReport();
				System.out.println(wholeReport);
			break;
			case 5:
				System.out.println("Enter the animal's name");
				String name = sc.nextLine();
				double hcost = vet.calculateHospitalizationCost(name);
				if (hcost != 0){
					System.out.println("Hospital cost for the pet is: " + "$" + hcost);
				} else {
					System.out.println("Sorry! We couldn't find that animal.");
				}
			break;
			case 6:
				System.out.println("Enter the animal's name");
				String n = sc.nextLine();
				String dischargeResult = vet.discharge(n);
				System.out.println(dischargeResult);
			break;
			case 7:
				double incomes = vet.getHospitalizationIncomes();
				System.out.println("Total incomes in hospitalizations are: " + "$ " + incomes);
			break;
			case 8:
				System.out.println("Enter the animal's name");
				String xname = sc.nextLine();
				int petN = vet.searchRoomNumber(xname);
				if(petN == -1){
					System.out.println("Sorry! That pet does not exist in hospitalization area");
				} else {
					petN++;
					System.out.println("The pet is in room number " + petN);
				}
			break;
		}
		
	}
}