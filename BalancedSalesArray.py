class Solution:
    """
    @param sales: a integer array
    @return: return a Integer
    """
    import itertools
    def BalancedSalesArray(self, sales):
        # write your code here
        left,right = [],[]
        leftsum = rightsum = 0
        n = len(sales)
        for i in range(n):
            leftsum += sales[i] 
            left.append(leftsum)
            rightsum += sales[n-1-i]
            right.append(rightsum)
            

        n = len(sales)
        for i in range(n):
            if left[i] == right[n-1-i]:
                return i 
        return -1
        
        
    # https://nataliekung.gitbook.io/ladder_code/twitter-oa/balanced-sales-array