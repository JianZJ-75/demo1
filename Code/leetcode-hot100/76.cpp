#include <bits/stdc++.h>

using namespace std;

void solve() {
    string s, t;
    cin >> s >> t;
    int n = s.length(), m = t.length();
    map<int, int> mp;
    int cnt = 0;
    for (int i = 0; i < m; i++) {
        mp[t[i] - 'a']++;
        if (mp[t[i] - 'a'] == 1)
            cnt++;
    }
    int l = 0;
    string ans = "";
    int len = 1e6;
    for (int r = 0; r < n; r++) {
        mp[s[r] - 'a']--;
        if (mp[s[r] - 'a'] == 0)
            cnt--;
        while (mp[s[l] - 'a'] < 0) {
            mp[s[l] - 'a']++;
            l++;
        }
        if (cnt == 0) {
            if (r - l + 1 < len)
                ans = s.substr(l, r - l + 1);
        }
        
    }
    cout << ans << endl;
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