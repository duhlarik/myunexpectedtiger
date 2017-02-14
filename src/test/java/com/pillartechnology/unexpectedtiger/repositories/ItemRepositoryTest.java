package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemRepositoryTest {

    private ItemRepository itemRepository;

    @Before
    public void before() {
        itemRepository = new ItemRepository();
    }

    @Test
    public void retrieveAll_returns_empty_when_no_items_added() {
        //SUT
        List<Item> actualItems = new ItemRepository().retrieveAll();

        //ASSERT
        assertNotNull(actualItems);
        Assert.assertEquals(0, actualItems.size());
    }

    @Test
    public void retrieveAll_returns_one_item_added_correctly() {
        //ARRANGE
        Item item = new Item("test");
        itemRepository.add(item);

        //SUT
        List<Item> actualItems = itemRepository.retrieveAll();

        //ASSERT
        assertNotNull(actualItems);
        assertEquals(1, actualItems.size());
        assertEquals("test", actualItems.get(0).getContent());
    }

    @Test
    public void retrieveAll_returns_all_items_added_correctly() {
        //ARRANGE
        Item item1 = new Item("test 1");
        Item item2 = new Item("test 2");
        itemRepository.add(item1);
        itemRepository.add(item2);

        //SUT
        List<Item> actualItems = itemRepository.retrieveAll();

        //ASSERT
        assertNotNull(actualItems);
        assertEquals(2, actualItems.size());
        assertEquals("test 1", actualItems.get(0).getContent());
        assertEquals("test 2", actualItems.get(1).getContent());
    }

    @Test
    public void clearAll_removes_all_items_from_list() {
        //ARRANGE
        Item item1 = new Item("test item 1");
        Item item2 = new Item("test item 2");
        itemRepository.add(item1);
        itemRepository.add(item2);

        //SUT
        itemRepository.clearAll();
        List<Item> actualItems = itemRepository.retrieveAll();

        //ASSERT
        assertEquals(0, actualItems.size());
    }

    @Test
    public void removeItem_removes_the_last_item_from_the_list() {
        //ARRANGE
        Item item1 = new Item("test 1");
        Item item2 = new Item("test 2");
        itemRepository.add(item1);
        itemRepository.add(item2);

        //SUT
        itemRepository.removeItem();
        List<Item> actualItems = itemRepository.retrieveAll();

        //ASSERT
        assertEquals("test 1", actualItems.get(0).getContent());
        assertEquals(1, actualItems.size());
    }

    @Test
    public void removeItem_still_works_when_itemList_is_empty() {
        //ARRANGE
        Item item1 = new Item("test 1");
        itemRepository.add(item1);
        itemRepository.clearAll();

        //SUT
        itemRepository.removeItem();
        List<Item> actualItems = itemRepository.retrieveAll();

        //ASSERT
        assertEquals(0, actualItems.size());
    }

}