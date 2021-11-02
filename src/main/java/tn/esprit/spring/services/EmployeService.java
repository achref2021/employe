package tn.esprit.spring.services;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeService implements IEmployeService {
	@Autowired
	   EmployeRepository employeRepository;

		private static final Logger l = LogManager.getLogger(EmployeService.class);

		@Override
		public List<Employe> retrieveAllemploye() { 
			List<Employe> employes = null; 
			try {
		
				l.info("In retrieveAllemploye() : ");
				employes = (List<Employe>) employeRepository.findAll();  
				for (Employe employe : employes) {
					l.debug("user +++ : " + employe);
				} 
				l.info("Out of retrieveAllemploye() : ");
			}catch (Exception e) {
				l.error("Error in retrieveAllemploye() : " + e);
			}

			return employes;
		}


		@Override
		public Employe addemploye(Employe e) {
			e.setActif(true);
			employeRepository.save(e);
			return e;
		}

		@Override 
		public Employe updateemploye(Employe e) { 
			e.setActif(true);
			 return  employeRepository.save(e);
			 
		}

		@Override
		public void deleteemploye(String id) {
			employeRepository.deleteById(Long.parseLong(id));
		}

		@Override
		public Employe retrieveEmploye(String id) {
			l.info("in  retrieveEmploye id = " + id);
		
			Employe e =  employeRepository.findById(Long.parseLong(id)).get(); 
			l.info("employe returned : " + e);
			return e; 
		}

}
