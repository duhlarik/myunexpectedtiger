package com.pillartechnology.unexpectedtiger;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemService;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ItemServiceTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void createItemTestsContentToAFile() throws Exception {
        String expectedContent1 = "Test 1";
        ItemService service = new ItemService(folder.getRoot().getPath());
        Item itemUnderTest1 = service.createItem(expectedContent1);
        File[] files = folder.getRoot().listFiles();

        //ASSERT
        assertEquals(expectedContent1, itemUnderTest1.getContent());
        assertEquals(1, files.length);
        assertEquals(itemUnderTest1.getItemId(), files[0].getName());
    }

    @Test
    public void retrieveItem() throws Exception {
        //ARRANGE
        String expectedContent = "Test 1";
        ItemService service = new ItemService(folder.getRoot().getPath());
        Item testItem = service.createItem(expectedContent);
        String testItemId = testItem.getItemId();

        //ACT
        Item item = service.retrieveItem(testItemId);

        //ASSERT
        assertEquals(expectedContent, item.getContent());
    }

    @Test
    public void deleteItem() throws Exception {
        ItemService service = new ItemService(folder.getRoot().getPath());
        Item testItem1 = service.createItem("Test content 1");
        Item testItem2 = service.createItem("Test content 2");
        Item testItem3 = service.createItem("Test content 3");

        String testId2 = testItem2.getItemId();
        service.deleteItem(testId2);
        File[] files = folder.getRoot().listFiles();

        String fileId1 = files[0].getName();
        String fileId3 = files[1].getName();

        List<String> itemIds = new ArrayList<>();
        itemIds.add(testItem1.getItemId());
        itemIds.add(testItem3.getItemId());

        //ASSERT
        assertEquals(2, files.length);
        assertThat(itemIds, Matchers.containsInAnyOrder(fileId1, fileId3));
    }

    @Test
    public void retrieveAllItems() throws Exception {
        ItemService service = new ItemService(folder.getRoot().getPath());
        Item testItem1 = service.createItem("Test content 1");
        Item testItem2 = service.createItem("Test content 2");
        Item testItem3 = service.createItem("Test content 3");

        List<Item> files = service.retrieveAllItems();

        List<String> itemFiles = new ArrayList<>();
        itemFiles.add(testItem1.getItemId());
        itemFiles.add(testItem2.getItemId());
        itemFiles.add(testItem3.getItemId());

        //ASSERT
        assertEquals(3, files.size());
        assertThat(itemFiles, Matchers.containsInAnyOrder(files.get(0).getItemId(), files.get(1).getItemId(), files.get(2).getItemId()));
    }

    @Test
    public void deleteAllItems() throws Exception {
        ItemService service = new ItemService((folder.getRoot().getPath()));
        Item item1 = service.createItem("content 1");
        Item item2 = service.createItem("content 2");
        Item item3 = service.createItem("content 3");

        service.deleteAllItems();

        //ASSERT
        assertEquals(0, service.retrieveAllItems().size());
    }
}