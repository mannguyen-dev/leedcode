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
        max_ele = max(nums)
        max_ele_count = 0

        while left < n:
            while right < n and max_ele_count < k:
                if nums[right] ==  max_ele:
                    max_ele_count += 1
                right += 1

            if max_ele_count >= k:
                count += n - right + 1
                # print(f"left: {left}, right: {right}")

            if nums[left] == max_ele:
                max_ele_count -= 1

            left += 1
        return count




if __name__ == "__main__":
    sol = Solution()
    nums = [1,3,2,3,3]
    k = 2
    print(sol.countSubarrays(nums, k))