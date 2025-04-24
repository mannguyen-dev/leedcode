from array import array
from collections import defaultdict


class Solution(object):
    def countCompleteSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        freq = defaultdict(int)

        complete_sub_arrs = 0
        unique_count = len(set(nums))
        left = 0
        right = 0
        n = len(nums)

        while left < n:
            while right < n and len(freq) < unique_count:
                freq[nums[right]] += 1
                right += 1

            if (len(freq) < unique_count):
                break

            complete_sub_arrs += n - right + 1
            freq[nums[left]] -= 1
            if freq[nums[left]] == 0:
                freq.pop(nums[left])
            left += 1
        return complete_sub_arrs

if __name__ == "__main__":
    sol = Solution()
    nums = [1,3,1,2,2]
    print(sol.countCompleteSubarrays(nums))