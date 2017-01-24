package com.niit.CategoryDAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CategoryDAO.CategoryDAO;
import com.niit.Model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	public SessionFactory sessionfactory;
	
	@Autowired
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionfactory = sessionFactory;
		
	}
	
	@Transactional
	public List<Category> list(){
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>)
				sessionfactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
		}
	@Transactional
	public boolean save(Category category) {
		logger.debug("Starting of the method save");
		
		try {
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception occured while saving category");
			logger.error(e.getMessage());
			return false;
		}
		
		
		
	}
	
	@Transactional
	public boolean saveOrUpdate(Category category) {
		logger.debug("Starting of the method saveOrUpdate");
		
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception occured while saveOrUpdate category");
			logger.error(e.getMessage());
			return false;
		}
		
		
		
	}
	
	@Transactional
	public boolean update(Category category) {
		logger.debug("Starting of the method update");
		
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception occured while update category");
			logger.error(e.getMessage());
			return false;
		}
		
		
		
	}

	@Transactional
	public boolean delete(String id) {
		logger.debug("Starting of the method delete");
		logger.info("Going go delete :"+id);	
		Category CategoryToDelete = new Category();
		CategoryToDelete.setCat_id(id);
		try {
			sessionfactory.getCurrentSession().delete(CategoryToDelete);
			
			logger.debug("Ending of the method delete");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Category get(String id) {
		logger.debug("calling get");
		String hql = "from Category1 where id=" + "'"+ id +"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		logger.debug("hql:" + hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		logger.debug("End get");
		return null;
	}
	
	
	@Transactional
	public Category getByName(String name) {
		String hql = "from Category1 where name=" + "'"+ name +"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		
		return (Category)query.uniqueResult();
		
	}
}
