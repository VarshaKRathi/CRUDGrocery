package com.dev2qa.example.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev2qa.example.mvc.model.Grocery;
@Repository
public interface GroceryRepo extends CrudRepository<Grocery, Integer>{
	
	public  List<Grocery> findByCategory(String category);

}
