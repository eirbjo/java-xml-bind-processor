package com.example.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.xml.bind.JAXBContext;
import java.lang.reflect.Layer;
import java.util.Set;


@SupportedAnnotationTypes("com.example.module.SomeAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_9)
public class ProcessorUsingJavaXmlBind extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        System.out.println("Running " + getClass().getSimpleName() +".process");
        System.out.println(" java.xml? " +Layer.boot().findModule("java.xml").isPresent());
        System.out.println(" java.xml.bind? " +Layer.boot().findModule("java.xml.bind").isPresent());

        for (Element element : roundEnvironment.getRootElements()) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, JAXBContext.class.toString(), element);
        }

        return false;
    }
}
