#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n ;
    cin >> n;
    int* a = new int[n];
    int* suf = new int[n + 1];
    suf[n] = 1;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for (int i = n - 1; i >= 0; i--) {
        suf[i] = suf[i + 1] * a[i];
    }
    int pre = 1;
    for (int i = 0; i < n; i++) {
        suf[i] = pre * suf[i + 1];
        pre *= a[i];
    }
    for (int i = 0; i < n; i++)
        cout << suf[i] << " ";
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