## IO

#### 7.1 IO
	
	IO input output 流
	
	java对数据的操作是通过流的方式
	
	java用于操作流的对象都在IO包中
	
	流按操作数据分为两种 字节流 和 字符流
	
	流按流向分为 输入流 输出流
	
	因为文本数据 并且基于字节流 融合编码表 就产生 字符流 因为ASCII表的存在
	
	UNIcode 都是两个字节  
	
	UTF-8 1-3字节
	
	
	数据最常见体现方式:
		
		文件
	

#### 7.2 字节流的抽象基类
	
	InputStream 
	
		FileInputStream
			
			available()  返回文本的大小
	
	OutStream
	
		FileOutStream
	

#### 7.3 字符流的抽象基类
	
	Reader 
	
	Writer
	
7.3.1 Reader

	FileReader r1 = new FileReader(文件名)
	
		此构造方法指定了默认字符编码 如果想自己指定 可以现在FileInputStream上构造一个 InputStreamReader
		
		要保证文件的存在 要报出错误
	
	char c1 = r1.read()
	
	read方法 一次度一个字符 而且会自动往下读  返回值是-1 就表示结束了 

	r1.close()

7.3.2 Writer

	FileWriter
		
		操作文件的Writer子类
		
		FileWriter f1 = new FileWriter(指定目录 + 文件名, boolean append)
		
			如果指定目录下已经有同名文件  会覆盖
		
		f1.write('a')  // write写到流中 其实流就是内存块 也就是字符a还在内存 没有写到文件中
		
		f1.flush() // 刷新缓冲区  所谓刷新缓冲区 就是内存的数据写到文件中
		
		f1.close() // 关闭流 注意在关闭之前会刷新一次流的缓冲区	
	
	其实close是 先刷新缓冲区 将其写入到文件中 然后调用 系统API 完成写入操作 然后释放系统资源
	
	

7.3.3 字符流的缓冲区

	缓冲区的出现提高了对数据的读写效率
	
	对应类
		
		BufferedWriter
		
		BufferedReader
			
			readLine() 按行读取
			
		
	缓冲区要结合流才可以使用
	
	在流的基础上对流的功能进行了增强
	


注意 有这四个类派生出来的子类名称都是以其父类名称作为了子类名的后缀

	如 InputStream的子类 FileInputStream
	
	如 Reader的子类 FileReader
	

换行与回车

换行（英语：newline，Line break，end-of-line(EOL), Line Feed(LF)

以ASCII为基础的或相容的字元集使用分别LF（Line feed，U+000A）或CR（Carriage Return，U+000D）或CR+LF

\n newline

\r return 

Unix linux 系统里，每行结尾只有"<换行>"，即"\n"

Windows系统里面，每行结尾是"<回车><换行>"，即"\r\n"

Mac系统里，每行结尾是"<回车>"，即"\r"



#### 7.4 装饰设计模式

当想要对已有的对象进行功能增强时 可以定义类 将已有对象传入 基于已有的功能 并提供加强功能 

那么自定义的该类就成为 装饰类


装饰与继承区别:
	
	装饰类可以理解为装饰器  体现组合结构
	
	装饰比继承灵活 避免了继承体现臃肿
	
	降低了类与类之间的关系
	
	装饰类因为增强已有对象 具备的功能和已有的是相同的 只不过提供了更强功能
	
	所以装饰类和被装饰类通常都属于一个体系中的
	
	
#### 7.5 键盘
	
7.5.1 键盘输入结束
	
	ctrl + c
	
7.5.2 回车
	
	\r      13
	
	\n      10
	

#### 7.6 流规律

	通过三个明确来完成
	
		1. 明确源和目的
			
			源		输入流
				
					InputStream		Reader
			
			目的    输出流
			
					OutputStream	writer
					
		2. 操作数据是否是纯文本
			
			是		用字符流
			
			
			否		用字节流
				
		
		3. 体系明确后   在明确要使用那个具体的对象
		
			通过设备来进行区分
			
				源设备:  内存		硬盘		键盘
				
				
				目的设备: 内存	硬盘		控制台
		
		
		三个需求
			
			复制文件---纯文本
					
					源	
						因为是源 所以使用读取流  InputStream   Reader
						
						是不是操作文本文件
							
							是  所以选择Reader
							
							Reader体系中可以操作文件的对象是  FileReader
							
						是否提高效率
							
							是      加入Reader体系中缓冲区  
							
								BufferedReader 
							
					目的
						
						因为是目的 所以可以使用写入流  OutputStream Writer
						
						是不是操作文本文件
							
							是 Writer
							
							设备: 硬盘  文件
								
							Writer体系中可以操作文件对象是 FileWriter
							
					是否提高效率
						
						是      加入Writer体系中缓冲区
						
			
			
			键盘输入 是 字节流
				
				为了操作方便  要转成字符流 
					
					所以将 System.in 转成 Reader
					
					为了转换成就用Reader体系中转化流 InputStreamReader
					
				需要提高效率吗
					
					需要  BufferedReader
					
					
			
		编码: GBK
		
		FileReader 指定的编码是GBK 
		
		
		System.in  默认是 键盘
		
		System.out 默认是 控制台
		
		
		通过System.setIn()   System.setOut()  修改
		

#### 7.7 File类

7.7.1 File类
	
	用来将文件或者文件夹封装成对象
	
	方便对文件与文件夹进行操作
	
	File对象可以作为参数传递给流的构造函数
	

7.7.2 示例

	File f = new File(path,filename)
	
7.7.3 跨平台分隔符

	File.separator
	

