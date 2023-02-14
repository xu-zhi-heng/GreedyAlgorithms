/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,3,2};
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            int ones = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    ones++;
                }
            }
            if (ones > nums.length / 2) {
                ans += (1 << i);
            }
        }
        System.out.println(ans);
    }
}
