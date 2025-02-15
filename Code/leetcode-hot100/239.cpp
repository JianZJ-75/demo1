#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    map<int, int> mp;
    priority_queue<int> q;
    for (int i = 0; i < n; i++) {
        if (i >= k) {
            cout << q.top() << " ";
            mp[a[i - k]]--;
            while(mp[q.top()] <= 0) {
                q.pop();
            }
        }
        q.push(a[i]);
        mp[a[i]]++;
    }
    cout << q.top() << endl;
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