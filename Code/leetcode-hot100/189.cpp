#include <bits/stdc++.h>

using namespace std;

void re(int* a, int l, int r) {
    while (l < r) {
        swap(a[l], a[r]);
        l++;
        r--;
    }
}

void solve() {
    int n, k;
    cin >> n >> k;
    int* a = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    re(a, 0, n - 1);
    re(a, 0, k - 1);
    re(a, k - 1 + 1, n - 1);
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
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