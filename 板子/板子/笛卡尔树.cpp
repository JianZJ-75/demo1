// 一个区间取出最小值为根
// 分成左右区间在左右儿子
// 两边分别重复这些操作
#include <bits/stdc++.h>
using namespace std;
// 性质1：区间最小值为两个端点的lca
// 性质2：中序遍历就是原数组
/*性质3：一个点的祖先节点，如果这个祖先节点到这个点的路径是第一个向 左/右 的路径
，那么这个祖先节点就是 左/右 边第一个小于等于它的数*/
const int N = 1e5 + 10;
int n, a[N], l[N], r[N];
void build()
{
  stack<int> st;
  int root = 0;
  for (int i = 1; i <= n; i++)
  {
    int last = 0;
    while (!st.empty() && a[st.top()] > a[i])
    {
      last = st.top();
      st.pop();
    }
    if (!st.empty())
      r[st.top()] = i;
    else
      root = i;
    l[i] = last;
    st.push(i);
  }
}
signed main()
{
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    scanf("%d", &a[i]);
  return 0;
}
