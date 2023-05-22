package com.fmss.ikrestproject.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node {
    private int key;
    private int parentKey;
    private String name;
    private List<Node> nodeList;

    public Node(Node parentNode, String name) {
        this.key = generateKey();
        this.parentKey = parentNode.getKey();
        this.name = name;
        this.nodeList = new ArrayList<>();
    }

    public Node(String name) {
        this.key = generateKey();
        this.name = name;
        this.nodeList = new ArrayList<>();
    }

    private static int genKey = 0;

    private static int generateKey() {
        genKey = genKey + 1;
        return genKey;
    }


    public static Node searchNode(Node node, int searchKey) {

        if (node.getKey() == searchKey) {
            return node;
        }

        if (!CollectionUtils.isEmpty(node.getNodeList())) {
            for (Node subNode : node.getNodeList()) {
                Node found = searchNode(subNode, searchKey);
                if (found != null)
                    return found;
            }
        }
        return null;
    }

    public static boolean isNodeAlreadyUsed(Node headNode, Node selectNode, String newNodeName) {
        int searchKey = selectNode.getParentKey();

        while (searchKey != 0) {
            Node node = Node.searchNode(headNode, searchKey);

            if (node.getName().equals(newNodeName)) {
                return true;
            }
            searchKey = node.getParentKey();
        }
        return false;
    }
}

