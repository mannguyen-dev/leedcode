class Solution(object):
    def countSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        for i in range(len(nums) - 2):
            if (nums[i] + nums[i+2])*2 == nums[i+1]:
                count += 1

        return count


if __name__ == "__main__":
    sol = Solution()
    nums = [2,-7,-6]
    print(sol.countSubarrays(nums))