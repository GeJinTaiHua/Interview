## 🆚C#

### [🔓签名方法](https://github.com/GeJinTaiHua/RSA_SHA_MD5)：RSA、SHA1、MD5 ... 

### IOC框架
+ [🅰️Autofac](https://github.com/GeJinTaiHua/NetCore.Autofac)
+ Unity
+ MEF
+ Spring.NET
+ PostSharp
+ ... ...

### 传输实例
+ [♻️调用外部接口翻译](https://github.com/GeJinTaiHua/ConvertCNtoHK)
+ [✉️发邮件](https://github.com/GeJinTaiHua/SendEmail)
+ [☁️OAuth2.0](https://github.com/GeJinTaiHua/OAuth2.0)

### this 关键字解析
+ this 代表当前类的实例对象
```
namespace Demo
{
    public class Test
    {
        private string scope = "全局变量";
        public string getResult()
        {
            string scope = "局部变量";
　　　　　　　// this代表Test的实例对象
　　　　　　　// 所以this.scope对应的是全局变量
　　　　　　  // scope对应的是getResult方法内的局部变量
            return this.scope + "-" + scope;
        }
    }
}
```
+ 用 this 串联构造函数
```
namespace Demo
{
    public class Test
    {
        public Test()
        {
            Console.WriteLine("无参构造函数");
        }
        // this()对应无参构造方法Test()
　　　　 // 先执行Test()，后执行Test(string text)
        public Test(string text) : this()
        {
            Console.WriteLine(text);
            Console.WriteLine("有参构造函数");
        }
    }
}
```
+ 为原始类型扩展方法：静态类、静态方法、第一个参数前加this。
```
namespace Demo
{
    public static class Extends
    {
　　　　 // string类型扩展ToJson方法
        public static object ToJson(this string Json)
        {
            return Json == null ? null : JsonConvert.DeserializeObject(Json);
        }
        // object类型扩展ToJson方法
        public static string ToJson(this object obj)
        {
            var timeConverter = new IsoDateTimeConverter { DateTimeFormat = "yyyy-MM-dd HH:mm:ss" };
            return JsonConvert.SerializeObject(obj, timeConverter);
        }
        public static string ToJson(this object obj, string datetimeformats)
        {
            var timeConverter = new IsoDateTimeConverter { DateTimeFormat = datetimeformats };
            return JsonConvert.SerializeObject(obj, timeConverter);
        }
        public static T ToObject<T>(this string Json)
        {
            return Json == null ? default(T) : JsonConvert.DeserializeObject<T>(Json);
        }
        public static List<T> ToList<T>(this string Json)
        {
            return Json == null ? null : JsonConvert.DeserializeObject<List<T>>(Json);
        }
        public static DataTable ToTable(this string Json)
        {
            return Json == null ? null : JsonConvert.DeserializeObject<DataTable>(Json);
        }
        public static JObject ToJObject(this string Json)
        {
            return Json == null ? JObject.Parse("{}") : JObject.Parse(Json.Replace("&nbsp;", ""));
        }
    }
}
```
+ [索引器](http://www.cnblogs.com/jh007/p/6603318.html)

### 网址的拆分获取
http://www.bilo.com/aaa/bbb.aspx?id=1&name=bili   
"http://" 是协议名   
"www.bilo.com" 是域名  
"aaa"是站点名  
"bbb.aspx"是页面名（文件名）  
"id=1&name=bili"是参数   
+ 获取完整 url（协议名+域名+站点名+文件名+参数）  
```
// http://www.bilo.net/aaa/bbb.aspx?id=1&name=bili  
string url=Request.Url.ToString(); 
```
+ 获取域名
```
// www.bilo.com
string url=HttpContext.Current.Request.Url.Host; 
```
+ 获取参数
```
// ?id=1&name=bili  
string param= HttpContext.Current.Request.Url.Query; 
```
+ 获取 站点名+页面名 
```
// aaa/bbb.aspx
string url=HttpContext.Current.Request.Url.AbsolutePath;  (或 string url= HttpContext.Current.Request.Path;) 
```
+ 获取 站点名+页面名+参数
```
// /aaa/bbb.aspx?id=1&name=bili  
string url=Request.RawUrl;  (或 string url= Request.Url.PathAndQuery;) 
```

### 接口、类、抽象方法、虚方法
+ 接口和类
  + 区别：
    + 接口不能直接实例化，类可以
    + 接口不包含方法的实现，类包含
    + 接口可以多继承，类只能单继承
    + 类定义可在不同的源文件之间进行拆分
  + 相同：
    + 接口、类和结构都可以从多个接口继承
    + 接口类似于抽象基类：继承接口的任何非抽象类型都必须实现接口的所有成员
    + 接口和类都可以包含事件、索引器、方法和属性
+ 抽象方法、虚方法
  + 区别：
    + 抽象方法没有方法体，虚方法有方法体
    + 抽象方法只能在抽象类中声明，虚方法不是
    + 非抽象派生类必须重写抽象类中的抽象方法，虚方法不必
    
 ### const、readonly、static 
 + const：静态常量，也称编译时常量(compile-time constants)，属于类型级，**通过类名直接访问**，被所有对象共享。
   + 叫编译时常量的原因是它***编译时***会将其替换为所对应的值；
   + 静态常量在***速度***上会稍稍快一些，但是灵活性却比动态常量差一些；
   + 静态常量，隐式是静态的，即被static隐式修饰过，不能再用static重复修饰；
   + 在声明时初始化；
   + 静态常量只能被声明为简单的数据类型(内建的int和浮点型)、枚举或字符串；
   + 应用场合例如:Math.PI的定义（要声明一些从不改变且处处唯一的常量，就应该使用静态常量）。
 + readonly：动态常量，也称运行时常量(runtime constants)，属于对象级，**通过对象访问**。
   + 而动态常量的值是在***运行时***获得的；
   + 动态常量在性能上稍差一点，但是***灵活性***好比前者好；
   + readonly可以被static修饰，这时的static readonly和const非常相似；
   + 在声明是初始化，在构造函数里初始化（static readonly常量，如果在构造函数内指定初始值，则必须是静态无参构造函数）；
   + 动态常量可以是任意的数据类型；
   + 应用场合例如：SqlHelper类的连接字符串定义。
 + static：static是指所修饰的成员与类型有关，而与对象无关。意义与const和readonly迥然不同
 
 
