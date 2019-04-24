import java.util.ArrayList;

public class ClinicHistory{
	
	//Constantes
	public final static int ABIERTA = 1;
	public final static int CERRADA = 0;
	
	//Atributos
	private int status;
	private String symptoms;
	private String diagnostic;
	
	//Relation
	private Date ingressDate;
	private Animal animalData;
	private User ownerData;
	private ArrayList<Medicine> medicinesHistory;
	private Miniroom roomAssociated;
	
	public ClinicHistory (int xstatus, int xday, int xmonth, int xyear, String xsymptoms, String xdiagnostic, Animal xAnimalData, User xOwnerData, 
						ArrayList<Medicine> xmedicines, Miniroom xroom){
	
		status = xstatus;
		ingressDate = new Date(xday,xmonth,xyear); 
		symptoms = xsymptoms;
		diagnostic = xdiagnostic;
		
		animalData = xAnimalData;
		ownerData = xOwnerData;
		medicinesHistory = xmedicines;
		roomAssociated = xroom;
		
	}
	
	//getters
	
	public int getstatus(){
		return status;
	}
	public Date getingressDate(){
		return ingressDate;
	}
	public String getsymptoms(){
		return symptoms;
	}
	public String getdiagnostic(){
		return diagnostic;
	}
	public Animal getanimalData(){
		return animalData;
	}
	public User getownerData(){
		return ownerData;
	}
	public ArrayList<Medicine> getmedicinesHistory(){
		return medicinesHistory;
	}
	public Miniroom getroomAssociated(){
		return roomAssociated;
	}
	
	//setters
	
	public void setstatus (int xstatus){
		status = xstatus;
	}
	public void setingressDate (int xd, int xm, int xy){
		ingressDate = new Date(xd,xm,xy);
	}
	public void setsymptoms (String xsymptoms){
		symptoms = xsymptoms;
	}
	public void setdiagnostic (String xdiagnostic){
		diagnostic = xdiagnostic;
	} 
	public void setanimalData (Animal xanimalData){
		animalData = xanimalData;
	}
	public void setownerData (User xownerData){
		ownerData = xownerData;
	}
	public void setmedicinesHistory (ArrayList<Medicine> xmedicinesHistory){
		medicinesHistory = xmedicinesHistory;
	}
	public void setroomAssociated (Miniroom xroomAssociated){
		roomAssociated = xroomAssociated;
	}

	public String generateIndividualReport(){
		String report = "";
		if(animalData != null){
			report += "// ---------------------------------------- // \n";
			report += "Nombre Paciente: " + animalData.getpetName() + "\n";
			report += "Tipo de animal: " + animalData.getanimalType() + "\n";
			report += "Edad: " + animalData.getage() + " años \n";
			report += "Peso: " + animalData.getweight() + " Kg. \n \n";
			
			if(status == ABIERTA){
				report += "Estado actual: Abierta \n";
			} else {
				report += "Estado actual: Cerrada \n";
			}
			
			report += "Fecha de hospitalización: " + ingressDate.parseDate() + "\n";
			report += "Síntomas: " + symptoms + "\n";
			report += "Diagnóstico: " + diagnostic + "\n \n";
			
			report += "Medicamentos recetados: " + diagnostic + "\n";
			for (int j=0; j < medicinesHistory.size(); j++){
				String dn = medicinesHistory.get(j).getdrugName();
				int dose = medicinesHistory.get(j).getdose();
				double dcost = medicinesHistory.get(j).getdoseCost();
				int freq = medicinesHistory.get(j).getdoseFrequency();
				
				// Formato: "- Amoxicilina. Administrar 3 dosis cada 8 horas. Costo de la dosis: $60000."
				report += "- " + dn + ". Administrar " + dose + " dosis cada " + freq + " horas. Costo de la dosis: $" + dcost + ".\n"; 
			}
			report += "\n";
		}
		return report;
	}
}