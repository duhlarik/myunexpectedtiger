package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemRepositoryTest {

    private ItemService mockItemService;
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        //ARRANGE
        mockItemService = mock(ItemService.class);
        itemRepository = new ItemRepository(mockItemService);
    }

    @Test
    public void addInvokesItemServiceCreateItem() throws Exception {
        String expectedContent = "content";
        //ACT
        itemRepository.add(expectedContent);

        //ASSERT
        verify(mockItemService).createItem(expectedContent);
    }

    @Test
    public void retrieveItemInvokesItemServiceRetrieveItem() throws Exception {
        Item item = new Item();
        //ACT
        itemRepository.retrieveItem(item.getItemId());

        //ASSERT
        verify(mockItemService).retrieveItem(item.getItemId());
    }

    @Test
    public void removeItemInvokesItemServiceDeleteItem() throws Exception {
        Item item = new Item();
        //ACT
        itemRepository.removeItem(item.getItemId());

        //ASSERT
        verify(mockItemService).deleteItem(item.getItemId());
    }

    @Test
    public void retrieveAllInvokesItemServiceRetrieveAllItems() throws Exception {
        //ACT
        itemRepository.retrieveAll();

        //ASSERT
        verify(mockItemService).retrieveAllItems();
    }

    @Test
    public void clearAllInvokesItemServiceDeleteAllItems() throws Exception {
        //ACT
        itemRepository.clearAll();

        //Assert
        verify(mockItemService).deleteAllItems();
    }
}