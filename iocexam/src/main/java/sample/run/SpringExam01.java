package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        System.out.println("ApplicationContext 생성전");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        System.out.println("ApplicationContext 생성후");

        //DL
        MyBean bean =(MyBean) context.getBean("bean");

        bean.setName("knag");

        System.out.println(bean.getName());

        MyBean bean2 = context.getBean("bean",MyBean.class);
        bean2.setName("kim");

        System.out.println(bean2.getName());

        MyBean bean3 = context.getBean("bean",MyBean.class);

        System.out.println(bean3.getName());
        System.out.println(bean.getName());

        if(bean == bean2){
            System.out.println("bean == bean2");
        }
    }
}
