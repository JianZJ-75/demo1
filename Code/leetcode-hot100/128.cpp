#include <bits/stdc++.h>

using namespace std;

void solve() {
    set<int> st;
    int n;
    cin >> n;
    int a[n + 1];
    for (int i = 0; i <= n; i++) {
        cin >> a[i];
        st.insert(a[i]);
    }
    int pre;
    int cnt = 0;
    int ans = 1;
    for (auto i : st) {
        if (cnt == 0) {
            cnt++;
            pre = i;
        } else {
            if (i != pre + 1) {
                ans = max(ans, cnt);
                cnt = 1;
                pre = i;
            } else {
                cnt++;
                pre = i;
            }
        }
    }
    cout << max(ans, cnt) << endl;
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