package com.alan.context;

import com.alan.constant.XmlConstants;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 10:17 AM 2019/5/24
 */
public class ApplicationSingleContext {

    private static String filePath = "/Users/liuhao/IdeaProjects/self-srping-IOC-AOP/self-ioc/src/main/resources/application.xml";

    private static Document config;

    /**
     * 容器map
     */
    private static Map<String,Object> containerMap =new HashMap<String, Object>();


    /**
     * 其实用局部的安全 多线程的情况下 这个会改变
     */
    private static Class<?> classFile;

    static {

        SAXReader reader = new SAXReader();
        try {

            config = reader.read(filePath);
            //加载单例的bean
            loadingBean();
        } catch (Exception e) {

            e.getStackTrace();
        }

    }

    /**
     * 单例实在spring 容器创建的时候加载
     * 根据scope 获取对应的标签 获取标签中class 的类路径,根据classFile去创建实例
     */
    public static void loadingBean( ){
        //真实情况是加载scope等于single 或者为空默认的
        String xpath = "//bean[@scope='" + XmlConstants.SINGLE_SCOPE + "']";

        List<Element> list = null;

        Object singleBean=null;
        
        try {
            list = config.selectNodes(xpath);

            for (Element singleBeanElement : list) {
                //获取类路径
                String classPath = singleBeanElement.attributeValue(XmlConstants.CLAZZ_DEFINE);

                classFile = Class.forName(classPath);
                if(classFile!=null){

                    singleBean = classFile.newInstance();
                    System.out.println("class loading:"+classPath);
                    //容器加载bean 类路径重复的会背替换 可以增加逻辑在选择怎么替换
                    containerMap.put(classPath,singleBean);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取bean 的时候判断容器里面是否已经拥有 在spring加载的时候创建
     * 如果没有每次去创建新的实例
     *
     * @return
     */
    public Object getBean(String beanId) {
        //从任意位置的节点上选择名称为 item 的节点。要重点突出这个任意位置，它不受当前节点的影响，也就是说假如当前节点是在第 100 层（有点夸张），也可以选择第一层的名称为 item 的节点。
        //在 SelectNodes("//bean") 的基础上，增加了一个限制，就是要求拥有 id 属性。
        String xpath = "//bean[@id='" + beanId + "']";

        Object bean = null;

        List<Element> list = null;

        try {
            //document 去查找对应满足条件的bean标签的element元素 拿到元素去根据classs属性创建实例
            list = config.selectNodes(xpath);
            //加载不到对应bean的元素时候返还空
            if(list==null|| list.size()==0){
                return null;
            }
            //由于根据beanId 去获取只获取其中一个
            Element beanElement = list.get(0);

            //获取类路径
            String classPath = beanElement.attributeValue(XmlConstants.CLAZZ_DEFINE);

            if(containerMap.get(classPath)!=null){
                return containerMap.get(classPath);
            }

            classFile = Class.forName(classPath);

            if(classFile!=null){
                System.out.println("be used newInstance.....");
                bean = classFile.newInstance();
                //初始化对象
                init(bean, beanElement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;

    }

    /**
     * 初始化对象
     * 获取具体bean对象的 property
     */
    public void init(Object bean, Element beanElement) {
        //获取
        List<Element> propertyList = beanElement.elements(XmlConstants.PROPERTY);

        if (propertyList == null || propertyList.size() == 0) {

            return;
        }

        Class<?> beanClass = bean.getClass();

        //进行赋值 注意数据类型
        for (Element property : propertyList) {
            String propertyName = property.attributeValue(XmlConstants.PROPERTY_NAME);
            String propertyValue = property.attributeValue(XmlConstants.PROPERTY_VALUE);

            try {
                //根据配置文件中的属性名字获取对应类中的属性名字
                Field declaredField = beanClass.getDeclaredField(propertyName);

                if (declaredField != null) {
                    //获取对象属性的类型
                    String filedTypeName = declaredField.getType().getName();
                    setValue(bean, declaredField, filedTypeName, propertyValue);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 赋值
     *
     * @param bean
     * @param field
     * @param typeName
     * @param value
     */
    public void setValue(Object bean, Field field, String typeName, String value) throws Exception {
        field.setAccessible(true);//暴力访问,能访问
        if (XmlConstants.STRING_TYPE_NAME.equals(typeName)) {
            field.set(bean, value);
        } else if (XmlConstants.INT_TYPE_NAME.equals(typeName)) {
            field.set(bean, Integer.valueOf(value));
        }
    }


    public static void main(String[] args) {
        ApplicationSingleContext applicationSingleContext = new ApplicationSingleContext();
        Object person = applicationSingleContext.getBean("person");
        Object person2 = applicationSingleContext.getBean("person");
        System.out.println(person);
        System.out.println(person2);


        //多例的
        Object brid = applicationSingleContext.getBean("brid");
        Object brid2 = applicationSingleContext.getBean("brid");
        System.out.println(brid);
        System.out.println(brid2);

    }


}
