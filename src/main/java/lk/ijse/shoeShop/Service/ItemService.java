package lk.ijse.shoeShop.Service;



import lk.ijse.shoeShop.Dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();
    void saveItem(String itemSupplierId,ItemDto itemDto,String size,String qty);
    void updateItem(String updateItemId , ItemDto itemDto,String supplierId);
    void deleteItem(String deleteItemId);

    ItemDto searchItem(String searchItemId);

    String getLastItemId();

    List<String> selectItemHasAllSizesGet(String selectItemId);

}
