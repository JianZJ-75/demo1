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

using namespace std;

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

void Jian()
{
    ll n, k;
    priority_queue<ll> q;
    cin >> n >> k;
    rep(i, 1, n)
    {
        ll x;
        cin >> x;
        q.push(x);
    }
    if (k == 1)
    {
        cout << q.top() << endl;
        return;
    }
    ll ans = q.top(), cnt = 0;
    while (!q.empty())
    {
        ll t = q.top();
        q.pop();
        t /= k;
        cnt++;
        if (t)
            q.push(t);
        if (!q.empty())
            ans = min(ans, q.top() + cnt);
        else
            ans = min(ans, cnt);
    }
    cout << ans << endl;
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // _ = read();
    while (_--)
        Jian();
    return 0;
}