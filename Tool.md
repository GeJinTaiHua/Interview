## 🔧工具

  * [XML](#XML)
    * [约束模式](#约束模式)
  * [Maven](#Maven)
    * [依赖范围、依赖传递、排除依赖](#%E4%BE%9D%E8%B5%96%E8%8C%83%E5%9B%B4%E4%BE%9D%E8%B5%96%E4%BC%A0%E9%80%92%E6%8E%92%E9%99%A4%E4%BE%9D%E8%B5%96)
  * [Docker](#Docker)
    * [Docker命令](#docker%E5%91%BD%E4%BB%A4)
  * [Shell](#Shell)
    * [Shell命令](#shell%E5%91%BD%E4%BB%A4)
 

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

### Docker
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
 
### Shell
#### Shell命令
+ 返回当前路径的"." 
$(cd `dirname $0`; pwd)

+ 变量
  + $0：当前脚本的文件名
  + $n：传递给脚本或函数的参数。n 是一个数字，表示第几个参数。例如，第一个参数是$1，第二个参数是$2。
  + $#：传递给脚本或函数的参数个数。
  + $\*：传递给脚本或函数的所有参数。
  + $@：传递给脚本或函数的所有参数。被双引号(" ")包含时，与 $* 稍有不同，下面将会讲到。
  + $?：上个命令的退出状态，或函数的返回值。
  + $$：当前Shell进程ID。对于 Shell 脚本，就是这些脚本所在的进程ID

