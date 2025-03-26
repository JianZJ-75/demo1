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

void quicksort(int l, int r, int *a) // 若是多关键字排序，int a[]改为P a[]
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

// 快排
void qs(int l, int r, int *a) {
    srand(time(0));
    if (l >= r)
        return;
    swap(a[l], a[l + rand() % (r - l + 1)]);
    int x = a[l];
    int i = l, j = r;
    while (i < j) {
        while (i < j && a[j] > x)
            j--;
        if (i < j)
            a[i++] = a[j];
        while (i < j && a[i] < x)
            i++;
        if (i < j)
            a[j--] = a[i];
    }
    a[i] = x;
    qs(l, i - 1, a);
    qs(i + 1, r, a);
}

// 归并排序
void merge(int l, int r, int *a) {
    if (l >= r)
        return;
    int m = (l + r) / 2;
    merge(l, m, a);
    merge(m + 1, r, a);
    int c[r - l + 2];
    int p1 = l, p2 = m + 1, idx = 0;
    while (p1 <= m && p2 <= r) {
        if (a[p1] <= a[p2])
            c[++idx] = a[p1++];
        else
            c[++idx] = a[p2++];
    }
    while (p1 <= m)
        c[++idx] = a[p1++];
    while (p2 <= r)
        c[++idx] = a[p2++];
    for (int i = l; i <= r; i++)
        a[i] = c[i - l + 1];
}

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
        if (s + 1 <= r && a[s] < a[s + 1])
            s++;
        if (a[fa] >= a[s])
            return;
        else {
            swap(a[fa], a[s]);
            fa = s;
            s = fa * 2 + 1;
        }
    }
}

void heap_sort(int l, int r, int *a) {
    int len = r - l + 1;
    for (int i = len / 2 - 1; i >= 0; i--)
        down(i, len - 1, a);
    for (int i = len - 1; i >= 0; i--) {
        swap(a[0], a[i]);
        down(0, i - 1, a);
    }
}

void Jian()
{
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) // 若是多关键字排序，需改动
        cin >> a[i];
    // quicksort(0, n - 1, a);
    // qs(0, n - 1, a);
    // merge(0, n - 1, a);
    ms(0, n - 1, a);
    heap_sort(0, n - 1, a);
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