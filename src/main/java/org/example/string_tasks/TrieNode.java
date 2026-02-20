package org.example.string_tasks;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isEnd;
}
