package com.mulesoft.jaxrs.raml.annotation.model.jdt;

import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;

import com.mulesoft.jaxrs.raml.annotation.model.IFieldModel;
import com.mulesoft.jaxrs.raml.annotation.model.ITypeModel;

public class JDTField extends JDTAnnotatable implements IFieldModel{

	public JDTField(IAnnotatable tm) {
		super(tm);
	}

	@Override
	public String getName() {
		return ((IField)tm).getElementName();
	}

	@Override
	public ITypeModel getType() {
		try {
			return doGetType(((IField)tm), ((IField)tm).getTypeSignature());
		} catch (JavaModelException e) {
			return null;
		}
	}

}
