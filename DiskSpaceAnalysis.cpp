#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>

using namespace std;

int getMax(vector<int> vec, int x){
    int n = vec.size();
    auto cmp = [](const pair<int,int>&a, const pair<int,int>&b){
        return a.first > b.first;
    };
    priority_queue<pair<int, int>, vector<pair<int,int>>, decltype(cmp)> q(cmp);
    
    for (int i = 0; i < x; ++i) {
        q.emplace(vec[i], i);
    }
    int ans = q.top().first;
    
    for (int i = x; i < n; ++i) {
        q.emplace(vec[i], i);
        while (q.top().second <= i - x) {
            q.pop();
        }
        ans = max(ans, q.top().first);
    }
    return ans;
}


int main() {
    cout << getMax({8, 3, 5, 7, 2, 6}, 2);

    return 0;
}