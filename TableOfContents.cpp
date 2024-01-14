#include<bits/stdc++.h>
using namespace std;

vector<string> ans(vector<string>& input){
    vector<string> res = input;
    int a = 0, b = 0;
    int n = res.size();
    for(int i=0; i<n; i++){
        string str = res[i];
        if(str[1] == '#'){
            //   ## board
        //     1.1. board
            b++;
            string k = "  " + res[i];
            k[0] = a+'0';
            k[1] = '.';
            k[2] = b+'0';
            k[3] = '.';
            res[i] = k;
        }else{
//              # summ
            // 1. summ
            a++;
            b = 0;
            string k = "a" + res[i];
            k[0] = a + '0';
            k[1] = '.';
            res[i] = k;
        }
    }
    return res;
}

int main() {
    int n = 10;
    vector<string> input = {"# games","## games","## gam","## ff","# second","## sec","## seco","# hello","# first","# summary"};
    vector<string> output = ans(input);
    for(int i=0;i<output.size();i++){
        cout<< output[i] << endl;
    }
    return 0;
}

// https://leetcode.com/discuss/interview-question/1489502/new-hackerrank-question