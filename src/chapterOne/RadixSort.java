package chapterOne;

import java.util.Arrays;

/**
 * 基数排序
 * 时间复杂度：O(k(n+m))
 * O(n+m)
 */
public class RadixSort {
    //ASCII码的取值范围
    public static final int ASXII_RANGE = 128;

    public static String[] radixSort(String[] array, int maxLeng){
        //排序结果数组，用于存储每一次按位排序的临时结果
        String[] sortedArray = new String[array.length];
        //从个位开始比较，一直比较到最高位
        for (int k = maxLeng - 1; k >= 0; k--){
            //计数排序的过程，分成3步：
            //1.创建辅助排序的统计数组，并把待排序的字符对号入座，
            //这里为了代码简洁，直接使用ASCII码范围作为数组长度
            int[] count = new int[ASXII_RANGE];
            for (int i = 0; i < array.length; i++){
                int index = getCharIndex(array[i],k);
                count[index]++;
            }
            //2.统计数组做变形，后面的元素等于前面的元素之和,
            // 这一步是为了得到，每个数的正确位置，比如第一个格子排第一，第二个格子就要排第二，
            // 以此类推，每个格子里最后一个数在新的排序数组中的序号等于自己和前面所有格子求和。
            for (int i = 1; i < count.length; i++){
                count[i] = count[i] + count[i - 1];
            }
            //3.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
            for (int i = array.length - 1; i >= 0; i--){
                int index = getCharIndex(array[i],k);
                int sortedIndex = count[index] - 1;
                sortedArray[sortedIndex] = array[i];
                count[index]--;
            }
            //下一轮排序需要以上一轮的排序结果为基础，因此吧结果赋值给array
            array = sortedArray.clone();
        }
        return array;
    }

    /**
     * 获取字符串第k位字符所对应的ASCII码序号
     * @param s
     * @param k
     * @return
     */
    private static int getCharIndex(String str, int k) {
        //如果字符串长度小于k，直接返回0，相当于给不存在的位置补0
        if (str.length() < (k + 1)){
            return 0;
        }
        return str.charAt(k);
    }

    public static void main(String[] args){
        String[] array = {"qd","abc","qwe","hhh","a","cws","ope"};
        System.out.println(Arrays.toString(radixSort(array,3)));
    }
}
