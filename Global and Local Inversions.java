class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int[] BIT = new int[n+1]; // Binary Indexed Tree
        update(BIT, A[0]+1, 1);
        int local = 0, global = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1]) local++;
            global += i - getPrefixSum(BIT, A[i]+1);
            update(BIT, A[i]+1, 1);
        }
        return local == global;
    }
    void update(int[] BIT, int index, int val) {
        while (index < BIT.length) {
            BIT[index] += val;
            index += index & -index;
        }
    }
    int getPrefixSum(int[] BIT, int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & -index;
        }
        return sum;
    }
}