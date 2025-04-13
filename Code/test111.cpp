#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param message string字符串
     * @return string字符串
     */
    string reverseMessage(string message)
    {
        int n = message.length();
        string ans = "";
        vector<string> tmp;
        for (int i = 0; i < n;)
        {
            int j = i;
            string t = "";
            if (message[j] != ' ')
                t += message[j];
            while (j + 1 < n && message[j] != ' ')
            {
                j++;
                t += message[j];
            }
            tmp.push_back(t);
            cout << t << endl;
            i = j + 1;
        }
        for (auto i : tmp) {
            cout << i << endl;
        }
        for (int i = tmp.size(); i >= 0; i--) {
            if (i == tmp.size())
                ans += tmp[i];
            else    
                ans = ans + " " + tmp[i];
        }
        cout << ans[0] << "123" << ans[1] << endl;
        return ans;
    }
};

signed main() {
    Solution s;
    string str = str = "the sky is blue";\
    cout << str << endl;
    cout << s.reverseMessage(str);
    return 0;
}