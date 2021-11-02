package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {
	List<Employe> retrieveAllemploye();
	Employe addemploye(Employe e);
	void deleteemploye(String id);
	Employe updateemploye(Employe e);
	Employe retrieveEmploye(String id);

}
