import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个大小为 N 的整数数组 A，其中包含从 1 到 N 的唯一整数。您最多可以交换任意两个整数 B 次。
 * 返回可以通过执行最多 B 次交换创建的最大字典值数组。
 */
public class LargestPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 7, 9, 6, 3, 2, 1, 5};
        int b = 11;
        // 统计交互次数
        int count = b > arr.length ? arr.length : b;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        int index = 0;
        int max = arr.length;
        int temp = 0;
        for (int i = 0; i < count;) {
            int maxIndex = hashMap.get(max);
            if (index == maxIndex) {
                max = max - 1;
                index++;
            } else {
                temp = arr[index];
                arr[index] = arr[maxIndex];
                arr[maxIndex] = temp;
                // 交互hashmap中的位置信息
                hashMap.replace(max, index);
                hashMap.replace(arr[max - 1], max - 1);
                i++;
                max = max - 1;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
