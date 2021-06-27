package com.dealbab.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Store")
public class Store {

	private Integer id;
    private String storeName;
    private String storeImageUrl;
    private String storeRedirectUrl;
    private String catalogName;
    private String catalogURL;
    private String pdf;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public String getStoreImageUrl() {
			return storeImageUrl;
		}
		public void setStoreImageUrl(String storeImageUrl) {
			this.storeImageUrl = storeImageUrl;
		}
		public String getStoreRedirectUrl() {
			return storeRedirectUrl;
		}
		public void setStoreRedirectUrl(String storeRedirectUrl) {
			this.storeRedirectUrl = storeRedirectUrl;
		}
		public String getCatalogName() {
			return catalogName;
		}
		public void setCatalogName(String catalogName) {
			this.catalogName = catalogName;
		}
		public String getCatalogURL() {
			return catalogURL;
		}
		public void setCatalogURL(String catalogURL) {
			this.catalogURL = catalogURL;
		}
		public String getPdf() {
			return pdf;
		}
		public void setPdf(String pdf) {
			this.pdf = pdf;
		}
		@Override
		public String toString() {
			return "Store [id=" + id + ", storeName=" + storeName + ", storeImageUrl=" + storeImageUrl
					+ ", storeRedirectUrl=" + storeRedirectUrl + ", catalogName=" + catalogName + ", catalogURL="
					+ catalogURL + ", pdf=" + pdf + "]";
		}
	    
}
