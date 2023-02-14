import java.util.Arrays;

/**
 * 给定一个包含 N 个整数 A 的数组 A。
 * 通过将数组中的 3 个数字相乘，返回可能的最高乘积。
 * 注意：解决方案将适合 32 位带符号整数。
 */
public class HighestProduct {
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 0, 1, 2, 5, 4};

        Arrays.sort(arr);
        int result1 = arr[0] * arr[1] * arr[arr.length - 1];
        int result2 = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];

        System.out.println(Math.max(result1, result2));
    }
}
