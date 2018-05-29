
public class Test01 {
	byte b = 3;
	
	public void test( ) {
		// 下面语句错误原因
		// 2是整数 默认类型int
		// 根据自动类型提升 b + 2 之后结果也是int数值
		// 这时候int数值赋给byte变量就报错了
		//b = b + 2;
		
		// 解决办法 加法运算完 再强制转为byte
		b = (byte)(b + 2);
		System.out.println(b);
	}
}
