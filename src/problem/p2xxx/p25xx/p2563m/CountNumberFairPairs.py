def countFairPairs(self, nums, lower, upper):
    """
    :type nums: List[int]
    :type lower: int
    :type upper: int
    :rtype: int
    """
    def lower_bound(start, end, target):
        while start < end:
            mid = start + (end - start) // 2
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        return start

    def upper_bound(start, end, target):
        while start < end:
            mid = start + (end - start) // 2
            if nums[mid] <= target:
                start = mid + 1
            else:
                end = mid
        return start

    nums.sort()
    n = len(nums)
    count = 0
    for i in range(n - 1):
        lb = lower_bound(i + 1, n, lower - nums[i])
        ub = upper_bound(i + 1, n, upper - nums[i])
        count += ub - lb

    return count

# Main function to test the solution
if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    lower = 2
    upper = 5
    result = countFairPairs(None, nums, lower, upper)
    print(f"Count of fair pairs: {result}")