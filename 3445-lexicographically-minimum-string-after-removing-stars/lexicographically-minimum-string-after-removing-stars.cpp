class Solution {
public:
    string clearStars(string s) {
        int n = s.length();
        vector<char> arr;
        for (int i = 0;i < n;i++) {
            arr.push_back(s[i]);
        }
        map<char, vector<int>> mp;
        int i = 0;
        while (i < n) {
            if (s[i] != '*') {
                mp[s[i]].push_back(i);
            }
            else {
                arr[mp[mp.begin()->first][mp[mp.begin()->first].size()-1]] = '/';
                mp[mp.begin()->first].pop_back();
                if (mp[mp.begin()->first].size() == 0) {
                    mp.erase(mp.begin()->first);
                }
            }
            i++;
        }
        string ans = "";
        for (auto it : arr) {
            if (int(it) >= 97 and int(it) <= 122) ans += it;
        }
        return ans;
    }
};