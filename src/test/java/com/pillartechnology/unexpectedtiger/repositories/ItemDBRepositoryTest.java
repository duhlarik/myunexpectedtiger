package com.pillartechnology.unexpectedtiger.repositories;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ItemDBRepositoryTest {

    @Mock
    private ItemService mockItemService;

    @InjectMocks
    private ItemDBRepository itemDBRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void saveInvokesItemServiceSave() throws Exception {
//        ItemDBRepository itemDBRepository = new ItemDBRepository(mockItemDBService);
//        Item item = new Item("content", "id");
//
//    }

//    @Test
//    public void retrieveItemInvokesItemServiceRetrieveItem() throws Exception {
//        Item item = new Item();
//        itemRepository.findOne(item.getItemId());
//        Mockito.verify(mockItemService).findOne(item.getItemId());
//    }
//
//    @Test
//    public void retrieveAllItemsInvokesItemServiceRetrieveAllItems() throws Exception {
//        itemRepository.findAll();
//        Mockito.verify(mockItemService).findAll();
//    }
//
//    @Test
//    public void deleteItemInvokesItemServiceDeleteItem() throws Exception {
//        Item item = new Item();
//        itemRepository.delete(item.getItemId());
//        Mockito.verify(mockItemService).delete(item.getItemId());
//    }
//
//    @Test
//    public void deleteAllItemsInvokesItemServiceDeleteAllItems() throws Exception {
//        itemRepository.deleteAll();
//        Mockito.verify(mockItemService).deleteAll();
//    }
}