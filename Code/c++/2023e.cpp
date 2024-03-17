#include <bits/stdc++.h>
#define ll long long
#define double
#define rep(i, a, b) for(ll i = a; i <= b; i++)
#define rrep(i, a, b) for(ll i = a; i >= b; i--)

using namespace std;

string s;
ll n;

ll qmi(ll a, ll b)
{
    ll ret = 1;
    while(b)
    {
        if(b & 1)
            ret = ret * a;
        b /= 2;
        a = a * a;
    }
    return ret;
}

void Jian()
{
    cin >> n >> s;
    ll L = 0, R = 0, U = 0, D = 0;
    rep(i, 0, n - 1)
    {
        if(s[i] == 'L')
            L++;
        if(s[i] == 'R')
            R++;
        if(s[i] == 'U')
            U++;
        if(s[i] == 'D')
            D++;
    }
    rep(i, 0, n - 1)
    {
        if(s[i] == 'L' || s[i] == 'R')
        {
            ll u = 0, d = 0;
            rep(j, i + 1, n - 1)
            {
                if(s[j] == 'U')
                    u++;
                if(s[j] == 'D')
                    d++;
                if(s[j] == 'L' || s[j] == 'R')
                {
                    if(s[i] != s[j])
                    {
                        if(u == d)
                        {
                            if(s[i] == 'L')
                                L--;
                            if(s[i] == 'R')
                                R--;
                        }
                    }
                    break;
                }
            }
        }
        if(s[i] == 'U' || s[i] == 'D')
        {
            ll l = 0, r = 0;
            rep(j, i + 1, n - 1)
            {
                if(s[j] == 'L')
                    l++;
                if(s[j] == 'R')
                    r++;
                if(s[j] == 'U' || s[j] == 'D')
                {
                    if(s[i] != s[j])
                    {
                        if(l == r)
                        {
                            if(s[i] == 'U')
                                U--;
                            if(s[i] == 'D')
                                D--;
                            continue;
                        }
                    }
                    break;
                }
            }
        }
    }
    cout << L << " " << R << " " << U << " " << D << endl;
    cout << (L + R + 1) * (U + D + 1) << endl;
    rep(i, -L, R)
    {
        rep(j, -D, U)
        {
            cout << i << " " << j << endl;
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    //cin >> _;
    while(_--)
        Jian();
    return 0;
}