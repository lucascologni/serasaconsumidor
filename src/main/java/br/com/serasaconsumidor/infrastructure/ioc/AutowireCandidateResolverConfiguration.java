package br.com.serasaconsumidor.infrastructure.ioc;

import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * Essa classe é responsável por estender a anotação "@Qualifier", para seja possível ler uma configuração
 * do arquivo "application.yaml".
 */
@Component
public class AutowireCandidateResolverConfiguration implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {

        DefaultListableBeanFactory bf = (DefaultListableBeanFactory) beanFactory;
        bf.setAutowireCandidateResolver(new EnvironmentAwareQualifierAnnotationAutowireCandidateResolver());
    }

    private static class EnvironmentAwareQualifierAnnotationAutowireCandidateResolver extends QualifierAnnotationAutowireCandidateResolver {

        @Override
        protected boolean checkQualifier(BeanDefinitionHolder bdHolder, Annotation annotation, TypeConverter typeConverter) {

            if (annotation instanceof Qualifier) {

                Qualifier qualifier = (Qualifier) annotation;

                if (qualifier.value().startsWith("${") && qualifier.value().endsWith("}")) {

                    DefaultListableBeanFactory bf = (DefaultListableBeanFactory) this.getBeanFactory();
                    ResolvedQualifier resolvedQualifier = new ResolvedQualifier(bf.resolveEmbeddedValue(qualifier.value()));

                    return super.checkQualifier(bdHolder, resolvedQualifier, typeConverter);
                }
            }

            return super.checkQualifier(bdHolder, annotation, typeConverter);
        }

        private static class ResolvedQualifier implements Qualifier {

            private final String value;

            ResolvedQualifier(String value) {
                this.value = value;
            }

            @Override
            public String value() {
                return this.value;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return Qualifier.class;
            }
        }
    }
}