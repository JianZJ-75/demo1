#include <bits/stdc++.h>

using namespace std;

unordered_map<int, bool> mp1, mp2;
int *p, *c;
string s;

void dfs(int n, vector<vector<string>> &ans, int now) {
    if (now == n) {
        vector<string> tmp;
        for (int i = 0; i < n; i++) {
            s[p[i]] = 'Q';
            tmp.push_back(s);
            s[p[i]] = '.';
        }
        ans.push_back(tmp);
        return;
    }
    for (int i = 0; i < n; i++) {
        int t = now - i + n - 1;
        if (!c[i] && !mp1[now + i] && !mp2[t]) {
            p[now] = i;
            c[i] = 1;
            mp1[now + i] = 1;
            mp2[t] = 1;
            dfs(n, ans, now + 1);
            c[i] = 0;
            mp1[now + i] = 0;
            mp2[t] = 0;
        }
    }
}

vector<vector<string>> solveNQueens(int n) {
    vector<vector<string>> ans;
    p = new int[n];
    c = new int[n];
    for (int i = 0; i < n; i++) {
        s += '.';
    }
    dfs(n, ans, 0);
    return ans;
}

void solve() {
    
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--) {
        solve();
    }
    return 0;
}