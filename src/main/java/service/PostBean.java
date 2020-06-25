package service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;


public class PostBean implements BeanPostProcessor {
    @Nullable
    @Autowired(required = false)
    public int year;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("开始初始化bean！");
        return bean;
    }
    @Required
    public void setYear(int year){
        this.year=year;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化完成！");
        return bean;
    }
}
