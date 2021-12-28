package com.study.springcore.a_try;

public class ProfileServiceDto {

		
		private Long ServiceId;
		private String ServiceIdentifier;
		private String Enable;
		
		
		public ProfileServiceDto() {
//			super();
		}
		public Long getServiceId() {
			return ServiceId;
		}
		public void setServiceId(Long serviceId) {
			ServiceId = serviceId;
		}
		public String getServiceIdentifier() {
			return ServiceIdentifier;
		}
		public void setServiceIdentifier(String serviceIdentifier) {
			ServiceIdentifier = serviceIdentifier;
		}
		public String getEnable() {
			return Enable;
		}
		public void setEnable(String enable) {
			Enable = enable;
		}
		@Override
		public String toString() {
			return "ProfileServiceDto [ServiceId=" + ServiceId + ", ServiceIdentifier=" + ServiceIdentifier
					+ ", Enable=" + Enable + "]";
		}
		
		
		
		
}
