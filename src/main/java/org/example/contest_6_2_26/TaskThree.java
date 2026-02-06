package org.example.contest_6_2_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskThree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Set<String>> contexts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");

            Set<String> currentQuery = new HashSet<>(Arrays.asList(words));
            List<Integer> commonContexts = new ArrayList<>();

            for (int j = 0; j < contexts.size(); j++) {
                Set<String> context = contexts.get(j);
                boolean intersects = false;
                for (String word : currentQuery) {
                    if (context.contains(word)) {
                        intersects = true;
                        break;
                    }
                }
                if (intersects) {
                    commonContexts.add(j);
                }
            }

            if (commonContexts.isEmpty()) {
                contexts.add(new HashSet<>(currentQuery));
            } else {
                Set<String> mergedContext = new HashSet<>(currentQuery);
                for (int idx : commonContexts) {
                    mergedContext.addAll(contexts.get(idx));
                }
                commonContexts.sort(Collections.reverseOrder());
                for (int idx : commonContexts) {
                    contexts.remove(idx);
                }
                contexts.add(mergedContext);
            }
        }

        int contextCount = contexts.size();
        int maxContext = 0;
        for (Set<String> context : contexts) {
            maxContext = Math.max(maxContext, context.size());
        }

        System.out.println(contextCount + " " + maxContext);
    }

}
