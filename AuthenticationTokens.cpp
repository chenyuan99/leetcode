#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>

using namespace std;

int numberOfTokens(int expiryLimit, vector<vector> commands)
{

    unordered_map<int, int> mp;
    int time = 0;

    for (int c = 0; c < commands.size(); c++)
    {

        int action = commands[c][0];
        int token_id = commands[c][1];
        time = commands[c][2];

        if (action == 0)
        {
            mp[token_id] = expiryLimit + time;
        }

        else if (action == 1)
        {
            if (mp.count(token_id))
            {
                int expiry_time = mp[token_id];
                if (expiry_time >= time)
                {
                    mp[token_id] = time + expiryLimit;
                }
            }
        }
    }
    int count = 0;
    for (const auto &ele : mp)
    {
        if (ele.second >= time)
        {
            count++;
        }
    }
    //cout<<time;
    return count;

    // https://leetcode.com/discuss/interview-question/378237/Twitter-or-OA-2019-or-Authentication-Tokens
}