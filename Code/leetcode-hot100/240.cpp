#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n, m, k;
    cin >> n >> m >> k;
    int** a = new int*[n + 1];
    for (int i = 1; i <= n; i++) {
        a[i] = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            cin >> a[i][j];
        }
    }
    for (int i = 1; i <= n; i++) {
        if (a[i][1] > k)
            break;
        int l = 0, r = m + 1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[i][mid] <= k)
                l = mid;
            else
                r = mid;
        }
        if (a[i][l] == k)
        {
            cout << "true";
            return;
        }
    }
    cout << "false";
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