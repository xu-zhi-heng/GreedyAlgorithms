import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int len = gas.length;
        // 表示当前的油量
        int current = 0;
        // 从第几个车站开始
        int start = 0;
        // 将数组变为两倍，因为是一个环
        int[] gasCopy = Arrays.copyOf(gas, len);
        int[] costCopy = Arrays.copyOf(cost, len);
        int[] newGas = IntStream.concat(Arrays.stream(gas), Arrays.stream(gasCopy)).toArray();
        int[] newCost = IntStream.concat(Arrays.stream(cost), Arrays.stream(costCopy)).toArray();

        for (int i = 0; i < len * 2; i++) {
            if (i == start + len) {
                System.out.println(start);
                break;
            }
            current = current + newGas[i] - newCost[i];
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
    }
}
