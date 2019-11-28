/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : journey

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 28/11/2019 18:59:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章主键',
  `tittle` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `summary` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章摘要',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章Markdown内容',
  `reading` int(11) NOT NULL DEFAULT 0 COMMENT '文章阅读量',
  `love` int(11) NOT NULL DEFAULT 0 COMMENT '文章点赞数量',
  `discuss` int(11) NOT NULL DEFAULT 0 COMMENT '文章评论量',
  `status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '文章状态(0 草稿、1已发布、2已删除)',
  `category` int(11) DEFAULT NULL COMMENT '文章分类',
  `creatime` bigint(20) DEFAULT NULL COMMENT '文章创建日期',
  `updatime` bigint(20) DEFAULT NULL COMMENT '文章更新日期',
  `top` tinyint(2) NOT NULL DEFAULT 1 COMMENT '文章置顶(0 置顶 、1 不置顶)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 190 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_info
-- ----------------------------
INSERT INTO `article_info` VALUES (1, 'TCP协议详解', '通过TCP报文格式探究TCP的可靠传输是如何实现的，主要是TCP的连接建立过程，连接释放过程，SYN泛洪攻击的原因和解决的办法!通过TCP报文格式探究，通过TCP报文格式探究TCP的可靠传输是如何实现的，主要是TCP的连接建立过程，连接释放过程......', '![](https://img.hacpai.com/bing/20190303.jpg?imageView2/1/w/960/h/540/interlace/1/q/100)\n\n# TCP协议特点\n\n## 1、面向连接\n\n传输控制协议Transmission Control Protocol 要对数据的传输进行一个详细的控制，TCP是面向连接(虚连接)的传输层协议，但注意此处的连接是虚连接：\n\n![net01.png](https://img.hacpai.com/file/2019/11/net01-6827890e.png)\n\n\n\n\n## 2、每个TCP连接只能是点对点\n\nTCP连接是点对点的连接，而不是向广播那样的形式\n\n## 3、可靠有序，不丢不重\n\nTCP提供可靠交付的服务，无差错、不丢失、不重复、按序到达。可靠有序，不丢不重，后面会写到这些功能是如何实现的\n\n## 4、TCP提供全双工通信\n\n发送缓存：准备发送的数据 + 已发送但尚未收到确认的数据\n接收缓存：按序到达但尚未被接受应用程序读取的数据 + 不按序到达的数据\n\n## 5、面向字节流\n\nTCP面向字节流，TCP把应用程序交下来的数据看成仅仅是一连串的无结构的字节流。\n\n\n\n# TCP报文格式\n\n![net02.png](https://img.hacpai.com/file/2019/11/net02-8d345924.png)\n\n\n## 1、填充字段\n\n首先看看填充字段，这个字段主要是为了保证添加选项字段后TCP首部是还是4字节的整数倍（通常填充的是全零字段）。\n\n固定首部就是20字节（图中一行就是32位，8位是一个字节，所以图中的一行就是4字节，五行就是20字节）\n\n## 2、源端口和目的端口\n\n源端口和目的端口分别占用4字节，总占用8字节\n\n## 3、序号\n\n序号：在一个TCP连接中传送的字节流中的每一个字节都按顺序编号，本字段表示本报文段所发送数据的第一个字节的序号。如下图，如果发的是123号字节的数据，那么TCP报文中的头部序号就是1，如果发送的是456号字节的数据，那么TCP报文中的头部序号就是4：\n\n![net03.png](https://img.hacpai.com/file/2019/11/net03-f94f8dbc.png)\n\n\n## 4、确认号\n\n确认号：期望收到对方下一一个报文段的第一个数据字节的序号。若确认号为N，则证明到序号N-1为止的所有数据都已正确收到。如下图：接收端收到数据后要反馈给发送端，还是向发送端发一个确认报文，填写自己的确认号，发送端就知道了接收端收到了那些数据，没收到的超时要重发：\n\n![net04.png](https://img.hacpai.com/file/2019/11/net04-7d08cffb.png)\n\n\n\n## 5、数据偏移\n\n数据偏移(首部长度) ： TCP报文段的数据起始处距离TCP报文段的起始处有多远，以4字节为单位，即1个数值是4字节，首部长度包含固定的20字节，还有选项字段和填充字段，所以需要知道首部的长度，就需要这个字段来说明首部长度。 由于数据偏移字段只有4位的存储空间，最大为 1111 ，就是最大值为15，15 * 4 = 60字节，所以TCP协议首部最长为60字节（20字节固定大小 + 40字节的选项和填充字段）。\n\n## 6、6个控制位\n\n### URG - 紧急位\n\n紧急位URG，URG=1时， 标明此报文段中有紧急数据，是高优先级的数据，应尽快传送，不用在缓存里排队，配合紧急指针字段使用\n\n### ACK - 确认位\n\n确认位ACK，ACK=1时确认号有效，在连接建立后所有传送的报文段都必须把ACK置为1\n\n### PSH - 推送位\n\n推送位PSH，PSH=1时， 接收方尽快交付接收应用进程，不再等到缓存填满再向上交付\n\n![net05.png](https://img.hacpai.com/file/2019/11/net05-75e4a09c.png)\n\n### RST - 复位\n\n复位RST，RST=1时， 表明TCP连接中出现严重差错，必须释放连接，然后再重新建立传输链接。\n\n### SYN - 同部位\n\n同步位SYN，SYN=1时，表明是一个连接请求/连接接受报文，建立连接的时候表示此报文段为请求/连接接受报文\n\n### FIN - 终止位\n\n终止位FIN，FIN=1时， 表明此报文段发送方数据已发完，要求释放放连接\n\n不过在书中也有这样描述的：\n\n![net09.png](https://img.hacpai.com/file/2019/11/net09-ff1c395b.png)\n\n\n这个会在后面的拥塞控制中讲到！\n\n## 7、窗口\n\n窗口指的是发送本报文段的一方的接收窗口，即现在允许对方发送的数据量，反映了自己可以缓存的字节流，那么对方就知道了你的接收能力怎么样，以此决定向你发送报文的数据量应该控制在多大的范围。举个简单的例子，如果接收方发来的报文确认号是701， 窗口是1000，那么发送方接下来要发的报文就是701~1700的数据。\n\n## 8、校验和\n\n检验首部+数据，检验时要加上12字节的伪首部（IP首部）第四个字段为6（UDP中是17）\n\n## 9、紧急指针\n\n当URG=1时，这个字段才有用，指出本报文段中紧急数据的字节数，假设紧急指针为50，那么数据部分的1-50的数据才是紧急数据，剩下的是普通数据\n\n## 10、选项\n\n选项，例如最大报文段长度MSS、窗口扩大、时间戳、选择确认...\n\n\n\n# TCP的连接管理\n\n建立连接 ----＞数据传送----＞释放连接\n\nTCP连接的建立采用客户服务器方式，主动发起连接建立的应用进程叫做客户，而被动等待连接建立的应用进程叫服务器。\n\n## 1、建立连接过程\n\nstep1、客户端发送连接请求报文段，无应用层数据， SYN = 1，seq = x(随机值，由客户端主机产生)，SYN为1很好理解，前面说到了SYN=1表明是一个连接请求/连接接受报文，建立连接的时候表示此报文段为请求/连接接受报文\n\nstep2、服务器端为该TCP连接分配缓存和变量，并向客户端返回确认报文段，允许连接，无应用层数据，SYN = 1，ACK = 1，seq=y(随机值)，ack=x+1。怎么理解呢？客户端首次发报文，这个报文是建立连接用的，所以客户端随机产生了一个序号seq=y，但是这个序号对于服务器是有用的，因为服务器通过客户端发来的seq就知道需要接收的下一个报文段的序号了，那就是seq的值再加一；\n\n![net06.png](https://img.hacpai.com/file/2019/11/net06-cbb94454.png)\n\n\n\n\nstep3、客户端为该TCP连接分配缓存和变量，并向服务器端返回确认的确认，并且可以携带数据\n\n![net07.png](https://img.hacpai.com/file/2019/11/net07-8db3b1ac.png)\n\n\n总结一下就是：\n\n**第一次发数据包 (客户端->服务器)：客户端知道自己的发送能力正常；服务器知道自己的接收能力正常，也知道客户端的发送能力正常**\n\n**第二次发数据包 (服务器->客户端)：客户端知道服务器的接收、发送能力正常，客户端知道自己的接收能力正常；服务器知道自己的发送能力正常**\n\n**那么现在的问题就是：**\n\n**客户端知道服务器的发送、接收能力都正常，同时也知道自己的发送、接收都正常，那么是不是可以通信了呢？？？？ 不可以，因为服务器目前只知道：自己的发送、接收能力正常，客户端的发送能力正常**\n\n**唯一不能确定的是客户端的接收能力是否正常，所以通过第三次握手，确定了客户端的接收能力也是正常的！**\n\n\n\n补上一张加上状态的图\n\n![net11.png](https://img.hacpai.com/file/2019/11/net11-ffa39477.png)\n\n\n## 2、连接的释放过程\n\n![net08.png](https://img.hacpai.com/file/2019/11/net08-bd2711cf.png)\n\n\n可以看出这是一个四次握手的过程\n\n参与一条TCP连接的两个进程中的任何一个都能终止该连接，连接结束后，主机中的 资源 (缓存和变量) 将被释放。\n\nstep1、客户端发送连接释放报文段，停止发送数据，主动关闭TCP连接。\n\nFIN=1，seq=u （u就等于前面已经传送过来的数据的最后一个字节的序号加1） \n\nstep2、服务器端回送一个确认报文段，客户到服务器这个方向的连接就释放了，处于半关闭状态（close_wait），这个半关闭状态就是客户端停止发送数据，服务器端还可以发送数据。 TCP服务器通知高层的应用进程，客户端向服务器的方向就释放了，这时候处于半关闭状态，即客户端已经没有数据要发送了，但是服务器若发送数据，客户端依然要接受。这个状态还要持续一段时间，也就是整个CLOSE-WAIT状态持续的时间。 \n\nACK=1，seq=v，ack=u+1\n\nstep3、服务器端发完数据，就发出来连接释放报文段，主动关闭TCP连接\n\nFIN=1，ACK=1，seq=w，ack=u+1\n\nstep4、客户端回送确认报文段，再等待时间计时器设置的2MSL（最长报文段寿命）后，连接彻底关闭\n\nACK=1，seq=u+1，ack=w+1\n\n![net10.png](https://img.hacpai.com/file/2019/11/net10-a6b30c96.png)\n![net12.png](https://img.hacpai.com/file/2019/11/net12-2de5aad1.png)\n\n\n# TCP的其他问题\n\n## 1、TCP泛洪攻击\n\nSYN洪泛攻击，这种方式利用TCP协议的特性，就是三次握手。攻击者发送TCP SYN, SYN是TCP三次握手中的第-一个数据包，而当服务器返回ACK后，该攻击者就不对其进行再确认，那这个TCP连接就处于挂起状态，也就是所谓的半连接状态，服务器收不到再确认的话，还会重复发送ACK给攻击者。这样更加会浪费服务器的资源。攻击者就对服务器发送非常大量的这种TCP连接，由于每一个 都没法完成三次握手，所以在服务器上，这些TCP连接会因为挂起状态而消耗CPU和内存，最后服务器可能死机，就无法为正常用户提供服务了。\n\n如何解决TCP泛洪攻击？\n\n① 无效连接的监视释放\n\n 监视系统的半开连接和不活动连接，当达到一定阈值时拆除这些连接，从而释放系统资源 \n\n② SYN Cookie\n\n它使用一种特殊的算法生成seq，这种算法考虑到了对方的IP、端口、己方IP、端口的固定信息，以及对方无法知道而己方比较固定的一些信息，如MSS(Maximum Segment Size，最大报文段大小，指的是TCP报文的最大数据报长度，其中不包括TCP首部长度)、时间等，在收到对方的ACK报文后，重新计算一遍，看其是否与对方回应报文中的（seq-1）相同，从而决定是否分配TCB资源\n\n③ SYN Cache\n\n系统在收到一个SYN报文时，在一个专用HASH表中保存这种半连接信息，直到收到正确的回应ACK报文再分配TCB。这个开销远小于TCB的开销。当然还需要保存序列号。\n\n④ SYN Proxy防火墙\n\n 一种方式是防止墙dqywb连接的有效性后，防火墙才会向内部服务器发起SYN请求。防火墙代服务器发出的SYN ACK包使用的序列号为c, 而真正的服务器回应的序列号为c\', 这样，在每个数据报文经过防火墙的时候进行序列号的修改。另一种方式是防火墙确定了连接的安全后，会发出一个safe reset命令，client会进行重新连接，这时出现的syn报文会直接放行。这样不需要修改序列号了。但是，client需要发起两次握手过程，因此建立连接的时间将会延长。 ', 30, 30, 40, 1, 5, 1574416207591, 1574851830743, 1);
INSERT INTO `article_info` VALUES (2, 'MySQL慢查询日志', 'AAA', '![](https://img.hacpai.com/bing/20181115.jpg?imageView2/1/w/960/h/540/interlace/1/q/100)\n\n# 慢查询日志\n\n## 什么是慢查询日志\n\nMySQL的慢查询日志是 MySQL提供的一种日志记录，它用来记录在 MySQL 中响应时间超过阀值的语句，具体指运行时间超过long_query_time 值的 SQL，则会被记录到慢查询日志中\n\n具体指运行时间超过 long_query_time 值的 SQL，则会被记录到慢查询日志中。long_query_time 的默认值为 10, 意思是运行 10 秒以上的语句\n\n由它来查看哪些 SQL 超出了我们的最大忍耐时间值，比如一条SQL执行超过 5 秒钟，我们就算慢 SQL，希望能收集超过 5 秒的SQL，结合之前explain进行全面分析\n\n\n\n默认情况下，MySQL 数据库没有开启慢査询日志，需要我们手动来设置这个参数。当然，如果不是调优需要的话，一般不建议启动该参数，因为开启慢查询日志会或多或少带来一定的性能影响。慢査询日志支持将日志记录写入文件！\n\n## 如何开启慢查询\n\n查看开启状态\n\n```sql\nSHOW VARIABLES LIKE \'%slow_query_log%\'\n```\n\n![mysql01.png](https://img.hacpai.com/file/2019/10/mysql01-ee66e8fb.png)\n\n\n开启慢查询\n\n```sql\nset global slow_query_log = 1\n```\n\n使用 set global_slow_query_log = 1 开启了慢查询日志只对当前数据库生，如果 MYSQL 重启后则会失效。\n\n![mysql02.png](https://img.hacpai.com/file/2019/10/mysql02-30d35e55.png)\n\n\n如果要永久生效，就必须修改配置文件 my.cnf（其它系统变量也是如此）修改 my.cnf 文件，[mysqld]下增加或修改参数\n\nslow_query_log 和 slow_query_log_file 后，然后重启 MySQL 服务器。也即将如下两行配置进my.cnf文件\n\n```ini\nslow_query_log =1\n\nslow_query_log_file=/var/lib/mysql/tim-slow.log\n```\n\n关于慢查询的参数 slow_query_log_fie，它指定慢查询日志文件的存放路径，系统默认会给一个缺省的文件host_name-slow.log（如果没有指定参数 slow_query_log_file的话）\n\n那么开启慢查询日志后，什么样的SQL参会记录到慢查询里面？\n\n通过 show variables like \'long_query_time%\' 来查看默认时间长度，单位是秒：\n\n![mysql03.png](https://img.hacpai.com/file/2019/10/mysql03-5006b3f6.png)\n\n\n同样的，可以使用命令修改，也可以在my.cnf里面配置。假如运行时间正好等于 long_query_time 的情况，并不会被记录下来。也就是说，在MySQL源码里是判断大于 long_query_time，而非大于等于!\n\n设置记录的阈值：\n\n```sql\nset global long_query_time=3;\n```\n\n![mysql04.png](https://img.hacpai.com/file/2019/10/mysql04-607cc162.png)\n\n\n\n设置了但是还是没有发生更改？为什么？此时需要重新开启一个会话才可以：\n\n![mysql05.png](https://img.hacpai.com/file/2019/10/mysql05-e69133ed.png)\n\n接下来实行一个较慢的查询，如下图，但是记得要在配置文件中做如下配置：\n\n![mysql06.png](https://img.hacpai.com/file/2019/10/mysql06-6375e2df.png)\n\n\n接着去日志文件中查看存在哪些超过阈值的SQL就好了：\n\n![mysql07.png](https://img.hacpai.com/file/2019/10/mysql07-cccb58f5.png)\n\n\n查询当前系统中有多少条慢查询记录：\n\n![mysql08.png](https://img.hacpai.com/file/2019/10/mysql08-9a9efb74.png)\n\n\n记载一下我的配置文件\n\n```ini\nslow_query_log=1;\nslow_query_log_file=/var/lib/mysql/tim-slow.log;\nlong_query_time=3;\nlog_output=FILE\n```\n\n## 日志分析工具mysqldumpshow\n\n![mysql09.png](https://img.hacpai.com/file/2019/10/mysql09-5378b5bd.png)\n\n\n在生产环境中，如果要手工分析日志，查找、分析 SQL，显然是个体力活，MYSQL 提供了日志分析工具mysqldumpshow\n\n* s:是表示按何种方式排序\n* c:访问次数\n* l:锁定时间\n* r:返回记录\n* t:查询时间\n* al:平均锁定时间\n* ar:平均返回记录数\n* at:平均查询时间\n* t:即为返回前面多少条的数据\n* g:后边搭配一个正则匹配模式，大小写不敏感的\n\n\n\n下面是使用示例：\n\n得到返回记录集最多的 10 个 SQL\n\n```bash\nmysqldumpslow -s r -t 10 /var/lib/mysql/tim-slowlog\n```\n\n得到访问次数最多的 10 个 SQL\n\n```bash\nmysqldumpslow -s c-t 10 /var/lib/mysql/tim-slow log\n```\n\n得到按照时间排序的前 10 条里面含有左连接的查询语句\n\n```bash\nmysqldumpslow -s t -t 10 -g \"left join\" /var/lib/mysql/tim-slowlog\n```\n\n另外建议在使用这些命令时结合和 more 使用，否则有可能出现爆屏情況 \n\n```bash\nmysqldumpslow -s r -t 10 /var/lib/mysq/tim-slow.log | more\n```\n\n```java\npublic class Demo{\n	//同时注释齐全\n	public static void main(String[] args){\n		System.out.println(\"This is a string\");\n	}\n}\n```', 12, 12, 0, 1, 5, 1574416207591, 1574916011524, 1);

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article` int(11) NOT NULL,
  `tag` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (121, 1, 7);
INSERT INTO `article_tag` VALUES (122, 1, 1);
INSERT INTO `article_tag` VALUES (124, 2, 2);

-- ----------------------------
-- Table structure for category_info
-- ----------------------------
DROP TABLE IF EXISTS `category_info`;
CREATE TABLE `category_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类信息主键',
  `myname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名称',
  `describes` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类描述',
  `amount` int(11) DEFAULT NULL COMMENT '分类下文章数(已发布的文章)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_info
-- ----------------------------
INSERT INTO `category_info` VALUES (1, 'Java核心技术', '包含JVM、Java并发编程等内容', 3);
INSERT INTO `category_info` VALUES (2, 'C++标准库', 'STL组件的相关介绍，源码剖析', 1);
INSERT INTO `category_info` VALUES (3, '数据结构与算法', '二叉树、排序等算法知识的介绍', 1);
INSERT INTO `category_info` VALUES (4, '虚拟化技术', 'Docker、K8S等原理以及使用', 1);
INSERT INTO `category_info` VALUES (5, '计算机网络', 'TCP/IP协议族', 1);

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `menu` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置项名称',
  `param` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '配置值',
  `argument` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '配置项功能说明',
  PRIMARY KEY (`menu`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES ('blogTittle', 'Tim\'s Blog ', '博客站点标题');
INSERT INTO `config_info` VALUES ('pageSize', '20', '每页的文章数量');

-- ----------------------------
-- Table structure for discuss_info
-- ----------------------------
DROP TABLE IF EXISTS `discuss_info`;
CREATE TABLE `discuss_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论内容',
  `creatime` bigint(20) DEFAULT NULL COMMENT '评论时间',
  `osystem` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论者操作系统',
  `browser` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论者浏览器',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论者邮箱',
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论者站点',
  `article` int(11) DEFAULT NULL COMMENT '评论归属文章',
  `reply` int(11) DEFAULT NULL COMMENT '评论归属回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discuss_info
