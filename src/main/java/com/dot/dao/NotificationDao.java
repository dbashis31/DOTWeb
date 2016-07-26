package com.dot.dao;

import java.util.List;

import com.dot.data.Notification;
import com.dot.data.UserAccount;

public interface NotificationDao {
	List<Notification> findAll();
	Notification findByID(Long notificationID);
	List<Notification> findLatestFive();
	Long countNotification();
}
