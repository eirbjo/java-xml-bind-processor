module com.example.annotation.processor {
        requires java.compiler;
        requires java.xml.bind;
        exports com.example.processor;
        provides javax.annotation.processing.Processor
        with com.example.processor.ProcessorUsingJavaXmlBind;
}