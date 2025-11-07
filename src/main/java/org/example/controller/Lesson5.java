package org.example.controller;

import org.example.Data.Lesson5_tree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class Lesson5 {

    Lesson5_tree lesson5_tree;
    String result = "";

    public void Init(){
        lesson5_tree = new Lesson5_tree();
        lesson5_tree.setName("1");
        lesson5_tree.setLeftNode(new Lesson5_tree());
        lesson5_tree.setRightNode(new Lesson5_tree());
        lesson5_tree.getLeftNode().setName("2");
        lesson5_tree.getRightNode().setName("3");
        lesson5_tree.getLeftNode().setLeftNode(new Lesson5_tree());
        lesson5_tree.getLeftNode().setRightNode(new Lesson5_tree());
        lesson5_tree.getRightNode().setLeftNode(new Lesson5_tree());
        lesson5_tree.getRightNode().setRightNode(new Lesson5_tree());
        lesson5_tree.getLeftNode().getLeftNode().setName("4");
        lesson5_tree.getLeftNode().getRightNode().setName("5");
        lesson5_tree.getRightNode().getLeftNode().setName("6");
        lesson5_tree.getRightNode().getRightNode().setName("7");
    }

    @GetMapping("/Search")
    public String Start_Search() {
        Init();
        String ans = "";
        HashMap<Integer, String> search_method_name = new  HashMap<>();
        search_method_name.put(1, "先序遍历");
        search_method_name.put(2, "中序遍历");
        search_method_name.put(3, "后序遍历");
        for (Integer key : search_method_name.keySet()) {
            DFS(lesson5_tree, key);
            ans += "<div>DFS " + search_method_name.get(key) + " result: " + result + "\n</div>";
            result = "";
        }
        BFS(lesson5_tree);
        ans += "<div>BFS result: " + result + "\n</div>";
        return ans;
    }

    public void DFS(Lesson5_tree lesson5_tree, int search_method){
        if (search_method == 1)
            result += lesson5_tree.getName() + ' ';
        if (lesson5_tree.getLeftNode() != null)
            DFS(lesson5_tree.getLeftNode(), search_method);
        if (search_method == 2)
            result += lesson5_tree.getName() + ' ';
        if (lesson5_tree.getRightNode() != null)
            DFS(lesson5_tree.getRightNode(), search_method);
        if (search_method == 3)
            result += lesson5_tree.getName() + ' ';
    }

    public void BFS(Lesson5_tree lesson5_tree){
        List<Lesson5_tree> queue = new ArrayList<>();
        queue.add(lesson5_tree);
        while (!queue.isEmpty()){
            Lesson5_tree top = queue.get(0);
            result += top.getName() + ' ';
            queue.remove(top);
            if (top.getLeftNode() != null)
                queue.add(top.getLeftNode());
            if (top.getRightNode() != null)
                queue.add(top.getRightNode());
        }
    }
}
