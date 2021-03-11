import java.util.ArrayList;
import java.util.List;

public class RelativeSortArray2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] ret = relativeSortArray(arr1, arr2);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]);
        }

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] ret = new int[arr1.length];
        int[] arr = new int[1000];
        int num = 0;

        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]] += 1;
        }
        for (int j = 0; j < arr2.length; j++) {
            while (arr[arr2[j]] > 0) {
                ret[num ++] = arr2[j];
                arr[arr2[j]]--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                ret[num ++ ] = i;
                arr[i]--;
            }
        }
        return ret;
    }
}
