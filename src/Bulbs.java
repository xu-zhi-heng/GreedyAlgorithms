/**
 * N个灯泡用电线连接。
 * 每个灯泡都有一个与之关联的开关，但是由于接线错误，一个开关还会更改当前灯泡右侧所有灯泡的状态。
 * 给定所有灯泡的初始状态，找出打开所有灯泡所需按下的最少开关数。
 * 您可以多次按下同一个开关。
 * 注：0 代表灯泡熄灭，1 代表灯泡亮起。
 */
public class Bulbs {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 1};
        int cost = 0;
        for (int item : arr) {
            if (cost % 2 == 0) {
                item = item;
            } else {
                item = item == 0 ? 1 : 0;
            }
            // 如果当前的灯是开着的，则不需要进行操作
            if (item % 2 == 1) {
                continue;
            } else {
                cost++;
            }
        }
        System.out.println(cost);
    }
}
