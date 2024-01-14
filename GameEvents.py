def getEventsOrder(team1,team2,events1,events2):
    events = []
    for e in events1:
        events.append(team1+ ' '+e)
    for e in events2:
        events.append(team2+ ' '+e)    
    parsed1 = parse(events1,team1)
    parsed2 = parse(events2,team2)
    #types = ['G','Y','R','S']
    
    merged = parsed1 + parsed2
    idxSorted = sorted([i for i in range(len(merged))],key = lambda x:(merged[x][2],merged[x][3],convert(merged[x][4]),merged[x][0],merged[x][1],merged[x][5]))
    
    res = []
    for i in idxSorted:
        res.append(events[i])
    
    return res    

def timeIndex(l):
    for i,item in enumerate(l):
        if item.isdigit():
            return i
        elif '+' in item:
            new = item.split('+')
            flag = True
            for n in new:
                if not n.isdigit():
                    n = False
            if flag:
                return i
            
            

def parse(events,team):
    parsed = []
    for event in events:
        sp = event.split(' ')
        idx = timeIndex(sp)
        #print(idx)
        record = []
        record.append(team)
        player = ' '.join(sp[:idx])
        record.append(player)
        timeSeg = sp[idx]
        times = calcExtra(timeSeg)
        record.append(times[0]) #time
        record.append(times[1]) #extra
        record.append(sp[idx+1]) [#event](https://leetcode.com/problems/cut-off-trees-for-golf-event) name
        if len(sp) == idx + 3: # substitute exists:
            record.append(sp[-1])
        else:
            record.append('')
        
        
        parsed.append(record)
    
    return parsed    
            
        
        
        
   


def calcExtra(timeSeg):
    if not timeSeg.isdigit():
        times = timeSeg.split('+')
    else:
        times = [timeSeg,'0']
    return times      

def convert(event):
    if event == 'G':
        return 0
    elif event == 'Y':
        return 1
    elif event == 'R':
        return 2
    elif event == 'S':
        return 3
