package com.halfacode.ecommerce.pizzaservice;

import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestEngine;
import org.junit.platform.engine.UniqueId;

public class MySpringTest implements TestEngine{

	public static final String Engin_Id="my-custom-engine";
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest, UniqueId uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(ExecutionRequest request) {
		// TODO Auto-generated method stub
		
	}

}
