from collections import defaultdict


class Solution(object):
    def countLargestGroup(self, n):
        """
        :type n: int
        :rtype: int
        """
        def countSumDigits(n):
            _sum = 0
            while n != 0:
                _sum += n % 10
                n //= 10
            return _sum

        _map = defaultdict(list)
        for i in range(1, n + 1):
            _map[countSumDigits(i)].append(i)

        _max = 0
        count = 0
        for k, v in _map.items():
            if _max < len(v):
                _max = len(v)
                count = 1
            elif _max == len(v):
                count += 1

        return count

    def countLargestGroup2(self, n):
        """
        :type n: int
        :rtype: int
        """

        def countSumDigits(num):
            return sum(int(d) for d in str(num))

        digit_sum_counts = defaultdict(int)
        for i in range(1, n + 1):
            digit_sum_counts[countSumDigits(i)] += 1

        max_size = max(digit_sum_counts.values())
        return sum(1 for count in digit_sum_counts.values() if count == max_size)

if __name__ == "__main__":
    sol = Solution()
    res = sol.countLargestGroup2(13)
    print(res)
