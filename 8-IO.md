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
	
	Reader Writer
	
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
	
	

