package com.dot.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dot.data.Notification;
import com.dot.data.UserAccount;

@Repository("notificationDao")
public class NotificationDaoImpl extends AbstractDao implements NotificationDao {

	@Override
	public List<Notification> findAll() {
		try {	
			Criteria criteria = getSession().createCriteria(Notification.class);
			return (List<Notification>) criteria.list();
		}catch(NoResultException nr){
			return null;
		}catch(Exception ex){
			return null;
		}	
	}

	@Override
	public Notification findByID(Long notificationID) {
		try {
			 Query query = getSession().createQuery("from Notification where notificationId = :notificationId ");
			 query.setParameter("notificationId", notificationID);
			 return (Notification)query.list().get(0);
			}catch(NoResultException nr){
				return null;
			}catch(Exception ex){
				return null;
			}
	}

	@Override
	public List<Notification> findLatestFive() {
		try {
		    Query query = getSession().createQuery("from Notification n order by n.notificationAddedOn desc ");
		    return (List<Notification>)query.setMaxResults(5).list();
		}catch(NoResultException nr){
			return null;
		}catch(Exception ex){
			return null;
		}
	}
	@Override
	public Long countNotification(){
		try {
		    Query query = getSession().createQuery("select count(*) from Notification");
		    return ( (Long) query.iterate().next() );
		}catch(NoResultException nr){
			return 0l;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}

}
