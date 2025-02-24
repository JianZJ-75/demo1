#include <bits/stdc++.h>

using namespace std;

int coinChange(vector<int>& coins, int amount) {
    int f[amount + 1];
    for (int i = 0; i <= amount; i++)
        f[i] = 0x3f3f3f3f / 2;
    f[0] = 0;
    for (auto x : coins) {
        for (int j = x; j <= amount; j++) {
            f[j] = min(f[j], f[j - x] + 1);
        }
    }
    return f[amount] < (0x3f3f3f3f / 2) ? f[amount] : -1;
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