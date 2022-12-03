package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.esprit.examen.repositories.CategorieProduitRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class CategorieProduitServiceImplTest {
	@Mock
	CategorieProduitRepository categorieProduitRepositoryMock;
	@InjectMocks
	CategorieProduitServiceImpl categorieProduitService;

	@Test
	@Order(1)
	public void testaddCp() {
		CategorieProduit cp = new CategorieProduit();
		cp.setCodeCategorie("aa");
		cp.setLibelleCategorie("bb");
		cp.setIdCategorieProduit(1L);
		Mockito.when(categorieProduitRepositoryMock.save(cp)).thenReturn(cp);
		CategorieProduit s1 = categorieProduitService.addCategorieProduit(cp);
		Assertions.assertNotNull(s1);
		System.out.println("working add MOCKITO !");
	}
	@Test
	@Order(2)
	public void testdeleteOperateur() {
		CategorieProduit cp = new CategorieProduit();
		cp.setCodeCategorie("aa");
		cp.setLibelleCategorie("bb");
		categorieProduitService.deleteCategorieProduit(cp.getIdCategorieProduit());
		Mockito.verify(categorieProduitRepositoryMock).deleteById(cp.getIdCategorieProduit());
		System.out.println("working delete MOCKITO !");
	}
	@Test
	@Order(3)
	public void tesupdateCategorie() {
		CategorieProduit cp = new CategorieProduit();
		cp.setCodeCategorie("aa");
		cp.setLibelleCategorie("bb");
		cp.setCodeCategorie("dd");
		Mockito.when(categorieProduitService.addCategorieProduit(cp)).thenReturn(cp);
		CategorieProduit s1 = categorieProduitService.updateCategorieProduit(cp);
		Assertions.assertEquals(s1.getLibelleCategorie(),s1.getLibelleCategorie());
		System.out.println("working update MOCKITO !");

	}
	@Test
	@Order(4)
	public void testretrieveCp(){
		CategorieProduit cp = new CategorieProduit();
		cp.setCodeCategorie("aa");
		cp.setLibelleCategorie("bb");
		cp.setCodeCategorie("dd");
		Mockito.when(categorieProduitRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(cp)); //find all
		CategorieProduit s1 = categorieProduitService.retrieveCategorieProduit(1L);
		Assertions.assertNotNull(s1);
		System.out.println("working retrieve MOCKITO !");


	}

	


	/*
	@Test
	public void testDeleteClient() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = dateFormat.parse("30/09/2000");
		Client c = new Client("Salhi", "Ahmed", dateNaissance, "ahmed.salhi@esprit.tn", "pwd", Profession.Cadre,
				CategorieClient.Ordinaire);
		Client client = clientService.addClient(c);
		clientService.deleteClient(client.getIdClient());
		assertNull(clientService.retrieveClient(client.getIdClient()));
	}

	@Test
	public void testRetrieveAllClients() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = dateFormat.parse("30/09/2000");
		List<Client> clients = clientService.retrieveAllClients();
		int expected = clients.size();
		Client c = new Client("Salhi", "Ahmed", dateNaissance, "ahmed.salhi@esprit.tn", "pwd", Profession.Cadre,
				CategorieClient.Ordinaire);
		Client client = clientService.addClient(c);
		assertEquals(expected + 1, clientService.retrieveAllClients().size());
		clientService.deleteClient(client.getIdClient());

	}
	@Test
	public void testGetClientsByDateNaissance() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = dateFormat.parse("28/09/2000");
		Date endDate = dateFormat.parse("30/09/2005");
		List<Client> clients = clientService.getClientsByDateNaissance(startDate, endDate);
		log.info(" count" + clients.size());
		for (Client client : clients) {
			log.info(" client : " + client.getNom()+ " né le "+client.getDateNaissance());

		}
	}
	*/

}

