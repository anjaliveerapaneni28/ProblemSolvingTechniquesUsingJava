class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int n = nums.length;
        int flag = 0;
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == i) {
                    flag = 1;
                    break;
                }
                if (nums[mid] < i) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (flag == 0) {
                arr.add(i);
            }
            flag = 0;
        }
        return arr;
    }
}
