#include <bits/stdc++.h>

using namespace std;

int maxProfit(vector<int>& prices) {
    int ans = 0;
    int n = prices.size();
    int mx = 0;
    for (int i = n - 1; i >= 0; i--) {
        ans = max(ans, mx - prices[i]);
        mx = max(mx, prices[i]);
    }
    return ans;
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