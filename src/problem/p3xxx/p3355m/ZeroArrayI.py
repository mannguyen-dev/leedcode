class Solution(object):
    def isZeroArray(self, nums, queries):
        """
        :type nums: List[int]
        :type queries: List[List[int]]
        :rtype: bool
        """
        diff_arr = [0] * (len(nums) + 1)

        for query in queries:
            start = query[0]
            end = query[1]
            diff_arr[start] += 1
            diff_arr[end+1] -= 1

        total = 0
        for i in range(len(nums)):
            total += diff_arr[i+1]
            if total < nums[i]:
                return False
        return True

