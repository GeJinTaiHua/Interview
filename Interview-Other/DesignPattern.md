## 💏OO（面向对象）


  * [四大基本特性](#%E5%9B%9B%E5%A4%A7%E5%9F%BA%E6%9C%AC%E7%89%B9%E6%80%A7)
  * [七大设计原则](#%E4%B8%83%E5%A4%A7%E8%AE%BE%E8%AE%A1%E5%8E%9F%E5%88%99)
  * [24种设计模式](#24%E7%A7%8D%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F)
    * [创建型模式](#%E5%88%9B%E5%BB%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F)
    * [结构型模式](#%E7%BB%93%E6%9E%84%E5%9E%8B%E6%A8%A1%E5%BC%8F)
    * [行为型模式](#%E8%A1%8C%E4%B8%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F)
  * [框架模式](#%E6%A1%86%E6%9E%B6%E6%A8%A1%E5%BC%8F)
    * [MVC](#mvc)
    * [ORM](#orm)
    * [RESTful架构风格](#restful%E6%9E%B6%E6%9E%84%E9%A3%8E%E6%A0%BC)
  * [基本知识](#%E5%9F%BA%E6%9C%AC%E7%9F%A5%E8%AF%86)
    * [类之间的关系：继承、依赖、关联、聚合、组合](#%E7%B1%BB%E4%B9%8B%E9%97%B4%E7%9A%84%E5%85%B3%E7%B3%BB%E7%BB%A7%E6%89%BF%E4%BE%9D%E8%B5%96%E5%85%B3%E8%81%94%E8%81%9A%E5%90%88%E7%BB%84%E5%90%88)


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
#### 创建型模式
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
  + JDK1.8 流的流水线理念
+ 原型模式：用于创建重复的对象，同时又能保证性能。    
![原型模式](http://www.runoob.com/wp-content/uploads/2014/08/prototype_pattern_uml_diagram.jpg) 
```
public abstract class Prototype {
    abstract Prototype myClone();
}
```
```
public class ConcretePrototype extends Prototype {

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
```

#### 结构型模式
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

#### 行为型模式 
+ 策略模式
  + java的 Comparator 和 Comparable
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
 
 ### 框架模式
 #### MVC
 + Model（模型）
 + View（视图）
 + Controller（控制器）
 
#### ORM
&emsp;&emsp;对象-关系映射；用来把对象模型表示的对象映射到基于S Q L 的关系模型数据库结构中去。

#### RESTful 架构风格
+ 资源：以json(或其他Representation)为载体的、面向用户的一组数据集。
+ URI：用一个URI（统一资源定位符）指向资源，即每个URI都对应一个特定的资源。
+ 统一接口：数据的元操作，分别对应于HTTP方法：
  + GET（SELECT）：从服务器取出资源（一项或多项）；
  + POST（CREATE）：在服务器新建一个资源；
  + PUT（UPDATE）：在服务器更新资源（客户端提供完整资源数据）；
  + PATCH（UPDATE）：在服务器更新资源（客户端提供需要修改的资源数据）；
  + DELETE（DELETE）：从服务器删除资源。
+ 无状态

### 基本知识
#### 类之间的关系：继承、依赖、关联、聚合、组合  
+ 继承（实现）：是一种【is-a】关系；
  + 优点：
    + 子类能自动继承父类的接口；
    + 创建子类的对象时，无须创建父类的对象。
  + 缺点：
    + 破坏封装，子类与父类之间紧密耦合，子类依赖于父类的实现，子类缺乏独立性；
    + 支持扩展，但是往往以增加系统结构的复杂度为代价；
    + 不支持动态继承。在运行时，子类无法选择不同的父类；
    + 子类不能改变父类的接口。
+ 依赖：一个类A中的方法使用到了另一个类B；
```
public class Pen {
    public void write(){
    }
}

public class Me {
    public void write(Pen pen){//pen作为Me类方法的参数
        pen.write();
    }
}
```
+ 关联：两个类、或者类与接口之间语义级别的一种强依赖关系；
  + 被关联类B以类属性的形式出现在关联类A中，或者关联类A引用了一个类型为被关联类B的全局变量的这种关系。
```
public class You {
    private Pen pen; // 让pen成为you的类属性 

    public You(Pen p){
        this.pen = p;
    }

    public void write(){
        pen.write();
    }
}
```
+ 聚合：关联关系的一种特例，他体现的是整体与部分、拥有的关系，即【has-a】的关系；
```
public class Family {
    private List<Child> children; //一个家庭里有许多孩子
}
```
+ 组合：一种【contains-a】的关系，这种关系比聚合更强，也称为强聚合。
  + 优点：
    + 不破坏封装，整体类与局部类之间松耦合，彼此相对独立；
    + 具有较好的可扩展性；
    + 支持动态组合。在运行时，整体对象可以选择不同类型的局部对象；
    + 整体类可以对局部类进行包装，封装局部类的接口，提供新的接口。
  + 缺点：
    + 整体类不能自动获得和局部类同样的接口；
    + 创建整体类的对象时，需要创建所有局部类的对象。
```
public class Nose {
    private Eye eye = new Eye();  //一个人有鼻子有眼睛
    private Nose nose = new Nose();
}
```



 
 
 
