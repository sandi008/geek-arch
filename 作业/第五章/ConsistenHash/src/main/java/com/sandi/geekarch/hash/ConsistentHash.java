package com.sandi.geekarch.hash;

import com.sandi.geekarch.util.MathUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 *   
 * <p>一致性Hash实现</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/30 2:43 下午
 * @since V1.0
 *  
 */
@Slf4j
public class ConsistentHash {

    /**
     * 真实节点 链表（真实节点具有上线下线特点：频繁的增删操作）
     */
    private List<Node<String>> nodeList = new LinkedList<>();

    /**
     * 虚拟节点，key——节点的Hash值；value——节点的名称
     */
    private SortedMap<Integer, Node<String>> virtualNodes = new TreeMap<Integer, Node<String>>();

    private HashStrategy hashStrategy;

    /**
     * 方便把数据存储于真实节点，方便后面统计
     */
    private Map<String, Node<String>> ipNodeMap = new HashMap<>();

    public ConsistentHash(List<String> servers, int virtualNodesNum, HashStrategy hashStrategy) {
        this.hashStrategy = hashStrategy;

        // 把原始服务器IP 加入真实节点 Node
        for (String server : servers) {
            Node<String> node = new Node<String>(server, server);
            nodeList.add(node);
            ipNodeMap.put(server, node);
        }

        // 添加虚拟节点
        for (Node<String> node : nodeList) {
            for (int i = 1; i < virtualNodesNum; i++) {
                String virtualNodeName = node.getIp() + "#VN" + i;
                int hash = hashStrategy.hash(virtualNodeName);
                virtualNodes.put(hash, new Node<String>(virtualNodeName, node.getIp()));
                if (log.isDebugEnabled()) {
                    log.debug("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                }
            }
        }
    }

    /**
     * 获取虚拟节点所在真实节点（即数据分配在哪台服务器）
     *
     * @param node
     *
     * @return
     */
    public Node<String> getServer(String node) {
        // 计算节点Hash
        int hash = hashStrategy.hash(node);

        // 获取大于应该Hash的所有Map
        SortedMap<Integer, Node<String>> subMap = virtualNodes.tailMap(hash);

        // 获取对应的虚拟节点为名
        Node<String> virtualNode;
        if (subMap.isEmpty()) {
            virtualNode = virtualNodes.get(virtualNodes.firstKey());
        } else {
            // 获取第一个key,顺时针过去离node最近的节点
            Integer i = subMap.firstKey();
            virtualNode = subMap.get(i);
        }

        return virtualNode;
    }


    /**
     * 添加键值数据
     *
     * @param key
     * @param value
     */
    public void put(String key, int value) {
        Node<String> node = this.getServer(key);
        Node<String> stringNode = ipNodeMap.get(node.getIp());
        stringNode.add(key, value + "");
        if (log.isDebugEnabled()) {
            log.debug("[" + key + "]被路由到结点[" + node.getIp() + "]");
        }
    }

    /**
     * 数据分析统计
     */
    public void statistics() {
        double[] nodeCnt = new double[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            Node<String> node = nodeList.get(i);
            nodeCnt[i] = node.getData().size();
            log.info(node.getIp() + "\t" + node.getData().size());
        }
        ;
        log.info("" + MathUtil.standardDiviation(nodeCnt));
    }

}
