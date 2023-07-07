package com.in28minutes.spring.basics.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ComponentDAO {
	@Autowired //A proxy is getting autowired in here rather than the instance. The proxy will make sure to provide a new instance everytime this dependency is used.
	ComponentJdbcConnection componentJdbcConnection;

	public ComponentJdbcConnection getcomponentJdbcConnection() {
		return componentJdbcConnection;
	}

	public void setcomponentJdbcConnection(ComponentJdbcConnection componentJdbcConnection) {
		this.componentJdbcConnection = componentJdbcConnection;
	}
	
}
