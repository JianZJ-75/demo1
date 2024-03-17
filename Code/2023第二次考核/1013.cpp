#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

void Jian()
{
    ll n;
    cin >> n;
    string s;
    cin >> s;
    ll l = 0, r = 0, k = 0, t; // t为等号后得第一个位置
    int ok = 1;
    ll wz, x; // wz位置  x正负
    rep(i, 0, n - 1)
    {
        if (s[i] == '+')
        {
            if (ok)
                l += k;
            else
                l -= k;
            k = 0;
            ok = 1;
        }
        else if (s[i] == '-')
        {
            if (ok)
                l += k;
            else
                l -= k;
            k = 0;
            ok = 0;
        }
        else if (s[i] == '=')
        {
            if (ok)
                l += k;
            else
                l -= k;
            k = 0;
            ok = 1;
            t = i + 1;
            break;
        }
        else if (s[i] == 'x')
        {
            x = ok;
            wz = 1;
        }
        else
            k = k * 10 + (s[i] - '0');
    }
    rep(i, t, n - 1)
    {
        if (s[i] == '+')
        {
            if (ok)
                r += k;
            else
                r -= k;
            k = 0;
            ok = 1;
        }
        else if (s[i] == '-')
        {
            if (ok)
                r += k;
            else
                r -= k;
            k = 0;
            ok = 0;
        }
        else if (s[i] == 'x')
        {
            x = ok;
            wz = 0;
        }
        else
            k = k * 10 + (s[i] - '0');
    }
    if (ok)// 方程最后一位没加
        r += k;
    else
        r -= k;
    if (wz)
    {
        if (x)
            x = r - l;
        else
            x = l - r;
    }else
    {
        if (x)
            x = l - r;
        else
            x = r - l;
    }
    cout << "x=" << x << endl;
}

int main()
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