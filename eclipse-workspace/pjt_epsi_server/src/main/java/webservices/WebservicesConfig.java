package webservices;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebservicesConfig extends WsConfigurerAdapter {
	  @Bean
	  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(servlet, "/music/*");
	  }

	  @Bean(name = "music")
	  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema musicSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("musicPort");
	    wsdl11Definition.setLocationUri("/music");
	    wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
	    wsdl11Definition.setSchema(musicSchema);
	    return wsdl11Definition;
	  }

	  @Bean
	  public XsdSchema musicsSchema() {

	    return new SimpleXsdSchema(new ClassPathResource("music.xsd"));
	  }
	}

