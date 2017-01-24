package com.niitshoppingkart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.CategoryDAO.CategoryDAO;
import com.niit.Model.Category;

@Controller
public class CategoryController {
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	public CategoryDAO categoryDAO;
	
	@Autowired
	public Category category;
	
	@RequestMapping(value = "/manage_categories", method = RequestMethod.GET)
	public String listCategories(Model model){
		log.debug("starting of method 	list categories");
		model.addAttribute("category",category);
		model.addAttribute("Category list", categoryDAO.list());
		model.addAttribute("isAdminClickedCategory", true);
		log.debug("end of method listcategories");
		return "/home";
		
	}
	
	@RequestMapping(value= "/manage_category_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("Category") Category category , Model model)
	{
		log.debug("starting of method addCategories");
		log.debug("id" +category.getCat_id());
		if(categoryDAO.saveOrUpdate(category)== true){
			model.addAttribute("msg", "successfully created/updated the category");
		}
		else
		{
			model.addAttribute("msg", "not able to create/update");
			
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategory", true);
		log.debug("ending of the method category_add");
		return "/home";
		}
	
	
	@RequestMapping("manage_category_remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, Model model) throws Exception
	{
		boolean flag= categoryDAO.delete(id);
		String msg="successfully done  the operation";
				if(flag!= true) {
					msg="the operation is not success";
					model.addAttribute("msg",msg);}
					return "forward:/manage_categories";
					
				}
	@RequestMapping("manage_categories_edit/{id}")
	public String editCateogry(@PathVariable("id") String id , Model model)
	{
		log.debug("starting of method editCategories");
		
		category= categoryDAO.get(id);
		model.addAttribute("category", category);
		log.debug("end of method edit category");
		return "foward:/manage_categories";
	}
	
}
