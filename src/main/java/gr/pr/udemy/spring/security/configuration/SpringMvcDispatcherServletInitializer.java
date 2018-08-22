package gr.pr.udemy.spring.security.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}
	
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DemoAppConfiguration.class};
	}
	
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
