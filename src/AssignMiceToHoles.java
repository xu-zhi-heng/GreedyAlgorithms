import java.util.Arrays;

/**
 * 有 N 个 Mice 和 N 个孔，它们被放置在一条直线上。 每个洞只能容纳一只老鼠。
 * 小鼠的位置由数组 A 表示，孔的位置由数组 B 表示。
 * 鼠标可以停留在他的位置，从 x 向右移动一步到 x + 1，或者从 x 向左移动一步到 x − 1。这些移动中的任何一个都需要 1 分钟。
 * 将老鼠分配到洞中，以便最大限度地减少最后一只老鼠进入洞内的时间。
 */
public class AssignMiceToHoles {
    public static void main(String[] args) {
        int[] mice = {3, 2, -4};
        int[] holes = {0, -2, 4};

        Arrays.sort(mice);
        Arrays.sort(holes);
        int ans = 0;
        for (int i = 0; i < mice.length; i++) {
            ans = Math.max(ans, Math.abs(mice[i] - holes[i]));
        }

        System.out.println(ans);
    }
}
