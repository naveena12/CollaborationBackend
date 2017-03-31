package com.niit.colloboration.DAO.impl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloboration.model.FileUpload;
import com.niit.collobration.DAO.FileUploadDAO;

@Repository("fileUploadDAO")
@EnableTransactionManagement
public class FileUploadDAOimpl implements FileUploadDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	public FileUploadDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	@Override
	public void save(FileUpload fileUpload) {
		//Session session=sessionFactory.getCurrentSession();
		//session.save(fileUpload);
		sessionFactory.getCurrentSession().save(fileUpload);
		/*session.flush();
		session.close();*/
		
		// TODO Auto-generated method stub
		
	}
  @Transactional
	@Override
	public FileUpload getFile(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from FileUpload where name=?");
		query.setParameter(0, username);
        FileUpload fileUpload=(FileUpload)((org.hibernate.Query) query.setMaxResults(1)).uniqueResult();
		//session.close();
		return fileUpload;
		// TODO Auto-generated method stub

	}
	

}
