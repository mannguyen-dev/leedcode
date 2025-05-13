class Solution(object):

    def lengthAfterTransformations(self, s, t):
        """
        :type s: str
        :type t: int
        :rtype: int
        """

        MOD = 1000000007

        def mod_add(a, b):
            return ((a % MOD) + (b % MOD)) % MOD

        sfreq = [0] * 26

        for c in s:
            sfreq[ord(c) - ord('a')] += 1

        for _ in range(t):
            next_freq = [0] * 26
            for j in range(26):
                if j < 25:
                    next_freq[j+1] = sfreq[j]
                else:
                    next_freq[0] = sfreq[25]
                    next_freq[1] = mod_add(next_freq[1], sfreq[25])
            sfreq = next_freq

        string_size = 0
        for num in sfreq:
            string_size = mod_add(string_size, num)

        return string_size

if __name__ == "__main__":
    sol = Solution()
    s = "abcyy"
    t = 2
    print(sol.lengthAfterTransformations(s, t))