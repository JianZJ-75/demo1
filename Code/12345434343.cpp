#include <bits/stdc++.h>

using namespace std;


class Solution {
    public:
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         * 
         * 
         * @param nums1 int整型 vector 
         * @param nums2 int整型 vector 
         * @param k int整型  
         * @return int整型vector
         */
        vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
            int n = nums1.size(), m = nums2.size();
            vector<int> ans;
            stack<int> s1, s2;
            int idx1[n + 10], idx2[m + 10];
            int i1 = -1, i2 = -1;
            s1.push(nums1[0]);
            for (int i = 1; i < n; i++) {
                while (!s1.empty() && s1.top() < nums1[i]) {
                    i1--;
                    s1.pop();
                }
                s1.push(nums1[i]);
                idx1[++i1] = i; 
            }
            s2.push(nums2[0]);
            for (int i = 1; i < m; i++) {
                while (!s2.empty() && s2.top() < nums2[i]) {
                    i2--;
                    s2.pop();
                }
                s2.push(nums2[i]);
                idx2[++i2] = i;
            }
            vector<int> t1;
            // 处理最大
            map<int, pair<int, int>> mp;
            int i3 = s1.size() + s2.size() - 1;
            while (!s1.empty() && !s2.empty()) {
                if (s1.top() < s2.top()) {
                    mp[i3--] = {1, idx1[i1--]};
                    t1.push_back(s1.top());
                    s1.pop();
                } else {
                    mp[i3--] = {2, idx2[i2--]};
                    t1.push_back(s2.top());
                    s2.pop();
                }
            }
            while (!s1.empty()) {
                mp[i3--] = {1, idx1[i1--]};
                t1.push_back(s1.top());
                s1.pop();
            }
            while (!s2.empty()) {
                mp[i3--] = {2, idx2[i2--]};
                t1.push_back(s2.top());
                s2.pop();
            }
            reverse(t1.begin(), t1.end());
            int n1 = t1.size();
            while (n1 > k) {
                t1.pop_back();
            }
            if (n1 < k) {
                vector<int> ad[n1 + 10];
                for (int i = n1 - 1; i >= 0; i--) {
                    pair<int, int> x = mp[i];
                    if (x.first == 1) {
                        int sy = n - 1 - x.second;
                        vector<int> tt1, tt2;
                        for (int j = x.second + 1; j < n; j++)
                            tt1.push_back(nums1[j]);
                        int need = k - n1;
                        if (need <= sy) {
                            ad[i] = maxNumber(tt1, tt2, need);
                        } else {
                            ad[i] = tt1;
                        }
                        n1 += tt1.size();
                    } else {
                        int sy = m - 1 - x.second;
                        vector<int> tt1, tt2;
                        for (int j = x.second + 1; j < m; j++)
                            tt1.push_back(nums2[j]);
                        int need = k - n1;
                        if (need <= sy) {
                            ad[i] = maxNumber(tt1, tt2, need);
                        } else {
                            ad[i] = tt1;
                        }
                        n1 += tt1.size();
                    }
                }
                n1 = t1.size();
                vector<int> ans;
                for (int i = 0; i < n1; i++) {
                    ans.push_back(t1[i]);
                    vector<int> ttt = ad[i];
                    int nnn = ttt.size();
                    for (int j = nnn - 1; j >= 0; j--)
                        ans.push_back(ttt[j]);
                }
                t1 = ans;
            }
            return t1;
        }
};
    

int main() {
    int nn, mm, k;
    cin >> nn >> mm >> k;
    vector<int> nums1, nums2;
    for (int i = 0; i < nn; i++) {
        int x;
        cin >> x;
        nums1.push_back(x);
    }
    for (int i = 0; i < mm; i++) {
        int x;
        cin >> x;
        nums2.push_back(x);
    }
    

    // int n = nums1.size(), m = nums2.size();
    // vector<int> ans;
    // stack<int> s1, s2;
    // int idx1[n + 10], idx2[m + 10];
    // int i1 = -1, i2 = -1;
    // s1.push(nums1[0]);
    // for (int i = 1; i < n; i++) {
    //     while (!s1.empty() && s1.top() < nums1[i]) {
    //         i1--;
    //         s1.pop();
    //     }
    //     s1.push(nums1[i]);
    //     idx1[++i1] = i; 
    // }
    // s2.push(nums2[0]);
    // for (int i = 1; i < m; i++) {
    //     while (!s2.empty() && s2.top() < nums2[i]) {
    //         i2--;
    //         s2.pop();
    //     }
    //     s2.push(nums2[i]);
    //     idx2[++i2] = i;
    // }
    // vector<int> t1;
    // // 处理最大
    // map<int, pair<int, int>> mp;
    // int i3 = s1.size() + s2.size() - 1;
    // while (!s1.empty() && !s2.empty()) {
    //     if (s1.top() < s2.top()) {
    //         mp[i3--] = {1, idx1[i1--]};
    //         t1.push_back(s1.top());
    //         s1.pop();
    //     } else {
    //         mp[i3--] = {2, idx2[i2--]};
    //         t1.push_back(s2.top());
    //         s2.pop();
    //     }
    // }
    // while (!s1.empty()) {
    //     mp[i3--] = {1, idx1[i1--]};
    //     t1.push_back(s1.top());
    //     s1.pop();
    // }
    // while (!s2.empty()) {
    //     mp[i3--] = {2, idx2[i2--]};
    //     t1.push_back(s2.top());
    //     s2.pop();
    // }
    // reverse(t1.begin(), t1.end());
    // int n1 = t1.size();
    // while (n1 > k) {
    //     t1.pop_back();
    // }
    // if (n1 < k) {
    //     vector<int> ad[n1 + 10];
    //     for (int i = n1 - 1; i >= 0; i--) {
    //         pair<int, int> x = mp[i];
    //         if (x.first == 1) {
    //             int sy = n - 1 - x.second;
    //             if (sy <= k)
    //         } else {

    //         }
    //     }
    // }

    // for (auto i : t1)
    //     cout << i << " ";
    // cout << endl;

    Solution s;
    vector<int> ans = 

    return 0;
}