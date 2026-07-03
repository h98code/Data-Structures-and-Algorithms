package org.Projects.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {


    // TC = O(N * M) where N is the number of domains and M is the average length of the domain
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(String domainDetails : cpdomains) {
            String[] details = domainDetails.split(" "); //["9001", "discuss.leetcode.com"]
            String[] domain = details[1].split("\\."); // ["discuss", "leetcode", "com"]

            StringBuilder prevSb = new StringBuilder();

            for(int i=domain.length - 1; i>=0; i--) {
                StringBuilder sb = new StringBuilder(domain[i]);

                if(i != domain.length - 1)
                    sb.append(".");

                sb.append(prevSb);
                prevSb = sb;
                String dom = sb.toString();
                int count = Integer.parseInt(details[0]);
                mp.put(dom, mp.getOrDefault(dom, 0) + count);
            }
        }

        for(Map.Entry<String, Integer> ent : mp.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(ent.getValue() + " ");
            sb.append(ent.getKey());
            ans.add(sb.toString());
        }

        return ans;
    }
}
