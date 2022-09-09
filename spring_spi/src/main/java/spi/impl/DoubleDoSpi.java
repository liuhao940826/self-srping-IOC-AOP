package spi.impl;

import spi.SpiInterface;

public class DoubleDoSpi implements SpiInterface {


  @Override
  public void spi() {
    System.out.println("自定义的spi接口工作内容2222222");
  }
}
