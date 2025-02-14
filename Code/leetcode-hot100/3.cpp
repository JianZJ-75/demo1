#include <bits/stdc++.h>

using namespace std;

void solve() {
    string s;
    cin >> s;
    int n = s.length();
    int ans = 0, l = 0;
    int ok[26] = {0};
    for (int r = 0; r < n; r++) {
        int tmp = s[r] - 'a';
        if (ok[tmp] != 0) {
            while (s[l] != s[r])
                l++;
            l++;    
        }
        ok[tmp] = 1;
        ans = max(ans, r - l + 1);
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