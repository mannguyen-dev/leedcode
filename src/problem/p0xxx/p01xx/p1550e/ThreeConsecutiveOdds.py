class Solution(object):
    def threeConsecutiveOdds(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        count = 0
        for num in arr:
            if num & 1 != 0:
                count += 1
            else:
                count = 0

            if count == 3:
                return True
        return False

if __name__ == "__main__":
    sol = Solution()
    nums = [1,2,34,3,4,5,7,23,12]
    print(sol.threeConsecutiveOdds(nums))