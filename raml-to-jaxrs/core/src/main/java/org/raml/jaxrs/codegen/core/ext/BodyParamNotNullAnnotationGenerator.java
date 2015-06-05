package org.raml.jaxrs.codegen.core.ext;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;
import org.raml.model.Action;
import org.raml.model.MimeType;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Generator that annotates all body parameters @NotNull
 */
public class BodyParamNotNullAnnotationGenerator extends AbstractGeneratorExtension {

    /** Name of the parameter that contains Json objects. */
    private static final String JSON_BODY_PARAM_NAME = "entity";

    /**
     * {@inheritDoc}
     * <p>
     * Annotates all method parameters with javax @NotNull.
     */
    @Override
    public void onAddResourceMethod(JMethod method, Action action, MimeType bodyMimeType, Collection<MimeType> uniqueResponseMimeTypes) {
        for (JVar param : method.params()) {
            if (param.name().equals(JSON_BODY_PARAM_NAME)) {
                param.annotate(NotNull.class);
            }
        }
    }
}
