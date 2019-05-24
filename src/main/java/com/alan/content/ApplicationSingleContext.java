package com.alan.content;

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

    private static String filePath = "src/main/resources/application.xml";

    private static Document config;
    /**
     * key beanName
     * value classPath
     */
    private static Map<String, String> beanMap = new HashMap<String, String>();

    static {

        SAXReader reader = new SAXReader();
        try {
            config = reader.read(filePath);
        } catch (Exception e) {

            e.getStackTrace();
        }

    }

    /**
     * 获取bean 这边先模拟单利的所以先get(0)
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
            list = config.selectNodes(xpath);

            Element beanElement = list.get(0);

            String classPath = beanElement.attributeValue(XmlConstants.clazzDefine);

            bean = Class.forName(classPath).newInstance();

            init(bean, beanElement);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;

    }

    /**
     * 初始化对象
     */
    public void init(Object bean, Element beanElement) {
        //获取
        List<Element> propertyList = beanElement.elements(XmlConstants.property);

        if (propertyList == null || propertyList.size() == 0) {

            return;
        }

        Class<?> beanClass = bean.getClass();

        //进行赋值 注意数据类型
        for (Element property : propertyList) {
            String propertyName = property.attributeValue(XmlConstants.propertyName);
            String propertyValue = property.attributeValue(XmlConstants.propertyValue);

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
        if (XmlConstants.stringTypeName.equals(typeName)) {
            field.set(bean, value);
        } else if (XmlConstants.intTypeName.equals(typeName)) {
            field.set(bean, Integer.valueOf(value));
        }
    }


    public static void main(String[] args) {
        ApplicationSingleContext applicationSingleContext = new ApplicationSingleContext();
        Object person = applicationSingleContext.getBean("person");
        System.out.println(person);

    }


}
