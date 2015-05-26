package org.raml.jaxrs.codegen.core.ext;

import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;
import org.raml.model.Action;
import org.raml.model.MimeType;
import org.raml.model.Raml;
import org.raml.model.Resource;
import org.raml.model.parameter.AbstractParam;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Collection;

/**
 * Generator that annotates all body parameters @NotNull
 */
public class BodyParamNotNullAnnotationGenerator implements GeneratorExtension {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreateResourceInterface(JDefinedClass resourceInterface, Resource resource) {

    }

    /**
     * {@inheritDoc}
     * <p>
     * Annotates all method parameters with javax @NotNull.
     */
    @Override
    public void onAddResourceMethod(JMethod method, Action action, MimeType bodyMimeType, Collection<MimeType> uniqueResponseMimeTypes) {
        for (JVar jv : method.params()) {
            jv.annotate(NotNull.class);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean AddParameterFilter(String name, AbstractParam parameter, Class<? extends Annotation> annotationClass, JMethod method) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRaml(Raml raml) {

    }
}
