class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        res = 0b0
        for _ in range(32):
            res <<= 1
            res |= (n & 1)
            n >>= 1
        return res


if __name__ == "__main__":
    sol = Solution()
    n = 0b00000010100101000001111010011100
    print(sol.reverseBits(n))