package com.management;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConfiguarationUtility 
{

	static SessionFactory getSessionFactory() {
		StandardServiceRegistry servicesr = new StandardServiceRegistryBuilder().configure("config.xml").build();

		Metadata meta = new MetadataSources(servicesr).getMetadataBuilder().build();

		SessionFactory sFactory = meta.buildSessionFactory();
		return sFactory;
	}

}
