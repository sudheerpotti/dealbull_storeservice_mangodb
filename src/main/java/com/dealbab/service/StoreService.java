package com.dealbab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealbab.model.Store;
import com.dealbab.repository.StoreRepository;
@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;
	public Store createStore(Store store) {
		
		return storeRepository.save(store);
	}

	public Optional<Store> checkStoreById(Integer id) {
		// TODO Auto-generated method stub
		return storeRepository.findById(id);
	}

	public List<Store> getAllStore() {
		// TODO Auto-generated method stub
		return storeRepository.findAll();
	}

	public void deleteStore(Integer id) {
		// TODO Auto-generated method stub
		storeRepository.deleteById(id);
	}

}
