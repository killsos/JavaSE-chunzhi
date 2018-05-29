
public class Test02 {
	public void Test () {
		short s = 4;
		
		// 下面语句编译失败
		// s = s +5;
		// 失败原因
		// 这里有两步操作 第一 s + 5 同时 运算结果同时为int型
		// int型运算结果赋给short型变量s 所以报错
		
		// 下面编译成功
		s += 5;
		// 成功原因 s+5 结果为int 但是会发生一次强制类型转换为short
	}
}
