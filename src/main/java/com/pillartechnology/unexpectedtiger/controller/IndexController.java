package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    String index(ModelMap model) throws IOException {
        model.put("todoItems", itemRepository.retrieveAllItems());
        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(String content) throws IOException {
        itemRepository.createItem(content);
        return "redirect:/";
    }

    @RequestMapping("/clear")
    String clear() throws IOException {
        itemRepository.deleteAllItems();
        return "redirect:/";
    }

    @RequestMapping(value="/removeItem", method = RequestMethod.GET)
    String removeItem(@RequestParam("itemId") String itemId) {
        Item item = new Item(itemId);
        itemRepository.deleteItem(itemId);
        return "redirect:/";
    }

//    @RequestMapping("/removeLast")
//    String removeLast() {
//        itemRepository.removeLastItem();
//        return "redirect:/";
//    }
}
