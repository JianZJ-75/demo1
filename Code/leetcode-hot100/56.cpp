#include <bits/stdc++.h>

using namespace std;

bool cmp(int* a, int* b) {
    return a[0] < b[0];
}

void solve() {
    int n;
    cin >> n;
    int** a = new int*[n + 1];
    for (int i = 1; i <= n; i++) {
        a[i] = new int[2];
        cin >> a[i][0] >> a[i][1];
    }
    sort(a + 1, a + 1 + n, cmp);
    vector<int*> ans;
    ans.push_back(new int[2]{a[1][0], a[1][1]});
    for (int i = 2; i <= n; i++) {
        if (a[i][0] <= ans.back()[1])
            ans.back()[1] = max(ans.back()[1], a[i][1]);
        else
            ans.push_back(new int[2]{a[i][0], a[i][1]});
    }
    for (auto i : ans)
        cout << i[0] << " " << i[1] << endl;
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