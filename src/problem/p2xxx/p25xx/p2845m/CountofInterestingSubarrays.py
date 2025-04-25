from collections import defaultdict


class Solution(object):
    def countInterestingSubarrays(self, nums, modulo, k):
        """
        :type nums: List[int]
        :type modulo: int
        :type k: int
        :rtype: int
        """

        pos = 0
        interest_sub_arrays = 0
        n = len(nums)
        prefix_count = 0

        mod_freq = defaultdict(int)
        mod_freq[0] = 1

        while pos < n:
            if nums[pos] % modulo == k:
                prefix_count += 1

            prefix_count %= modulo
            key = (prefix_count - k + modulo) % modulo
            if key in mod_freq:
                interest_sub_arrays += mod_freq[key]

            mod_freq[prefix_count] += 1
            pos += 1


        return interest_sub_arrays

if __name__ == "__main__":
    sol = Solution()
    nums = [2, 10, 5, 8, 17]
    modulo = 3
    k = 2
    print(sol.countInterestingSubarrays(nums, modulo, k))