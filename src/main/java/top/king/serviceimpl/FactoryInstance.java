package top.king.serviceimpl;

import org.springframework.beans.factory.FactoryBean;

public class FactoryInstance implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return "null";
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    public static PostBean createInstance() {
        PostBean postBean = new PostBean();
        postBean.flag = 8;
        return postBean;
    }
}
