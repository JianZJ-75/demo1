#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

struct P
{
    ll a;
    ll b;
    ll ok = 0;
    ll sum;
    ll index;
};

bool cmp1(P a, P b)
{
    if (a.a == b.a)
        return a.index < b.index;
    return a.a > b.a;
}

bool cmp2(P a, P b)
{
    if (a.b == b.b)
        return a.index < b.index;
    return a.b > b.b;
}

bool cmp3(P a, P b)
{
    if (a.sum == b.sum)
        return a.index < b.index;
    return a.sum > b.sum;
}

void Jian()
{
    ll n, x, y, z;
    cin >> n >> x >> y >> z;
    P a[n + 1];
    ll ans[n + 1];
    ll index = 0;
    rep(i, 1, n)
        cin >> a[i].a;
    rep(i, 1, n)
        cin >> a[i].b;
    rep(i, 1, n)
    {
        a[i].index = i;
        a[i].sum = a[i].a + a[i].b;
    }
    ll k = 0;
    sort(a + 1, a + 1 + n, cmp1);
    rep(i, 1, n)
    {
        if (k == x)
            break;
        if (a[i].ok == 0)
        {
            ans[++index] = a[i].index;
            a[i].ok = 1;
            k++;
        }
    }
    k = 0;
    sort(a + 1, a + 1 + n, cmp2);
    rep(i, 1, n)
    {
        if (k == y)
            break;
        if (a[i].ok == 0)
        {
            ans[++index] = a[i].index;
            a[i].ok = 1;
            k++;
        }
    }
    k = 0;
    sort(a + 1, a + 1 + n, cmp3);
    rep(i, 1, n)
    {
        if (k == z)
            break;
        if (a[i].ok == 0)
        {
            ans[++index] = a[i].index;
            a[i].ok = 1;
            k++;
        }
    }
    sort(ans + 1, ans + 1 + index);
    rep(i, 1, index)
        cout << ans[i] << endl;
}

int main()
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