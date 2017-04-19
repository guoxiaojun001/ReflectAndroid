# ReflectAndroid
1.获取类中私有属性

2.调用无参数的私有方法

3.调用带有参数的私有方法
PrivateUtil.invoke(new FanShePresenter(MainActivity.this),
         "withParam1", new Class[] { String.class },
         new Object[] { "我是参数" });

4.调用带有多个参数的私有方法
 //多个参数
 PrivateUtil.invoke(new FanShePresenter(MainActivity.this),
         "withParam2", new Class[] { String.class ,String.class},
          new Object[] { "我是参数","小马" });
