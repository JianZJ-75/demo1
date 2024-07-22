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
    string url;
    cin >> url;
    vector<string> ans;
    int n = url.length();
    string a1, a2;
    int l = 0;
    bool b1 = 1, b2 = 1;
    rep(i, 0, n - 1)
    {
        if (b1 && url[i] == ':' && url[i + 1] == '/' && url[i + 2] == '/')
        {
            b1 = 0;
            a1 = url.substr(l, i);
            l = i + 3;
            i = i + 2;
        }
        else if (b2 && url[i] == '/')
        {
            if (l == i)
            {
                l++;
                continue;
            }
            b2 = 0;
            a2 = url.substr(l, i - l);
            l = i + 1;
        }
        else if (!b1 && !b2 && url[i] == '/')
        {
            if (l == i)
            {
                l++;
                continue;
            }
            string tmp = url.substr(l, i - l);
            int len = tmp.length();
            int cnt = 0, idx = -1;
            rep(j, 0, len - 1)
            {
                if (tmp[j] == '=')
                {
                    cnt++;
                    idx = j;
                }
            }
            if (cnt == 1 && idx != 0 && idx != len - 1)
                ans.push_back(tmp);
            l = i + 1;
        }
    }
    if (l < n)
    {
        string tmp = url.substr();
        int len = tmp.length();
        int cnt = 0, idx = -1;
        rep(j, 0, len - 1)
        {
            if (tmp[j] == '=')
            {
                cnt++;
                idx = j;
            }
        }
        if (cnt == 1 && idx != 0 && idx != len - 1)
            ans.push_back(tmp);
    }
    cout << a1 << endl;
    cout << a2 << endl;
    for (auto i : ans)
    {
        cout << i << endl;
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