class Solution:
    def moveZeroes(self, nums):
     """
     :type nums: List[int]
     :rtype: void Do not return anything, modify nums in-place instead.
     """
     length = len(nums)
     i,j = 0,0
     while(i < length):
         if nums[j] == 0:
             del nums[j]
             nums.append(0)
             i += 1
             continue
         j += 1
         i += 1