import java.util.ArrayList;
import java.util.List;

/**
 * 这是一排座位。 假设它包含 N 个彼此相邻的座位。 有一群人已经随机坐在那排。 即有些坐在一起，有些分散。
 * 已占用的座位用字符“x”标记，未占用的座位用点（“.”）标记
 * 现在你的目标是让整个小组坐在一起，即彼此相邻，他们之间没有任何空位，这样移动他们的跳跃总数应该是最少的。
 */
public class Seats {
    public static void main(String[] args) {
//        String[] seats = {".", "x", ".", ".", "x", ".", ".", "x", "x", "."};
        String[] seats = {"x", "x", ".", ".", "x", "x", ".", ".", ".", ".", "x", "x", "x"};

        System.out.println(minValue_02(seats));
    }

    // 超时
    public static int minValue(String[] seats) {
        // 记录每一个x出现的位置
        List<Integer> xIndex = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals("x")) {
                xIndex.add(i);
            }
        }
        // 这里的做法是： 假设第三个人需要移动，前面已经有两个人了，所以他移动就不需要那么次，只需要 移动的位置 - 2即可
        for (int i = 0; i < xIndex.size(); i++) {
            xIndex.set(i, xIndex.get(i) - i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < seats.length; i++) {
            int total = 0;
            for (Integer index : xIndex) {
                total += Math.abs(index - i);
            }
            ans = Math.min(total, ans);
        }
        return ans;
    }


    // 通过中位数找到最佳集合点
    public static int minValue_02(String[] seats) {
        List<Integer> xIndex = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals("x")) {
                xIndex.add(i);
            }
        }
        for (int i = 0; i < xIndex.size(); i++) {
            xIndex.set(i, xIndex.get(i) - i);
        }
        System.out.println(xIndex);
        int median = xIndex.get(xIndex.size() / 2);
        int ans = 0;
        for (int i = 0; i < xIndex.size(); i++) {
            ans = ans + Math.abs(xIndex.get(i) - median);
        }
        return ans;
    }
}
