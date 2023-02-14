import java.util.*;

/**
 * 有 N 个孩子站成一排。 每个孩子都被分配了一个评级值。
 * 您根据以下要求向这些孩子赠送糖果：
 * 1. 每个孩子必须至少有一颗糖果。
 * 2. 评分高的孩子得到的糖果比邻居多。
 * 你必须给的最少糖果是多少？
 */
public class DistributeCandy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 4, 3, 3, 1};
        int len = arr.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        // 记录arr数组从小到大的顺序
        List<Integer> orderList = new ArrayList<>();
        // 对arr数组进行排序操作
        int[] orderArr = Arrays.copyOf(arr, len);
        Arrays.sort(orderArr);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (orderList.contains(j)) {
                    continue;
                }
                if (orderArr[i] == arr[j]) {
                    orderList.add(j);
                    break;
                }
            }
        }
        for (int i = 0; i < orderList.size(); i++) {
            int ordinalValue = orderList.get(i);
            if (ordinalValue > 0 && arr[ordinalValue] > arr[ordinalValue - 1]) {
                candies[i] = Math.max(candies[i], candies[ordinalValue - 1] + 1);
            }
            if (ordinalValue < len - 1 && arr[ordinalValue] < arr[ordinalValue + 1]) {
                candies[i] = Math.max(candies[ordinalValue], candies[ordinalValue + 1] + 1);
            }
        }
        int sum = Arrays.stream(candies).sum();
        System.out.println(sum);
    }
}
