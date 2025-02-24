#include <bits/stdc++.h>

using namespace std;

int longestCommonSubsequence(string text1, string text2) {
    int n = text1.length();
    int m = text2.length();
    int f[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
        memset(f[i], 0, sizeof(f[i]));
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            f[i + 1][j + 1] = text1[i] == text2[j] ? f[i][j] + 1 : max(f[i][j + 1], f[i + 1][j]);
        }
    }
    return f[n][m];
}

void solve() {
    
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