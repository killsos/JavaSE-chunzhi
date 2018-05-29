
public class Test04 {
	public void test () {
		int a = 3;
		switch (a) {
		default:
			System.out.println("default");
			//break;
		case 1:
			System.out.println(1);
			//break;
		case 2:
			System.out.println(2);
			//break;
		case 4:
			System.out.println(4);
			//break;
		}
	}
	/*
	 * 运行结果是
	 *  default
	 *  1
	 *  2
	 *  4
	 *  为何呢？
	 *  安装switch执行顺序是先case 后default 遇见break就结束 
	 *  如果default没有遇到break就不再判断运行到switch中所有语句一直到右边大括号
	 *  
	 *  case 1 不满足
	 *  
	 *  case 2 不满足
	 *  
	 *  case 4 不满足
	 *  
	 *  default 执行没有遇break
	 *  
	 *  然后就不再判断case就执行所有可以执行的语句
	 *  
	 *  所以结果 default 1 2 4
	 */
}
