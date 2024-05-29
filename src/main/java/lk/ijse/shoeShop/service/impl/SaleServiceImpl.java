package lk.ijse.shoeShop.service.impl;

import lk.ijse.shoeShop.dto.InventoryDTO;
import lk.ijse.shoeShop.dto.SaleDTO;
import lk.ijse.shoeShop.dto.SalesInventoryDTO;
import lk.ijse.shoeShop.persistence.entity.Inventory;
import lk.ijse.shoeShop.persistence.entity.Sales;
import lk.ijse.shoeShop.persistence.entity.SalesDetails;
import lk.ijse.shoeShop.persistence.repository.InventoryRepo;
import lk.ijse.shoeShop.persistence.repository.SaleDetailsRepo;
import lk.ijse.shoeShop.persistence.repository.SaleRepo;
import lk.ijse.shoeShop.service.SaleService;
import lk.ijse.shoeShop.service.exception.DuplicateRecordException;
import lk.ijse.shoeShop.service.exception.NotFoundException;
import lk.ijse.shoeShop.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    SaleRepo salesRepository;
    SaleDetailsRepo salesDetailsRepository;
    InventoryRepo inventoryRepository;
    ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepo salesRepository, SaleDetailsRepo salesDetailsRepository, ModelMapper modelMapper,InventoryRepo inventoryRepository) {
        this.salesRepository = salesRepository;
        this.salesDetailsRepository = salesDetailsRepository;
        this.modelMapper = modelMapper;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<SaleDTO> getAllSales() {
        //getWeeklyProfit();
        List<Sales> salesList = salesRepository.findAll();
        return salesList.stream().map(sales -> {
            SaleDTO salesDTO = modelMapper.map(sales, SaleDTO.class);

            List<SalesDetails> salesDetailsList = salesDetailsRepository.findAllBySalesOrderNo(sales.getOrderNo());
            List<SalesInventoryDTO> salesInventoryDTOList = salesDetailsList.stream()
                    .map(details -> {
                        SalesInventoryDTO salesInventoryDTO = modelMapper.map(details, SalesInventoryDTO.class);
                        salesInventoryDTO.setInventory(modelMapper.map(details.getInventory(), InventoryDTO.class));
                        return salesInventoryDTO;
                    })
                    .collect(Collectors.toList());

            salesDTO.setInventory(salesInventoryDTOList);
            return salesDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public SaleDTO getSaleDetails(String id) {
        if(!salesRepository.existsByOrderNo(id)){
            throw new NotFoundException("Sales "+id+" Not Found!");
        }
        SaleDTO salesDTO = modelMapper.map(salesRepository.findByOrderNo(id), SaleDTO.class);
        System.out.println("ID-----------------------"+id);
        List<SalesInventoryDTO> salesInventory = salesDetailsRepository.findAllBySalesOrderNo(id).stream().map(
                salesDetails -> modelMapper.map(salesDetails, SalesInventoryDTO.class)
        ).toList();
        salesDTO.setInventory(salesInventory);

        return salesDTO;
    }

    @Transactional
    @Override
    public SaleDTO saveSales(SaleDTO salesDTO) {
        if(maintainInventoryQuantity(salesDTO)){
            if(salesRepository.existsByOrderNo(salesDTO.getOrderNo())){
                throw new DuplicateRecordException("This Sales "+salesDTO.getOrderNo()+" already exicts...");
            }
            SaleDTO newsalesDTO = modelMapper.map(salesRepository.save(modelMapper.map(
                    salesDTO, Sales.class)), SaleDTO.class
            );

            List<SalesInventoryDTO> salesInventoryDTO = new ArrayList<>();
            for (SalesInventoryDTO inventoryDTO : salesDTO.getInventory()) {
                SalesDetails savedSaleDetails = salesDetailsRepository.save(modelMapper.map(inventoryDTO, SalesDetails.class));
                salesInventoryDTO.add(modelMapper.map(savedSaleDetails, SalesInventoryDTO.class));
            }
            newsalesDTO.setInventory(salesInventoryDTO);
            return newsalesDTO;
        }else {
            return salesDTO;
        }
    }

    @Transactional
    @Override
    public void updateSales(String id, SaleDTO salesDTO) {
        for(SalesInventoryDTO inventoryDTO : salesDTO.getInventory()){
            if(inventoryDTO.getQuantity() == 0){
                if(!isDateWithinThreeDays(String.valueOf(salesDTO.getPurchaseDate()))){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("comming");
                    throw new NotFoundException("Update Failed This Order " +
                            salesDTO.getOrderNo() + " Can't refund");
                }
            }
        }
        if(salesRepository.existsById(salesDTO.getOrderNo())){
            salesRepository.save(modelMapper.map(salesDTO,Sales.class));
            for (SalesInventoryDTO inventoryDTO : salesDTO.getInventory()) {
                if(!salesDetailsRepository.existsById(inventoryDTO.getId())){
                    throw new NotFoundException("Update Failed; Sales id: " +
                            salesDTO.getOrderNo() + " does not exist");
                }
                salesDetailsRepository.save(modelMapper.map(inventoryDTO, SalesDetails.class));
            }
        }
    }

    @Override
    public void deleteSales(String id) {
        if(!salesDetailsRepository.existsBySalesOrderNo(id)&&!salesRepository.existsByOrderNo(id)){
            throw  new NotFoundException("Sales "+ id + "Not Found...");
        }else if(salesRepository.existsByOrderNo(id)){
            salesRepository.deleteByOrderNo(id);
        }
        salesDetailsRepository.deleteAllBySalesOrderNo(id);
        salesRepository.deleteByOrderNo(id);
    }

    @Override
    public String nextOrderCode() {
        String lastOrderCode = salesRepository.findLatestOrderCode();
        if(lastOrderCode==null){lastOrderCode = "ORD0000";}
        int numericPart = Integer.parseInt(lastOrderCode.substring(4));
        numericPart++;
        String nextOrderCode = "ORD" + String.format("%04d", numericPart);
        return nextOrderCode;
    }

    protected boolean isDateWithinThreeDays(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
        LocalDateTime inputDate = LocalDateTime.parse(dateString, formatter.withZone(ZoneId.of("Asia/Kolkata")));
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        LocalDateTime threeDaysAgo = currentDate.minus(3, ChronoUnit.DAYS);
        return !inputDate.isBefore(threeDaysAgo);
    }

    protected Boolean maintainInventoryQuantity(SaleDTO salesDTO){
        boolean valid = false;
        for (int i = 0; i<salesDTO.getInventory().size();i++){
            SalesInventoryDTO inventoryDTO = salesDTO.getInventory().get(i);
            String itemCode = inventoryDTO.getInventory().getItemCode();
            System.out.println(itemCode);

            InventoryDTO inventory = modelMapper.map(inventoryRepository.findByItemCode(itemCode),InventoryDTO.class);
            if(inventory.getQuantity()>0){
                if(inventory.getQuantity()-inventoryDTO.getQuantity()>=0){
                    inventory.setQuantity(inventory.getQuantity()-inventoryDTO.getQuantity());
                    inventoryRepository.save(modelMapper.map(inventory, Inventory.class));
                    valid = true;
                }else{
                    valid = false;
                    throw new ServiceException("Can't Proceed this Sale ."+inventory.getItemDescription()+" No much Quantity");
                }
            }else{
                valid = false;
                throw new ServiceException("Can't Proceed this Sale ."+inventory.getItemDescription()+" No much Quantity");
            }
        }
        return valid;
    }

    public void getWeeklyProfit(){
        Map<String, Double> dataList = new HashMap<>();
        List<Date> dates = salesRepository.findAllPurchaseDate();
        int quantity;
        double dayProfit = 0;
        for (Date date:dates){
            if(convertToLocalDateFormat(String.valueOf(date))){
                List<Sales> sales = salesRepository.findAllByPurchaseDate(date);
                for (int i = 0; i < sales.size(); i++) {
                    List<SalesDetails> salesDetailsArray = salesDetailsRepository.findAllBySalesOrderNo(sales.get(i).getOrderNo());
                    for (int j = 0; j < salesDetailsArray.size(); j++){
                        System.out.println("----------------------------------------------------------------");
                        quantity = salesDetailsArray.get(j).getQuantity();
                        InventoryDTO inventoryDTO = modelMapper.map(
                                inventoryRepository.findByItemCode(salesDetailsArray.get(j).getInventory().getItemCode()),InventoryDTO.class
                        );
                        dayProfit += quantity*(inventoryDTO.getExpectedProfit());
                    }
                    System.out.println("////////////////////////////////////////////////////////////////");
                    System.out.println(date);
                    System.out.println(dayProfit);
                    if(dayProfit!=0){
                        String newdate = convertDateFormat(String.valueOf(date));
                        if (!dataList.containsKey(newdate)) {
                            dataList.put(newdate, dayProfit);
                        } else {
                            double currentProfit = dataList.get(newdate);
                            dataList.put(newdate, currentProfit + dayProfit);
                        }
                    }
                    dayProfit = 0;
                }
            }
        }
        System.out.println(dataList);
    }

    private Boolean convertToLocalDateFormat(String dateTimeString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);
        LocalDate localDate = localDateTime.toLocalDate();

        Boolean purchaseDateEqualToWeeklyDate = checkWeeklyDate(localDate.format(dateFormatter));
        return purchaseDateEqualToWeeklyDate;
    }

    private boolean checkWeeklyDate(String purchasedate){
        List<LocalDate> dates = new ArrayList<>();
        Boolean vaid = false;
        LocalDate today = LocalDate.now();

        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            dates.add(date);
        }

        L:for (LocalDate date : dates) {
            if(String.valueOf(date).equals(purchasedate)){
                vaid = true;
                break L;
            }else{
                vaid = false;
            }
        }
        return vaid;
    }

    private String convertDateFormat(String inputDateStr) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        Date inputDate = null;
        try {
            inputDate = inputDateFormat.parse(inputDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outputDateFormatObj = new SimpleDateFormat("yyyy-MM-dd");
        return outputDateFormatObj.format(inputDate);
    }
}

