#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

struct P
{
    int x, y;
    bool operator<(const P &a) const // 重构<
    {
        if (x == a.x)
            return y < a.y;
        else
            return x < a.x;
    }
};

void quicksort(int l, int r, int a[]) // 若是多关键字排序，int a[]改为P a[]
{
    srand(time(0));
    if (r - l + 1 <= 1) // or l>=r
        return;
    swap(a[l], a[l + rand() % (r - l + 1)]); // 较大时可以写(rand()<<15)+rand()
    int i = l, j = r;
    int x = a[l]; // 若是多关键字，应该写成P x=a[l];
    while (i < j)
    {
        while (i < j && a[j] > x) // 若是多关键字排序，且重构的是<，应该写成x<a[j]
            j--;                  // 若坚持用a[j]>x，应在结构体内再重载>
        if (i < j)
            a[i++] = a[j];
        while (i < j && a[i] < x)
            i++;
        if (i < j)
            a[j--] = a[i];
    }
    a[i] = x;
    quicksort(l, i - 1, a);
    quicksort(i + 1, r, a);
}

void Jian()
{
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) // 若是多关键字排序，需改动
        cin >> a[i];
    quicksort(0, n - 1, a);
    for (int i = 0; i < n; i++) // 若是多关键字排序，需改动
        cout << a[i] << " ";
}

int main()
{
    int t = 1;
    // cin >> t;
    while (t--)
        Jian();
    return 0;
}