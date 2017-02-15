package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    String index(ModelMap model) {

        model.put("todoItems", itemRepository.retrieveAll());
        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(Item item) {
        itemRepository.add(item);
        return "redirect:/";
    }

    @RequestMapping("/clear")
    String clear() {
        itemRepository.clearAll();
        return "redirect:/";
    }

    @RequestMapping("/removeLast")
    String removeLast() {
        itemRepository.removeLastItem();
        return "redirect:/";
    }

    @RequestMapping("/removeItem")
    String removeItem(Item item) {
        itemRepository.removeItem(item);
        return "redirect:/";
    }

}
