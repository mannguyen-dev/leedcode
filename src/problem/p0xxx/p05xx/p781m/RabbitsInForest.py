from collections import defaultdict


class Solution:
    def numRabbits(self, answers):
        group_freq = defaultdict(int)
        count = 0

        for ele in answers:
            if ele == 0:
                count += 1
            else:
                group_freq[ele] += 1
                if group_freq[ele] == ele + 1:
                    count += ele + 1
                    group_freq[ele] = 0

        for group, freq in group_freq.items():
            if freq > 0:
                count += group + 1

        return count

if __name__ == '__main__':
    # Example usage
    solution = Solution()
    answers = [1, 1, 2]
    print(solution.numRabbits(answers))  # Output: 5