import java.io.File;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class HelloWorld {
	public static void main(String[] args) throws Exception {
//		ServerSocket ss = new ServerSocket(11000);
//		
//		System.out.println("开始");
//		Socket s = ss.accept();
//		System.out.println("等待");
//		System.out.println(s.getInetAddress().getHostAddress());
//		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
//		
//		out.println("browser hello");
//		
//		s.close();
//		
//		ss.close();
		
		File[] files = File.listRoots();
		
		for (File f : files) {
			System.out.println(f);
		}
	}
	
}
