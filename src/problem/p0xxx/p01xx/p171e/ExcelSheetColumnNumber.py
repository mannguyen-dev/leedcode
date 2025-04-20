class Solution(object):
    def title_to_number(self, column_title):
        """
        :type column_title: str
        :rtype: int
        """
        ans = 0
        for i in range(len(column_title)):
            ans = ans * 26 + ord(column_title[i]) - ord('A') + 1
        return ans

if __name__ == '__main__':
    # Example usage
    solution = Solution()
    column_title = "ZY"
    print(solution.title_to_number(column_title))  # Output: 28