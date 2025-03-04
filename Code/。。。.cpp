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
#define mmax(a, b) (a) >= (b) ? (a) : (b)
#define mmin(a, b) (a) <= (b) ? (a) : (b)

using namespace std;

// 快速排序
void qs(int l, int r, int *a) {
    if (l >= r)
        return;
    srand(time(0));
    swap(a[l], a[l + rand() % (r - l + 1)]);
    int x = a[l];
    int i = l, j = r;
    while (i < j) {
        while (i < j && a[j] > x)
            j--;
        if (i < j) a[i++] = a[j];
        while (i < j && a[i] < x)
            i++;
        if (i < j) a[j--] = a[i];
    }
    a[i] = x;
    qs(l, i - 1, a);
    qs(i + 1, r, a);
}

// 归并排序
void ms(int l, int r, int *a) {
    if (l >= r) return;
    int m = (l + r) / 2;
    ms(l, m, a);
    ms(m + 1, r, a);
    int p1 = l, p2 = m + 1, idx = 0;
    int c[r - l + 1];
    while (p1 <= m && p2 <= r) {
        if (a[p1] <= a[p2])
            c[idx++] = a[p1++];
        else
            c[idx++] = a[p2++];
    }
    while (p1 <= m)
        c[idx++] = a[p1++];
    while (p2 <= r)
        c[idx++] = a[p2++];
    for (int i = l; i <= r; i++)
        a[i] = c[i - l];
}

// 堆排序
void down(int l, int r, int *a) {
    int fa = l;
    int s = 2 * l + 1;
    while (s <= r) {
        if (s + 1 <= r && a[s + 1] > a[s])
            s++;
        if (a[s] < a[fa])
            return;
        else {
            swap(a[s], a[fa]);
            fa = s;
            s = fa * 2 + 1;
        }
    }
}

void hs(int l, int r, int *a) {
    int n = r - l + 1;
    for (int i = n / 2 - 1; i >= 0; i--)
        down(i, r, a);
    for (int i = n - 1; i >= 0; i++) {
        swap(a[0], a[r]);
        down(0, i - 1, a);
    }
}

int fa[1000];

int dsu_find(int x) {
    if (fa[x] == x)
        return x;
    fa[x] = dsu_find(fa[x]);
    return fa[x];
}

void dsu_union(int x, int y) {
    int fx = dsu_find(x), fy = dsu_find(y);
    if (fx == fy)
        return;
    fa[fx] = fy;
}

void Jian() {
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