package top.king.serviceimpl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class PostBean implements BeanPostProcessor {
    int flag = 0;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("开始初始化bean！");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化完成！");
        return bean;
    }

    public void destory() {
        System.out.println("销毁方法！");
    }

    public void test() {
        System.out.println("测试方法！");
    }

    public static PostBean createInstance() {
        PostBean postBean = new PostBean();
        postBean.flag = 5;
        return postBean;
    }
}
