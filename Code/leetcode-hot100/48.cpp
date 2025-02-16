#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n;
    cin >> n;
    int** a = new int*[n + 1];
    for (int i = 1; i <= n; i++) {
        a[i] = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            cin >> a[i][j];
        }
    }
    for (int i = 1; i <= n / 2; i++) {
        for (int j = 1; j <= (n + 1) / 2; j++) {
            int tmp = a[i][j];
            a[i][j] = a[n - j + 1][i];
            a[n - j + 1][i] = a[n - i + 1][n - j + 1];
            a[n - i + 1][n - j + 1] = a[j][n - i + 1]; 
            a[j][n - i + 1] = tmp;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
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