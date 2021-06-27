package com.dealbab.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealbab.exception.StoreNotFoundException;
import com.dealbab.model.Store;
import com.dealbab.repository.StoreRepository;
import com.dealbab.service.StoreService;
@RestController
@RequestMapping(value="/dealbab")
public class StoreController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreRepository storeRepository;
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(value="/store")
	public Store createStore(@RequestBody Store store){
		 return storeService.createStore(store);
			}
	/*public ResponseEntity<?> createStore(@Validated @RequestBody Store store, UriComponentsBuilder ucBuilder){

		  if (storeRepository.findById(store.getId()).isPresent()) {
		        throw new StoreAlreadyExistsException(store.getId());
		    }
		  storeRepository.save(store);
		    HttpHeaders headers = new HttpHeaders();
		    headers.setLocation(ucBuilder.path("/api/store/{id}").buildAndExpand(store.getId()).toUri());
		    return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}*/
/*@CrossOrigin(origins = "http://localhost:8080")
 * @GetMapping(value="/store/{id}")
	public Optional<Store> checkStoreById(@PathVariable("id")Integer id)
	{
		return storeService.checkStoreById(id);
	}*/
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value="/store/{id}")
	public ResponseEntity<Store> getStore(@PathVariable("id") Integer id) {
	    return storeRepository.findById(id)
	        .map(store -> new ResponseEntity<>(store, HttpStatus.OK))
	        .orElseThrow(() -> new StoreNotFoundException(id));
	}
	/*@CrossOrigin(origins = "http://localhost:8080")
@GetMapping(value="/store")
public Iterable<Store> getAllStore()
{
	return storeService.getAllStore();
	
}*/
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value="/store")
	public ResponseEntity<?> store() {
	    List<Store> store = storeService.getAllStore();

	    if (store.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	    HashMap<String, Object> hmap = new HashMap<String, Object>();
	    hmap.put("count", store.size());
	    hmap.put("store", store);
	    return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
 }
	/*@CrossOrigin(origins = "http://localhost:8080")
@DeleteMapping(value="/store/{id}")
public void deleteStore(@PathVariable("id")Integer id){
	storeService.deleteStore(id);
}*/
	@CrossOrigin(origins = "http://localhost:8080")
	 @DeleteMapping(value="/store/{id}")
	 public ResponseEntity<?> deleteStore(@PathVariable("id") Integer id) {
	     return storeRepository.findById(id)
	         .map(store -> {
	        	 storeRepository.delete(store);
	             return new ResponseEntity(HttpStatus.NO_CONTENT);
	          })
	          .orElseThrow(() -> new StoreNotFoundException(id));
	 }
}
