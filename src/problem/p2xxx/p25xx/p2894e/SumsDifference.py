class Solution(object):
    def differenceOfSums(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        divisible = 0
        non_divisible = 0
        for i in range(1, n + 1):
            print(i)
            if i % m == 0:
                divisible += i
            else:
                non_divisible += i

        return non_divisible - divisible


if __name__ == "__main__":
    sol = Solution()
    n = 10
    m = 3
    print(sol.differenceOfSums(n, m))
