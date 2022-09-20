import java.util.List;

public class CanIAdvance {
    public static void main(String[] args){
        int[] test1 = new int[]{0, 1, 2, 3, 4};
        int[] test2 = new int[]{1, 1, 2, 3, 4};
        int[] test3 = new int[]{1, 0, 2, 3, 4};
        int[] test4 = new int[]{3, 0, 0, 0, 4};
        int[] test5 = new int[]{3, 0, 0, 1, 4};
        int[] test6 = new int[]{3, 0, 0, 1, 0};
        int[] test7 = new int[]{0};
        int[] test8 = new int[]{1, 0};
        List<int[]> tests = List.of(test1, test2, test3, test4, test5, test6, test7, test8);
        List<Boolean> results = List.of(false, true, false, false, true, true, true, true);
        for (int i = 0; i < tests.size(); ++i)
        {
            if (canIAdvance(tests.get(i)) == results.get(i))
            {
                System.out.println("Test №" + i +  " passed successfully");
            }
            else
            {
                System.out.println("Test №" + i + " failed");
            }
        }
    }

    public static boolean canIAdvance(int[] array) throws NullPointerException
    {
        if (array == null) throw new NullPointerException("array cannot be null");
        else if (array.length == 1) return true;
        else
        {
            int maxAvaliableIndex = 0;
            for (int i = 0; i < array.length; ++i)
            {
                if (i > maxAvaliableIndex) return false;
                if (i + array[i] > maxAvaliableIndex)
                {
                    maxAvaliableIndex = i + array[i];
                    if (maxAvaliableIndex >= array.length-1) return true;
                }
            }
            return true;
        }
    }
}
