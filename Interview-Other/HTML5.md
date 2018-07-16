## 📄HTML5

### 源码
+ [超链接、转义字符](/Interview-.NET/NETSubject/Views/ViewValue/Index.cshtml)

### CSS 优先级
1. 在属性后面使用 !important 会覆盖页面内任何位置定义的元素样式
2. 作为 style 属性写在元素内的样式
3. id选择器
4. 类选择器
5. 标签选择器
6. 通配符选择器
7. 器自定义或继承

### html()、append()、prepend()、after()、before()
+ html中()替换当前所有内容
+ append()在被选元素结尾插入内容
+ prepend()在被选元素开头插入内容
+ after()在被选元素之后插入内容
+ before()在被选元素之前插入内容

### prop()、attr() 
+ 对于HTML元素本身就带有的固有属性，在处理时，使用prop方法。$("#chk1").prop("checked") == false
+ 对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法。  $(".intxt1").attr("url");

### jQuery的各种选择器
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
















