package com.virtusa.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.ecommerce.models.Product;
import com.virtusa.ecommerce.models.Stock;
import com.virtusa.ecommerce.repository.ProductRepository;
import com.virtusa.ecommerce.repository.StockRepository;

@Service
public class StockService {
    @Autowired
	private StockRepository stockRepository;
	@Autowired
    private ProductRepository productRepository;
 
    public List<Stock> getAllStocksAboveBufferLevel()
    {
    	
    	
    	return stockRepository.findAll().stream().filter(stock->stock.getQty()> 
    	productRepository.getOne(stock.getProduct().getProductId())
    	.getBufferLevel()).collect(Collectors.toList());
    }
    
    
    
}
