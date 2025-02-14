#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int r = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] != 0) {
            a[r++] = a[i];
        }
    }
    for (int i = r; i < n; i++) {
        a[i] = 0;
    }
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
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