#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

void Jian()
{
    string s;
    s.erase(2);                               // 删除下标2开始之后的字符
    s.erase(2, 5);                            // 删除下标2开始之后5个字符
    s.substr(2);                              // 截取2到最后
    s.substr(2, 5);                           // 从2开始截取5个字符
    int ret = s.find('x', 2);                 // 从2开始找到第一个x，没有返回-1
    s.insert(2, 3, 'd');                      // 从2后开始插入3个字符
    s.insert(2, "da");                        // 从2后开始插入一个字符串
    s.replace(2, 5, "d");                     // 从2开始的5个字符换成字符串
    s.replace(s.begin(), s.begin() + 5, "d"); // 从2开始的5个字符换成字符串
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    cin >> t;
    while (t--)
        Jian();
    return 0;
}