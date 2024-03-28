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
const ll M = 1e9 + 7;

using namespace std;

ll qmi(ll a, ll b)
{
    ll ret = 1;
    while (b)
    {
        if (b & 1)
            ret = ret * a;
        b /= 2;
        a = a * a;
    }
    return ret;
}

ll gcd(ll a, ll b)
{
    if (a < b)
        swap(a, b);
    return b ? gcd(b, a % b) : a;
}

void Jian()
{
    // string s, t;
    // cin >> s >> t;
    // ll n = s.length(), m = t.length();
    // s = " " + s;
    // t = " " + t;
    // ll nxt[m + 1] = {0};
    // ll j = 0;
    // rep(i, 2, m)
    // {
    //     while (j > 0 && t[j + 1] != t[i])
    //         j = nxt[j];
    //     if (t[j + 1] == t[i])
    //         j++;
    //     nxt[i] = j;
    // }
    // j = 0;
    // vector<ll> ans;
    // rep(i, 1, n)
    // {
    //     while ((j == m) || (j > 0 && t[j + 1] != s[i]))
    //         j = nxt[j];
    //     if (t[j + 1] == s[i])
    //         j++;
    //     if (j == m)
    //         ans.push_back(i - m + 1);
    // }
    // if (ans.size() == 0)
    //     cout << -1 << endl << -1 << endl;
    // else
    // {
    //     cout << ans.size() << endl;
    //     for (auto i : ans)
    //         cout << i << " ";
    //     cout << endl;
    // }

    string s, t;
    cin >> s >> t;
    ll n = s.length(), m = t.length();
    t =  " " +  t + "#" + s;
    ll nxt[n + m + 1] = {0};
    ll j = 0;
    rep(i, 2, n + m + 1)
    {
        while (j > 0 && t[j + 1] != t[i])
            j = nxt[j];
        if (t[j + 1] == t[i])
            j++;
        nxt[i] = j;
    }   
    vector<ll> ans;
    rep(i, m + 1, n + m + 1)
        if (nxt[i] == m)
            ans.push_back(i - 2 * m);
    if (ans.size() == 0)
        cout << -1 << endl << -1 << endl;
    else
    {
        cout << ans.size() << endl;
        for (auto i : ans)
            cout << i << " ";
        cout << endl;
    }
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    cin >> _;
    while (_--)
        Jian();
    return 0;
}