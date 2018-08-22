## 💏OO（面向对象）


  * [四大基本特性](#%E5%9B%9B%E5%A4%A7%E5%9F%BA%E6%9C%AC%E7%89%B9%E6%80%A7)
  * [七大设计原则](#%E4%B8%83%E5%A4%A7%E8%AE%BE%E8%AE%A1%E5%8E%9F%E5%88%99)
  * [24种设计模式](#24%E7%A7%8D%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F)


### 四大基本特性
+ 抽象
  - 数据抽象 
  - 过程抽象 
+ 封装
+ 继承
+ 多态
  - 动态链接 

### 七大设计原则
+ 单一职责原则（SRP）
  + 单一功能
  + 解耦和增强内聚性（高内聚，低耦合）
+ 开闭原则（OCP）
  + 对扩展开放，对修改关闭
+ 里氏替换原则（LSP）
  + 在任何父类出现的地方都可以用他的子类来替代。
  + 子类可以有自己的个性。
  + 覆盖或实现父类的方法时输入参数可以被放大，输出结果可以被缩小。
+ 接口隔离原则（ISP）
  + 一个接口不需要提供太多的行为，一个接口应该只提供一种对外的功能，不应该把所有的操作都封装到一个接口当中。
+ 依赖倒置原则（DIP）
  + 高层模块不应该依赖低层模块，两者都应该依赖其抽象（抽象类或接口）。
  + 抽象不应该依赖细节（具体实现）。
  + 细节（具体实现）应该依赖抽象。
+ 合成复用原则（CRP）
  + 尽量使用对象组合，而不是继承来达到复用的目的。
+ 迪米特法则（最少知识原则）（LOD）
  + 一个对象应当对其他对象有尽可能少的了解。
  + 类间解耦，低耦合

### 24种设计模式
1) 创建型模式
  + [单例模式](/Interview-.NET/Subject/设计模式/Singleton.cs)：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
    1) [double check](/Interview-Java/src/test/java/Pattern/Singleton/SingletonDC.java)
    2) [饿汉模式](/Interview-Java/src/test/java/Pattern/Singleton/SingletonHungry.java)
    3) [静态内部类](/Interview-Java/src/test/java/Pattern/Singleton/SingletonIODH.java)
    4) [枚举单例](/Interview-Java/src/test/java/Pattern/Singleton/SingletonEnum.java)
    + [容器管理单例](/Interview-Java/src/test/java/Pattern/Singleton/SingletonManager.java)
    + [破坏单例的2种方法](/Interview-Java/src/test/java/Pattern/DestroySingle.java#L19)
  + 工厂模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类。   
  ![简单工厂模式](http://www.runoob.com/wp-content/uploads/2018/07/1530601914-2143-DP-SimpleFactory.png)   
  ![工厂模式](http://www.runoob.com/wp-content/uploads/2018/07/1530601917-1999-DP-Factory.png)
  + 抽象工厂模式：围绕一个超级工厂创建其他工厂。   
  ![抽象工厂模式](http://www.runoob.com/wp-content/uploads/2018/07/1530601916-7298-DP-AbstractFactory.png)
  + 建造者模式：使用多个简单的对象一步一步构建成一个复杂的对象。
  + 原型模式：用于创建重复的对象，同时又能保证性能。    
  ![原型模式](http://www.runoob.com/wp-content/uploads/2014/08/prototype_pattern_uml_diagram.jpg) 
2) 结构型模式
  + 适配器模式：作为两个不兼容的接口之间的桥梁。       
  ![适配器模式](https://raw.githubusercontent.com/aalansehaiyang/technology-talk/master/basic-knowledge/img/5.png)
  + 装饰器模式：允许向一个现有的对象添加新的功能，同时又不改变其结构。    
  ![装饰器模式](http://www.runoob.com/wp-content/uploads/2014/08/decorator_pattern_uml_diagram.jpg)
  + 代理模式
  + 外观模式
  + 桥接模式
  + 组合模式（整体模式）：把一组相似的对象当作一个单一的对象。
    + 创建了一个包含自己对象组的类。
    + 据树形结构来组合对象，用来表示部分以及整体层次。    
  ![组合模式](http://www.runoob.com/wp-content/uploads/2014/08/composite_pattern_uml_diagram.jpg)
  + 享元模式
3) 行为型模式 
  + 策略模式
  + 模板方法模式
  + 观察者模式（发布—订阅模式）（事件监听模式）
    + 对象间存在一对多关系
    + 当一个对象被修改时，则会自动通知它的依赖对象。    
  ![观察者模式](http://www.runoob.com/wp-content/uploads/2014/08/observer_pattern_uml_diagram.jpg)
  + 迭代子模式
  + 责任链模式：通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。    
  ![责任链模式](http://www.runoob.com/wp-content/uploads/2014/08/chain_pattern_uml_diagram.jpg)
  + 命令模式
  + 备忘录模式
  + 状态模式：类的行为是基于它的状态改变的     
  ![状态模式](http://www.runoob.com/wp-content/uploads/2014/08/state_pattern_uml_diagram_1.png)
  + 访问者模式
  + 中介者模式
  + 解释器模式

### Overload、Override
+ Overload（重载）：一个类中多态性的表现；
![重载](http://www.runoob.com/wp-content/uploads/2013/12/overloading-vs-overriding.png)
+ Override（重写）：父类和子类多态性的表现；
![重写](http://www.runoob.com/wp-content/uploads/2013/12/overloading-vs-overriding.png)
