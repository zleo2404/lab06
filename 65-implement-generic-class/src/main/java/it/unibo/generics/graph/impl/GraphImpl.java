package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    Map<N,List<N>> graph;

    public GraphImpl(){
        graph = new HashMap<>();
    }

    @Override
    public void addEdge(N source, N target) {
       
        graph.get(source).add(target);
        
    }

    @Override
    public void addNode(N node) {

        graph.put(node, new LinkedList<>());
        
    }
    
    
    @Override
    public List<N> getPath(N source, N target) {
            
        Queue<N> coda = new LinkedList<>();
        List<N> esplorati = new LinkedList<>();
        LinkedList<N> res = new LinkedList<>();
        Map<N,N> genitori = new HashMap<>();
        esplorati.add(source);
        coda.add(source);
        while(!coda.isEmpty()){

            N v = coda.poll();
            if(v==target){
                break;
            }
            for( N n : graph.get(v)){
                if(!esplorati.contains(n)){
                    esplorati.add(n);
                    genitori.put(n,v);
                    coda.add(n);
                }
            }

        }
        res.add(target);
        while(target != source){
            res.addFirst(genitori.get(target));
            target = genitori.get(target);
        }
        return res;
        

    }

    @Override
    public Set<N> linkedNodes(N node) {
       Set<N> set = new HashSet<>();
       set.addAll(graph.get(node));
        return set;
    }

    @Override
    public Set<N> nodeSet() {
        Set<N> nodes = new HashSet<>();
        nodes.addAll(graph.keySet());
        return nodes;
    }
    
}
