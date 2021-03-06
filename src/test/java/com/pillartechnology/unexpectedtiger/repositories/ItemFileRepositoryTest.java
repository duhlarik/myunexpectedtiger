package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ItemFileRepositoryTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void createItemTestsThatContentIsAddedToAFile() throws Exception {
        String expectedContent1 = "Test 1";
        ItemFileRepository service = new ItemFileRepository(folder.getRoot().getPath());
        Item itemUnderTest1 = service.save(expectedContent1);
        File[] files = folder.getRoot().listFiles();

        //ASSERT
        assertEquals(expectedContent1, itemUnderTest1.getContent());
        assertEquals(1, files.length);
        assertEquals(itemUnderTest1.getItemId(), files[0].getName());
    }

    @Test
    public void retrieveItemTestsThatTheCorrectItemIsRetrieved() throws Exception {
        //ARRANGE
        String expectedContent = "Test 1";
        ItemFileRepository service = new ItemFileRepository(folder.getRoot().getPath());
        Item testItem = service.save(expectedContent);
        String testItemId = testItem.getItemId();

        //ACT
        Item item = service.findOne(testItemId);

        //ASSERT
        assertEquals(expectedContent, item.getContent());
    }

    @Test
    public void deleteItemTestsThatTheCorrectItemIsDeleted() throws Exception {
        ItemFileRepository service = new ItemFileRepository(folder.getRoot().getPath());
        Item testItem1 = service.save("Test content 1");
        Item testItem2 = service.save("Test content 2");
        Item testItem3 = service.save("Test content 3");

        String testId2 = testItem2.getItemId();
        service.delete(testId2);
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
    public void retrieveAllItemsTestsThatAllItemsAreRetrieved() throws Exception {
        ItemFileRepository service = new ItemFileRepository(folder.getRoot().getPath());
        Item testItem1 = service.save("Test content 1");
        Item testItem2 = service.save("Test content 2");
        Item testItem3 = service.save("Test content 3");

        List<Item> files = service.findAll();

        List<String> itemFiles = new ArrayList<>();
        itemFiles.add(testItem1.getItemId());
        itemFiles.add(testItem2.getItemId());
        itemFiles.add(testItem3.getItemId());

        //ASSERT
        assertEquals(3, files.size());
        assertThat(itemFiles, Matchers.containsInAnyOrder(files.get(0).getItemId(), files.get(1).getItemId(), files.get(2).getItemId()));
    }

    @Test
    public void deleteAllItemsTestsThatAllItemsAreDeleted() throws Exception {
        ItemFileRepository service = new ItemFileRepository((folder.getRoot().getPath()));
        Item item1 = service.save("content 1");
        Item item2 = service.save("content 2");
        Item item3 = service.save("content 3");

        service.deleteAll();

        //ASSERT
        assertEquals(0, service.findAll().size());
    }
}