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


def minium_sum_bad_solution(k: str):
    sum = 0
    number_string = str(k)
    for i in range(1, len(number_string)):
        x = number_string[:i]
        y = number_string[i:]
        current_sum = int(x) + int(y)
        if i == 1:
            sum = current_sum
        if current_sum < sum:
            sum = current_sum
        print(x)
        print(y)
    print(sum)
    return sum


# ==========================
# I can switch the position of the numbers LOL
# All though i'll not delete the lines above
# ==========================


# On this solution i have convert my integer number to string_sort
# and get the first 2 numbers, the 2 minor numbers, those numbers
# are the ones that have to be the first number cause the decimal value
# should be minor.
# this is not a good solution
def minium_sum(k: str):
    string_sort = sorted(k)
    x = string_sort[:2]
    y = string_sort[2:]

    total_x = int(f"{x[0]}{y[0]}")
    total_y = int(f"{x[1]}{y[1]}")

    return total_x + total_y


def minium_sum_simplified(num: int):
    string_sort = sorted(str(num))
    return int((string_sort[0] + string_sort[2])) + int(
        (string_sort[1] + string_sort[3])
    )


print(minium_sum_simplified(int(input("Number \n"))))
