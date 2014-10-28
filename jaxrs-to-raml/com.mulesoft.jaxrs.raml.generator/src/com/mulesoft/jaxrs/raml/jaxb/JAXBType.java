package com.mulesoft.jaxrs.raml.jaxb;

import java.util.ArrayList;

import com.mulesoft.jaxrs.raml.annotation.model.IMethodModel;
import com.mulesoft.jaxrs.raml.annotation.model.ITypeModel;


public class JAXBType extends JAXBModelElement {
	
	public JAXBType(ITypeModel model) {
		super(model);
		IMethodModel[] methods = model.getMethods();
		for (IMethodModel m:methods){
			
		}
	}
	protected JAXBType superClass;

	protected ArrayList<JAXBProperty>properties=new ArrayList<JAXBProperty>();
	
}