7.7.4 常见方法

	创建
	
		createNewFile()  返回值 boolean  已经存在的文件 返回 false
		
		mkdir()
		
		mkdirs()	创建多级目录
	
	删除
		
		delete()
		
		deleteOnExit()  退出时候删除
	
	判断
		
		exists()  是否存在
		
		记住 在判断文件对象是否是文件或者目录的时候 必须要先判断该文件或目录是否存在
		
		isFile()
		
		isDirectory()
		
		isAbsoluate()
	
	获取信息
	
		canExecute()  文件是否可执行
		
		getName()	文件名
		
		getPath()	文件路径
		
		getParent()	
			
			返回绝对路径中父目录  如果获取的是相对路径 返回null
		
			也就是 如果相对路径中有上一层目录 那么该目录就是返回结果
		
		getAbsolutePath()
		
		lastModified()
		
		length()
	

#### 7.8 Properties

7.8.1 Properties
	
	是hashtable子类
	
	也就是说它具备map集合的特点 而且它里面存储的键值对都是字符串
	
	是集合中和IO技术相结合的集合容器
	
	该对象的特点:
		
		该对象的特点	可以用于键值对形式的配置文件
		
	
		
#### 7.9 打印流

7.9.1 打印流

	提供额打印方法  可以将各种数据类型的数据都原样打印
	
	字节打印流	PrintStream
	
	字符打印流	PrintWriter
	
	
7.9.2 SequenceInputStream 
	
	表示其他输入流的逻辑串联 
	
	
#### 7.10 对象的序列化

7.10.1 操作对象

	ObjectInputStream	ObjectOutputStream
		
		被操作对象需要实现Serializable  对象可持久化 对象可串行性  

	
	Serializable    是 标记接口  所谓 标记接口 就是没有方法的接口  给类添加一个UID  UID与类的成员有关
	
	可以自定义一个UID后 即便类的成员改变了 也不会报错
	
	静态成员不会被序列化  
	
	非静态成员如果也不想被序列化 加上关键字 transient
		
		被transient修饰后 在堆内存里存在 而不会序列化到文件中
		


#### 7.10 管道流

7.10.1 PipedInputStream PipedOutputStream
	
	输入 输出 可以直接进行连接 通过结合线程使用
	
	管道输入流应该连接到管道输出流 管道输入流提供要写入管道输出流的所有数据字节
	
	通常 数据由某个线程从PipedInputStream对象读取 并由其他线程将其写入到相应的PipedOutputStream
	
	不建议对这两个对象尝试使用单线程 因为这样可能死锁线程
	

7.10.2 RandomAccessFile
	
	随机访问文件  自身具备读写的方法
	
	通过skipBytes(int x) 和 seek(int x) 来达到随机访问
	
	此类实例支持对随机访问文件的读取和写入 
	
	随机访问文件的行为类似存储在文件系统中的一个大型byte数组
	
	存在指向该隐含数组的光标或索引 称为 文件指针
	
	这个类不算是IO体系中子类
	
	而是直接继承自Object
	
	但是IO包中的成员 因为它具备读和写功能
	
	内部封装了一个数组  而且通过指针对数组的元素进行操作
	
	可以通过getFilePoninter获取指针位置
	
	同时可以通过seek改变指针的位置
	
	其实完成读写的原理就是内部封装了字节输入流和字节输出流
	
	通过构造函数可以知道 该类只能操作文件
	
	而且操作文件还有模式
	
	
#### 7.11 IO包中其他类

7.11.1 操作基本数据类型

	DataInputSteam
	
	DataOutputSteam
	
	用于操作基本数据类型的数据的流对象
	
7.11.2 操作字节数组
	
	ByteArrayInputStream
	
		在构造的时候 需要接受数据源 
		
		而且数据源是一个字节数组
	
	ByteArrayOutputStream
		
		在构造的时候 不需要定义数据目的
		
		因为该对象中已经内部封装了可变长度的字节数组
		
		这就是数据目的地
		
		因为这两个流对象都操作的数组 并没有使用系统资源
		
		所以 不要进行close关闭
		
	
7.11.3 操作字符数组

	CharArrayReader
	
	CharArrayWriter
	
7.11.4 操作字符串
	
	StringReader
	
	StringWriter
	
	
#### 7.12 字符编码
	
	字符流的出现为了方便操作字符
	
	更重要是的加入了编码转换
	
	通过子类转换流来完成
		
		InputStreamReader
		
		OutputStreamWriter
		
	在两个对象进行构造的时候可以加入字符集
	
	
7.12.1 编码表的由来

	计算机只能识别二进制数据 早期由来是电信号
	
	为了方便应用计算机 让它可以识别各个国家的文字
	
	就将各个国家的文字用数字来表示 并一一对应 形成一张表
	
	这就是编码表
	

7.12.2 常用编码表
	
	ascii  美国标准信息交换码
		
		用一个字节的7位表示
		
	ISO8859-1 拉丁码表 欧洲码表
	
		用一个字节的7位表示
		
	GB2312 中文编码表
		
	GBK 中文编码表升级版 表示更多中文文字
	
	Unicode  国际标准码 融合全球文字
		
		所有文字都用两个字节来表示   JAVA语言使用的就是Unicode
		
	UTF-8 可变的字节  最多用3个字节来表示一个字符
	
	编码
		
		字符串 转  字节数组
		
		String --> byte[]  str.getBytes(charsetName)
		
	解码
		
		字节数组 转  字符串
		
		byte[] --> String   new String(byte[], charsetName)
		
	
Tomcat服务器编码  是 iso-8859-1 识别英文和拉丁文

标识头 

在utf8 标识

一个字节 最高位是0是ascii 如果最高位是1

两个字节 首字节最高两位是1  第二字节最高位是1

三个字节  首字节最高三位是1  首字节最高两位是1  第二字节最高位是1
		
	