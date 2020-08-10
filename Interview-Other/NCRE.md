## 📃软考（软件设计师）

### 一、计算机系统知识

### 二、程序语言基础知识

### 三、操作系统知识
+ 重叠流水线时间计算：
  + 周期 = 最大单条指令执行时间
  + 公式1：(指令条数+2)*周期
  + 公式2：第一条指令顺序执行时间+(指令条数-1)*周期

### 四、系统开发和运行知识
#### CMM模型
<table>
  <tr>
    <td>初始级</td> 
    <td>无秩序、混乱；</td> 
  </tr>
  <tr>
    <td>可重复级</td> 
    <td>对成本、进度和功能特性进行跟踪；</td> 
  </tr>
  <tr>
    <td>定义级</td> 
    <td>文档化、标准化</td> 
  </tr>
  <tr>
    <td>管理级</td> 
    <td>质量标准</td> 
  </tr>
  <tr>
    <td>优化级</td> 
    <td></td> 
  </tr>
</table>

### 五、网络基础知识
+ 分配网络主机
  + 可分配网络数 = 2^网络号位数
  + 最大主机数 = 2^主机号位数-2
  <table>
    <tr>
      <td rowspan="2">ip地址</td> 
      <td>网络号（高位）</td> 
      <td></td> 
    </tr>
    <tr>
      <td>主机号（低位</td> 
      <td>网络地址：主机号部分全为0  
          <br>广播地址：主机号部分全为1</td>
    <tr>
  </table>

#### OSI七层
<table>
    <tr>
        <td >OSI 七层网络模型</td> 
        <td >TCP/IP 四层概念模型</td> 
        <td >对应网络协议</td> 
    </tr>
    <tr>
        <td >应用层（Application）</td>    
        <td rowspan="3">应用层</td>  
        <td >HTTP、TFTP, FTP, NFS, WAIS、SMTP</td>      
    </tr>
    <tr>
        <td >表示层（Presentation）</td>    
        <td >Telnet, Rlogin, SNMP, Gopher</td>      
    </tr>
    <tr>
        <td >会话层（Session）</td>    
        <td >SMTP, DNS</td>      
    </tr>
    <tr>
        <td >传输层（Transport）</td> 
        <td >传输层</td> 
        <td >TCP, UDP</td> 
    </tr>
    <tr>
        <td >网络层（Network）</td> 
        <td >网络层</td> 
        <td >IP, ICMP, ARP, RARP, AKP, UUCP</td> 
    </tr>
    <tr>
        <td >数据链路层（Data Link）</td> 
        <td rowspan="2">数据链路层</td> 
        <td >FDDI, Ethernet, Arpanet, PDN, SLIP, PPP</td> 
    </tr>
    <tr>
        <td >物理层（Physical）</td> 
        <td >IEEE 802.1A, IEEE 802.2到IEEE 802.11</td> 
    </tr>
</table>

### 六、多媒体基础知识
+ 数据传输率(b/s) = 采样频率(Hz) * 量化位数(b) * 声道数
+ 分辨率比较：
  + 图像分辨率 > 显示分辨率：显示部分图像
  + 图像分辨率 < 显示分辨率：图像只占屏幕一部分

### 七、数据库技术基础

### 八、数据结构
+ 完全无向图边的条数：N*(N-1)/2
  + N：顶点个数
+ 环路复杂性：V(G) = E-N+2	
  + E：边数	
  + N：节点图
+ 二叉树：N0 = N2 + 1，N = 2*N0 + N1 -1
  + N0：度0的节点总数  	
  + N1：度1的节点总数  	
  + N2：度2的节点总数 

### 九、算法设计与分析
+ 海明码：m+k+1<2^k
  + m位数据 
  + k位校验位

### 十、面向对象技术

### 十一、标准化和软件知识产权基础知识

### 十二、软件系统分析与设计
#### 内聚类型（从高到底）
<table>
  <tr>
    <td>内聚类型</td>
    <td>描述</td>
  </tr>
  <tr>
    <td>功能内聚</td>
    <td>完成一个单一功能，各个部分协同工作，缺一不可。</td>
  </tr>
  <tr>
    <td>顺序内聚</td>
    <td>处理元素相关，而且必须顺序执行。</td>
  </tr>
  <tr>
    <td>通信内聚</td>
    <td>所有处理元素集中在一个数据结构的区域上。</td>
  </tr>
  <tr>
    <td>过程内聚</td>
    <td>处理元素相关，而且必须按特定的次序执行。</td>
  </tr>
  <tr>
    <td>瞬时内聚</td>
    <td>所包含的任务必须在同一时间间隔内执行（如初始化模块）。</td>
  </tr>
  <tr>
    <td>逻辑内聚</td>
    <td>完成逻辑上相关的一组任务。</td>
  </tr>
  <tr>
    <td>偶然内聚</td>
    <td>完成一组没有关系或松散关系的任务。</td>
  </tr>
</table>

#### 耦合类型（从高到底）
<table>
  <tr>
    <td>耦合类型</td>
    <td>描述</td>
  </tr>
  <tr>
    <td>内容耦合</td>
    <td>一个模块访问另一个模块的内部数据；一个模块不通过正常入口转到另一个模块内部；两个模块有一部分程序代码重叠；一个模块有多个入口。</td>
  </tr>
  <tr>
    <td>公共耦合</td>
    <td>多个模块引用同一个全局数据库。</td>
  </tr>
  <tr>
    <td>外部耦合</td>
    <td>与软件以外的环境有关。</td>
  </tr>
  <tr>
    <td>控制耦合</td>
    <td>模块间传递的信息中包含用于控制模块内部逻辑的信息。</td>
  </tr>
  <tr>
    <td>标记耦合</td>
    <td>一个数据结构的一部分借助于模块接口被传递。</td>
  </tr>
  <tr>
    <td>数据耦合</td>
    <td>借助参数表传递简单数据。</td>
  </tr>
  <tr>
    <td>非直接内聚</td>
    <td>没有直接联系，互相不依赖对方。</td>
  </tr>
</table>


 	


