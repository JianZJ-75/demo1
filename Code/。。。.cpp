#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

struct P
{
    int in,sz;
};

bool cmp(P a,P b)
{
    if(a.sz==b.sz) return a.in<b.in;
    else return a.sz<b.sz;
}

void Jian()
{
    int n, m;
    cin >> n >> m;
    ll a[n];
    for (int i = 0; i < n;)
        cin >> a[i++];
    ll sum = 0;
    for (int i = 0; i < m;)
        sum += a[i++];
    int ans = 0;
    ll jp = 0;
    P b[m];
    for(int i=0;i<m;i++)//i是下标，sz是对应下标的值
    {
        b[i].in=i;
        b[i].sz=a[i];
    }
    sort(b,b+m,cmp);//排序
    int js=m-1;
    for(int i=0;i<m;i++)//遍历一遍使前缀和>=到m的前缀和；
    {
        jp+=a[i];
        for(;jp<sum;)//如果前缀和小于，则将1~m最大的一项变号；
        {
            ans++;
            sum-=2*b[js].sz;
            if(b[js].in==i)jp+=-2*a[i];
            js--;
        }
    }
    sum = 0;
    for (int i = m; i < n; i++)//保证m项之后的后缀和>=0
    {
        sum += a[i];
        if (sum < 0)
        {
            if (a[i] < 0)
            {
                ans++;
                sum -= 2 * a[i];
            }
        }
    }
    cout << ans << "\n";
}

int main()
{
    int t = 1;
    cin >> t;
    while (t--)
        Jian();
    return 0;
}