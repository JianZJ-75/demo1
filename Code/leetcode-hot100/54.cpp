#include <bits/stdc++.h>

using namespace std;

int n, m;
int R[4] = {0, 0, 0, 1};
int cnt = 0;

// r0 d1 l2 u3
void c(int** a, int x, int y, int r) {
    cout << a[x][y] << " ";
    cnt++;
    if (cnt == n * m)
        return;
    if (r == 0) {
        if (y + 1 + R[r] <= m) {
            y++;
        } else {
            R[r]++;
            r = (r + 1) % 4;
            x++;
        }
    } else if (r == 1) {
        if (x + 1 + R[r] <= n) {
            x++;
        } else {
            R[r]++;
            r = (r + 1) % 4;
            y--;
        }
    } else if (r == 2) {
        if (y - 1 - R[r] >= 1) {
            y--;
        } else {
            R[r]++;
            r = (r + 1) % 4;
            x--;
        }
    } else {
        if (x - 1 - R[r] >= 1) {
            x--;
        } else {
            R[r]++;
            r = (r + 1) % 4;
            y++;
        }
    }
    c(a, x, y, r);
}

void solve() {
    cin >> n >> m;
    int** a = new int*[n + 1];
    for (int i = 1; i <= n; i++) {
        a[i] = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            cin >> a[i][j];
        }
    }
    c(a, 1, 1, 0);
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