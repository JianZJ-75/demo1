#include <bits/stdc++.h>

using namespace std;
const int N = 1e6 + 5;
struct Hftree
{
    int parent, r, l;
    char binary; // 存编码 0 / 1
} tree[N];
typedef pair<double, int> PDI;
map<char, int> password; // 2*n - 1 个节点 , map存储读入的节点对应的字符和节点编号
string hid_pword[N];     // 存每一个读入的字符转化成的哈夫曼编码
string word = "";
int root, now;
priority_queue<PDI, vector<PDI>, greater<PDI>> q; // 小根堆 ，将每个节点的编号（第二关键字）和权重（第一关键字）放进去，堆顶就是权重最小的

void buildtree()
{
    double weight;
    while (q.size() > 1)
    {
        auto object1 = q.top();
        q.pop();
        auto object2 = q.top();
        q.pop();
        weight = object1.first + object2.first;
        tree[object1.second].parent = now;
        tree[object2.second].parent = now;
        tree[now].l = object1.second;
        tree[object1.second].binary = '0';
        tree[now].r = object2.second;
        tree[object2.second].binary = '1';
        q.push({weight, now++});
    }
    root = q.top().second;
}

void dfs(int u)
{
    if (u != root)
        word += tree[u].binary;
    if (tree[u].l == 0 && tree[u].r == 0)
    {
        hid_pword[u] = word;
        word.pop_back();
        return;
    }
    dfs(tree[u].l);
    dfs(tree[u].r);
    word.pop_back();
    return;
}

int main()
{
    int n;
    double weight;
    char paword;
    cin >> n;
    now = n + 2;
    password[' '] = 1;
    tree[0].parent = 0;
    tree[0].l = 0;
    tree[0].r = 0;
    q.push({186, 1});
    for (int i = 2; i <= n + 1; i++)
    {
        cin >> paword >> weight;
        password[paword] = i;
        tree[i].parent = 0;
        tree[i].l = 0;
        tree[i].r = 0;
        q.push({weight, i});
    }
    buildtree();
    dfs(root);
    string article;
    getline(cin, article);
    getline(cin, article);
    string trans_article = "";
    for (int i = 0; i < article.size(); i++)
    {
        trans_article += hid_pword[password[article[i]]];
    }
    cout << trans_article << endl;
    return 0;
}
