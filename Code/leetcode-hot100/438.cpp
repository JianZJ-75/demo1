#include <bits/stdc++.h>

using namespace std;

void solve() {
    string s, p;
    cin >> s >> p;
    int n = s.length(), m = p.length();
    int ss[26] = {0};
    int pp[26] = {0};
    for (int i = 0; i < m; i++) {
        ss[s[i] - 'a']++;
        pp[p[i] - 'a']++;
    }
    int l = 0;
    while (true) {
        bool ok = 1;
        for (int i = 0; i < 26; i++) {
            if (pp[i] != ss[i]) {
                ok = 0;
                break;
            }
        }
        if (ok) {
            cout << l << endl;
        }
        if (l + m > n)
            break;
        ss[s[l++] - 'a']--;
        ss[s[l + m - 1] - 'a']++;
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