
/**
 * 
 * https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95
 * 
 * @author killsos
 * 
 * 二分搜索（英语：binary search）也称折半搜索（英语：half-interval search）
 * 
 * 提前是对有序数组
 * 
 * 如果在一个有序数组 插入一个数值之后依然是有序数组 如何确定位置
 * 依然是利用折半查找 
 */
public class BinarySearch {
	
	public int BinarySearchM(int[] arr, int key) {
		 int min, max, mid;
		 min = 0;
		 max = arr.length - 1;
		 
		 while (min <= max) {
			mid = (max + min) >> 1;

			if (key < arr[mid]) {
				min = mid + 1;
			} else if (key > arr[mid]) {
				max = mid - 1;
			} else {
				return mid;
			}
		}
		 // 这是折半查找
		// return -1; 
        // 返回 min 就是插入的位置
		return min;
	}	

}
