package br.cin.ufpe.healthwatcher.facade;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.cin.ufpe.healthwatcher.business.AnimalComplaintController;
import br.cin.ufpe.healthwatcher.business.ComplaintController;
import br.cin.ufpe.healthwatcher.business.DiseaseController;
import br.cin.ufpe.healthwatcher.business.EmployeeController;
import br.cin.ufpe.healthwatcher.business.EmployeeLogin;
import br.cin.ufpe.healthwatcher.business.FoodComplaintController;
import br.cin.ufpe.healthwatcher.business.HealthUnitController;
import br.cin.ufpe.healthwatcher.business.MedicalSpecialtyController;
import br.cin.ufpe.healthwatcher.business.SearchComplaintController;
import br.cin.ufpe.healthwatcher.business.SpecialComplaintController;

@ManagedBean
@SessionScoped
public class Facade implements Serializable {
	
	private static final long serialVersionUID = -2205283915107762308L;

	private static Facade instance;
	
	public static Facade getInstance(){
		if(instance==null){
			instance = new Facade();
		}
		return instance;
	}
	
	private AnimalComplaintController animalComplaintController = new AnimalComplaintController();
	
	private FoodComplaintController foodComplaintController = new FoodComplaintController();
	
	private SpecialComplaintController specialComplaintController = new SpecialComplaintController();
	
	private HealthUnitController healthUnitController = new HealthUnitController();
	
	private MedicalSpecialtyController medicalSpecialtyController = new MedicalSpecialtyController();
	
	private ComplaintController complaintController = new ComplaintController();
	
	private SearchComplaintController searchComplaintController = new SearchComplaintController();
	
	private DiseaseController diseaseController = new DiseaseController();
	
	private EmployeeLogin employeeLogin = new EmployeeLogin();
	
	private EmployeeController employeeController = new EmployeeController();

	public AnimalComplaintController getAnimalComplaintController() {
		return animalComplaintController;
	}

	public FoodComplaintController getFoodComplaintController() {
		return foodComplaintController;
	}

	public SpecialComplaintController getSpecialComplaintController() {
		return specialComplaintController;
	}

	public HealthUnitController getHealthUnitController() {
		return healthUnitController;
	}

	public MedicalSpecialtyController getMedicalSpecialtyController() {
		return medicalSpecialtyController;
	}

	public ComplaintController getComplaintController() {
		return complaintController;
	}
	
	public SearchComplaintController getSearchComplaintController(){
		return searchComplaintController;
	}

	public DiseaseController getDiseaseController() {
		return diseaseController;
	}

	public EmployeeLogin getEmployeeLogin() {
		return employeeLogin;
	}

	public EmployeeController getEmployeeController() {
		return employeeController;
	}

}