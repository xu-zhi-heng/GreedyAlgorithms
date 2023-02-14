import java.util.*;
/**
 * 给定一个大小为 N x 2 的二维整数数组 A，表示不同会议的时间间隔。
 * 找出能够举行所有会议所需的最少会议室数量。
 * 注意：- 如果一个会议在时间 t 结束，另一个在时间 t 开始的会议可以使用同一个会议室
 */
public class SolveCodingChallenges {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 30},
                {5, 10},
                {15, 20}
        };
        int current = 0;
        int ans = 0;
        HashMap<Integer, Integer> time = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int[] item : arr) {
            time.put(item[0], 1);
            time.put(item[1], -1);
            list.add(item[0]);
            list.add(item[1]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            current += time.get(list.get(i));
            ans = Math.max(ans, current);
        }
        System.out.println(ans);
    }
}
