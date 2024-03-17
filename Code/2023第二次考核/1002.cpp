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
    string s;
    cin >> s;
    int h0 = 0, m0 = 0;
    h0 = (s[0] - '0') * 10 + (s[1] - '0');
    m0 = (s[3] - '0') * 10 + (s[4] - '0');
    int t;
    cin >> t;
    int h = t / 60, m = t % 60;
    h0 += h;
    m0 += m;
    h0 += m0 / 60;
    m0 %= 60;
    h0 %= 24;
    if (h0 < 10)
        cout << "0" << h0 << ":";
    else    
        cout << h0 << ":";
    if (m0 < 10)
        cout << "0" << m0 << endl;
    else
        cout << m0 << endl;
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