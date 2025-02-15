#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int sum = 0;
    map<int, int> mp;
    mp[0]++;
    int ans = 0;
    for (int i = 0; i < n; i++) {
        sum += a[i];
        ans += mp[sum - k];
        mp[sum]++;
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