items = [2, 3, 1, 2, 4, 2]

stack = []
finalPrice = items[:]

for i, item in enumerate(items):
    while stack and stack[-1][1] >= item:
        index, value = stack.pop()
        finalPrice[index] = value - item

    stack.append((i, item))

print(sum(finalPrice))
print(finalPrice)

# https://leetcode.com/discuss/interview-question/378221/Twitter-or-OA-2019-or-Final-Discounted-Price