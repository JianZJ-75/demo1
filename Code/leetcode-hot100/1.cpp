#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b) {
    if (a < b)
        swap(a, b);
    return b ? gcd(b, a % b) : a;
}

void solve() {
    int n;
    cin >> n;
    int a[n + 1];
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    int target;
    cin >> target;
    map<int, int> mp;
    for (int i = 1; i <= n; i++) {
        if (mp[target - a[i]] != 0 ) {
            cout << i - 1 << " " << mp[target - a[i]] - 1 << endl;
            return;
        }
        mp[a[i]] = i;
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