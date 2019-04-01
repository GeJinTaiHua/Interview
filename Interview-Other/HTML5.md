## 📄HTML5

  * [框架](#框架)
  * [关键字](#%E5%85%B3%E9%94%AE%E5%AD%97)
    * [AJAX](#ajax)
    * [html()、append()、prepend()、after()、before()](#htmlappendprependafterbefore)
    * [prop()、attr()](#propattr)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [CSS 优先级](#css-%E4%BC%98%E5%85%88%E7%BA%A7)
    * [jQuery的各种选择器](#jquery%E7%9A%84%E5%90%84%E7%A7%8D%E9%80%89%E6%8B%A9%E5%99%A8)
    * [选择器性能优化](#%E9%80%89%E6%8B%A9%E5%99%A8%E6%80%A7%E8%83%BD%E4%BC%98%E5%8C%96)
    
### 框架
1) [React](http://react-china.org/)
2) [jQuery](https://jquery.com/)
3) [Angular ](http://www.angularjs.net.cn/)
4) [Vue](https://cn.vuejs.org/)


### 关键字
#### AJAX 
+ url：要求为String类型的参数，（默认为当前页地址）发送请求的地址。
+ type：要求为String类型的参数，请求方式（post或get）默认为get。注意其他http请求方法，例如put和delete也可以使用，但仅部分浏览器支持。
+ cache：要求为Boolean类型的参数，默认为true（当dataType为script时，默认为false），设置为false将不会从浏览器缓存中加载请求信息。
+ data：要求为 Object或String类型的参数，发送到服务器的数据。
+ dataType：要求为String类型的参数，预期服务器返回的数据类型。
  + xml：返回XML文档，可用JQuery处理。
  + html：返回纯文本HTML信息；包含的script标签会在插入DOM时执行。
  + script：返回纯文本JavaScript代码。不会自动缓存结果。除非设置了cache参数。注意在远程请求时（不在同一个域下），所有post请求都将转为get请求。
  + json：返回JSON数据。
  + jsonp：JSONP格式。使用SONP形式调用函数时，例如myurl?callback=?，JQuery将自动替换后一个“?”为正确的函数名，以执行回调函数。
  + text：返回纯文本字符串。
+ beforeSend：发送请求前
+ complete：请求完成后
+ success：请求成功后
+ error：请求失败时
+ ... ...
```
    $.ajax({
        type: "POST",
        url: "https://www.json.cn/",
        data: { 
                date1: 2, 
                date2: "123"
              },
        dataType: "json",
        success: function (data) {
          
        }
    });
```

#### html()、append()、prepend()、after()、before()
+ html中()替换当前所有内容
+ append()在被选元素结尾插入内容
+ prepend()在被选元素开头插入内容
+ after()在被选元素之后插入内容
+ before()在被选元素之前插入内容

#### prop()、attr() 
+ 对于HTML元素本身就带有的固有属性，在处理时，使用prop方法。   $("#chk1").prop("checked") == false
+ 对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法。   $(".intxt1").attr("url");

### 基础知识
#### CSS 优先级
1. 在属性后面使用 !important 会覆盖页面内任何位置定义的元素样式
2. 作为 style 属性写在元素内的样式
3. id选择器
4. 类选择器
5. 标签选择器
6. 通配符选择器
7. 器自定义或继承

#### jQuery的各种选择器
+ #id：根据给定的ID匹配一个元素
+ element：根据给定的元素标签名匹配所有元素
+ .class：根据给定的css类名匹配元素
+ \*：匹配所有元素，多用于结合上下文来搜索
+ :first：获取第一个元素
+ :not(selector)：去除所有与给定选择器匹配的元素
+ :even：匹配所有索引值为偶数的元素，从 0 开始计数
+ :odd：匹配所有索引值为奇数的元素，从 0 开始计数
+ :eq(index)：匹配一个给定索引值的元素
+ :gt(index)：匹配所有大于给定索引值的元素
+ :lang(language)：选择指定语言的所有元素
+ :last()：获取最后个元素
+ :lt(index)：匹配所有小于给定索引值的元素
+ :header：匹配如 h1, h2, h3之类的标题元素
+ :animated：匹配所有正在执行动画效果的元素
+ :focus：匹配当前获取焦点的元素
+ :root：选择该文档的根元素，在HTML中，文档的根元素，和$(":root")选择的元素一样，永远是<html>元素
+ :target：选择由文档URI的格式化识别码表示的目标元素
+ :contains(text)：匹配包含给定文本的元素
+ :empty：匹配所有不包含子元素或者文本的空元素
+ :has(selector)：匹配含有选择器所匹配的元素的元素
+ :parent：匹配含有子元素或者文本的元素
+ :hidden：匹配所有不可见元素，或者type为hidden的元素
+ :visible：匹配所有的可见元素
+ [attribute]：匹配包含给定属性的元素
+ [attribute=value]：匹配给定的属性是某个特定值的元素
+ :text : 匹配所有的单行文本框
+ :input : 匹配所有 input, textarea, select 和 button 元素
+ ... ...

#### 选择器性能优化
+ 第一，多用ID选择器 , 总是从#id选择器来继承。（ID选择器是速度最快的，这主要是因为它使用JavaScript的内置函数getElementById()）
+ 第二，少直接使用Class选择器。（速度最慢的是Class选择器，其需要通过解析 HTML文档树）
+ 第三，多用父子关系，少用嵌套关系。
+ 第四，缓存jQuery对象。
+ 通过链式调用，采用find(),end(),children(),has,filter()等方法，来过滤结果集，减少$()查找方法调用，提升性能。



