def waitingTime(tickets, p):
    return sum([min(tickets[i], tickets[p]) if i<=p else min(tickets[i], tickets[p] - 1) for i in range(len(tickets))])