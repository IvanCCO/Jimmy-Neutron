from typing import List
import random

class MinStack:

    def __init__(self):
        self.stack = [] # o(1)

    def push(self, val: int) -> None:

        actual_min = val if not self.stack else min(val, self.getMin()) # o(1)
        self.stack.append({'value': val, 'min_value': actual_min}) # o(1)
        

    def pop(self) -> None:
        self.stack.pop() # o(1)
        

    def top(self) -> int:
        return self.stack[-1]["value"] # o(1)
        

    def getMin(self) -> int:
        return self.stack[-1]["min_value"] # 0(1)
        

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

    def checkValid(self, matrix: List[List[int]]) -> bool:
        # iterar nas linhas e verificar se as linhas são validas
        n = len(matrix)

        for row in matrix:
            if len(set(row)) != n:
                return False

        for colum in zip(*matrix):
            if len(set(colum)) != n:
                return False

        return True

    def longestConsecutive(self, nums: List[int]) -> int:

        # Funciona mas não está otimizado
        #
        # o(n)
        new_set = set(nums)
        res = 0

        # o(n) * o(n) = o(n**2)
        for num in nums:
            
            search_number = num
            consectiveCounter = 0

            # o(n)
            while search_number in new_set:
                search_number += 1
                consectiveCounter += 1

            res = max(res, consectiveCounter)


        return res

    def threeSum(self, nums: List[int]) -> List[List[int]]:

        res = []

        nums.sort()

        for fixed in range(len(nums)):

            if fixed > 0 and nums[fixed] == nums[fixed - 1]:
                continue

            left = fixed + 1

            right = len(nums) - 1


            while left < right:

                total = nums[fixed] + nums[left] + nums[right]

                if total < 0:
                    left += 1
                elif total > 0:
                    right -= 1
                else:
                    res.append([nums[fixed] , nums[left] , nums[right]])
                    left += 1

                    while nums[left] == nums[left - 1] and left < right:
                        left += 1


        return res

    def maxArea(self, height: List[int]) -> int:

        left = 0
        right = len(height) - 1

        max_area = 0

        while left < right:

            base = right - left
            altura = min(height[right], height[left])

            max_area = max(max_area, base * altura)

            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1

        return max_area

    def isValid(self, s: str) -> bool:
        
        close_carecters = [")", "]", "}"]
        expected_close = []


        for char in s:
            if char in close_carecters:
                if len(expected_close) == 0:
                    return False
                
                if not expected_close.pop() == char:
                    return False
            
            if char == '(':
                expected_close.append(')')
            elif char == '[':
                expected_close.append(']')
            elif char == '{':
                expected_close.append('}')

        return len(expected_close) == 0



s = Solution()
minStack = MinStack() # 0(1)
