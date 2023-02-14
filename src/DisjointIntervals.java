/**
 * 给定一组 N 个区间，由大小为 N x 2 的二维数组 A 表示，任务是找到相互不相交的区间的最大集合的长度。
 * 如果两个区间 [x, y] & [p, q] 没有任何共同点，则它们被认为是不相交的。
 * 返回一个整数，表示相互不相交的间隔的最大集合的长度。
 */
public class DisjointIntervals {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
//                {2, 3},
//                {1, 4},
//                {4, 6},
//                {8, 9},
                {2, 10},
                {1, 2},
                {4, 6},
        };

        // 结束的最早才会最长，所以先找出end最小的那个
        int temp = arr[0][1];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (temp > arr[i][1]) {
                index = i;
                temp = arr[i][0];
            }
        }

        int prev_s = arr[index][0];     // start
        int prev_e = arr[index][1];     // end
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                // 代表集合重合
                if (arr[i][0] <= prev_e) {
                    continue;
                } else {
                    prev_s = arr[i][0];
                    prev_e = arr[i][1];
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
