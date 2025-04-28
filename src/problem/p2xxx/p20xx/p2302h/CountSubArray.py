class Solution(object):
    def countSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        left = 0
        right = 0
        n = len(nums)
        count = 0
        sum_arr = 0

        while left < n:
            while right < n and (sum_arr + nums[right]) * (right - left + 1) < k:
                sum_arr += nums[right]
                right += 1

            count += right - left

            # Slide window forward
            if right == left:
                # Couldn't include nums[left] at all
                right += 1
            else:
                sum_arr -= nums[left]

            left += 1
        return count



if __name__ == "__main__":
    sol = Solution()
    nums = [1,1,1]
    k = 5
    print(sol.countSubarrays(nums, k))