package com.dev2qa.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev2qa.example.mvc.dao.GroceryRepo;
import com.dev2qa.example.mvc.model.Grocery;
import com.dev2qa.example.mvc.service.GroceryServiceImpl;

@Controller
public class GroceryController {

	@Autowired
	GroceryRepo repo;
	@Autowired
	GroceryServiceImpl groceryService;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addGrocery")
	public String addGrocery(Grocery grocery) {
		return groceryService.addGroceryItem(grocery);
	}

	@RequestMapping(value = "/showGrocery", method = RequestMethod.GET)
	public ModelAndView getGrocery(@RequestParam String category, Model model) {
		return groceryService.getGroceryItemByCategory(category);

	}

	@RequestMapping(value = "/readGrocery", method = RequestMethod.GET)
	public ModelAndView readGrocery(Model model) {
		return groceryService.readGroceryItem();

	}

	@RequestMapping("/updateGrocery")
	public ModelAndView updateGrocery(@RequestParam Integer itemId) {
		return groceryService.updateGroceryItem(itemId);
	}

	@RequestMapping("/deleteGrocery")
	public String deleteGrocery(@RequestParam Integer itemId) {

		return groceryService.deleteGroceryElement(itemId);

	}

}
