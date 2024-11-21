from typing import List
import random

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        k = len(nums) - k

        def quickSelect(l, r):
            rand = random.randint(l, r)
            nums[rand], nums[r] = nums[r], nums[rand]
            pivot, pivotPos = nums[r], l
            # r is not included
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[pivotPos], nums[i] = nums[i], nums[pivotPos]
                    pivotPos += 1

            nums[pivotPos], nums[r] =  nums[r], nums[pivotPos]

            if pivotPos > k: 
                return quickSelect(l, pivotPos - 1)
            elif pivotPos < k:
                return quickSelect(pivotPos + 1, r)
            else:
                return nums[pivotPos]


        return quickSelect(0, len(nums) - 1)

    def lengthOfLongestSubstring(self, s: str) -> int:

        # Solução o(n**2)
        # tamanhoMaiorSubstring = 0
        #
        # for i in range(0, len(s)):
        #     charSet = set()
        #     for j in range(i, len(s)):
        #         if s[j] in charSet:
        #             break
        #         charSet.add(s[j])
        #
        #     if len(charSet) > tamanhoMaiorSubstring:
        #         tamanhoMaiorSubstring = len(charSet)
        #
        #     if (len(s) - i) < tamanhoMaiorSubstring:
        #         break
        #
        # return tamanhoMaiorSubstring
        #

        # Solução o(n)
        left = max_substring = 0
        char_set = set()

        for right in range(len(s)):

            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1

            char_set.add(s[right])
            max_substring = max(max_substring, (right - left + 1) )

        return max_substring

    def maximumUniqueSubarray(self, nums: List[int]) -> int:

        left = max_subarray_sum = 0
        char_set = set()

        temp_max = 0
        for right in range(len(nums)):

            while nums[right] in char_set:
                char_set.remove(nums[left])
                temp_max -= nums[left]
                left += 1

            char_set.add(nums[right])
            temp_max += nums[right]

            max_subarray_sum = max(max_subarray_sum, temp_max)

        return max_subarray_sum

    # O(n log n)
    def quickSort(self, nums: List[int]) -> List[int]:

        if len(nums) <= 1:
            return nums

        pivot = nums[0]
        less = [i for i in nums[1:] if i <= pivot]
        greater = [i for i in nums[1:] if i > pivot]

        return self.quickSort(less) + [pivot] + self.quickSort(greater)

s = Solution()

