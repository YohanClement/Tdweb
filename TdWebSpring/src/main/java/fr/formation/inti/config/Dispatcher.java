package fr.formation.inti.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Dispatcher implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.scan("fr.formation.inti");
		root.register(AppConfig.class);

		
		container.addListener(new ContextLoaderListener(root));
		

		ServletRegistration.Dynamic registration = container.addServlet("JambonCru",
				new DispatcherServlet(root));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}
