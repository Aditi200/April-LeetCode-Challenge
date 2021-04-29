public int[] searchRange(int[] nums, int target) {
     
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;
        int n = nums.length;
        
        int start = 0;
        int end = n-1;
        
        while(start <= end) {
            int mid = start - (start - end)/2;
            
            if(nums[mid] == target) {
                output[0] = mid;
                end = mid - 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        
        start = 0;
        end = n-1;
        
        while(start <= end) {
            int mid = start - (start - end)/2;
            
            if(nums[mid] == target) {
                output[1] = mid;
                start = mid + 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        
        return output;
    }