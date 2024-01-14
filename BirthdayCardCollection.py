def hackerCards(collection, d):
    collection = set(collection)
    res = []
    curSum = 0
    # Write your code here
    for i in range(1, d + 1):
        if i in collection:
            continue
        if curSum + i > d:
            break
        curSum += i
        res.append(i)
    return res


    # https://leetcode.com/discuss/interview-question/1536950/twitter-oa-2022-twitter-early-career-engineering-coding-challenge-questions-and-solutions