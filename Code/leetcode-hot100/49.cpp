#include <bits/stdc++.h>

using namespace std;

string calc(string x) {
    vector<char> tmp;
    for (int i = 0; i < x.length(); i++) {
        tmp.push_back(x[i]);
    }
    sort(tmp.begin(), tmp.end());
    string res = "";
    for (auto i : tmp) {
        res += i;
    }
    return res;
}

void solve() {
    int n;
    cin >> n;
    string a[n + 1];
    string b[n + 1];
    map<string, vector<string>> mp;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        b[i] = calc(a[i]);
        mp[b[i]].push_back(a[i]);
    }
    for (auto i : mp) {
        for (auto j : i.second) {
            cout << j << " ";
        }
        cout << endl;
    }
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