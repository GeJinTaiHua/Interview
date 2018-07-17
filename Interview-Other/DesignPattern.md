## ✒️设计模式

### 常用设计模式
+ [单例模式](/Interview-.NET/Subject/设计模式/Singleton.cs)：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
```
public class SingletonClass{
    private static SingletonClass instance=null;
    public static SingletonClass getInstance(){
        if(instance==null){
            synchronized(SingletonClass.class){
                if(instance==null){
                    instance=new SingletonClass();
                }
            }
        }
        return instance;
    }
}
```
+ 工厂模式  
![工厂模式](https://raw.githubusercontent.com/aalansehaiyang/technology-talk/master/basic-knowledge/img/10.jpg)
+ 装饰模式：
在保持原有功能不变的情况下将一个类重新装饰，使其具有更强大的功能。
+ 适配器模式：
一个类的接口不能被客户端接受，需要转换为另一种接口，从而使两个不匹配的接口能在一起工作。  
![适配器模式](https://raw.githubusercontent.com/aalansehaiyang/technology-talk/master/basic-knowledge/img/5.png)
+ 观察者模式：
也叫发布—订阅模式，或者事件监听模式。
+ 责任链模式：
很多对象由每个对象对其下家的引用串连起来形成一条链，请求在这条链上传递，直到最终处理完。
+ 策略模式：
完成某个操作可能会有多种方法，适用于多种场合。我们需要把每个操作方法当做一个实现策略，调用者可根据需要（特定的规则）选择合适的策略。
+ 模板模式：
在框架设计中，提供了一个方便的开发程序的模板，你只要实现模板中的一些接口或方法就能完成一个复杂的任务。
+ 代理模式：
为其它对象提供一种代理以控制对这个对象的访问。
+ RBAC：
基于角色的权限访问控制。
