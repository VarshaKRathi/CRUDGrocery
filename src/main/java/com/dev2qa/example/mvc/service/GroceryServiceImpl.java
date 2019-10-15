package com.dev2qa.example.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dev2qa.example.mvc.dao.GroceryRepo;
import com.dev2qa.example.mvc.model.Grocery;

@Service
public class GroceryServiceImpl {

	@Autowired
	GroceryRepo repo;

	public ModelAndView updateGroceryItem(Integer itemId) {
		ModelAndView mv = new ModelAndView("updateGrocery.jsp");
		Grocery grocery = repo.findById(itemId).orElse(new Grocery());
		grocery.setItemPrice(13);
		grocery.setItemName("itemUpdated");
		repo.save(grocery);
		mv.addObject(grocery);
		return mv;
	}

	public ModelAndView readGroceryItem() {
		ModelAndView mv = new ModelAndView("home.jsp");
		Iterable<Grocery> grocerys = repo.findAll();
		List groceryList = new ArrayList();
		groceryList.add(grocerys);
		// model.addAttribute(ConstantVariable.GROCERY_LIST, groceryList);

		mv.addObject("groceryList", groceryList);
		return mv;
	}

	public String deleteGroceryElement(Integer itemId) {
		try {
			repo.deleteById(itemId);
		} catch (Exception e) {
			return e.getMessage();
		}

		return "deleteGrocery.jsp";
	}

	public ModelAndView getGroceryItemByCategory(String category) {
		ModelAndView mv = new ModelAndView("home.jsp");
		List<Grocery> grocerys = repo.findByCategory(category);
		List groceryCategoryList = new ArrayList();

		groceryCategoryList.add(grocerys);
		// model.addAttribute(ConstantVariable.GROCERY_LIST, groceryList);

		mv.addObject("groceryCategoryList", groceryCategoryList);
		return mv;
	}

	public String addGroceryItem(Grocery grocery) {
		if ((grocery.getItemName().isEmpty()) || ((grocery.getItemPrice()) == null)
				|| ((grocery.getItemQty()) == null)) {

		}
		repo.save(grocery);
		return "Create.jsp";
	}
}
