import java.io.File;

public class File01 {
	 public static void main(String[] args)  {
		File f = new File(File.separator+ "123"+File.separator+"file.txt");
		
		System.out.println("path:" + f.getPath());
		
		System.out.println("abspath:" + f.getAbsolutePath());
		
		System.out.println("parent:" + f.getParent());
	}
}
