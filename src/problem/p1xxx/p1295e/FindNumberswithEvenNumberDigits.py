class Solution(object):
    def findNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def count_number_of_digits(n):
            count = 0
            while n != 0:
                count += 1
                n //= 10
            return count

        res = 0
        for num in nums:
            if count_number_of_digits(num) & 1 == 0:
                res += 1
        return res


if __name__ == "__main__":
    sol = Solution()
    nums = [1,22,1]
    print(sol.findNumbers(nums))