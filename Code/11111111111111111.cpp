#include <bits/stdc++.h>
#define ll long long
#define dd double
#define rep(i, a, b) for(ll i = a; i <= b; i++)
#define rrep(i, a, b) for(ll i = a; i >= b; i--)

using namespace std;

void Jian()
{
    ll n;
    cin >> n;
    ll a[n + 1][n + 1];
    rep(i, 1, n)
        rep(j, 1, n)    
            cin >> a[i][j];
    bool row[n + 1] = {0}, line[n + 1] = {0};
    ll ans = 0;
    rep(i, 1, n)
    {
        rep(j, 1, n)
        {
            if(a[i][j] <= 0)
            {
                ans += a[i][j];
                row[i] = 1;
                line[j] = 1;
            }
        }
    }
    ll an1 = 0, an2 = 0;
    rep(i, 1, n)
    {
        if(line[i] == 0)
        {
            ll t = a[1][i];
            rep(j, 1, n)
            {
                t = min(t, a[j][i]);
            }
            an1 += t;
        }
    }
    rep(i, 1, n)
    {
        if(row[i] == 0)
        {
            ll t = a[i][1];
            rep(j, 1, n)
            {
                t = min(t, a[i][j]);
            }
            an2 += t;
        }
    }
    // cout << ans << " " << an1 << " " << an2 << endl;
    cout << ans + min(an1, an2) << endl;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    cin >> _;
    while(_--)
        Jian();
    return 0;
}