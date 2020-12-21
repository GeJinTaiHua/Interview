## 🔧工具
  * [Nginx](#Nginx)
    * [安装](#安装)
  * [XML](#XML)
    * [约束模式](#约束模式)
  * [Maven](#Maven)
    * [依赖范围、依赖传递、排除依赖](#%E4%BE%9D%E8%B5%96%E8%8C%83%E5%9B%B4%E4%BE%9D%E8%B5%96%E4%BC%A0%E9%80%92%E6%8E%92%E9%99%A4%E4%BE%9D%E8%B5%96)
  * [命令](#命令)
    * [Linux命令](#Linux命令)
    * [Shell命令](#shell%E5%91%BD%E4%BB%A4)
    * [Docker命令](#docker%E5%91%BD%E4%BB%A4)
    * [Crontab表达式](#Crontab表达式)

### Nginx
#### 安装
+ 1、安装make
  + ftp://ftp.gnu.org/gnu/make/
  ```
  yum -y install make
  ```

+ 2、安装gcc
  + http://ftp.gnu.org/gnu/gcc/
  ```
  yum install gcc-c++
  ```

+ 3、安装pcre库
  + https://sourceforge.net/projects/pcre/files/latest/download
  ```
  yum install -y pcre  pcre-devel

  rpm -qa pcre
  ```

+ 4、安装zlib库
  + http://rpmfind.net/linux/rpm2html/search.php?query=zlib
  ```
  yum install zlib zlib-d
  ```

+ 5、安装openssl
  + https://www.openssl.org/source/
  ```
  yum install openssl openssl-devel

  openssl version
  ```

+ 6、安装nginx
  + http://nginx.org/download/
  ```
  wget http://nginx.org/download/nginx-1.16.2.tar.gz
  tar -xvf nginx-1.16.2.tar.gz  ##解压
  cd nginx-1.16.2 ##进入目录
  ./configure  --prefix=/usr/local/ngnix --with-http_ssl_module  ##执行命令
  make && make install ##编译安装(默认安装在/usr/local/nginx)

  /usr/local/nginx/sbin ##先进入到nginx的安装位置的sbin目录下
  ./nginx ##启动

  ./nginx -s reload ##重启

  ./nginx -s stop ##停止

  ps -ef | grep nginx ##查看进程命令
  ```

### XML
#### 约束模式 
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
+ 清理屏幕
  + clear
  + reset：完全刷新终端屏幕，之前的终端输入操作信息将都会被清空。

+ 查看文件
  + tail：看后多少行日志；
  ```
  tail -100f   test.log   实时监控100行日志
  tail -n  10  test.log   查询日志尾部最后10行的日志;
  tail -n +10  test.log   查询10行之后的所有日志;
  ```
  + head：看前多少行日志；
  ```
  head -n  10  test.log   查询日志文件中的头10行日志;
  head -n -10  test.log   查询日志文件除了最后10行的其他所有日志;
  ```
  + cat：倒序查看；
  ```
  cat -n test.log |grep "debug"   查询关键字的日志
  ```

+ 进程
```
ps aux|grep java 查看java进程
ps aux 查看所有进程
ps –ef|grep tomcat 查看所有有关tomcat的进程
ps -ef|grep --color java 高亮要查询的关键字
kill -9 19979 终止线程号位19979的进程
```

+ vim
i：输入模式
:w（保存） :q（退出） :q!（不保存退出）

 
#### Shell命令
+ 启动jar包
```
#!/bin/bash
PID=`netstat -nlpt|grep -w "8084"|awk '{print $7}'|grep -oE "[0-9]+"`
if [ -z ${PID} ];then
    echo "PID:{PID} not exist, start Server.jar......" 
    nohup java -jar Server.jar >/dev/null 2>&1 & 
    echo "start end......" 
else
    echo "PID:{PID} exist, restart Server.jar......"
    kill -9 ${PID}
    nohup java -jar Server.jar >/dev/null 2>&1 & 
    echo "restart end......" 
fi
```

+ 环境变量  
![变量](/Interview-Other/Tool_Pic/param.png)
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
![测试文件](/Interview-Other/Tool_Pic/test.png)

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

