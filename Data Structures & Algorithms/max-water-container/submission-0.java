class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int max = Math.min(heights[left], heights[right]);
            int area = max * (right - left);
            maxArea = Math.max(maxArea, area);
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
