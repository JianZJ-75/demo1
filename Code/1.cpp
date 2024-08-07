#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <unordered_map>
#include <unordered_set>
#include <vector>

#define pb push_back
#define all0(a) a.begin(), a.end()
#define all1(a) a.begin() + 1, a.end()
#define int long long
using namespace std;
typedef long long LL;
typedef pair<int, int> PII;
typedef pair<double, int> PDI;
const int N = 1e6 + 10, INF = 0x3f3f3f3f, MOD = 1e9 + 7,P = 1e9 + 7,P_ = 101;

string s,t;  
int n, m, l, r, ans; 
int dp[N], lst[27];  

// 计算以T为前缀的子序列数
void work1() {
    cout << l << " " << r << endl;
    for (int i = l + 1; i < r; i++) {
        if (lst[s[i] - 'a'])    dp[i] = (dp[i - 1] * 2 - dp[lst[s[i] - 'a'] - 1]) % P;
        else    dp[i] = (dp[i - 1] * 2 + 1) % P;
        lst[s[i] - 'a'] = i;
    }
    ans = dp[r - 1] % P + 1; 
}

// 计算哈希值，检查T是否为子序列的前缀
void work2(int x) {
    int p = 0, q = 0, p_ = 0, q_ = 0, k = 1, k_ = 1;
    for (int i = 0; i < m; i++) {
        // 计算正向和逆向的哈希值
        p = p * P + t[m - i - 1] - 'a';
        q = (t[m - i - 1] - 'a') * k + q;
        k = k * P;
        p_ = p_ * P_ + t[m - i - 1] - 'a';
        q_ = (t[m - i - 1] - 'a') * k_ + q_;
        k_ = k_ * P_;
        // 如果两个哈希值相等，说明匹配，增加答案
        if (i >= x - 1 && p == q && p_ == q_)   ans++;
    }
}
void solve() {
    cin >> n >> m >> s >> t;
    int k = 0;

    for (l = 0; l < n; l++) {
        if (s[l] == t[k]) k++;
        if (k == m) break;
    }
    if (k < m) {
        cout << 0;
        return;
    }

    k = 0;
    for (r = n - 1; r > l; r--) {
        if (s[r] == t[k]) k++;
        if (k == m) break;
    }
    cout << l << " " << r << endl;
    if (l < r) work1();
    work2(m - k);

    cout << (ans % P + P) % P;
}
signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int T = 1;
    // cin >> T;
    while (T--) {
        solve();
    }
    return 0;
}