package org.raml.jaxrs.codegen.core.ext;

import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;
import org.raml.jaxrs.codegen.core.Generator;
import org.raml.model.Action;
import org.raml.model.MimeType;
import org.raml.model.Raml;
import org.raml.model.Resource;
import org.raml.model.parameter.AbstractParam;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.util.Collection;

/**
 * Add bean validation to all body method parameters.
 */
public class BeanValidationGenerator implements GeneratorExtension {
    @Override
    public void onCreateResourceInterface(JDefinedClass resourceInterface, Resource resource) {

    }

    @Override
    public void onAddResourceMethod(JMethod method, Action action, MimeType bodyMimeType, Collection<MimeType> uniqueResponseMimeTypes) {
        for (JVar jv : method.params()) {
            jv.annotate(Valid.class);
        }
    }

    @Override
    public boolean AddParameterFilter(String name, AbstractParam parameter, Class<? extends Annotation> annotationClass, JMethod method) {
        return false;
    }

    @Override
    public void setRaml(Raml raml) {

    }
}
