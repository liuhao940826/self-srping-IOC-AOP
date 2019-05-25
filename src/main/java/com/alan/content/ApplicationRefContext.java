package com.alan.content;

import com.alan.constant.XmlConstants;
import com.alibaba.fastjson.JSON;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.XMLConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 10:17 AM 2019/5/24
 */
public class ApplicationRefContext {

    private static String filePath = "src/main/resources/applicationRef.xml";

    private static Document config;

    /**
     * 容器map
     */
    private static Map<String, Object> containerMap = new HashMap<String, Object>();

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
    public static void loadingBean() {
        //真实情况是加载scope等于single 或者为空默认的
        String xpath = "//bean[@scope='" + XmlConstants.SINGLE_SCOPE + "']";

        List<Element> list = null;

        Object singleBean = null;

        try {
            list = config.selectNodes(xpath);

            for (Element singleBeanElement : list) {
                System.out.println("名字:" + singleBeanElement.getName());
                //获取类路径
                String classPath = singleBeanElement.attributeValue(XmlConstants.CLAZZ_DEFINE);

                Class<?> classFile = Class.forName(classPath);
                if (classFile != null) {
                    //这个single bean可以ref 的也可能是单个bean
                    singleBean = classFile.newInstance();
                    System.out.println("class loading:" + classPath);
                    //初始化这个bean
                    init(singleBean, singleBeanElement);

                    containerMap.put(classPath, singleBean);
                    System.out.println("容器map:"+JSON.toJSONString(containerMap));
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
            if (list == null || list.size() == 0) {
                return null;
            }
            //由于根据beanId 去获取只获取其中一个
            Element beanElement = list.get(0);

            //获取类路径
            String classPath = beanElement.attributeValue(XmlConstants.CLAZZ_DEFINE);

            if (containerMap.get(classPath) != null) {
                return containerMap.get(classPath);
            }

            Class<?> classFile = Class.forName(classPath);

            if (classFile != null) {
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
     *
     * @param bean        初始化的bean 对象
     * @param beanElement 当前bean的Element
     */
    public static void init(Object bean, Element beanElement) {
        //获取property的子节点 没有就说明不需要初始化
        List<Element> propertyList = beanElement.elements(XmlConstants.PROPERTY);
        //如果这个bean没有对应的propery列表就返还
        if (propertyList == null || propertyList.size() == 0) {

            return;
        }
        //有property 列表 bean的类文件
        Class<?> beanClass = bean.getClass();

        //进行赋值 注意数据类型
        for (Element property : propertyList) {
            //TODO 这边不能写死根据dom遍历获取
            //获取name后面的值
            String propertyName = property.attributeValue(XmlConstants.PROPERTY_NAME);
            //获取value 后面的值
            String propertyValue = property.attributeValue(XmlConstants.PROPERTY_VALUE);
            //获取ref 后面的值
            String propertyRef = property.attributeValue(XmlConstants.REF);

            try {
                //根据配置文件中的属性名字获取对应类中的属性名字
                Field declaredField = beanClass.getDeclaredField(propertyName);

                if (declaredField != null) {
                    //获取对象属性的类型

                    if (propertyValue != null && !"".equals(propertyValue)) {
                        String filedTypeName = declaredField.getType().getName();
                        setValue(bean, declaredField, filedTypeName, propertyValue);
                    } else if (propertyRef != null && !"".equals(propertyRef)) {
                        setRef(bean, propertyRef, propertyList);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * dependcy injection
     *
     * @param bean 需要设置ref的bean对象
     * @param ref  bean的Id
     */
    public static void setRef(Object bean, String ref, List<Element> propertyList) {

        try {

            Class<?> beanClass = bean.getClass();

            if (beanClass == null) {
                System.out.println("beanClass is null");
                return;
            }
            //获取ref 类路径
            String refClassPath = getRefClassPath(ref);

            if (refClassPath == null || "".equals(refClassPath)) {
                System.out.println("refClassPath is null");
                return;
            }

            //TODO 这边不能写死根据dom遍历获取
//            Field bridField = beanClass.getDeclaredField("brid");
            //获取bean class的所以反射字段
            Field[] declaredFields = beanClass.getDeclaredFields();

            out:
            for (Field declaredField : declaredFields) {
                //获取属性名
                String name = declaredField.getName();
                // 将属性的首字母大写
                String upperName = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());

                // 如果type是类类型，则前面包含"class "，后面跟类名
                Method getMethod = bean.getClass().getMethod("get" + upperName);

                Object value = getMethod.invoke(bean);

                if(value!=null){
                    continue ;
                }

                for (Element element : propertyList) {

                    System.out.println("declaredFieldName:"+declaredField.getName());

                    String propertyNaem = element.attributeValue(XmlConstants.PROPERTY_NAME);
                    System.out.println("propertyName"+propertyNaem);

                    if (name.equals(propertyNaem)) {
                        //暴力访问
                        declaredField.setAccessible(true);

                        //如果已经加载的就从加载的里面去获取 没有就创建
                        if (containerMap.get(refClassPath) != null) {
                            declaredField.set(bean, containerMap.get(refClassPath));
                        } else {
                            //获取ref的类文件
                            Class<?> refClass = Class.forName(refClassPath);

                            if (refClass == null) {
                                System.out.println("refClass is null not assignment");
                                continue out;
                            }

                            Object nextBean = refClass.newInstance();
                            Element nextBeanElement = getElementByBeanId(ref);

                            //递归去调用判断是否有依赖的ref 需要注入
                            init(nextBean, nextBeanElement);
                            //里面会递归调用
                            declaredField.set(bean, nextBean);
                        }
                    }else {
                        continue ;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
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
    public static void setValue(Object bean, Field field, String typeName, String value) throws Exception {
        field.setAccessible(true);//暴力访问,能访问
        if (XmlConstants.STRING_TYPE_NAME.equals(typeName)) {
            field.set(bean, value);
        } else if (XmlConstants.INT_TYPE_NAME.equals(typeName)) {
            field.set(bean, Integer.valueOf(value));
        }
    }


    /**
     * 获取id是ref 值的 那个bean 标签的classPath
     *
     * @param ref
     * @return
     */
    public static String getRefClassPath(String ref) {
        Element element = getElementByBeanId(ref);
        //获取ref的类路径
        String classPath = element.attributeValue(XmlConstants.CLAZZ_DEFINE);

        return classPath;
    }

    /**
     * 获取对应id的Element对象
     *
     * @param ref
     * @return
     */
    public static Element getElementByBeanId(String ref) {

        //获取ref 对应的class
        String xpath = "//bean[@id='" + ref + "']";

        List nodes = config.selectNodes(xpath);

        if (nodes == null || nodes.size() == 0) {
            System.out.println("ref nodes is empty");
            return null;
        }

        Element element = (Element) nodes.get(0);
        return element;

    }


    public static void main(String[] args) {
        ApplicationRefContext applicationSingleContext = new ApplicationRefContext();
        Object animal = applicationSingleContext.getBean("animal");
        System.out.println("动物" + animal);

    }


}
