package spi.impl;

import org.springframework.beans.factory.BeanNameAware;
import spi.SpiInterface;

public class DoSpi implements  BeanNameAware, SpiInterface {

  @Override
  public void spi() {
    System.out.println("自定义的spi接口工作内容");
  }


  @Override
  public void setBeanName(String name) {
    System.out.println("beanAware 接口 DoSpi beanName:"+name+"这个名字来源于@Bean的方法名");
  }
}
