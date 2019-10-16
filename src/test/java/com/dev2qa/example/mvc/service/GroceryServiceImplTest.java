package com.dev2qa.example.mvc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dev2qa.example.mvc.dao.GroceryRepo;
import com.dev2qa.example.mvc.model.Grocery;

@DataJpaTest
public class GroceryServiceImplTest {

	@Mock
	GroceryRepo repo;
	//GroceryRepo repo = mock(GroceryRepo.class);
	@InjectMocks
	GroceryServiceImpl GroceryService;
	Grocery gs = new Grocery();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public final void testReadGroceryItem() {
		Grocery gs = new Grocery();
		
		gs.setItemId(7);
		gs.setItemName("Test");
		gs.setCategory("food");
		gs.setItemPrice(5);
		gs.setItemQty(1);
		
	    Iterable<Grocery> gs1 = repo.findAll();
	  
	    assertEquals("food", gs.getCategory());
	 
	    assertEquals("Test", gs.getItemName());
	}

	@Test
	public final void testDeleteGroceryElement() {
		Integer itemId = 1;
		List<Grocery> groceryBefore = (List<Grocery>) repo.findAll();	
		List groceryCategoryList = new ArrayList();

		groceryCategoryList.add(groceryBefore);
		repo.deleteById(itemId);
		List<Grocery> groceryAfter = (List<Grocery>) repo.findAll();
		Integer count = groceryAfter.size();
		assertEquals(1, groceryCategoryList.size());
		
	}

	@Test
	public final void testGetGroceryItemByCategory() {
		String category = "food";
		gs.setItemId(7);
		gs.setItemName("Test");
		gs.setCategory("food");
		gs.setItemPrice(5);
		gs.setItemQty(1);
		
		repo.save(gs);
		List<Grocery> grocery = repo.findByCategory(category);	
		grocery.add(gs);
	    when(repo.findByCategory(category)).thenReturn(grocery);
		List groceryCategoryList = new ArrayList();

		groceryCategoryList.add(grocery);
		assertEquals(1, groceryCategoryList.size());
	
	}
	
	

	@Test
	public final void testAddGroceryItem() {
		gs.setItemId(7);
		gs.setItemName("Test");
		gs.setCategory("food");
		gs.setItemPrice(5);
		gs.setItemQty(1);
		
		repo.save(gs);
		List<Grocery> groceryAfterSave = (List<Grocery>) repo.findAll();
		List groceryCategoryList = new ArrayList();
		groceryCategoryList.add(groceryAfterSave);
		assertEquals(1, groceryCategoryList.size());
	
	}

}
