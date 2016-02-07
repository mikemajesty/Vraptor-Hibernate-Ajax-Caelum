package br.com.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
@ApplicationScoped
public class SessionCreator {
	private Session session;
	private SessionFactory factory;

	public SessionCreator() {
		this.factory = new AnnotationConfiguration().configure(
				"hibernate.cfg.xml").buildSessionFactory();
	}

	public Session getSession() {
		return this.session;
	}

	@PostConstruct
	public void open() {
		this.session = factory.openSession();
	}
	@PreDestroy
	public void close(){
		this.session.close();
		this.factory.close();
	}
}