-- ----------------------------
INSERT INTO `discuss_info` VALUES (1, 'b', 121212121, 'windwos', 'a', 'edede@qq.com', 'http:ss', 1, 1);
INSERT INTO `discuss_info` VALUES (2, 'AAAAAAAAAAA', 1574421578881, 'Windows NT 6.3; Win64; x64', 'Mozilla/5.0', '1529191@qq.com', 'http://baidu.com', 1, 1);

-- ----------------------------
-- Table structure for fragment_info
-- ----------------------------
DROP TABLE IF EXISTS `fragment_info`;
CREATE TABLE `fragment_info`  (
  `fragment_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'html片段名称',
  `fragment_data` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'html片断代码',
  `fragment_annotation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'html片断说明',
  PRIMARY KEY (`fragment_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fragment_info
-- ----------------------------
INSERT INTO `fragment_info` VALUES ('footer_html', '<h1>自定义页面底部</h1>', '博客页面底部HTML');
INSERT INTO `fragment_info` VALUES ('header_html', '<h1>自定义页面头部</h1>', '博客页面头部HTML');
INSERT INTO `fragment_info` VALUES ('notice_html', '<h1>这是我的公告</h1>', '公告栏的HTML');
INSERT INTO `fragment_info` VALUES ('signature_one_html', '<h1>自定义签名档_01<h1>', '博客签名档_01');
INSERT INTO `fragment_info` VALUES ('signature_three_html', '<h1>自定义签名档_03<h1>', '博客签名档_03');
INSERT INTO `fragment_info` VALUES ('signature_two_html', '<h1>自定义签名档_02<h1>', '博客签名档_02');

-- ----------------------------
-- Table structure for link_info
-- ----------------------------
DROP TABLE IF EXISTS `link_info`;
CREATE TABLE `link_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '友链编号',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '链接地址',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接描述',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag_info
-- ----------------------------
DROP TABLE IF EXISTS `tag_info`;
CREATE TABLE `tag_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签的ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签名称',
  `amount` int(11) DEFAULT NULL COMMENT '含有此标签的文章数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag_info
-- ----------------------------
INSERT INTO `tag_info` VALUES (1, 'Docker', 0);
INSERT INTO `tag_info` VALUES (2, 'MySQL', 0);
INSERT INTO `tag_info` VALUES (3, 'Java语法', 0);
INSERT INTO `tag_info` VALUES (4, 'C++语法', 0);
INSERT INTO `tag_info` VALUES (5, 'Python', 0);
INSERT INTO `tag_info` VALUES (6, '测试框架', 0);
INSERT INTO `tag_info` VALUES (7, '网络协议', 0);

SET FOREIGN_KEY_CHECKS = 1;
