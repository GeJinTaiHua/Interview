## 🔧工具

  * [XML](#XML)
    * [约束模式](#约束模式)
  * [Maven](#Maven)
    * [依赖范围、依赖传递、排除依赖](#%E4%BE%9D%E8%B5%96%E8%8C%83%E5%9B%B4%E4%BE%9D%E8%B5%96%E4%BC%A0%E9%80%92%E6%8E%92%E9%99%A4%E4%BE%9D%E8%B5%96)
  * [命令](#命令)
    * [Linux命令](#Linux命令)
    * [Shell命令](#shell%E5%91%BD%E4%BB%A4)
    * [Docker命令](#docker%E5%91%BD%E4%BB%A4)
    * [Crontab表达式](#Crontab表达式)

### 约束模式 
+ DTD
+ Schema（推荐）
    
### Maven
#### 依赖范围、依赖传递、排除依赖
+ 依赖范围
  + compile：默认的范围，编译测试运行都有效；
  + provided：编译和测试时有效，最后是在运行的时候不会被加入；（官方举了一个例子。比如在JavaEE web项目中我们需要使用servlet的API，但是呢Tomcat中已经提供这个jar，我们在编译和测试的时候需要使用这个api，但是部署到tomcat的时候，如果还加入servlet构建就会产生冲突，这个时候就可以使用provided。）
  + runtime：在测试和运行时有效；
  + test：在测试时有效；
  + system：与本机系统相关联，可移植性差。编译和测试时有效；
  + import：导入的范围，它只在使用dependencyManagement中，表示从其他pom中导入dependecy的配置。
+ 依赖传递：在正常开发中，我们也会封装maven构建供小伙伴们使用，在我们使用自定义的构建中，那么我们自定义的构建中依赖的构建，也会依赖传递过来。
  + 在工程的依赖树上，深度越浅，越被优先选择；
  + 若两个依赖包处于依赖树上的同一层，则谁在前，选择谁；
  + 避免传递依赖引起版本问题：如果工程直接依赖到某一框架的多个模块，最好全部声明这些依赖。
+ 排除依赖（exclusions） 

### 命令
#### Linux命令
+ less：使用 less 可以随意浏览文件，而 more 仅能向前移动，却不能向后移动，而且 less 在查看之前不会加载整个文件。
  + Shift+G：跳转到文件尾部
  + Shift+g：跳转到文件头部
```
less [参数] 文件 
```

+ sed：利用脚本来处理文本文件
```
sed [-hnV][-e<script>][-f<script文件>][文本文件]
```

+ grep：查找文件里符合条件的字符串
```
grep [-abcEFGhHilLnqrsvVwxy][-A<显示列数>][-B<显示列数>][-C<显示列数>][-d<进行动作>][-e<范本样式>][-f<范本文件>][--help][范本样式][文件或目录...]
```

+ awk：处理文本文件
```
awk [选项参数] 'script' var=value file(s)
```
```
awk [选项参数] -f scriptfile var=value file(s)
```

+ 进程
```
ps aux|grep java 查看java进程
ps aux 查看所有进程
ps –ef|grep tomcat 查看所有有关tomcat的进程
ps -ef|grep --color java 高亮要查询的关键字
kill -9 19979 终止线程号位19979的进程
```
 
#### Shell命令
+ 环境变量  
![变量](/Pic/param.png)
  + 输出所有的变量，包括全局变量和局部变量：set
  + 只显示全局变量：env(printenv)
  + 输出所有的变量，函数，整数，和已经导出的变量：declare
  + 自定义环境变量
  ```
  export 变量名 = value
  变量名 = value ; export 变量名
  declare - x 变量名 = value
  ```
  + 取消变量或取消变量赋值
  ```
  unset <Name_of_Variable>
  ```

+ 测试文件
![测试文件](/Pic/test.png)

+ 使脚本可执行
```
chmod a+x myscript.sh
```

+ 得到来自终端的输入
```
read name 
```

+ 获取当前的目录
```
$(cd `dirname $0`; pwd)

其中：
dirname $0，取得当前执行的脚本文件的父目录
cd `dirname $0`，进入这个目录(切换当前工作目录)
pwd，显示当前工作目录(cd执行后的)

```

#### Docker命令 
+ 镜像
  + 查看镜像  
  ```
  docker images
  ```
  + 发布镜像 
  ```
  docker push
  ```
  + 拉取镜像  
  ```
  docker pull
  ```
  + 删除镜像  
  ```
  docker rmi
  ```
  + 构建镜像
  ```
  docker build --no-cache=true -t "docker.xxx.com:5000/$project:v1" .
  ```
  + 删除带none的镜像
  ```
  docker rmi $(docker images | grep "none" | awk '{print $3}')
  ```
  ```
  $ docker stop $(docker ps -a | grep "Exited" | awk '{print $1 }') 
  $ docker rm $(docker ps -a | grep "Exited" | awk '{print $1 }') 
  $ docker rmi $(docker images | grep "none" | awk '{print $3}')
  ```

+ 容器
  + 查看使用的容器  
  ```
  docker ps
  ```
  + 查看所有容器  
  ```
  docker ps -a
  ```
  + 停止容器  
  ```
  docker stop
  ```
  + 删除容器  
  ```
  docker rm
  ```
  + 创建容器
  ```
   docker run -it -d \
                --name $project  \
                -p 8085:8084  \
   "docker.xxx.com:5000/$project:v1"
  ```
  + 进入容器内
  ```
  docker exec -it eassasb /bin/bash
  ```
  
#### Crontab表达式
字段|允许值（整数）|允许的特殊字符| 
---|---|---|
秒（Seconds）|0~59|, - * /    四个字符|
分（Minutes）|0~59|, - * /    四个字符|
小时（Hours）|0~23|, - * /    四个字符|
日期（DayofMonth）|1~31|,- * ? / L W C     八个字符|
月份（Month）|1~12 或 <br>JAN, FEB, MAR, APR, MAY, JUN, <br>JUL, AUG, SEP, OCT, NOV, DEC|, - * /    四个字符|
星期（DayofWeek）|1~7 （1=SUN=星期日）或 <br>SUN, MON, TUE, WED, THU, FRI, SAT|, - * ? / L C #     八个字符|
年(可选，留空)（Year）|1970~2099|, - * /    四个字符|

```
每秒：* * * * * ? *
每分：0 * * * * ? *
每时：0 0 * * * ? *
每日：0 0 0 * * ? *
```


