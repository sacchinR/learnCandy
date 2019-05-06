package com.examweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examweb.bean.CandyBean;
import com.examweb.bean.Regbean;

@Repository
public class CandyDao {
	
	@Autowired
	SessionFactory factory;
	
	
	@Transactional
	public void store(Regbean reg) {
		Session session=factory.getCurrentSession();
		session.save(reg);
	}

	@Transactional
	public void storeCandy(CandyBean candy) {
		Session session=factory.getCurrentSession();
		session.save(candy);
	}
	@Transactional
	public List<CandyBean> getCandy(Regbean login) {
		Session session=factory.getCurrentSession();
		int count=0;
		List<Regbean> check=session.createQuery("from Regbean where email= '"+login.getEmail()+"' ").list();
		for(Regbean temp:check) {
			if(temp.getEmail().equals(login.getEmail())) {
				List<CandyBean> candy=session.createQuery("from CandyBean where userId="+temp.getReg_id()+"  ").list();
				for(CandyBean ben:candy) {
					count++;
				}
				if(count<=1) {
					return null;
				}
				return candy;
			}
		}
		return null;
	}
	@Transactional
	public int getUserId(Regbean login) {
		Session session=factory.getCurrentSession();

		List<Regbean> check=session.createQuery("from Regbean where email= '"+login.getEmail()+"' ").list();
		for(Regbean temp:check) {
			if(temp.getEmail().equals(login.getEmail())) {
				return temp.getReg_id();
			}
		}
		return 0;
	}
	@Transactional
	public void deleteCandy(int candyId) {
		Session session=factory.getCurrentSession();
		CandyBean ben=session.get(CandyBean.class, candyId);
		session.delete(ben);
	}
	
}
