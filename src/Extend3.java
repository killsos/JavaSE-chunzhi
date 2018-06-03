
public class Extend3 extends Extend2 {
	//int num = 3; // 如果子类没有变量num  运行结果 2 2
	
	//int num = 3; // 如果子类有变量num  运行结果 2  3
 
	public void say() {
		System.out.println(super.num);
		System.out.println(this.num);
	}
}
