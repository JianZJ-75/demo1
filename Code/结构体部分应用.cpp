//第三次练习O
#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

struct P
{
    int in;
    int sz;
};

bool cmp(int a, int b)
{
    return a > b;
}

bool cmpP(P a, P b)
{
    if (a.sz == b.sz)
        return a.in > b.in;
    else
        return a.sz > b.sz;
}

void Jian()
{
    int n;
    cin >> n;
    P px[n];
    int ans[200001];
    for (int i = 0; i < n; i++)
    {
        cin >> px[i].sz;
        px[i].in=i;
    }//读入数组
    sort(px,px+n,cmpP);//逆序
    ll sum = 0, ret = 0, nn = 1;
    for (int i = 0; i < n; i++)
    {
        ret++;
        if (ret == 1)
            ans[px[i].in]=nn;
        else if (ret == 2)
            ans[px[i].in] = -nn;
        if (ret == 2)
        {
            ret = 0;
            nn++;
        }
        sum += 2ll * abs(ans[px[i].in]) * px[i].sz;
    }
    cout << sum << "\n"
         << 0 << " ";
    for (int i = 0; i<n; i++)
    {
        cout << ans[i];
        if (i == n-1)
            cout << "\n";
        else
            cout << " ";
    }
}

int main()
{
    int t = 1;
    cin >> t;
    while (t--)
        Jian();
    return 0;
}