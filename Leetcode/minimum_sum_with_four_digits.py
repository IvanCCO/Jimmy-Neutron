# The input(k) with lenght 4 is a integer number with four digits
# and i have to split the number into two pieces, p1, p2
# and return the minimum sum (p1 + p2)
# Example:
# k = 3023
# The two pieces can be
# A = p1=3 p2=023 where (p1 + p2) == 26  or
# B = p1=30 p2=23 where (p1 + p2) == 53 or
# C = p1=302 p2=3 where (p1 + p2) == 305
# So the best solution is A and the return value is 26
# Cause is the minimum value of the sum of the two parts


# I though on a bad solution but i think its is a solution
# 
# With a 4 length int number the max number of variantion is 3
# So i will put all three variations on a array and iterate over it
# to get the minimum value 
def minimumSumBadSolution(k : int):
    print(k)
    return k

