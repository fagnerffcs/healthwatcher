package br.cin.ufpe.healthwatcher.business.employee;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.cin.ufpe.healthwatcher.data.IEmployeeRepository;
import br.cin.ufpe.healthwatcher.model.employee.Employee;

@ManagedBean
@SessionScoped
public class EmployeeRecord implements Serializable {

	private static final long serialVersionUID = -3894035124921216300L;

	private Employee employee;
	
	private IEmployeeRepository employeeRepository;
	
	public EmployeeRecord(IEmployeeRepository rep) {
		this.employeeRepository = rep;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@PostConstruct
	private void init(){
		this.employee = new Employee();
	}
	
	public Employee search(String login) throws ObjectNotFoundException, RepositoryException {
		return employeeRepository.search(login);
	}

	public void insert(Employee employee) throws ObjectNotValidException, ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException {
		if (employeeRepository.exists(employee.getLogin())) {
			//TODO:alterar para usar a mensagem de excecao do bundle
			//throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
		} else {
			BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
			this.employee.setPassword(crypt.encode(this.employee.getPassword()));
			this.employeeRepository.insert(employee);
		}
	}

	public void update(Employee employee) throws ObjectNotValidException, ObjectNotFoundException, ObjectNotValidException, RepositoryException {
		employeeRepository.update(employee);
	}
	
//	public String salvar(){
//		FacesContext facesContext = FacesContext.getCurrentInstance();		
//		try{
//			init();
//		} catch(Exception e){
//            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//            						"Registration mal sucedido", "Não foi possível registrar a reclamação!"));
//            return "";
//		}
//		
//		return "menuEmployee.xhtml?faces-redirect=true";
//	}
	
	
}
