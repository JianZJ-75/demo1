#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define pii pair<ll, ll>
#define x first
#define y second
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const ll MOD = 1e9 + 7;

using namespace std;

ll n, m, ans;
string s, t;
ll f[26];

// dp求中间子序列总数
ll dp(string tmp)
{
    ll res = 0;
    ll len = tmp.length();
    rep(i, 0, len - 1)
    {
        ll c = tmp[i] - 'a';
        ll ttmp = res - f[c];
        f[c] = (1 + res) % MOD;
        res = (((f[c] + ttmp) % MOD) + MOD) % MOD;
    }
    return (res + 1) % MOD;
}

// 哈希求重合
void calc(ll x)
{
    ll p1 = 0, q1 = 0, p2 = 0, q2 = 0, k1 = 1, k2 = 1;
    ll base1 = 233, base2 = 131;
    rep(i, 0, m - 1)
    {
        ll d = m - i - 1;
        p1 = (p1 * base1 + t[d] - 'a') % MOD;
        q1 = ((t[d] - 'a') * k1 + q1) % MOD;
        k1 = k1 * base1 % MOD;
        p2 = (p2 * base2 + t[d] - 'a') % MOD;
        q2 = ((t[d] - 'a') * k2 + q2) % MOD;
        k2 = k2 * base2 % MOD;
        if (i + 1 >= x && p1 == q1 && p2 == q2)
            ans++,
            ans %= MOD;
    }
}

void Jian()
{
    cin >> n >> m;
    cin >> s >> t;
    ll cnt = 0;
    ll l = 0, r = n - 1;
    for (ll i = 0; l < n; l++)
        if (s[l] == t[i])
        {
            cnt++;
            i++;
            if (cnt == m)
                break;
        }
    if (cnt < m)
    {
        cout << 0 << endl;
        return;
    }
    cnt = 0;
    for (ll i = 0; r >= 0; r--)
        if (s[r] == t[i])
        {
            cnt++;
            i++;
            if (cnt == m)
                break;
        }
    if (cnt < m)
    {
        cout << 0 << endl;
        return;
    }
    if (l < r)
        ans += dp(s.substr(l + 1, r - l - 1)),
        ans %= MOD;
    cnt = 0;
    r = n - 1;
    for (ll i = 0; r > l; r--)
        if (s[r] == t[i])
        {
            cnt++;
            i++;
            if (cnt == m)
                break;
        }
    calc(m - cnt);
    cout << ans << endl;
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--)
        Jian();
    return 0;
}