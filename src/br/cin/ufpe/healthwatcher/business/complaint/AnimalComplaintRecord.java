package br.cin.ufpe.healthwatcher.business.complaint;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.cin.ufpe.healthwatcher.data.rdb.AnimalComplaintRepositoryRDB;
import br.cin.ufpe.healthwatcher.model.address.Address;
import br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint;
import br.cin.ufpe.healthwatcher.model.complaint.Situacao;
import br.cin.ufpe.healthwatcher.model.employee.Employee;

@ManagedBean
@ViewScoped
public class AnimalComplaintRecord implements Serializable {
	
	private static final long serialVersionUID = 7502327389893929089L;

	private AnimalComplaintRepositoryRDB animalComplaintRepositoryRDB = new AnimalComplaintRepositoryRDB();
	
	private AnimalComplaint animalComplaint;
	
	public AnimalComplaintRecord() {
		animalComplaint = new AnimalComplaint();
		animalComplaint.setAtendente(new Employee());
		animalComplaint.setOccurenceLocalAddress(new Address());
		animalComplaint.setEnderecoSolicitante(new Address());
	}
	
	@PostConstruct
	public void init(){
		animalComplaint = new AnimalComplaint();
		animalComplaint.setAtendente(new Employee());
		animalComplaint.setOccurenceLocalAddress(new Address());
		animalComplaint.setEnderecoSolicitante(new Address());
	}

	public AnimalComplaint getAnimalComplaint() {
		return animalComplaint;
	}

	public void setAnimalComplaint(AnimalComplaint animalComplaint) {
		this.animalComplaint = animalComplaint;
	}
	
	public String salvar(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try{
			this.animalComplaint.setDataParecer(new Date());
			this.animalComplaint.setDataQueixa(new Date());
			this.animalComplaint.setSituacao(Situacao.OPEN);
			animalComplaintRepositoryRDB.inserir(animalComplaint);
			facesContext.getExternalContext().getFlash().put("codigo", animalComplaint.getCodigo());
			init();
			return "animalComplaintInserted?faces-redirect=true";
		} catch(Exception e){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "N�o foi poss�vel registrar a reclama��o!", "Registration mal sucedido"));
            return "";
		}
	}

}
