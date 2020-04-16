import java.util.ArrayList;
import java.util.Arrays;


class DecompressRunLength {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i += 2) {
            int count = nums[i];
            int number = nums[i + 1];
            while (count > 0) {
                result.add(number);
                count -= 1;
            }

        }

        //convert to int array
        int[] out = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            out[i] = result.get(i);
        }
        return out;

    }

    public int[] decompressRLElistFASTER(int[] nums) {
        // Doesn ot use ArrayList which is additional mem allocation
        int finalSize = 0;

        for (int i=0; i<nums.length; i += 2) {
            finalSize += nums[i];

        }

        int[] out = new int[finalSize];

        int outIndex = 0;
        for (int i=0; i<nums.length; i += 2) {
            int count = nums[i];
            while (count>0){
                out[outIndex] = nums[i+1];
                count -= 1;
                outIndex += 1;
            }
        }
        return out;

    }

    public static void main(String[] args) {
        DecompressRunLength dc = new DecompressRunLength();

        int[] input = {1,2};
        boolean equals = Arrays.equals(dc.decompressRLElist(input), new int[]{2});
        System.out.println(equals);

    }
}
