#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int l = 0, r = n - 1;
    int ans = 0;
    int L = 0, R = 0;
    while (l < r) {
        L = max(L, a[l]);
        R = max(R, a[r]);
        if (L <= R) {
            ans += L - a[l++];
        } else {
            ans += R - a[r--];
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