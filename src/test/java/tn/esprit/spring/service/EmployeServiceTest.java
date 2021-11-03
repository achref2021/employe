package tn.esprit.spring.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceTest {
	@Autowired
	IEmployeService es; 

	@Test
	public void testRetrieveAllemploye() {
		List<Employe> listemployes = es.retrieveAllemploye();	
	
	}
	
	
	@Test
	public void testAddemploye()   {
		Employe e = new Employe("achref", "ismail","ismail.achref@esprit.tn" ,"12345", Role.INGENIEUR); 
		Employe employeAdded = es.addemploye(e); 
		Assert.assertEquals(e.getNom(), employeAdded.getNom());
	}
 
	@Test
	public void testModifyemploye()    {
		Employe e = new Employe(39L ,"achref", "ismail","ismail.achref@esprit.tn" ,"12345", Role.INGENIEUR); 
		Employe employeupdated = es.updateemploye(e); 
		Assert.assertEquals(e.getNom(), employeupdated.getNom());
	}

	@Test
	public void testRetrieveemploye() {
		Employe employeretrieved = es.retrieveEmploye("51"); 
	    Assert.assertEquals(51L,employeretrieved.getId().longValue());
	   }
	
	//@Test
	//public void testDeleteemploye() {
	//	es.deleteemploye("33");
	//}

}
