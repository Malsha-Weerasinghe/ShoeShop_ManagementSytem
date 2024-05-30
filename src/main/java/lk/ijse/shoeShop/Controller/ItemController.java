package lk.ijse.shoeShop.Controller;

import lk.ijse.shoeShop.Dto.ItemDto;
import lk.ijse.shoeShop.Service.ItemService;
import lk.ijse.shoeShop.convert.DataConvert;
import lk.ijse.shoeShop.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.PATCH, RequestMethod.DELETE ,RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    DataConvert dataConvert;


    @GetMapping
    @RequestMapping("/allItems")
    List<ItemDto> getAllItems(){
        List<ItemDto> allItems = itemService.getAllItems();
        return allItems;
    }


    @RequestMapping("/save/{id}/{size}/{qty}")
    void saveItem(@PathVariable("id") String supplierId,
                  @PathVariable("size") String size,

                  @PathVariable("qty") String qty,
                  @RequestPart("item_code") String code,
                  @RequestPart("item_desc") String desc,
                  @RequestPart("item_pic") String pic,
                  @RequestPart("category") String category,
                  @RequestPart("itemType") String itemType,
                  @RequestPart("occasion") String occasion,
                  @RequestPart("verities") String verities,
                  @RequestPart("salePrice") String salePrice,
                  @RequestPart("expectedProfit") String expectedProfit,
                  @RequestPart("profitMargin") String profitMargin,
                  @RequestPart("buyPrice") String buyPrice

    ){


        ItemDto itemDto = new ItemDto();

        System.out.println(pic);

        String picConvertBase64 = UtilMatters.convertBase64(pic);
        itemDto.setItemCode(code);
        itemDto.setItemDesc(desc);
        itemDto.setItemPic(picConvertBase64);
        itemDto.setCategory(category);
        itemDto.setItemType(itemType);
        itemDto.setOccasion(occasion);
        itemDto.setVerities(verities);
        itemDto.setUnitPriceSale(Double.parseDouble(salePrice));
        itemDto.setExpectedProfit(Double.parseDouble(expectedProfit));
        itemDto.setProfitMargin(Double.parseDouble(profitMargin));
        itemDto.setBuyPrice(Double.parseDouble(buyPrice));

        itemService.saveItem(supplierId,itemDto,size,qty);


    }



    @PutMapping
    @RequestMapping("/update/{id}/{supplierId}")
    @PreAuthorize("hasRole('ADMIN')")
    void updateItem(@PathVariable("id") String updateItemId ,
                    @PathVariable("supplierId") String supplierId,
                    @RequestPart("item_desc") String desc,
                    @RequestPart("item_pic") String pic,
                    @RequestPart("category") String category,
                    @RequestPart("itemType") String itemType,
                    @RequestPart("occasion") String occasion,
                    @RequestPart("verities") String verities,
                    @RequestPart("salePrice") String salePrice,
                    @RequestPart("expectedProfit") String expectedProfit,
                    @RequestPart("buyPrice") String buyPrice
    ){


        ItemDto itemDto = new ItemDto();


        String picConvertBase64 = UtilMatters.convertBase64(pic);
        itemDto.setItemDesc(desc);
        itemDto.setItemPic(picConvertBase64);
        itemDto.setCategory(category);
        itemDto.setItemType(itemType);
        itemDto.setOccasion(occasion);
        itemDto.setVerities(verities);
        itemDto.setUnitPriceSale(Double.parseDouble(salePrice));
        itemDto.setExpectedProfit(Double.parseDouble(expectedProfit));
        itemDto.setBuyPrice(Double.parseDouble(buyPrice));


        itemService.updateItem(updateItemId , itemDto,supplierId);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteItem(@PathVariable ("id") String deleteItemId){
        itemService.deleteItem(deleteItemId);
    }

    @GetMapping
    @RequestMapping("/search/{id}")
    ItemDto searchItem(@PathVariable("id") String searchItemId){
        ItemDto itemDto = itemService.searchItem(searchItemId);
        return itemDto;
    }

    @GetMapping
    @RequestMapping("/lastId")
    public String lastIdGet(){
        return itemService.getLastItemId();
    }


    @GetMapping
    @RequestMapping("/selectItemSizesGet/{id}")
    public List<String>  selectItemHasAllSizesGet(@PathVariable ("id") String itemId){
        List<String> selectedItemHasAllSizes = itemService.selectItemHasAllSizesGet(itemId);
        return selectedItemHasAllSizes;
    }




}
