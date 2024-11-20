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


        tamanhoMaiorSubstring = 0

        for i in range(0, len(s)):
            charSet = set()
            for j in range(i, len(s)):
                if s[j] in charSet:
                    break
                charSet.add(s[j])
            
            if len(charSet) > tamanhoMaiorSubstring:
                tamanhoMaiorSubstring = len(charSet)

            if (len(s) - i) < tamanhoMaiorSubstring:
                break

        return tamanhoMaiorSubstring

s = Solution()
print(s.lengthOfLongestSubstring(""))
print(s.lengthOfLongestSubstring("ckilbkd"))
print(s.lengthOfLongestSubstring("tmmzuxt"))
print(s.lengthOfLongestSubstring("dvdf"))

