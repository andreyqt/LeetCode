package org.example.contest_6_2_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskThree {

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int[] size, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y) {
            return;
        }

        if (size[x] < size[y]) {
            parent[x] = y;
            size[x] += size[y];
        } else {
            parent[y] = x;
            size[y] += size[x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Словарь: слово → номер первого контекста, где оно встретилось
        Map<String, Integer> wordToContext = new HashMap<>();
        // Массив для Union-Find: parent[i] = родитель i-го контекста
        int[] parent = new int[n];
        // Размеры контекстов
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Изначально каждый контекст сам себе родитель
            size[i] = 0;
        }

        int contextCount = 0;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");

            Set<String> currentWords = new HashSet<>(Arrays.asList(words));
            List<Integer> affectedContexts = new ArrayList<>();

            // Находим все контексты, с которыми есть пересечение
            for (String word : currentWords) {
                if (wordToContext.containsKey(word)) {
                    int ctxId = wordToContext.get(word);
                    ctxId = find(parent, ctxId);  // Находим корень
                    if (!affectedContexts.contains(ctxId)) {
                        affectedContexts.add(ctxId);
                    }
                }
            }

            if (affectedContexts.isEmpty()) {
                // Новый изолированный контекст
                for (String word : currentWords) {
                    wordToContext.put(word, contextCount);
                }
                size[contextCount] = currentWords.size();
                contextCount++;
            } else {
                // Объединяем с существующими контекстами
                int mainCtx = affectedContexts.get(0);
                mainCtx = find(parent, mainCtx);

                // Объединяем все затронутые контексты с mainCtx
                for (int j = 1; j < affectedContexts.size(); j++) {
                    int otherCtx = find(parent, affectedContexts.get(j));
                    if (mainCtx != otherCtx) {
                        union(parent, size, mainCtx, otherCtx);
                    }
                }

                // Добавляем новые слова в объединённый контекст
                int root = find(parent, mainCtx);
                for (String word : currentWords) {
                    if (!wordToContext.containsKey(word)) {
                        wordToContext.put(word, root);
                        size[root]++;
                    }
                }
            }
        }

        // Подсчитываем количество уникальных контекстов и максимальный размер
        Set<Integer> uniqueRoots = new HashSet<>();
        int maxSize = 0;

        for (int i = 0; i < contextCount; i++) {
            int root = find(parent, i);
            uniqueRoots.add(root);
            maxSize = Math.max(maxSize, size[root]);
        }

        System.out.println(uniqueRoots.size() + " " + maxSize);
    }
}
