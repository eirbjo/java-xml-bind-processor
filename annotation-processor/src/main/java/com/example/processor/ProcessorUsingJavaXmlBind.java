package com.example.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Set;


@SupportedAnnotationTypes("com.example.module.SomeAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_9)
public class ProcessorUsingJavaXmlBind extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        try {
            System.out.println(JAXBContext.newInstance(getClass()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return false;
    }
}
