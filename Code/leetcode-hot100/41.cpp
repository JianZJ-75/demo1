#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n ;
    cin >> n;
    int* a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        if (a[i] <= 0)
            a[i] = 0x3f3f3f3f;
    }
    for (int i = 1; i <= n; i++) {
        int tmp = abs(a[i]);
        if (tmp <= n) {
            a[tmp] = -abs(a[tmp]);
        }
    }
    for (int i = 1; i <= n; i++) {
        if (a[i] > 0) {
            cout << i << endl;
            return;
        }
    }
    cout << n + 1 << endl;
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