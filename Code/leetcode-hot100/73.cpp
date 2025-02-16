#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;
    int** a = new int*[n + 1];
    for (int i = 1; i <= n; i++) {
        a[i] = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            cin >> a[i][j];
        }
    }
    bool ok = 0;
    for (int i = 1; i <= n; i++) {
        if (a[i][1] == 0)
            ok = 1;
        for (int j = 1; j <= m; j++) {
            if (a[i][j] == 0) {
                a[i][1] = 0;
                a[1][j] = 0;
            }
        }
    }
    for (int i = n; i >= 1; i--) {
        for (int j = 2; j <= m; j++) {
            if (a[i][1] == 0 || a[1][j] == 0)
                a[i][j] = 0;
        }
        if (ok)
            a[i][1] = 0;
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
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