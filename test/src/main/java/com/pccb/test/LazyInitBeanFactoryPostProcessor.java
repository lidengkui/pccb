package com.pccb.test;

import com.pccb.common.com.pccb.common.boot.Apps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class LazyInitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Class<?>[] exclusionList;

    public LazyInitBeanFactoryPostProcessor() {
    }

    public LazyInitBeanFactoryPostProcessor(Class<?>[] exclusionList) {
        this.exclusionList = exclusionList;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            if (isLazy(beanName, beanFactory)) {
                BeanDefinition definition = beanFactory.getBeanDefinition(beanName);
                String beanClassName = definition.getBeanClassName();
                if (beanClassName != null && beanClassName.contains("com.pccb.module.mybatis")) {
                    continue;
                }
                definition.setLazyInit(true);
            }
        }
    }

    private boolean isLazy(String beanName, ConfigurableListableBeanFactory beanFactory) {
        if (exclusionList == null || exclusionList.length == 0) {
            return true;
        }
        for (Class<?> clazz : exclusionList) {
            if (beanFactory.isTypeMatch(beanName, clazz)) {
                return false;
            }
        }
        return true;
    }

}
