package org.raml.jaxrs.codegen.core.ext;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;
import org.raml.model.Action;
import org.raml.model.MimeType;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Add bean validation to all body method parameters.
 */
public class BeanValidationGenerator  extends AbstractGeneratorExtension {

    @Override
    public void onAddResourceMethod(JMethod method, Action action, MimeType bodyMimeType, Collection<MimeType> uniqueResponseMimeTypes) {
        for (JVar jv : method.params()) {
            boolean hasNotNullAnnotation = false;

            for (JAnnotationUse ja : jv.annotations()) {
                if (ja.getAnnotationClass().name().equals("Valid")) {
                    hasNotNullAnnotation = true;
                }

            }
            if (!hasNotNullAnnotation) {
                jv.annotate(Valid.class);
            }
        }
    }
}
