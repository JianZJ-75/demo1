#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    for (int i = 0; i < n - 2; i++) {
        if (i > 1 && a[i] == a[i - 1])
            continue;
        int l = i + 1, r = n - 1;
        while (l < r) {
            int tmp = a[i] + a[l] + a[r];
            if (tmp > 0)
                r--;
            else if (tmp == 0) {
                cout << a[i] << " " << a[l] << " " << a[r] << endl;
                while (l + 1 <= r && a[l + 1] == a[l])
                    l++;
                l++;
                while (r - 1 >= l && a[r - 1] == a[r])
                    r--;
                r--;
            } else {
                l++;
            }
        }
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