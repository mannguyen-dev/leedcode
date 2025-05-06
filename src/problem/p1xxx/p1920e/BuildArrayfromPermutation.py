class Solution(object):
    def buildArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        return [nums[nums[i]] for i in range(len(nums))]
    

if __name__ == "__main__":
    sol = Solution()
    nums = [5,0,1,2,3,4]
    print(sol.buildArray(nums))